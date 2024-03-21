import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddMakersComponent } from '../add-makers/add-makers.component';
@Component({
  selector: 'app-view-makers',
  templateUrl: './view-makers.component.html',
  styleUrls: ['./view-makers.component.scss']
})
export class ViewMakersComponent implements OnInit {

    
applyFilter($event: KeyboardEvent) {
  throw new Error('Method not implemented.');
  }
  
  // Sample data
  rows = [
    { name: 'John Doe', employeeId: '12345', email: 'john@equity.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    { name: 'Nickson', employeeId:'6578', email: 'nickson@equitybank.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    { name: ' Alex Maina', employeeId: '17654', email: 'alex@equitybank.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    { name: 'Mary Wangu', employeeId: '65677', email: 'mary@equitybank.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    { name: 'Rose Mary', employeeId: '1876', email: 'rose@equitybank.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    { name: 'Willys Ari', employeeId: '18945', email: 'willys@equitybank.co.ke', branchName: 'Branch A', branchCode: 'A001', status: 'Active' },
    
  ]
  dialogRef: any;
  
  
  constructor( private dialog:MatDialog) { }
    ngOnInit(): void {
      throw new Error('Method not implemented.');
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
    console.log('Delete:', row);}
  
  
    openAddFormDialog(): void {
      const dialogRef = this.dialog.open(AddMakersComponent, {
        width: '400px', // Set the width of the dialog
        disableClose: false, // Prevent closing the dialog by clicking outside or pressing Escape
        autoFocus: true, // Automatically focus on the first form field in the dialog
      });
  
      // Subscribe to the dialog closed event (optional)
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });

    }}
