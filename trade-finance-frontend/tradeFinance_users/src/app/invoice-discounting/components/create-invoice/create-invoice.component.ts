import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray, FormControl, Form } from '@angular/forms';

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
applicantsForm:FormGroup;

  formData: any = {}; // Initialize your form data
  isLinear: true;
  query: string = '';
  searchData: any;

  selected = 'pending';
  selectedFiles: any;

  applicantDetails :any;
  invoiceDetails: any;
  fundingDetails: any



  constructor(private builder: FormBuilder,
    private invDiscountingService: InvDiscountingService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,


  ) {  }

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
      // terms_and_condition: ['', Validators.required],

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
 
  processValues(){
    const applicantDetails = {
      "accountNumber": this.applicationForm?.get("accountNumber").value,
      "cifId": this.applicationForm?.get("cifId").value,
      "nationalId": this.applicationForm?.get("nationalId").value,
      "accountName": this.applicationForm?.get("accountName").value,
      "currency":this.applicationForm?.get("currency").value,
      "email": this.applicationForm?.get("email").value,
      "phoneNumber":this.applicationForm?.get("phoneNumber").value,
      "address": this.applicationForm?.get("address").value,
      "city": this.applicationForm?.get("city").value,
      "postalCode": this.applicationForm?.get("postalCode").value,
      "countryCode": this.applicationForm?.get("countryCode").value,
      "country": this.applicationForm?.get("country").value,
    }

    const invoiceDetails = {
      "invoiceDate": this.applicationForm?.get("invoiceDate").value,
      "invoiceNumber": this.applicationForm?.get("invoiceNumber").value,
      "invoiceAmount": this.applicationForm?.get("invoiceAmount").value,
      "applicantBusinessName": this.applicationForm?.get("applicantBusinessName").value,
      "applicantBusinessAddress": this.applicationForm?.get("applicantBusinessAddress").value,
      "dueDate":this.applicationForm?.get("dueDate").value,
      "invoices": this.applicationForm?.get("invoices").value,  //file upload
      "applicationForm": this.applicationForm?.get("applicationForm").value,      //file upload

      //  importer details
      "buyerName": this.applicationForm?.get("buyerName").value,
      "buyerBusinessName":this.applicationForm?.get("buyerBusinessName").value,
      "buyerCity": this.applicationForm?.get("buyerCity").value,
      "buyerCountry": this.applicationForm?.get("buyerCountry").value,
      "buyerEmailAddress": this.applicationForm?.get("buyerEmailAddress").value,
      // "terms_and_condition":this.applicationForm?.get("terms_and_condition").value,
    }

    const fundingDetails = {
      "fundingAmount": this.applicationForm?.get("fundingAmount").value,
      "disbursalDate": this.applicationForm?.get("disbursalDate").value,
      "repaymentDate": this.applicationForm?.get("repaymentDate").value,
      "creditAccount": this.applicationForm?.get("creditAccount").value,
      "creditLimit": this.applicationForm?.get("creditLimit").value,
      "creditAppraisalForm": this.applicationForm?.get("creditAppraisalForm").value,
    }

    this.applicantDetails = applicantDetails
    this.invoiceDetails = invoiceDetails
    this.fundingDetails = fundingDetails
  }
  onSubmit(): void {
    this.processValues()
    this.invDiscountingService.postApplicantDetails
    this.invDiscountingService.postInvoiceDetails
    this.invDiscountingService.postFundingDetails
    const formData = this.applicationForm.value;
       console.log(this.applicationForm.value);

    // if (this.applicationForm.valid) {
    //   const formData = this.applicationForm.value;
    //   console.log(formData);
    // } else {
    //   console.log(this.applicationForm.value);
    //   console.error('Form is invalid');
    //  alert("Form is Invalid")
    // }
    this.SubmitApplicant()
  }
  SubmitApplicant() {
    console.log(this.applicantDetails);
    console.log(this.invoiceDetails);
    console.log(this.fundingDetails);

    console.log("Form data", this.applicantDetails);
    this.invDiscountingService.postApplicantDetails(this.applicantDetails).subscribe({
      next: (responses) => {
        console.log("Invoice Form response", responses);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        this.submitInvoice()
      
          }
    });


  
  }
  submitInvoice(){
    console.log("Form data", this.invoiceDetails);
    this.invDiscountingService.postInvoiceDetails(this.invoiceDetails).subscribe({
      next: (responses) => {
        console.log("Invoice Form response", responses);
      },
      error: (err) => {
        console.error(err);
    
      },
      complete: () => {
        this.submitFunding()
      
          }
    })
  }
  submitFunding(){

    console.log("Form data", this.fundingDetails);
    this.invDiscountingService.postFundingDetails(this.fundingDetails).subscribe({
      next: (responses) => {
        console.log("Invoice Form response", responses);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
         this.applicationForm.reset();
        this.ngOnInit();
          alert('Form Submitted Successfully!')
        let result = window.confirm('Click OK to submit. Click Cancel to abort');
        if (result) {
          console.log(result)
            alert('Form Submitted Successfully!');
        }

      
          }
    })
  }

 

 

  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("passed email", res.entity[0].email)

        this.patchApplicationForm(res.entity[0])
      }
    })
  }

//Full form submission
// createInvoiceForm(data: any) {
//   const body = {
//     "accountNumber": data.accountNumber,
//     "cifId": data.cifId,
//     "nationalId": data.nationalId,
//     "accountName": data.accountName,
//     "currency": data.currency,
//     "email": data.email,
//     "phoneNumber":data.phoneNumber,
//     "address": data.address,
//     "city": data.city,
//     "postalCode":data.postalCode,
//     "countryCode":data.countryCode,
//     "country": data.country,
//     "invoiceDate": data.invoiceDate,
//       "invoiceNumber":data.invoiceNumber,
//       "invoiceAmount": data.invoiceAmount,
//       "applicantBusinessName": data.applicantBusinessName,
//       "applicantBusinessAddress": data.applicantBusinessAddress,
//       "dueDate":data.dueDate,
//       "invoices": data.invoices,                          //Doc upload
//       "applicationForm": data.applicationForm,
//       "buyerName":data.buyerName,
//       "buyerBusinessName":data.buyerBusinessName,
//       "buyerCity": data.buyerCity,
//       "buyerCountry":data.buyerCountry,
//       "buyerEmailAddress":data.buyerEmailAddress,
  
//       "fundingAmount": data.fundingAmount,
//       "disbursalDate": data.disbursalDate,
//       "repaymentDate": data.repaymentDate,
//       "creditAccount": data.creditAccount,
//       "creditLimit": data.creditLimit,
//       "creditAppraisalForm": data.creditAppraisalForm,    //Doc upload
// };
//   return body;
// }
// onSubmit() {
//   console.log("Form data", this.applicationForm.value);
//   const data = this.createInvoiceForm(this.applicationForm.value)
//   this.invDiscountingService.sendData(data,this.applicationForm.get('accountNumber')?.value).subscribe({
//     next: ((response) => {
//       console.log("InvoiceForm create response", response);
//     }),
//     error: ((err) => {
//       console.error(err)
//     }),
//     complete: (() => { })
//   })
//   this.applicationForm.reset()
//   this.ngOnInit()
//   //alert('Form Submitted Successfully!')
//   let result = window.confirm('Click OK to submit. Click Cancel to abort');
//   if (result) {
//       alert('Form Submitted Successfully!');
//       this.router.navigate(["/invoice-discounting/viewInvoiceForm"]);
//   } else {
//       alert('Application Cancelled');
//       this.router.navigate(["/invoice-discounting/createInvoiceForm"]);
//   }

   
// }


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



