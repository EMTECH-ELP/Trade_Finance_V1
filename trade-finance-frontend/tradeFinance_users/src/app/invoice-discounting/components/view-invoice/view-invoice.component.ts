import { Component,  OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
// import { PageEvent } from '@angular/material/paginator';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { RepaymentdetailsComponent } from '../repaymentdetails/repaymentdetails.component';
import { CreatedformComponent } from '../createdform/createdform.component';

import { TransferFundsComponent } from '../transfer-funds/transfer-funds.component';
import { Subject, Subscription, takeUntil } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { environment } from 'src/environments/environment';
// import { InvoiceDiscountingModule } from '../../invoice-discounting.module';



// interface InvoiceDiscounting {
//   no: string;
//   invoiceNumber: string;
//   applicantBusinessName: string;
//   invoiceAmount: string;
//   status: string;
//   actions: string;
// }
@Component({
  selector: 'app-view-invoice',
  templateUrl: './view-invoice.component.html',
  styleUrls: ['./view-invoice.component.sass']
})

export class ViewInvoiceComponent implements OnInit {

  // private subscriptions: Subscription = new Subscription();
  rows: any[]; // Define invoices array to hold the invoice objects
  InvoiceDiscounting: any;
  all: number = 8;
  pending: number = 0;
  approved: number = 0;
  rejected: number = 0;
  funded: number = 0;
  paid: number = 0;
  cancelled: number = 0;
  // Defining the pageEvent property
  // pageEvent: PageEvent;
  formData: any;
  // data = [];


  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data


  totainvoiceFormscreatedInvoices = 17;
  totalPendingInvoices = 0;
  totalApprovedInvoices = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'invoiceNumber', 'applicantBusinessName', 'invoiceAmount', 'status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  

  isLoading = true;
  products: any;
  invForms: any;
  totalRejectinvoices: any;
  row: any;


  mockData = [
    { no: 1, invoiceNumber: 'INV-001', applicantBusinessName: 'Doe Enterprises', invoiceAmount: 5000, status: 'Pending', actions: 'Actions' },
    { no: 2, invoiceNumber: 'INV-002', applicantBusinessName: 'Smith Ltd.', invoiceAmount: 15000, status: 'Approved', actions: 'Actions' },
    { no: 3, invoiceNumber: 'INV-003', applicantBusinessName: 'ACME Corp.', invoiceAmount: 2500, status: 'Rejected', actions: 'Actions' },
    { no: 4, invoiceNumber: 'INV-004', applicantBusinessName: 'Global Inc.', invoiceAmount: 7500, status: 'Pending', actions: 'Actions' },
    { no: 5, invoiceNumber: 'INV-005', applicantBusinessName: 'Tech Solutions', invoiceAmount: 12500, status: 'Approved', actions: 'Actions' },
    { no: 1, invoiceNumber: 'INV-001', applicantBusinessName: 'Doe Enterprises', invoiceAmount: 5000, status: 'Pending', actions: 'Actions' },
    { no: 2, invoiceNumber: 'INV-002', applicantBusinessName: 'Smith Ltd.', invoiceAmount: 15000, status: 'Approved', actions: 'Actions' },
    { no: 3, invoiceNumber: 'INV-003', applicantBusinessName: 'ACME Corp.', invoiceAmount: 2500, status: 'Rejected', actions: 'Actions' },
    { no: 4, invoiceNumber: 'INV-004', applicantBusinessName: 'Global Inc.', invoiceAmount: 7500, status: 'Pending', actions: 'Actions' },
    { no: 5, invoiceNumber: 'INV-005', applicantBusinessName: 'Tech Solutions', invoiceAmount: 12500, status: 'Approved', actions: 'Actions' }
  ];
  invoiceData: any;
  
  // destroy$: any;
  // private destroy$ = new Subject<void>();


  constructor(public dialog: MatDialog,
    private router: Router,
    private invDiscountingService: InvDiscountingService,
    private snackbar: SnackbarService) { }


  ngOnInit(): void {
    // Set isLoading to true when fetching starts
    this.getAllForms();
    // console.log('ViewInvoiceComponent initialized');
    // this.initializeMockData(); // Add this line to initialize mock data
  }



  // }
  initializeMockData(): void {
    this.dataSource = new MatTableDataSource(this.mockData);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    // this.isLoading = false; // Set loading to false as we are using static data
  }
  // ngOnDestroy(): void {
    
  //   this.subscriptions.unsubscribe();
  //   this.destroy$.next();
  //   this.destroy$.complete();
  // }



  public applyFilter(filterValue: string): void {
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


  public add() {
    console.log('Click Done')
    this.router.navigate(["invoice-discounting/createInvoice"])
  }

  public refresh() {
    // this.mockData
    // this.getAllForms();
  }

   public getAllForms(): void {
    const sub = this.invDiscountingService.getAllForms().pipe(
      // takeUntil(this.destroy$)
    ).subscribe({
      next: (res: any[]) => {
        console.log('Response:', res);
        const extractedData = res
          .map((applicationForm: any, index: number) =>
            applicationForm.invoices.map((invoice: any, invoiceIndex: number) => ({
              no: index * 100 + invoiceIndex + 1, // Unique numbering for each invoice
              invoiceNumber: invoice.invoiceNumber,
              applicantBusinessName: invoice.applicantBusinessName,
              invoiceAmount: invoice.invoiceAmount,
              status: invoice.status,
              actions: 'Actions', // Replace this with actual actions logic
            }))

          )
          .reduce((acc, val) => acc.concat(val), []); // Flatten the array of arrays

        this.dataSource = new MatTableDataSource(extractedData);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;


      },
      error: (err) => {
        console.error('Error fetching invoice forms:', err);
        this.snackbar.showNotification('error', 'Failed to fetch invoice forms');

      }
    });

    // this.subscriptions.add(sub);
  }

 public  openTransferDialog(): void {
    const dialogRef = this.dialog.open(TransferFundsComponent, {
      width: '600px',
      height: '500px'// Adjust width as needed
      // Other configuration options if needed
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // Handle dialog close if needed
    });
  }


  public openRepaymentDialog(): void {
    const dialogRef = this.dialog.open(RepaymentdetailsComponent, {
      width: '600px',
      height: '500px',// Adjust width as needed
      // Other configuration options if needed
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // Handle dialog close if needed
    });
  }

  handleButtonClick(event: Event, row: any): void {
    event.stopPropagation();
    console.log('Button clicked, row data:', row);
    this.getInvoiceDataById(row.no);  // Assuming `no` is the ID you use to fetch the invoice data
  }
  
  
  getInvoiceDataById(id: number): void {
    const url = `${environment.invUrl}/applicant/${id}`;
    console.log("Request URL:", url);  // Debugging statement to check URL
    this.invDiscountingService.getDataById(id).subscribe(
      response => {
        console.log("Invoice Data:", response);
        this.invoiceData = response;
        this.openFormDialog(this.invoiceData);
      },
      error => {
        console.error("Error:", error);
      }
    );
  }

  
  openFormDialog(rowData: any): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '1000px';
    dialogConfig.height = '750px';
    dialogConfig.data = { rowData: rowData };
  
    const dialogRef = this.dialog.open(CreatedformComponent, dialogConfig);
    
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
    });
  }
  
 
}