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
import { ViewpopUpComponent } from '../viewpop-up/viewpop-up.component';
import { FileUploadComponent } from 'src/app/shared/components/file-upload/file-upload.component';



interface InvoiceDiscounting {
  name: string;
  invoiceNumber: string;
 applicantBusinessName: string;
  buyerName: string;
  invoiceAmount: string;
  status: string;
  branchCode: string;
  actions: string;
}
@ Component({
  selector: 'app-view-invoice',
  templateUrl: './view-invoice.component.html',
  styleUrls: ['./view-invoice.component.sass']
})

export class ViewInvoiceComponent implements OnInit {
  
 geturl = `http://192.168.90.44:9000/invoices/list`;
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

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  // totainvoiceFormsreatedInvoiceDiscountingForms = 0;
  // totalItems: number = 0;
  //  all: number = 0;
  // pending = 0;
  // approved = 0;
  // totalRejectedForms = 0;
  // selectedStatus = 'all';
  // selectedFilterRadioButton: string = 'all';

  totainvoiceFormsreatedInvoices = 0;
  totalPendingInvoices = 0;
  totalApprovedInvoices = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'invoiceNumber', 'applicantBusinessName', 'buyerName', 'invoiceAmount','status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading = true;
  products: any;
 invForms: any;
totalRejectinvoices: any;


 

  constructor(private dialog: MatDialog,
    private router: Router,
    private invDiscountingService: InvDiscountingService,

    private snackbar: SnackbarService) { }


    ngOnInit(): void {
      this.getAllForms();
    }

    getAllForms(): void {
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
          buyerName: invoiceForms.buyerName,
          invoiceAmount:  invoiceForms.invoiceAmount,
          status:invoiceForms.status,
          actions: 'Actions',// Replace this with actual actions logic
        }));

        // error: (err) => {
        //   console.error('Error fetching invoiceForms:', Error);
        //   this.snackbar.showNotification('error', 'Failed to fetch invoice forms');
        // }

    },
  
  });
}

  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
 
  // onFilterChanged(value: string){
  //   console.log(value);
  //   this.selectedFilterRadioButton = value;


  // }
  public add() {
    this.router.navigate(["invoice-discounting/createInvoice"])
  }

  public openViewinvoiceFormsComponent(row) {

    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { rowData: row }

    const dialogRef = this.dialog.open(CreateInvoiceComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }

 
  
  // public refresh() {
  //   const dialogConfig = new MatDialogConfig()
  //   dialogConfig.disableClose = true
  //   dialogConfig.autoFocus = true
  //   dialogConfig.width = '600px'
  //   dialogConfig.data = { test: "row" }

  //   const dialogRef = this.dialog.open(CreateInvoiceComponent, dialogConfig);


  //   dialogRef.afterClosed().subscribe((result) => {
  //     console.log('closed');
  //   });
  // }

  // public edit() {
  //   this.router.navigate(["/invoice-discounting/modifyInvoice"])
  // }
  
  // pageSize = 10;
  // pageSizeOptions = ["[2,5,10,20, 30, 40, 50, 100]"];
  // totalItems = 5;



  // onPageChange(event: PageEvent) {
  //   // Extracting relevant information from the event
  //   const pageIndex = event.pageIndex;
  //   const pageSize = event.pageSize;
  //   const previousPageIndex = event.previousPageIndex;
  //   const length = event.length;
  //   // this.totalItems = this.rows.length; 
 
  // }

  

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
 viewDialog(): void{
 const dialogRef = this.dialog.open(ViewpopUpComponent,{
  width: '600px',
 });
 } 
}