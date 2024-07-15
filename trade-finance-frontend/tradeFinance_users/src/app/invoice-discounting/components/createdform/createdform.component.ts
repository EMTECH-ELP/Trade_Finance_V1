import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SharedService } from '../shared.service';


@Component({
  selector: 'app-createdform',
  templateUrl: './createdform.component.html',
  styleUrls: ['./createdform.component.sass']
})
export class CreatedformComponent implements OnInit {
  approverName: string = '';
  approverEmail: string = '';
  approvalForm: FormGroup; // Define FormGroup for email validation


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
event: any;
  accountNumber: any;
  


  constructor(
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private sharedService: SharedService,
    private router: Router,
    public service: InvDiscountingService,
  
  ) {
    this.approvalForm = this.fb.group({
      approverName: ['', Validators.required],
      approverEmail: ['', [Validators.required, Validators.email]]
    });
   
    console.log('Received Data:', this.data);
  }

  ngOnInit(): void {
    const now = new Date();
    // Format the date and time as required by datetime-local input
    this.currentDate = this.formatDateTime(now);
    console.log('Received Data:', this.applicationForm);
    this.route.paramMap.subscribe(params => {
      this.accountNumber = params.get('accountNumber');
      this.fetchData(this.accountNumber);
    });

  }
  fetchData(accountNumber: string): void {
    this.service.getDataById(accountNumber).subscribe(
      (data) => {
        this.data = data;
        // Handle the fetched data
      },
      (error) => {
        console.error('Error fetching data by ID:', error);
        alert('Failed to fetch data. Please try again later.');
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
    // Check if approverName and approverEmail are filled
    if (!this.approverName || !this.approverEmail) {
      this.snackBar.open('Please fill in the Name and Email fields before approving.', 'Close', { duration: 3000 });
      return;
    }

    // Prompt for invoice number
    const enteredInvoiceNumber = prompt('Please enter the Invoice Number for Approval:');
    if (!enteredInvoiceNumber) {
      // User canceled the prompt
      return;
    }

    const invoiceNumber = this.data?.invoices?.[0]?.invoiceNumber;

    if (enteredInvoiceNumber === invoiceNumber) {
      // Call service method to approve invoice
      this.service.approveInvoice(invoiceNumber).subscribe(
        response => {
          this.snackBar.open('Invoice approved successfully!', 'Close', { duration: 3000 });
          // Handle success scenario (e.g., close dialog if using MatDialog)
          // this.dialogRef.close(true);
        },
        error => {
          console.error('Error approving invoice:', error);
          // Handle specific error cases
          if (error.status === 404) {
            this.snackBar.open('Invoice not found. Please check the invoice number and try again.', 'Close', { duration: 3000 });
          } else {
            this.snackBar.open('Failed to approve invoice. Please try again.', 'Close', { duration: 3000 });
          }
        }
      );
    } else {
      this.snackBar.open('Invoice number does not match. Please try again.', 'Close', { duration: 3000 });
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


  closeForm(){
    this.router.navigate(["invoice-discounting/viewInvoice"])
  }


  
  printForm(): void {
    const printContent = document.getElementById('printable-content');
  
    if (printContent) {
      const WindowPrt = window.open('', '', 'width=900,height=650');
      const printDiv = WindowPrt.document.createElement('div');
  
      // Append the existing content
      printDiv.innerHTML = printContent.innerHTML;
  
      // Append additional information
      const approverParagraph = WindowPrt.document.createElement('p');
      approverParagraph.innerHTML = `<strong>Approved by:</strong> ${this.approverName}`;
      printDiv.appendChild(approverParagraph);
  
      const emailParagraph = WindowPrt.document.createElement('p');
      emailParagraph.innerHTML = `<strong>Email:</strong> ${this.approverEmail}`;
      printDiv.appendChild(emailParagraph);
  
      const dateParagraph = WindowPrt.document.createElement('p');
      dateParagraph.innerHTML = `<strong>Date:</strong> ${this.currentDate}`;
      printDiv.appendChild(dateParagraph);
  
      WindowPrt.document.body.appendChild(printDiv);
  
      // Add custom styles if needed
      const style = WindowPrt.document.createElement('style');
      style.textContent = `
        /* Your custom styles for print */
        body { font-family: Arial, sans-serif; }
        p { margin: 10px 0; }
        strong { font-weight: bold; }
      `;
      WindowPrt.document.head.appendChild(style);
  
      WindowPrt.focus();
      WindowPrt.print();
      WindowPrt.close();
    } else {
      console.error('Printable content element not found.');
    }
  }
  


}
