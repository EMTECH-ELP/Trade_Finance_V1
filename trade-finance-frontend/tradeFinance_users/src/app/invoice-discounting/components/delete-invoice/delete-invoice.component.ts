import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { SearchService } from '../../services/search.service';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-delete-invoice',
  templateUrl: './delete-invoice.component.html',
  styleUrls: ['./delete-invoice.component.sass']
})
export class DeleteInvoiceComponent implements OnInit {
  injector: any;
event: Event;
id: number;
  // data: any;
  invoiceNumber: string;
  deletionReason: string;
  message: string;
  deleting: boolean = false;
 
  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<DeleteInvoiceComponent>,

  private snackBar: MatSnackBar,
     private service:SearchService) { }


     ngOnInit(): void {
      // Assuming data is injected via MatDialogData
      // this.id = this.data.id;
    }
    
  


    onDeleteInvoice(): void {
      if (this.invoiceNumber && this.deletionReason) {
        const trimmedInvoiceNumber = this.invoiceNumber.trim();
        this.deleting = true; // Indicate deletion is in progress
        this.service.deleteInvoice(trimmedInvoiceNumber).subscribe(
          response => {
            this.message = 'Invoice deleted successfully!';
            this.snackBar.open(this.message, 'Close', { duration: 3000 });
            this.dialogRef.close(true); // Close dialog and return true to the caller
          },
          error => {
            this.message = 'Error deleting invoice. Please try again.';
            this.snackBar.open(this.message, 'Close', { duration: 3000 });
            console.error('Error deleting invoice:', error);
          }
        ).add(() => {
          this.deleting = false; // Reset deletion state
        });
      } else {
        this.message = 'Please enter both invoice number and reason for deleting.';
        this.snackBar.open(this.message, 'Close', { duration: 3000 });
      }
    }
  
   

  onCancel() {
    // Close the dialog without deleting the invoice
    console.log('cancelled')
    this.dialogRef.close(false);
  }




  
}
