import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LookUpService } from '../look-up.service';
import { MatDialogRef } from '@angular/material/dialog';



@Component({
  selector: 'app-lookup',
  templateUrl: './lookup.component.html',
  // styleUrls: ['./lookup.component.css']
})
export class LookupComponent implements OnInit {
  accountNumber: string;
  applicationForm: any; 
  searchForm: FormGroup; 
  cifId: string;
  nationalId: string

  @Output() applicationFormEvent = new EventEmitter<any>();
  dialogRef: any;

  constructor(private http: HttpClient, private formBuilder: FormBuilder, private lookupService: LookUpService, private dialog: MatDialogRef<LookupComponent>) { 
    this.searchForm = this.formBuilder.group({
      accountNumber: [''],
      cifId: [''],
      currency: [''],
      email: [''],
      phoneNumber: [''],
      address: [''],
      city: [''],
      postalCode: [''],
      countryCode: [''],
      country: ['']
    });
  }

  ngOnInit(): void {
    // Initialization code here
  }
  

//    search() {
//    this.lookupService.getFormDetailsByAccountNumber(this.accountNumber).subscribe(
//      (data) => {
//     // Handle successful response
//    this.applicationForm = data;
//          // Emit the application form event
//          this.applicationFormEvent.emit(this.applicationForm);
//          const result = data
//         this.dialog.close(result)
//        },
//        (error) => {
//          // Handle error
//          console.error('Error fetching application form details:', error);
//        }
//      );
//  }


   search() {
     // Check if the account number is empty
    if (!this.accountNumber || this.accountNumber.trim() === '') {
       alert('Account number is required.');
       return;
     }
  
    this.lookupService.getFormDetailsByAccountNumber(this.accountNumber).subscribe(
       (data) => {
        // Handle successful response
         this.applicationForm = data;
         // Emit the application form event
         this.applicationFormEvent.emit(this.applicationForm);
         const result = data;
         this.dialog.close(result);
       },
       (error) => {
         // Handle error
         if (error.status === 404) {
           alert('Account number does not exist.');
         } else {
           alert('Unable to fetch details. Please try again later.');
         }
         console.error('Error fetching application form details:', error);
       }
     );
   }

   closeDialog(): void {
    this.dialog.close(); 
  }


}
