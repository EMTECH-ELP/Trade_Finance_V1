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


  // public lookup(row){
  //   const dialogConfig = new MatDialogConfig()
  //   dialogConfig.disableClose = true
  //   dialogConfig.autoFocus = true
  //   dialogConfig.width = '600px'
  //   dialogConfig.data = { rowData: row }

  //   const dialogRef = this.dialog.open (LookupComponent, dialogConfig)
  //   dialogRef.afterClosed().subscribe((result)=>{
  //     console.log('closed');

  //   })
  // }


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
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryAddress: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryBank: ['', Validators.required],
      beneficiarySwiftCode: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],
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
      amountCode: ['', Validators.required],
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
    alert('Form Submitted Successfully!')
  }
  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };
  
    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);
  }
  

}