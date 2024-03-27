import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddMakersComponent } from '../add-makers/add-makers.component';
@Component({
  selector: 'app-view-makers',
  templateUrl: './view-makers.component.html',
  styleUrls: ['./view-makers.component.scss']
})
export class ViewMakersComponent implements OnInit {
  dialogRef: any;
  searchQuery: any;
  
  filteredRows:any[]=[];
  // Sample data
  rows :any[]= [
    { name: 'John Doe', employeeId: '12345', email: 'john@equity.co.ke', branchName: 'Umoja', branchCode: 'A001', status: 'Active' },
    { name: 'Nickson', employeeId:'6578', email: 'nickson@equitybank.co.ke', branchName: 'Kasarani', branchCode: 'A001', status: 'Active' },
    { name: ' Alex Maina', employeeId: '17654', email: 'alex@equitybank.co.ke', branchName: 'Westlands', branchCode: 'A001', status: 'Active' },
    { name: 'Mary Wangu', employeeId: '65677', email: 'mary@equitybank.co.ke', branchName: 'Garden City', branchCode: 'A001', status: 'Active' },
    { name: 'Rose Mary', employeeId: '1876', email: 'rose@equitybank.co.ke', branchName: 'Ruiru', branchCode: 'A001', status: 'Active' },
    { name: 'Willys Ari', employeeId: '18945', email: 'willys@equitybank.co.ke', branchName: 'Moyale', branchCode: 'A001', status: 'Active' },
  ]
  constructor( private dialog:MatDialog) { }
    ngOnInit(): void {
      this.filteredRows=this.rows
    }
 search() {
      if (this.searchQuery.trim() === '') {
        // If search query is empty, show all rows
        this.filteredRows = this.rows;
      } else {
        // Filter rows based on searchQuery
        this.filteredRows = this.rows.filter(row =>
          row.name.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
          row.employeeId.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
          row.email.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
          row.branchName.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
          row.branchCode.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
          row.status.toLowerCase().includes(this.searchQuery.toLowerCase())
        );
      }
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
