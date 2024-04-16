import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import { MatDialog } from '@angular/material/dialog';




@Component({
  selector: 'app-create-dc',
  templateUrl: './create-dc.component.html',
  styleUrls: ['./create-dc.component.sass'],
})
export class CreateDcComponent implements OnInit {
  dcForm: FormGroup;
  isPreviewMode: boolean = false;

  constructor(private fb: FormBuilder, private http: HttpClient,private dialog: MatDialog) {}

  ngOnInit(): void {
    this.initForm(); // Initialize dcForm property in ngOnInit()
  }

  initForm(): void {
    // Initialize dcForm using FormBuilder
    this.dcForm = this.fb.group({
      documentaryCollectionDetails: this.fb.group({
        // Defined form controls and nested form groups 
        dcType: ['select', Validators.required],
        
      }),
      // Defined top-level form controls 
      custAccountNumber: ['', Validators.required],
    custAccountName: ['', Validators.required],
    custBalance: ['', Validators.required],
    custAddress: ['', Validators.required],
    custEmail: ['', [Validators.required, Validators.email]],
    custPhone: ['', Validators.required],
    custBranch: ['', Validators.required],
    benFirstName: [''],
    benMiddleName: [''],
    benLastName: [''],
    benAddress: ['', Validators.required],
    benEmail: ['', [Validators.required, Validators.email]],
    benPhone: ['', Validators.required],
    benBank: ['', Validators.required],
    benBankCode: ['', Validators.required],
    benBankSwift: ['', Validators.required],
    benCity: ['', Validators.required],
    benCountry: ['', Validators.required],
    benAccountName: ['', Validators.required],
    benAccountNumber: ['', Validators.required],
    benCurrency: ['', Validators.required],
    originCountry:['', Validators.required],
    loadingPort:['', Validators.required],
    dischargePort:['', Validators.required],
    goodsDescription:['', Validators.required],
    DCquantity:['', Validators.required],
    DCvalue:['', Validators.required],
    shipDateStart:['', Validators.required],
    shipDateEnd:['', Validators.required],
    DCbillOfLading:['', Validators.required],
    DCinvoice:['', Validators.required],
    totPayableAmount:['', Validators.required],
    chargeAccount:['', Validators.required],
    payableAmount:['', Validators.required],
    payingAmount:['', Validators.required],
    invoices: [[], [Validators.required]],
    packingList: [[], Validators.required],
    billOfLading: [[], Validators.required],
    billOfExchange: [[], Validators.required],
    insuranceCertificate: [[]],
    inspectionCertificate: [[]],
    originCert: [[], Validators.required]


    
    });
  }

  

  



  
  












  


  onSubmit(): void {
   // Handle form submission
   if (this.dcForm.valid) {
    // Show preview mode
    this.isPreviewMode = true;
  } 
  else {
    // Form is invalid, show error message or prevent submission
    console.log('Form is invalid');
  }

  }

  cancelPreview(): void {
    // Cancel preview mode
    this.isPreviewMode = false;
  }

  saveAsDraft(): void {
    // Save form data as draft
    console.log('Form saved as draft');
    console.log('Draft data:', this.dcForm.value);
    this.isPreviewMode = false; // Exit preview mode after saving as draft
  }

  submitForm(): void {
    // Send form data to the server
    console.log('Form submitted successfully');
    console.log('Form data:', this.dcForm.value);
    this.isPreviewMode = false; // Exit preview mode after form submission
    
}
}