import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CreateComponent } from '../create/create.component';
import { Router } from '@angular/router';
import { TestComponent } from '../../test/test.component';
import { LcService } from '../../services/lc.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';



interface LetterOfCredit {
  name: string;
  letterOfCreditNumber: string;
  applicantAccountName: string;
  applicaAccountNumber: string;
  status: string;
  branchCode: string;
  actions: string;
}

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.sass']
})
export class ViewComponent implements OnInit {

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  totalCreatedLetters = 0;
  totalPendingLetters = 0;
  totalApprovedLetters = 0;
  selectedactions = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'letterOfCreditNumber','applicantAccountName', 'applicantAccountNumber','status' ,'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading = true;
  products: any;
  lcs: any;
  rows: any;
selectedStatus: any;

  constructor(private dialog: MatDialog,
    private router: Router,
    // private lcService: LcService,
    private snackbar: SnackbarService
    ) { }


  ngOnInit(): void {
    // this.loadtotalCreatedLetters();
    this.getrows();
  }

  public getrows() {
    this.rows = [
      { no: '1', letterOfCreditNumber: '183', applicantAccountName: 'Kings Fashion Limited', applicantAccountNumber: '03321445518', status:'Pending',  actions: 'Active' },
      { no: '2', letterOfCreditNumber: '652', applicantAccountName: 'R & X Electronics',  applicantAccountNumber: '03825432905', status:'Approved', actions: 'Active' },
      { no: '3', letterOfCreditNumber: '876', applicantAccountName:  'Hasenye Shipping Co.Ltd', applicantAccountNumber: '03590835214', status:'Approved', actions: 'Flagged' },
      { no: '4', letterOfCreditNumber: '656', applicantAccountName: 'JK Cement Manufacturers Ltd', applicantAccountNumber: '03676502126', status:'Pending', actions: 'Active' },
      { no: '5', letterOfCreditNumber: '187', applicantAccountName: 'Joshua Cheese & Milk Distributers', applicantAccountNumber: '03765432901', status:'Pending', actions: 'Active' },
    
    ];

    console.log("list:", this.rows);
    if (this.rows) {
      this.isLoading = false
    }
    this.dataSource = new MatTableDataSource(this.rows);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }


  // loadtotalCreatedLetters(){
  //   this.lcService.gettotalCreatedLetters().subscribe((data: any[]) => {
  //     this.dataSource = new MatTableDataSource(data);
  //     this.isLoading = false;
  //   });
  // }

  // public getLCs() {
  //   this.lcService.getAllLCs().subscribe({
  //     next: ((res) => {
  //       console.log("Response", res);
  //       if (res.length > 0) {
  //         this.dataSource = new MatTableDataSource(res);
  //         this.dataSource.paginator = this.paginator;
  //         this.dataSource.sort = this.sort;
  //         this.isLoading = false;
  //       } else {
  //         this.isLoading = false;
  //         this.snackbar.showNotification("", "No LCs found!")
  //       }
  //     }),
  //     error: ((err) => {
  //       this.isLoading = false;
  //     }),
  //     complete: (() => { })
  //   });
  // }

  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public add() {
    this.router.navigate(["/lc/create"])
  }

  public openViewLcComponent(row) {

    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { rowData: row }

    const dialogRef = this.dialog.open(TestComponent, dialogConfig);


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

    const dialogRef = this.dialog.open(TestComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }

  public verify() {
    this.router.navigate(['/lc/lcApproval'])

  }
 public transfer(row){
  this.router.navigate(["/lc/transferlc"])
  }
}