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
import { DeleteInvoiceComponent } from '../delete-invoice/delete-invoice.component';



interface InvoiceDiscounting {
  name: string;
  invoiceNumber: string;
  applicantAccountName: string;
  applicaAccountNumber: string;
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

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  // totalCreatedInvoiceDiscountingForms = 0;
  // totalItems: number = 0;
  //  all: number = 0;
  // pending = 0;
  // approved = 0;
  // totalRejectedForms = 0;
  // selectedStatus = 'all';
  // selectedFilterRadioButton: string = 'all';

  totalCreatedInvoices = 0;
  totalPendingInvoices = 0;
  totalApprovedInvoices = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'invoiceNumber', 'applicantAccountName', 'applicantAccountNumber', 'status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading = true;
  products: any;
  lcs: any;
totalRejectinvoices: any;
  rows: any[];

 

  constructor(private dialog: MatDialog,
    private router: Router,
    private invDiscountingService: InvDiscountingService,

    private snackbar: SnackbarService) { }


  ngOnInit(): void {
    this.getrows();
    // this.getFormData();
  }


  public getrows()  {
   this.rows = [
      { no: '1', invoiceNumber: 'ML_183', applicantAccountName: 'Kings Fashion Limited', applicantAccountNumber: '03321445518', status: 'Pending', actions: 'Active' },
      { no: '2', invoiceNumber: 'KM_652', applicantAccountName: 'R & X Electronics', applicantAccountNumber: '03825432905', status: 'Approved', actions: 'Active' },
      { no: '3', invoiceNumber: 'SL_876', applicantAccountName: 'Hasenye Shipping Co.Ltd', applicantAccountNumber: '03590835214', status: 'Approved', actions: 'Flagged' },
      { no: '4', invoiceNumber: 'ABC_656', applicantAccountName: 'JK Cement Manufacturers Ltd', applicantAccountNumber: '03676502126', status: 'Pending', actions: 'Active' },
      { no: '5', invoiceNumber: 'XYZ_187', applicantAccountName: 'Joshua Cheese & Milk Distributers', applicantAccountNumber: '03765432901', status: 'Pending', actions: 'Active' },

    ];
  
    // console.log("list:", this.rows);
    // if (this.rows) {
    //   this.isLoading = false
    // }

    
    this.dataSource = new MatTableDataSource(this.rows);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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
    this.router.navigate(["/invoice-discounting/createInvoice"])
  }

  public openViewLcComponent(row) {

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

 
  
  public refresh() {
    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { test: "row" }

    const dialogRef = this.dialog.open(CreateInvoiceComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }

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
 
  totalRowsCount = this.getrows.length;
  // totalPendingForms = this.getrows( s => s.created === true ).length;
  // totalApprovedForms = this.getrows.( s => s.approved === false).length;
  
  // getFormData(): void {
  //   this.invDiscountingService.getFormData()
  //     .subscribe(data => {
  //       this.formData = data;
  //       console.log(this.formData); // Handle the retrieved form data here
  //     });
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

 deleteDialog(): void{
  const dialogRef = this.dialog.open(DeleteInvoiceComponent,{
   width: '600px',
  });
  } 


}