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


  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    this.lcService.createLc(this.applicationForm.value,this.applicationForm.get('accountNumber')?.value).subscribe({
      next: ((response) => {

        console.log("Lc create response", response);
      }),
      error: ((err) => {
        console.error(err)
      }),
      complete: (() => { })
    })
    // this.applicationForm.reset()
    this.ngOnInit()
    // alert('Form Submitted Successfully!')
    // this.router.navigate(["/lc/view"]);
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