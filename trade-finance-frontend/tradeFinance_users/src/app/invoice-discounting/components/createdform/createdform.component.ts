import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-createdform',
  templateUrl: './createdform.component.html',
  styleUrls: ['./createdform.component.sass']
})
export class CreatedformComponent implements OnInit {
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
  invoiceId:number
  invoiceData: any;
  currentDate:string;

    // applicationForm!: applicationFormDetails: 
    constructor(
      @Inject(MAT_DIALOG_DATA) public data: any,
      private router: Router,
      public service:InvDiscountingService,
      private activatedRoute: ActivatedRoute, 
      public dialogRef:MatDialogRef<CreatedformComponent>, 
      private snackbar: SnackbarService,
      ) {
     
       }
  
    ngOnInit(): void {
      const now = new Date();
      // Format the date and time as required by datetime-local input
      this.currentDate = this.formatDateTime(now); 
      console.log("Data received:", this.data);
      const data = this.data.rowData
      if (data) {
        this.rowData = data
        this.getInvoiceDataById(data.id)
      }
      const invoiceId = this.data.rowData.value
      if (invoiceId) {
        this.rowData = invoiceId
        console.log("data", invoiceId);
      }

      
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

    getInvoiceDataById(id:number){
      const url = `${environment.invUrl}/invoices/${id}`
      this.service.getData(url).subscribe(
        ((response) => {
          console.log("123456798",response);
          this.invoiceData = response
          
        }),
        ((error) => {
          console.log(error);
          
        }),
        () => {

        }
      )
    }
    approveAction(): void {
         // Prompt for password for approval
         const enteredPassword = prompt('Please enter your password:');
         alert('Successfully approved.');
      // if (enteredPassword!== null && enteredPassword === this.loggedInUserPassword) {
      //   console.log('Password matched!');
      // } 
      // else {
      //   alert('Incorrect password.');
      // }
    }
  
    rejectAction(): void {
     // Prompt for reason and password for rejection
    const enteredPassword = prompt('Please enter your reason for rejection:');
    const Password = prompt('Please enter your password:');
    if (enteredPassword!== null && enteredPassword === this.isLoggedIn) {
      console.log('Password matched and reason submitted.');
      // Process rejection
    }
    // else {
    //   alert('Incorrect password.');
    // }
  }

  // checkPassword(password: string): void {
  //   if (password!== this.isLoggedIn) {
  //     alert('Incorrect password.');
  //   }
  // }
  

    onClose(): void {
      this.dialogRef.close(false);
    }
  }
  