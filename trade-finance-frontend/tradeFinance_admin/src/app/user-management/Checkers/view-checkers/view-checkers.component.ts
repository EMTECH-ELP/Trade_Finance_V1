import { Component, OnInit, ViewChild } from '@angular/core';
import { AddCheckersComponent } from '../add-checkers/add-checkers.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-view-checkers',
  templateUrl: './view-checkers.component.html',
  styleUrls: ['./view-checkers.component.scss']
})
export class ViewCheckersComponent implements OnInit {

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'name', 'employeeId', 'email', 'branchName', 'branchCode','status'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  isLoading = true;
  rows: any;

  constructor(private dialog: MatDialog) { }
  ngOnInit(): void {
    this.getRows();
  }

  public getRows() {
    this.rows = [
      { name: 'Mercy Awiti', employeeId: '12345', email: 'mercy@equity.co.ke', branchName: 'Westlands', branchCode: 'A001', status: 'Active' },
      { name: 'Anne Wairimu', employeeId: '6578', email: 'anne@equitybank.co.ke', branchName: 'Tom Mboya', branchCode: 'A001', status: 'Active' },
      { name: ' Becky  Atieono', employeeId: '17654', email: 'becky@equitybank.co.ke', branchName: 'Githurai', branchCode: 'A001', status: 'Flagged' },
      { name: 'Moses West', employeeId: '65677', email: 'moses@equitybank.co.ke', branchName: 'Changamwe', branchCode: 'A001', status: 'Active' },
      { name: 'Mark Carl', employeeId: '1876', email: 'mark@equitybank.co.ke', branchName: 'Ruiru', branchCode: 'A001', status: 'Active' },
      { name: 'James Maina', employeeId: '18945', email: 'james@equitybank.co.ke', branchName: 'Moyale', branchCode: 'A001', status: 'Active' },
    ];

    console.log("list:", this.rows);
    if (this.rows) {
      this.isLoading = false
    }
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

  public refresh() {
    this.getRows();
  }

  public add(){
    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { test: "data" }

    const dialogRef = this.dialog.open(AddCheckersComponent, dialogConfig);


    dialogRef.afterClosed().subscribe((result) => {
      console.log('closed');
    });
  }

  edit(row: any): void {
    // Implement edit functionality here
    console.log('Edit:', row);
  }

  viewDetails(row: any): void {
    // Implement view details functionality here
    console.log('View Details:', row);
  }

  delete(row: any): void {
    // Implement delete functionality here
    console.log('Delete:', row);
  }


  openAddFormDialog(): void {
    const dialogRef = this.dialog.open(AddCheckersComponent, {

    });

  }
}