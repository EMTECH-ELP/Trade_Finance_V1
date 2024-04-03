import { Component, OnInit, ViewChild } from '@angular/core';
import { CreateInvoiceComponent } from '../create-invoice/create-invoice.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';

@Component({
  selector: 'app-view-invoice',
  templateUrl: './view-invoice.component.html',
  styleUrls: ['./view-invoice.component.sass']
})
export class ViewInvoiceComponent implements OnInit {

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  totalCreatedLetters = 0;
  totalPendingLetters = 0;
  totalApprovedLetters = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'letterOfCreditNumber', 'applicantAccountNumber', 'beneficiaryAccountNumber', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading = true;
  products: any;
  lcs: any;


  constructor(private dialog: MatDialog,
    private router: Router,
  
    private snackbar: SnackbarService) { }


  ngOnInit(): void {
    this.getLCs();
  }

  public getLCs() {}
   
 

  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

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

  public verify() {


  }
}