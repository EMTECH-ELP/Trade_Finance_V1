import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LcService } from '../../services/lc.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  additionalFileUploads:{label: string}[]=[];
  // dialog: any;
 // router: any;

  constructor(private fb: FormBuilder,
    private lcService: LcService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    // private lookupDialog: MatDialogRef<LookupComponent>
  ) { }



  ngOnInit() {

    this.applicationForm = this.fb.group({
      accountNumber: ['', Validators.required],
      cifId: ['', Validators.required],
      nationalId: ['', Validators.required],
      accountName: ['', Validators.required],
      currency: ['', Validators.required],
      email: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postalCode: ['', Validators.required],
      countryCode: ['', Validators.required],
      country: ['', Validators.required],

      //Step2: Beneficiary details
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryIban: ['', Validators.required],
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryAddressLine2: [''],
      beneficiaryCity: ['', Validators.required],
      beneficiaryPostalCode: ['', Validators.required],
      beneficiaryCountryCode: ['', Validators.required],
      beneficiaryCountry: ['', Validators.required],
      advisingBankName: [''],
      advisingBankCountry: [''],
      advisingBankBic: ['', Validators.required],     //For SWIFT CODE
      //beneficiaryPhoneNumber: ['', Validators.required],

      //Step 3: LC details 
      lcNumber: [''],
      lcType: ['', Validators.required],
      applicableRules: ['', Validators.required],
      shipmentDate: ['', Validators.required],
      portOfDischarge: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      shipmentTerms: ['', Validators.required],
      partialShipment: ['', Validators.required],
      transShipment: ['', Validators.required],
      issueDate: ['', Validators.required],
      expiryDate: ['', Validators.required],
      tenor: ['', Validators.required], 
      transferable: ['', Validators.required],
      negotiationPeriod: ['', Validators.required],
      commodityCode: ['', Validators.required],
      goodsQuantity: ['', Validators.required],
      pricePerUnit: ['', Validators.required],
      countyOfOrigin: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      amount: ['', Validators.required],
      transferAmount: [''],
      transferCurrencyCode: [''],
      newExpiryDate: [''],
      currencyCode: ['', Validators.required],
      collateralType: ['', Validators.required],
      collateralId: ['',],
      collateralValue: ['', Validators.required],
      guarantorName: ['', Validators.required],
      guarantorAddress: ['', Validators.required],
      guarantorEmail: ['', Validators.required],
      guarantorPhoneNumber: ['', Validators.required],
      documentName1: ['', Validators.required],                   //one to nine
      documentDescription1: ['', Validators.required]
    });

  }

  createLOC(data: any) {
    const body = {
      "accountNumber": data.accountNumber,
      "cifId": data.cifId,
      "nationalId": data.nationalId,
      "accountName": data.accountName,
      "currency": data.currency,
      "email": data.email,
      "phoneNumber":data.phoneNumber,
      "address": data.address,
      "city": data.city,
      "postalCode":data.postalCode,
      "countryCode":data.countryCode,
      "country": data.country,
      "lcNumber": "",
      "lcType": data.lcType,
      "applicableRules": data.applicableRules,
      "shipmentDate": data.shipmentDate,
      "portOfDischarge": data.portOfDischarge,
      "portOfLoading": data.portOfLoading,
      "shipmentTerms": data.shipmentTerms,
      "partialShipment": data.partialShipment,
      "transShipment": data.transShipment,
      "issueDate": data.issueDate,
      "expiryDate": data.expiryDate,
      "tenor": data.tenor,
      "transferable": data.transferable,
      "negotiationPeriod": data.negotiationPeriod,
      "commodityCode": data.commodityCode,
      "goodsQuantity": data.goodsQuantity,
      "pricePerUnit": data.pricePerUnit,
      "countyOfOrigin":data.countyOfOrigin,
      "chargesBorneBy":data.chargesBorneBy,
      "amount": data.amount,
      "transferAmount":data.transferAmount,
      "transferCurrencyCode":data.transferCurrencyCode,
      "newExpiryDate": data.newExpiryDate,
      "currencyCode": data.currencyCode,
      "collateralType": data.collateralType,
      "collateralId": data.collateralId,
      "collateralValue":data.collateralValue,
      "guarantorName": data.guarantorName,
      "guarantorAddress": data.guarantorAddress,
      "guarantorEmail": data.guarantorEmail,
      "guarantorPhoneNumber": data.guarantorPhoneNumber,
      "documentName1": data.documentName1,
      "documentDescription1": data.documentDescription1,
  "beneficiaryDto": {
  "beneficiaryFirstName": data.beneficiaryFirstName,
      "beneficiaryMiddleName": data.beneficiaryMiddleName,
      "beneficiaryLastName": data.beneficiaryLastName,
      "beneficiaryAccountNumber": data.beneficiaryAccountNumber,
      "beneficiaryAccountName": data.beneficiaryAccountName,
      "beneficiaryEmail": data.beneficiaryEmail,
      "beneficiaryIban": data.beneficiaryIban,
      "beneficiaryAddressLine1": data.beneficiaryAddressLine1,
      "beneficiaryAddressLine2": data.beneficiaryAddressLine2,
      "beneficiaryCity": data.beneficiaryCity,
      "beneficiaryPostalCode": data.beneficiaryPostalCode,
      "beneficiaryCountryCode": data.beneficiaryCountryCode,
      "beneficiaryCountry": data.beneficiaryCountry,
      "advisingBankName": data.advisingBankName,
      "advisingBankCountry": data.advisingBankCountry,
      "advisingBankBic":data.advisingBankBic
  },
  "documentsRequiredDto": {},
  "shipmentAndGoodsDto": {},
  "paymentSecurityDto": {}
  };
    return body;
  }

  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    const data = this.createLOC(this.applicationForm.value)
    this.lcService.createLc(data,this.applicationForm.get('accountNumber')?.value).subscribe({
      next: ((response) => {

        console.log("Lc create response", response);
      }),
      error: ((err) => {
        console.error(err)
      }),
      complete: (() => { })
    })
    this.applicationForm.reset()
    this.ngOnInit()
    alert('Form Submitted Successfully!')
     this.router.navigate(["/lc/view"]);
  }
  openLookup(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

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

      // If the selected file is a PDF, read it as a data URL using FileReader
      const fileReader = new FileReader();
      fileReader.onload = () => {
        // Convert the PDF file content to a string
        const pdfString = fileReader.result as string;

        // Now you have the PDF content as a string (pdfString)
        // You can assign it to a form control or store it as needed
        // For example, you can store it in a form control named 'pdfContent'
        this.applicationForm.get('pdfContent')?.setValue(pdfString);
      };
      fileReader.readAsDataURL(selectedFile);
    }
  }
  
  addFileUpload() {
    const newLabel = prompt('Enter Document Name for the New File Upload:'); // Prompts the user to enter the label
  
    if (newLabel) { // Check if the user entered a label
      // Add the new file upload section with the specified label
      const newRow = {
        label: newLabel.trim(), // Trim to remove leading/trailing spaces
      };
      this.additionalFileUploads.push(newRow);
    }
  }
}