import { Component, OnInit, ViewChild } from '@angular/core';
import { AddUsersComponent } from '../add-users/add-users.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { AuthService } from 'src/app/core/service/auth.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.scss']
})
export class ViewUsersComponent implements OnInit {

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'name', 'employeeId', 'email', 'branchName', 'branchCode','roles', 'status',  'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  isLoading = true;
  users: any;

  constructor(private dialog: MatDialog, private authservice: AuthService) { }
  ngOnInit(): void {
    this.getAllUsers();
  }


  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public refresh() {
    this.getAllUsers();
    }

  getAllUsers(): void {
    this.authservice.getAllUsers().subscribe({
      next: (result: any) => {
        if (result.statusCode === 302) {
          this.isLoading = false
        
          this.dataSource = new MatTableDataSource(result.entity);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        }
      },
      error: (error) => {}
    })
  }
 
  public add(){
    const dialogConfig = new MatDialogConfig()
    dialogConfig.disableClose = true
    dialogConfig.autoFocus = true
    dialogConfig.width = '600px'
    dialogConfig.data = { test: "data" }

    const dialogRef = this.dialog.open(AddUsersComponent, dialogConfig);


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
    const dialogRef = this.dialog.open(AddUsersComponent, {

    });

  }
}