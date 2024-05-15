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
import { ModifyComponent } from '../modify/modify.component';
import { DeleteLcComponent } from '../delete-lc/delete-lc.component';



interface LetterOfCredit {
  name: string;
  lcNumber: string;
  accountName: string;
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
  totalCreatedLetters: number = 5;
  totalPendingLetters: number = 5;
  totalApprovedLetters: number = 0;
  totalRejectedLetters: number = 0;
  selectedactions = 'all';
  count = 0;
  lcCount = 0;


  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'lcNumber', 'accountName', 'accountNumber', 'status', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  isLoading = true;
  products: any;
  lcs: any;
  rows: any;
  selectedStatus: any;


  constructor(private dialog: MatDialog,
    private router: Router,
    private lcService: LcService,
    private snackbar: SnackbarService
  ) { }


  ngOnInit(): void {
    this.getAllLCs();
  }

  public getAllLCs() {
    this.lcService.getAllLCs().subscribe({
      next: (res: any) => {
        const extractedData = res.data.map((lc: any, index: number) => ({
          no: index + 1,
          lcNumber: lc.lcNumber,
          lcType: lc.lcType,
          amount: lc.amount,
          accountName: lc.accountName ? 'Account Name' : '', // Replace this with actual account name retrieval logic
          accountNumber: lc.accountNumber ? lc.accountNumber : '',
          status: lc.status,
          actions: 'Actions',// Replace this with actual actions logic
        }));

        this.dataSource = new MatTableDataSource(extractedData);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err) => {
        console.error('Error fetching LCs:', err);
        this.snackbar.showNotification('error', 'No LCs found');
      }
    });
  }


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
    dialogConfig.width = '800px'
    dialogConfig.data = { rowData: row }

    const dialogRef = this.dialog.open(TestComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }
  public refresh() {
    // const dialogConfig = new MatDialogConfig()
    // dialogConfig.disableClose = true
    // dialogConfig.autoFocus = true
    // dialogConfig.width = '600px'
    // dialogConfig.data = { test: "row" }

    // const dialogRef = this.dialog.open(ModifyComponent, dialogConfig);


    // dialogRef.afterClosed().subscribe((result) => {
    //   console.log('closed');
    // });
    // this.router.navigate(['/lc/modify'])
  }
public modify(){
  this.router.navigate(['/lc/modify'])
}
  public verify() {
    this.router.navigate(['/lc/verify'])

  }
  public transfer() {
    this.router.navigate(["/lc/transferlc"])
  }
public openDeleteConfirmationDialog(){
    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { test: "row" }

    const dialogRef = this.dialog.open(DeleteLcComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
}
}