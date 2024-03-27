import { Component, OnInit, ViewChild } from '@angular/core';
import { AddMakersComponent } from '../add-makers/add-makers.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
@Component({
  selector: 'app-view-makers',
  templateUrl: './view-makers.component.html',
  styleUrls: ['./view-makers.component.scss']
})
export class ViewMakersComponent implements OnInit {
 
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
      { name: 'Anne Wairimu', employeeId: '12345', email: 'ann@equitybank.co.ke', branchName: 'Kasarani', branchCode: '054', status: 'Active' },
      { name: 'Fridah Atieno', employeeId: '6578', email: 'fridah@equitybank.co.ke', branchName: 'Limuru', branchCode: '032', status: 'Active' },
      { name: 'Alex James', employeeId: '17654', email: 'alex@equitybank.co.ke', branchName: 'Eldoret', branchCode: '122', status: 'Flagged' },
      { name: 'Zippy West', employeeId: '65677', email: 'zippy@equitybank.co.ke', branchName: 'Nakuru', branchCode: '078', status: 'Active' },
      { name: 'Mark Carl', employeeId: '1876', email: 'mark@equitybank.co.ke', branchName: 'Kisii', branchCode: '098', status: 'Active' },
      { name: 'Regina Maina', employeeId: '18945', email: 'regina@equitybank.co.ke', branchName: 'Nyali', branchCode: '101', status: 'Active' },
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

    const dialogRef = this.dialog.open(AddMakersComponent, dialogConfig);


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
    const dialogRef = this.dialog.open(AddMakersComponent, {

    });

  }

    }
