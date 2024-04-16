import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-lookup',
  templateUrl: './lookup.component.html',
  // styleUrls: ['./lookup.component.css']
})
export class LookupComponent {
  accountNumber: string;
  applicationForm: any; // Assuming this is the structure of application form details you expect
  searchForm: FormGroup; // Assuming you have a FormGroup for the search form

  @Output() applicationFormEvent = new EventEmitter<any>();
  dialogRef: any;

  constructor(private http: HttpClient, private formBuilder: FormBuilder) { 
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

  search() {
    // Make an HTTP request to fetch application form details based on the account number
    this.http.get<any>(`http://192.168.91.166:8181/api/collection/create=${this.accountNumber}`).subscribe(
      (data) => {
        this.applicationForm = data;
        // Patch the form with fetched application form details
        this.searchForm.patchValue({
          accountNumber: this.applicationForm.accountNumber,
          cifId: this.applicationForm.cifId,
          currency: this.applicationForm.currency,
          email: this.applicationForm.email,
          phoneNumber: this.applicationForm.phoneNumber,
          address: this.applicationForm.address,
          city: this.applicationForm.city,
          postalCode: this.applicationForm.postalCode,
          countryCode: this.applicationForm.countryCode,
          country: this.applicationForm.country

          
        
        });
        // Emit an event with application form details
        this.applicationFormEvent.emit(this.applicationForm);
        // Close the dialog
      },
      (error) => {
        console.error('Error fetching application form details:', error);
      }
    );
  }
  closeDialog() {
    // Close the dialog
    this.dialogRef.close();
  }
}
