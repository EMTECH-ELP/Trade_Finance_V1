import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-delete-lc',
  templateUrl: './delete-lc.component.html',
  styleUrls: ['./delete-lc.component.sass']
})
export class DeleteLcComponent implements OnInit {
  lcId: string; // Property to store the ID of the Letter of Credit

  constructor() { }

  ngOnInit(): void {
  }

  confirmDelete(): void {
    // Perform deletion logic here, such as making an API call
    console.log('Deleting Letter of Credit with ID:', this.lcId);
    // After successful deletion, display success message and reset lcId
    alert('Letter of Credit deleted successfully.');
    this.lcId = ''; // Reset lcId
  }

  cancelDelete(): void {
    // Handle cancellation logic here, if needed
    console.log('Deletion canceled');
    // You may want to reset lcId or perform other actions here
  }
}
