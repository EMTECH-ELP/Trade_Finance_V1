import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray, FormControl, Form } from '@angular/forms';
// import { SearchService } from '../../services/search.service';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.sass']
})
export class CreateInvoiceComponent implements OnInit {
 
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  additionalInvoices: FormArray;

  isLinear: true;
  query: string = '';
  searchData: any;

  selected = 'pending';
  selectedFiles: any;
  // formdata: any = {};

  // rows: any;

  // invoiceStatus: any;



  constructor(private builder: FormBuilder,
    private invDiscountingService: InvDiscountingService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,


    //private searchService: SearchService
  ) { }

  ngOnInit(): void {
    this.applicationForm = this.builder.group({
      accountNumber: ['', Validators.required],
      cifId: ['', Validators.required],
      nationalId: ['', Validators.required],
      accountName: ['', Validators.required],
      currency: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postalCode: ['', Validators.required],
      countryCode: ['', Validators.required],
      country: ['', Validators.required],

      // invoice details

      invoiceDate: ['', Validators.required],
      invoiceNumber: ['', Validators.required],
      invoiceAmount: ['', Validators.required],
      applicantBusinessName: ['', Validators.required],
      applicantBusinessAddress: ['', Validators.required],
      dueDate: ['', Validators.required],
      invoices: ['', Validators.required],    //file upload
      applicationForm: ['', Validators.required],       //file upload

      //  importer details
      buyerName: ['', Validators.required],
      buyerBusinessName: ['', Validators.required],
      buyerCity: ['', Validators.required],
      buyerCountry: ['', Validators.required],
      buyerEmailAddress: ['', [Validators.required, Validators.email]],
      terms_and_condition: ['', Validators.required],

      //  Funding details
      fundingAmount: ['', Validators.required],
      disbursalDate: ['', Validators.required],
      repaymentDate: ['', Validators.required],
      creditAccount: ['', Validators.required],
      creditLimit: ['', Validators.required],
      creditAppraisalForm: ['', Validators.required],   //file upload
 
      additionalInvoices: new FormArray ([
        new FormGroup({
           invoiceNo: new FormControl(''),
           invoiceAmount: new FormControl(''),
           applicantCompanyName: new FormControl(''),
           businessAddress: new FormControl(''),
           invoiceDate: new FormControl(''),
           due: new FormControl(''),
           files: new FormControl(''),
        })
    ]),
     importerDetails: new FormArray ([
        new FormGroup({
           fullName: new FormControl(''),
           email: new FormControl(''),
           buyerBusinessName: new FormControl(''),
           importerCountry: new FormControl(''),
           importerCity: new FormControl(''),
        })
    ]),
  })
  }

  addRowbtn1(){
    const formgroup = new FormGroup({
      invoiceNo: new FormControl(''),
      invoiceAmount: new FormControl(''),
      applicantCompanyName: new FormControl(''),
      businessAddress: new FormControl(''),
      invoiceDate: new FormControl(''),
      due: new FormControl(''),
      files: new FormControl(''),
    });
    (<FormArray>this.applicationForm.get('additionalInvoices')).push(formgroup);
  }
  addRowbtn2(){
    const formgroup = new FormGroup({
      fullName: new FormControl(''),
           email: new FormControl(''),
           buyerBusinessName: new FormControl(''),
           importerCountry: new FormControl(''),
           importerCity: new FormControl(''),
    });
    (<FormArray>this.applicationForm.get('importerDetails')).push(formgroup);
  }
  
  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];

    // Check if a file is selected
    if (selectedFile) {
      // Check file type
      if (selectedFile.type !== 'application/pdf') {
        // Display an error message or take appropriate action
        alert('Please select a PDF file.');

        // Clear the file input and disable it
        event.target.value = '';
        return;
      }
    }
  }
  onSubmit() {
    console.log("Form data", this.applicationForm.value);
  
    // First, post applicant details
    this.invDiscountingService.postApplicantDetails(this.applicationForm.value).subscribe({
      next: (response) => {
        console.log("Applicant Form response", response);
  
        // Next, post invoice details
        this.invDiscountingService.postInvoiceDetails(this.applicationForm.value).subscribe({
          next: (response) => {
            console.log("Invoice Form response", response);
  
            // Finally, post other data or perform any other actions
            this.invDiscountingService.postData(this.applicationForm.value).subscribe({
              next: (response) => {
                console.log("Other Form response", response);
                alert('Form Submitted Successfully!');
                this.router.navigate(["/invoice-discounting/viewInvoice"]);
              },
              error: (err) => {
                console.error(err);
                alert('An error occurred while submitting the form. Please try again later.');
              }
            });
          },
          error: (err) => {
            console.error(err);
            alert('An error occurred while submitting the invoice details. Please try again later.');
          }
        });
      },
      error: (err) => {
        console.error(err);
        alert('An error occurred while submitting the applicant details. Please try again later.');
      }
    });
  }
  
  // postapplicant() {
  //   console.log("Form data", this.applicationForm.value);
  //   // this.row = this.applicationForm.value;
  //   this.invDiscountingService.postapplicantDetails(this.applicationForm.value).subscribe({
  //     next: ((response) => {
  //       console.log("Invoice Form response", response);
  //     }),
  //     error: ((err) => {
  //       console.error(err);
  //       alert('An error occurred while submitting the form. Please try again later.');
  //     }),
  //     complete: (() => {})
  //   })
  //   // this.applicationForm.reset()

  // }
  // postInvoices() {
  //   console.log("Form data", this.applicationForm.value);
  //   // this.row = this.applicationForm.value;
  //   this.invDiscountingService.postinvoiceDetails(this.applicationForm.value).subscribe({
  //     next: ((response) => {
  //       console.log("Invoice Form response", response);
  //     }),
  //     error: ((err) => {
  //       console.error(err);
  //       alert('An error occurred while submitting the form. Please try again later.');
  //     }),
  //     complete: (() => {})
  //   })
  //   // this.applicationForm.reset()

  // }

  // onSubmit() {
  //   console.log("Form data", this.applicationForm.value);
  //   // this.row = this.applicationForm.value;
  //   this.invDiscountingService.postData(this.applicationForm.value).subscribe({
  //     next: ((response) => {
  //       console.log("Invoice Form response", response);
  //       alert('Form Submitted Successfully!')
  //     }),
  //     error: ((err) => {
  //       console.error(err);
  //       alert('An error occurred while submitting the form. Please try again later.');

  //     }),
  //     complete: (() => {})
  //   })
  //   // this.applicationForm.reset()
  //   this.ngOnInit()
  //   this.router.navigate(["/invoice-discounting/viewInvoice"]);
  // }
 

  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("received data", res),

          console.log("passed email", res.data[0].email)

        this.patchApplicationForm(res.data[0])
      }
    })
  }

  public patchApplicationForm(data: any): void {
    this.applicationForm.patchValue({
      accountNumber: data.accountNumber,
      cifId: data.cifId,
      nationalId: data.nationalId,
      accountName: data.accountName,
      currency: data.currency,
      email: data.email,
      phoneNumber: data.phoneNumber,
      address: data.address,
      city: data.city,
      postalCode: data.postalCode,
      countryCode: data.countryCode ? data.countryCode : 'NAN',
      country: data.country
    });
  }

}



