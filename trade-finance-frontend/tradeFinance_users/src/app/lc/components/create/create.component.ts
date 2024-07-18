import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LcService } from '../../services/lc.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import { ActivatedRoute, Router } from '@angular/router';
import { InvDiscountingService } from 'src/app/invoice-discounting/services/inv-discounting.service';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  additionalFileUploads: { label: string }[] = [];
  uploadedFile: File | null = null;
  fileUrl: string | null = null;
  shipmentTerms: Array<{ value: string, viewValue: string }> = [{ value: "FCP", viewValue: "FCP: Free Carrier" }, { value: "CPT", viewValue: "CPT:  Carriage Paid To" }, { value: "CIP ", viewValue: "CIP: Carriage and Insurance Paid To " }, { value: "DAP", viewValue: "DAP: Delivered At Place " }, { value: "DPU", viewValue: "DPU: Delivered At Place Unloaded " }, { value: "DDP", viewValue: "DDP: Delivered Duty Paid " }, { value: "EXW", viewValue: " Ex Works" }];
  beneficiaryIban: Array<{ value: string, viewValue: string }> = [{ value: "ES91 2100 0418 4502 0005 1332", viewValue: "ES91 2100 0418 4502 0005 1332" }, { value: "NL91 ABNA 0417 1643 00 ", viewValue: "NL91 ABNA 0417 1643 00 " }, { value: "FR14 2004 1010 0505 0001 3M02 606", viewValue: "FR14 2004 1010 0505 0001 3M02 606" }, { value: "GB29 NWBK 6016 1331 9268 19 ", viewValue: "GB29 NWBK 6016 1331 9268 19 " }, { value: "DE89 3704 0044 0532 0130 00", viewValue: "DE89 3704 0044 0532 0130 00" }];
  cities: Array<{value: string, viewValue: string}> = [{value: 'Entebbe', viewValue: 'Entebbe'}, {value: 'Kinshasa', viewValue: 'Kinshasa'}, {value: 'Kampala', viewValue: 'Kampala'}, {value: 'Osaka', viewValue:'Osaka'}, {value: 'Beijing', viewValue: 'Beijing'}, {value: 'Arusha', viewValue: 'Arusha'}, {value: 'Lubumbashi', viewValue: 'Lubumbashi'}, {value: 'Shanghai', viewValue: 'Tokyo'}];
  countries: Array<{value: string, viewValue: string}> = [{value: 'Uganda', viewValue: 'Uganda'}, {value: 'Congo', viewValue: 'Congo'}, {value: 'China', viewValue: 'China'}, {value: 'USA', viewValue: 'USA'}, {value: 'Tanzania', viewValue: 'Tanzania'}, {value: 'Japan', viewValue: 'Japan'}, {value: 'South Africa', viewValue: 'South Africa'}, {value: 'Egypt', viewValue: 'Egypt'},];
  countrycodes: Array<{value: string, viewValue: string}> = [{value: 'UG', viewValue: 'UG'}, {value: 'CG', viewValue: 'CG'}, {value: 'CN', viewValue: 'CN'}, {value: 'US', viewValue: 'US'}, {value: 'TZ', viewValue: 'TZ'}, {value: 'JY', viewValue: 'JY'}, {value: '', viewValue: ''}];
  beneficiarybanks: Array<{value: string,viewValue: string}> = [{value: 'Centenary Bank', viewValue: 'Centenary Bank'}, {value: 'Stanbic Bank Uganda', viewValue: 'Stanbic Bank Uganda'},{value: 'Rawbank', viewValue: 'Rawbank'},{value: 'Trust Merchant Bank (TMB)', viewValue: 'Trust Merchant Bank (TMB)'},{value: 'CRDB Bank', viewValue: 'CRDB Bank'},{value: 'SMBC', viewValue: 'SMBC'},{value: 'MUFG', viewValue: 'MUFG'},{value: 'NBC', viewValue: 'NBC'}]; 

  constructor(private fb: FormBuilder,
    private lcService: LcService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private invoiceService: InvDiscountingService,
    // private lookupDialog: MatDialogRef<LookupComponent>
  ) { }



  ngOnInit() {

    this.applicationForm = this.fb.group({
      accountNumber: ['', [Validators.required, Validators.maxLength(15)]],
      cifId: ['', [Validators.required, Validators.maxLength(8), Validators.minLength(6)]],
      nationalId: ['', [Validators.required, Validators.maxLength(10)]],
      accountName: ['', Validators.required],
      currency: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
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
      advisingBankName: ['', Validators.required],                                    //add advisingBankCountry
      advisingBankBranch: ['', Validators.required],                                  //add this                    //add this
      advisingBankBranchCode: ['', Validators.required],                             //add this
      advisingBankBic: ['', Validators.required],     //For SWIFT CODE
      advisingBankCountry: [''],
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
      guarantorPhoneNumber: ['', [Validators.required, Validators.pattern(/^\+?[1-9]\d{1,14}$/)]],
      documentName1: ['', Validators.required],                   //one to nine
      documentDescription1: ['', Validators.required],
      commercialInvoiceFile: [''],
      documentName2: ['', Validators.required],                   //one to nine
      documentDescription2: ['', Validators.required],
      billOfLadingFile: [''],
      documentName3: ['', Validators.required],                   //one to nine
      documentDescription3: ['', Validators.required],
      packingListFile: [''],
      confirm: [''],
      advise: ['']
    });

  }

  createLOC(data: any) {
    const body = {
      "lcNumber": "",
      "lcType": data.lcType,
      "applicableRules": data.applicableRules,
      "issueDate": data.issueDate,
      "expiryDate": data.expiryDate,
      "tenor": data.tenor,
      "transferable": data.transferable,
      "negotiationPeriod": data.negotiationPeriod,
      "chargesBorneBy": data.chargesBorneBy,
      "amount": data.amount,
      "transferAmount": data.transferAmount,
      "transferCurrencyCode": data.transferCurrencyCode,
      "newExpiryDate": data.newExpiryDate,
      "currencyCode": data.currencyCode,
      "collateralType": data.collateralType,
      "collateralId": data.collateralId,
      "collateralValue": data.collateralValue,
      "guarantorName": data.guarantorName,
      "guarantorAddress": data.guarantorAddress,
      "guarantorEmail": data.guarantorEmail,
      "guarantorPhoneNumber": data.guarantorPhoneNumber,
      "documentName1": data.documentName1,
      "documentDescription1": data.documentDescription1,
      "commercialInvoiceFile": data.commercialInvoiceFile,
      "documentName2": data.documentName2,
      "documentDescription2": data.documentDescription2,
      "billOfLadingFile": data.billOfLadingFile,
      "documentName3": data.documentName3,
      "documentDescription3": data.documentDescription3,
      "packingListFile": data.packingListFile,
      "confirm": data.confirm,
      "advise": data.advise,
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
        "advisingBankBranch": data.advisingBankBranch,                                //add this                    //add this
        "advisingBankBranchCode": data.advisingBankBranchCode,
        "advisingBankCountry": data.advisingBankCountry,
        "advisingBankBic": data.advisingBankBic
      },
      "applicantDto": {
        "accountNumber": data.accountNumber,
        "cifId": data.cifId,
        "nationalId": data.nationalId,
        "accountName": data.accountName,
        "currency": data.currency,
        "email": data.email,
        "phoneNumber": data.phoneNumber,
        "address": data.address,
        "city": data.city,
        "postalCode": data.postalCode,
        "countryCode": data.countryCode,
        "country": data.country,
      },
      "documentsRequiredDto": {},
      "shipmentAndGoodsDto": {
        "shipmentDate": data.shipmentDate,
        "portOfDischarge": data.portOfDischarge,
        "portOfLoading": data.portOfLoading,
        "shipmentTerms": data.shipmentTerms,
        "partialShipment": data.partialShipment,
        "transShipment": data.transShipment,
        "commodityCode": data.commodityCode,
        "goodsQuantity": data.goodsQuantity,
        "pricePerUnit": data.pricePerUnit,
        "countryOfOrigin": data.countyOfOrigin,
      },
      "paymentSecurityDto": {}
    };
    return body;
  }

  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    const data = this.createLOC(this.applicationForm.value)
    this.lcService.createLc(data, this.applicationForm.get('accountNumber')?.value).subscribe({
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
    //alert('Form Submitted Successfully!')
    let result = window.confirm('Click OK to submit. Click Cancel to abort');
    if (result) {
      alert('Form Submitted Successfully!');
      this.router.navigate(["/lc/view"]);
    } else {
      alert('Application Cancelled');
      this.router.navigate(["/lc/create"]);
    }


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
      country: data.country,
    });
  }
  OnFileSelected(event: any) {
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
  //Calculate the total amount under LC Details section:
  updateAmount() {
    const quantity = this.applicationForm.get('goodsQuantity').value;
    const price = this.applicationForm.get('pricePerUnit').value;
    const amount = quantity * price;
    this.applicationForm.get('amount').setValue(amount);
  }

  calculateAmount() {
    const quantity = this.applicationForm.get('goodsQuantity').value;
    const price = this.applicationForm.get('pricePerUnit').value;
    return quantity * price;
  }

  //INPUT FIELDS LOOKUPS
  //Beneficiary Details:
  getIban() { }
  getCity() { }
  getCountryandCode() { }
  getBankDetails() { }
  getShipmentTerm() {
    this.lcService.getAllShipmentTerms().subscribe({
      next: (response) => {
        console.log("Get shipment terms response", response);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        alert('Shipment terms retrieved successfully');
      }
    });
  }





  //Method to handle file download action
  // downloadFile() {
  //   const fileUrl = this.applicationForm.value.billOfLadingFile;
  //   const link = document.createElement('a');
  //   link.href = fileUrl;
  //   link.download = fileUrl.split('/').pop(); // Extract the file name
  //   link.click();
  // }
  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.uploadedFile = input.files[0];
      this.generateFileUrl();
    }
  }

  generateFileUrl(): void {
    if (this.uploadedFile) {
      this.fileUrl = URL.createObjectURL(this.uploadedFile);
      this.applicationForm.patchValue({ billOfLadingFile: this.fileUrl });
    }
  }

  downloadFile(): void {
    if (this.fileUrl) {
      const link = document.createElement('a');
      link.href = this.fileUrl;
      link.download = this.uploadedFile?.name ?? 'download';
      link.click();
    }
  }

}