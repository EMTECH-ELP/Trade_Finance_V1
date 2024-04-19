import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LcService } from '../../services/lc.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  // dialog: any;
  router: any;

  constructor(private fb: FormBuilder,
    private lcService: LcService,
    private dialog: MatDialog
    // private lookupDialog: MatDialogRef<LookupComponent>
  ) { }



  ngOnInit() {

    this.applicationForm = this.fb.group({
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

      //Step2: Beneficiary details
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryAddress: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryIban: ['', Validators.required],
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryBankAddressLine2: [''],
      beneficiaryPostalCode: ['', Validators.required],
      beneficiaryCountryCode: ['', Validators.required],
      beneficiaryCountry: ['', Validators.required],
      advisingBankName: ['', Validators.required],
      advisingBankCountry: ['', Validators.required],
      advisingBankBic: ['', Validators.required],     //For SWIFT CODE
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],
    //Step 3: LC details      
      lcType: ['', Validators.required],
      applicableRules: ['', Validators.required],
      isExpired: ['', Validators.required],
      shipmentDate: ['', Validators.required],
      portOfDischarge: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      shipmentTerms: ['', Validators.required],
      partialShipment: ['', Validators.required],
      transShipment: ['', Validators.required],
      issueDate: ['', Validators.required],
      expiryDate: ['', Validators.required],
      usance: ['', Validators.required],
      transferable: ['', Validators.required],
      negotiationPeriod: ['', Validators.required],
      commodityCode: ['', Validators.required],
      goodsQuantity: ['', Validators.required],
      pricePerUnit: ['', Validators.required],
      countyOfOrigin: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      amount: ['', Validators.required],
      currencyCode: ['', Validators.required],
      collateralType: ['', Validators.required],
      collateralId: ['', Validators.required],
      collateralValue: ['', Validators.required],
      guarantorName: ['', Validators.required],
      guarantorAddress: ['', Validators.required],
      guarantorEmail: ['', Validators.required],
      guarantorPhoneNumber: ['', Validators.required],
      documentName1: ['', Validators.required],
      documentDescription1: ['', Validators.required]
    });

  }

  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    this.lcService.createLc(this.applicationForm.value).subscribe({
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