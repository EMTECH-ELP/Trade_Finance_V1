import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { SearchService } from '../../services/search.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-delete-invoice',
  templateUrl: './delete-invoice.component.html',
  styleUrls: ['./delete-invoice.component.sass']
})
export class DeleteInvoiceComponent implements OnInit {
  data: any;

  
  constructor(private http:HttpClient, 
    private dialogRef: MatDialogRef<DeleteInvoiceComponent >,
    
     private service:SearchService) { }





  onDelete() {
    this.service.deleteInvoice(this.data.id).subscribe(
      response => {
        // Handle successful deletion
        alert('Successfully deleted');
        this.dialogRef.close(true);
      },
      error => {
        // Handle error
        alert('Error deleting invoice');
        this.dialogRef.close(false);
      }
    );
    // Add logic to delete the invoice
    // Close the dialog after deletion
    
    
  }

  onCancel() {
    // Close the dialog without deleting the invoice
    console.log('cancelled')
    this.dialogRef.close(false);
  }




  ngOnInit(): void {
  }

}
