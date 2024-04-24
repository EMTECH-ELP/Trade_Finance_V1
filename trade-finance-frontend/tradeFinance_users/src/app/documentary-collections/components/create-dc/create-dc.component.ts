import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
//import {HttpClient} from "@angular/common/http";
import { MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { DcServiceService } from '../../dc-service.service';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';






@Component({
  selector: 'app-create-dc',
  templateUrl: './create-dc.component.html',
  styleUrls: ['./create-dc.component.sass'],
  providers: [ DcServiceService ],
})
export class CreateDcComponent implements OnInit {
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  // dialog: any;
  router: any;

  constructor(private fb: FormBuilder,
    private dcservice: DcServiceService,
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
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryBank: ['', Validators.required],
      beneficiarySwiftCode: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],
      originCountry: ['', Validators.required],
      loadingPort: ['', Validators.required],
      dischargePort: ['', Validators.required],
      goodsDescription: ['', Validators.required],
      DCquantity: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      shipDateStart: ['', Validators.required],
      shipDateEnd: ['', Validators.required],
      DCbillOfLading: ['', Validators.required],
      DCinvoice: ['', Validators.required],
      dcType: ['', Validators.required],
      totPayableAmount: ['', Validators.required],
      chargeAccount: ['', Validators.required],
      payableAmount: ['', Validators.required],
      payingAmount: ['', Validators.required],
      invoices: [[], [Validators.required]],
    packingList: [[], Validators.required],
    billOfLading: [[], Validators.required],
    billOfExchange: [[], Validators.required],
    insuranceCertificate: [[]],
    inspectionCertificate: [[]],
    originCert: [[], Validators.required]
    });

  }

  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    this.dcservice.createDc(this.applicationForm.value).subscribe({
      next: ((response) => {

        console.log("dc create response", response);
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
  



  
  rows: any[] = [
    { documentType: 'Bill of Exchange', checked: false },
    { documentType: 'Invoice', checked: false },
    { documentType: 'Certificate of Origin', checked: false },
    { documentType: 'Insurance Certificate', checked: false },
    { documentType: 'Packing List', checked: false },
    { documentType: 'Marine Bill of Lading', checked: false },
    { documentType: 'CMR/Airway Bill', checked: false },
    { documentType: 'Others', checked: false },
    { documentType: 'Others', checked: false },
    // Adds rows to html
  ];

  toggleRow(index: number) {
    this.rows[index].checked = !this.rows[index].checked;
  }
  

}