import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { CreateInvoiceComponent } from '../create-invoice/create-invoice.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
import { PageEvent } from '@angular/material/paginator';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { RepaymentdetailsComponent } from '../repaymentdetails/repaymentdetails.component';
import { CreatedformComponent } from '../createdform/createdform.component';
import { FileUploadComponent } from 'src/app/shared/components/file-upload/file-upload.component';
import { DataSource } from '@angular/cdk/collections';
import { TransferFundsComponent } from '../transfer-funds/transfer-funds.component';



interface InvoiceDiscounting {
  no:number;
  invoiceNumber: string;
  applicantBusinessName: string;
  // buyerName: string;
  invoiceAmount: number;
  status: string;
  // branchCode: string;
  actions: string;
}
@ Component({
  selector: 'app-view-invoice',
  templateUrl: './view-invoice.component.html',
  styleUrls: ['./view-invoice.component.sass']
})

export class ViewInvoiceComponent implements OnInit {

 
 geturl = `http://192.168.91.96:9000/invoices/list`;
 rows: any[]; // Define invoices array to hold the invoice objects

  all: number = 0;
  pending: number = 0;
  approved: number = 0;
  rejected: number = 0;
  funded: number = 0;
  paid: number = 0;
  cancelled: number = 0;
    // Defining the pageEvent property
    pageEvent: PageEvent;
formData: any;
data = []; 


//Mock data for testing

//  mockData: InvoiceDiscounting[] = [
//   { no: 1, invoiceNumber: 'INV-001', applicantBusinessName: 'Doe Enterprises', invoiceAmount: 5000, status: 'Pending',  actions: 'Actions' },
//   { no: 2, invoiceNumber: 'INV-002', applicantBusinessName: 'Smith Ltd.',  invoiceAmount: 15000, status: 'Approved', actions: 'Actions' },
//   { no: 3, invoiceNumber: 'INV-003', applicantBusinessName: 'ACME Corp.',  invoiceAmount: 2500, status: 'Rejected', actions: 'Actions' },
//   { no: 4, invoiceNumber: 'INV-004', applicantBusinessName: 'Global Inc.',  invoiceAmount: 7500, status: 'Pending',  actions: 'Actions' },
//   { no: 5, invoiceNumber: 'INV-005', applicantBusinessName: 'Tech Solutions',  invoiceAmount: 12500, status: 'Approved',  actions: 'Actions' }
// ];

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data


  totainvoiceFormsreatedInvoices = 0;
  totalPendingInvoices = 0;
  totalApprovedInvoices = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'invoiceNumber', 'applicantBusinessName',  'invoiceAmount','status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading: boolean = false;
  products: any;
 invForms: any;
totalRejectinvoices: any;
row: any;


 

  constructor(public dialog: MatDialog,
    private router: Router,
    private invDiscountingService: InvDiscountingService,

    private snackbar: SnackbarService) { }


    ngOnInit(): void {
        // Set isLoading to true when fetching starts
     
      this.getAllForms();
      // this.initializeMockData(); // Add this line to initialize mock data

    }
    
    // initializeMockData(): void {
    //   this.dataSource = new MatTableDataSource(this.mockData);
    //   this.dataSource.sort = this.sort;
    //   this.dataSource.paginator = this.paginator;
    //   this.isLoading = false; // Set loading to false as we are using static data
    // }
 getAllForms(): void {
      this.isLoading = true;
      console.log('Fetching invoice forms...');
      this.invDiscountingService.getAllForms().subscribe({
      next: (res: any) => {  
        console.log('Response:', res); 
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
          const extractedData = res.data.map((invoiceForms: any, index: number) => ({     
          no: index + 1,
         invoiceNumber: invoiceForms.invoiceNumber,           
         applicantBusinessName: invoiceForms.applicantBusinessName, 
          // buyerName: invoiceForms.buyerName,
          invoiceAmount:  invoiceForms.invoiceAmount,
          status:invoiceForms.status,
          actions: 'Actions',// Replace this with actual actions logic
        }));
      },
    // Set isLoading to false when fetching is completed
    // this.isLoading = false;
    error: (err) => {
      console.error('Error fetching invoiceForms:', err.message || err.toString());
      this.snackbar.showNotification('error', 'Failed to fetch invoice forms');
      this.isLoading = false;
    }

 
  
  });
}

applyFilter(event: Event) {
  const filterValue = (event.target as HTMLInputElement).value;
  this.dataSource.filter = filterValue.trim().toLowerCase();

  if (this.dataSource.paginator) {
    this.dataSource.paginator.firstPage();
  }
}


  public add() {
    this.router.navigate(["/invoice-discounting/createInvoice"])
  }

  public openViewinvoiceFormsComponent(row) {
    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '1000px';
    dialogConfig.height= '1000px';

    dialogConfig.data = { rowData: row }
    const dialogRef = this.dialog.open(CreateInvoiceComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }

  openTransferDialog(): void {
    const dialogRef = this.dialog.open(TransferFundsComponent, {
      width: '600px', 
      height:'500px',// Adjust width as needed
      // Other configuration options if needed
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // Handle dialog close if needed
    });
  }
  

  openDialog(): void {
    const dialogRef = this.dialog.open(RepaymentdetailsComponent, {
      width: '600px', 
      height:'500px',// Adjust width as needed
      // Other configuration options if needed
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // Handle dialog close if needed
    });
  }

  openFormDialog(rowData: any): void {
    const dialogRef = this.dialog.open(CreatedformComponent, {
      width: '100%',

      position:{
        right:"2em"
      },
      data: { rowData: rowData }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // Handle any actions after the dialog is closed if necessary
    });
  }


}
