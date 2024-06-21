import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { environment } from 'src/environments/environment';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';



@Component({
  selector: 'app-createdform',
  templateUrl: './createdform.component.html',
  styleUrls: ['./createdform.component.sass']
})
export class CreatedformComponent implements OnInit {
  viewForm: FormGroup;
  showRejectPrompt = false;
  isLoggedIn: string;
  loggedInUserPassword: string;
  createdform;
  createdformNo;
  uploadedFile: File | null = null;
  fileUrl: string | null = null;
  applicationForm: any;
  mockData: any;
  rowData: any;
  invoiceId: number
  invoiceData: any;
  currentDate: string;
  invoices: any;
  data: any;

  // applicationForm!: applicationFormDetails: 
  constructor(
    @Inject(MAT_DIALOG_DATA) public receivedData: any,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    public service: InvDiscountingService,
    public dialogRef: MatDialogRef<CreatedformComponent>
  ) {
    this.data = receivedData; // Assign received data to class property
    console.log('Received Data:', this.data);
  }

  ngOnInit(): void {
    const now = new Date();
    // Format the date and time as required by datetime-local input
    this.currentDate = this.formatDateTime(now);
    console.log('Received Data:', this.applicationForm);


  }
  getFormByNationalId(id: any): void {
    console.log(id)
    this.service.getDataById(id).subscribe(
      (response: any) => {
        console.log('Form Data:', response);
        // Handle successful response, e.g., assign to a property for binding in template
      },
      (error) => {
        console.error('Error fetching form data:', error);
        // Handle error, show error message, etc.
      }
    );
  }
  // Function to format date and time
  private formatDateTime(date: Date): string {
    const year = date.getFullYear();
    const month = this.padZero(date.getMonth() + 1);
    const day = this.padZero(date.getDate());
    const hours = this.padZero(date.getHours());
    const minutes = this.padZero(date.getMinutes());
    // Combine date and time in the required format: YYYY-MM-DDTHH:mm
    return `${year}-${month}-${day}T${hours}:${minutes}`;
  }

  // Function to pad single-digit numbers with leading zero
  private padZero(num: number): string {
    return num < 10 ? '0' + num : num.toString();
  }
  downloadFile(): void {
    if (this.fileUrl) {
      const link = document.createElement('a');
      link.href = this.fileUrl;
      link.download = this.uploadedFile?.name ?? 'download';
      link.click();
    }
  }

  approveAction(): void {
    // Prompt for InvoiceNumber for approval
    const enteredinvoiceNumber = prompt('Please enter the Invoice Number for Approval:');
    const invoiceNumber = this.data?.invoices?.[0]?.invoiceNumber;
    if (invoiceNumber) {
      this.service.approveInvoice(invoiceNumber).subscribe(response => {
        this.snackBar.open('Invoice approved successfully!', 'Close', { duration: 3000 });
        this.dialogRef.close(true); // Close dialog and return success
      }, error => {
        console.error('Error approving invoice:', error);
        this.snackBar.open('Failed to approve invoice. Please try again.', 'Close', { duration: 3000 });
      });
    }
  }

  rejectAction(): void {
    // Prompt for reason and password for rejection
    const enteredPassword = prompt('Please enter your reason for rejection:');
    if (enteredPassword !== null && enteredPassword === this.isLoggedIn) {
      console.log('Password matched and reason submitted.');
      // Process rejection
    }
    // else {
    //   alert('Incorrect password.');
    // }
  }



  onClose(): void {
    this.dialogRef.close(false);
  }
  // print(): void {
  //   const printContent = document.getElementById('printable-content');
  //   const WindowPrt = window.open('', '', 'width=900,height=650');
  //   WindowPrt.document.write('<html><head><title>Print Invoice</title>');
  //   WindowPrt.document.write('<style>/* Your custom styles for print */</style>');
  //   WindowPrt.document.write('</head><body>');
  //   WindowPrt.document.write(printContent.innerHTML);
  //   WindowPrt.document.write('</body></html>');
  //   WindowPrt.document.close();
  //   WindowPrt.focus();
  //   WindowPrt.print();
  //   WindowPrt.close();
  // }
}
