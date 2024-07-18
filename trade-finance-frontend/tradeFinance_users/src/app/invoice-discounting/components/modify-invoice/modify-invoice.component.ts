import { Component,Inject, OnInit } from '@angular/core';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modify-invoice',
  templateUrl: './modify-invoice.component.html',
  styleUrls: ['./modify-invoice.component.sass']
})
export class ModifyInvoiceComponent implements OnInit {

  rows: any;
 invoiceNumber: string;
  firstName: string;
  lastName: string;
  email: string;
  rowsname: string;
  role: string;
  phoneNo: any;
  InvDiscountingService: any;
modifyForm: any;

  constructor(
    // public dialogRef: MatDialogRef<ModifyInvoiceComponent>,
    // @Inject(MAT_DIALOG_DATA) public data: any,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private Service: InvDiscountingService,
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.invoiceNumber = params['invoiceNumber'];
      // Use this.invoiceNumber to fetch relevant data or perform actions
    });
  }

  onSubmit(): void {
    // this.updaterows();
    // this.dialogRef.close();
  }

  // updaterows(): void {
  //   // Perform the update logic here
  //   const updatedrows = {
  //     firstName: this.firstName,
  //     lastName: this.lastName,
  //     email: this.email,
  //     phoneNo: this.phoneNo,
  //     rowsname: this.rowsname,
  //     role: this.role
  //   };

  //   // Make an HTTP request to update the rows
  //   this.InvDiscountingService.updaterows(updatedrows).subscribe(
  //     (response) => {
  //       console.log('rows updated successfully:', response);
  //       // Optionally, perform any additional actions upon successful update

  //       // Close the dialog
  //       this.dialogRef.close();
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.error('Error updating rows:', error);
  //       // Handle the error appropriately
  //       this.snackBar.open("Error updating rows. Please try again later.", "Close", {
  //         duration: 5000,
  //         horizontalPosition: 'end',
  //         verticalPosition: 'top',
  //         panelClass: 'notify-error'
  //       });
  //     }
  //   );
  // }
}







