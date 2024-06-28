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

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<DeleteInvoiceComponent>,

  private snackBar: MatSnackBar,
     private service:SearchService) { }


     ngOnInit(): void {
      // Assuming data is injected via MatDialogData
      this.id = this.data.id;
    }
    
  


    onDelete(event: Event, id: number): void {
      event.stopPropagation();
      if (confirm('Are you sure you want to delete this invoice?')) {
        this.service.deleteInvoice(id).subscribe(() => {
          this.snackBar.open('Invoice deleted successfully', 'Close', {
            duration: 3000,
          });
          this.dialogRef.close(true);
        });
      }
    }
    

  onCancel() {
    // Close the dialog without deleting the invoice
    console.log('cancelled')
    this.dialogRef.close(false);
  }




  
}
