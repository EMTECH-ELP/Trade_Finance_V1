import { Component, OnInit } from '@angular/core';
import { AddCheckersComponent } from '../add-checkers/add-checkers.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-view-checkers',
  templateUrl: './view-checkers.component.html',
  styleUrls: ['./view-checkers.component.scss']
})
export class ViewCheckersComponent implements OnInit {

  dialogRef: any;
  searchQuery: any;
  
  filteredRows:any[]=[];
  // Sample data
  rows :any[]= [
    { name: 'Mercy Awiti', employeeId: '12345', email: 'mercy@equity.co.ke', branchName: 'Westlands', branchCode: 'A001', status: 'Active' },
    { name: 'Anne Wairimu', employeeId:'6578', email: 'anne@equitybank.co.ke', branchName: 'Tom Mboya', branchCode: 'A001', status: 'Active' },
    { name: ' Becky  Atieono', employeeId: '17654', email: 'becky@equitybank.co.ke', branchName: 'Githurai', branchCode: 'A001', status: 'Flagged' },
    { name: 'Moses West', employeeId: '65677', email: 'moses@equitybank.co.ke', branchName: 'Changamwe', branchCode: 'A001', status: 'Active' },
    { name: 'Mark Carl', employeeId: '1876', email: 'mark@equitybank.co.ke', branchName: 'Ruiru', branchCode: 'A001', status: 'Active' },
    { name: 'James Maina', employeeId: '18945', email: 'james@equitybank.co.ke', branchName: 'Moyale', branchCode: 'A001', status: 'Active' },
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
      const dialogRef = this.dialog.open(AddCheckersComponent, {
        width: '400px', // Set the width of the dialog
        disableClose: false, // Prevent closing the dialog by clicking outside or pressing Escape
        autoFocus: true, // Automatically focus on the first form field in the dialog
      });
  
      // Subscribe to the dialog closed event (optional)
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });

    }}

