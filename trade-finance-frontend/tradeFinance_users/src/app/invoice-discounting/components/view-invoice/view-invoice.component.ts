import { Component,  EventEmitter,  OnInit, Output, ViewChild } from '@angular/core';
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
import { SharedService } from '../shared.service';
import { TransferFundsComponent } from '../transfer-funds/transfer-funds.component';
import { Subject, Subscription, takeUntil, throwError } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { DeleteInvoiceComponent } from '../delete-invoice/delete-invoice.component';
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
  @Output() invoiceCounts = new EventEmitter<{ total: number, pending: number, approved: number, rejected: number, funded: number, repaid: number }>();

  // private subscriptions: Subscription = new Subscription();
  rows: any[]; // Define invoices array to hold the invoice objects
  InvoiceDiscounting: any;

  pending: number = 0;
  approved: number = 0;
  rejected: number = 0;
  funded: number = 0;
  paid: number = 0;
  cancelled: number = 0;
  // Defining the pageEvent property
  // pageEvent: PageEvent;
  formData: any;
  rowData: any;
  // data = [];

  totalCreatedInvoices: number = 0;
  pendingCount: number = 0;
  approvedCount: number = 0;
  fundedCount: number = 0;
  repaidCount: number = 0;
  rejectedCount: number = 0;

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  dialogData: any;
  data: any;
  onSelect(row: any) {
    // Your logic here
    console.log('Selected row:', row);
  }

  selectedStatus = 'all';
  filteredDataSource = new MatTableDataSource<any>([]);
  searchTerm: string = '';
  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'invoiceNumber', 'applicantBusinessName', 'accountNumber' ,'invoiceAmount', 'status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  // totalCreatedInvoices: number = 0;
  isLoading = true;
  products: any;
  invForms: any;
  totalRejectinvoices: any;
  row: any;


  invoiceData: any;
  
  // destroy$: any;
  // private destroy$ = new Subject<void>();


  constructor(public dialog: MatDialog,
    private router: Router,
    private http: HttpClient, 
    private sharedService: SharedService,
    private invDiscountingService: InvDiscountingService,
    private snackbar: SnackbarService) { }


  ngOnInit(): void {
    // Set isLoading to true when fetching starts
    this.getAllForms();
    this.sharedService.invoiceCount$.subscribe((count) => {
      this.totalCreatedInvoices = count;
    });
 
  }


  public applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value.trim().toLowerCase();
    this.dataSource.filter = filterValue;
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  


  public add() {
    console.log('Click Done')
    this.router.navigate(["invoice-discounting/createInvoice"])
  }

  public refresh() {
    this.getAllForms();
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
              accountNumber: applicationForm.accountNumber,
              invoiceAmount: invoice.invoiceAmount,
              status: invoice.status,
              actions: 'Actions', // Replace this with actual actions logic
            }))

          )
          .reduce((acc, val) => acc.concat(val), []); // Flatten the array of arrays

        this.dataSource = new MatTableDataSource(extractedData);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;

            // Total count of all invoices
            this.totalCreatedInvoices = extractedData.length;

     //   Calculate counts based on status
     this.pendingCount = extractedData.filter(row => row.status === 'PENDING').length;
     this.approvedCount = extractedData.filter(row => row.status === 'APPROVED').length;
     this.rejectedCount = extractedData.filter(row => row.status === 'REJECTED').length;
     this.fundedCount = extractedData.filter(row => row.status === 'FUNDED').length;
     this.repaidCount = extractedData.filter(row => row.status === 'REPAID').length;
     
     this.invoiceCounts.emit({
      total: this.totalCreatedInvoices,
      pending: this.pendingCount,
      approved: this.approvedCount,
      rejected: this.rejectedCount,
      funded: this.fundedCount,
      repaid: this.repaidCount
    });
    this.sharedService.setInvoiceCount(this.totalCreatedInvoices);
      },
      error: (err) => {
        console.error('Error fetching invoice forms:', err);
        this.snackbar.showNotification('error', 'Failed to fetch invoice forms');

      }
    });

    // this.subscriptions.add(sub);
  }
  openModifyComponent(row: any): void {
    const invoiceNumber = row.invoiceNumber; // Adjust this based on your row data structure
    this.router.navigate(['/modify', invoiceNumber]);
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
  openDialogById(accountNumber: any): void {
    this.invDiscountingService.getDataById(accountNumber).subscribe(
      (data) => {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = data;
        dialogConfig.width = '1000px';
        dialogConfig.height = '750px';
  
        const dialogRef = this.dialog.open(CreatedformComponent, dialogConfig);
        dialogRef.afterClosed().subscribe(result => {
          console.log('The dialog was closed', result);
        });
      },
      (error) => {
        console.error('Error fetching data by ID:', error);
        // Display a user-friendly error message
        alert('Failed to fetch data. Please try again later.');
      }
    );
  }
  

 openDeleteConfirmationDialog(row:any){
    const dialogRef = this.dialog.open(DeleteInvoiceComponent, {
      data: { id: row.id },
      width: '400px',
    

    });
    dialogRef.afterClosed().subscribe(result => {
      if(result) {
        console.log('Invoice deleted');
      }else{
        console.log('Deletion Cancelled');
      
      }
    })
  } 
}
