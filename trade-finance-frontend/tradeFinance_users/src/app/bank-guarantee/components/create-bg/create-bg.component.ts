import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-bg',
  templateUrl: './create-bg.component.html',
  styleUrls: ['./create-bg.component.sass']
})
export class CreateBgComponent implements OnInit {

  selectedValue: string;
  applicationForm: FormGroup;

  constructor(private fb: FormBuilder,
  ) { }


  ngOnInit() {

    this.applicationForm = this.fb.group({
      applicantFirstName: ['', Validators.required],
      applicantMiddleName: [''],
      applicantLastName: ['', Validators.required],
      applicantAddress: ['', Validators.required],
      applicantEmail: ['', [Validators.required, Validators.email]],
      applicantPhoneNumber: ['', Validators.required],
      businessName: ['', Validators.required],
      applicantAccountName: ['', Validators.required],
      applicantAccountNumber: ['', Validators.required],
      issuingBank: ['', Validators.required],
      issuingSwiftCode: ['', Validators.required],

      //  step 2: beneficiary details
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

      // step 3: Guarantee Details
      bgType: ['', Validators.required],
      issueDate: ['', Validators.required],
      expiryDate: ['', Validators.required],
      amount: ['', Validators.required],
      amountCode: ['', Validators.required],

      // step 4:Goods and shipment details
      goodsDescription: ['', Validators.required],
      quantityValue: ['', Validators.required],
      amountID: ['', Validators.required],
      countryName: ['', Validators.required],
      portLoading: ['', Validators.required],
      portDischarge: ['', Validators.required],
      shipmentDate: ['', Validators.required],
      billOfLading: ['', Validators.required],
      invoiceNo: ['', Validators.required],

      // step 5:Security Details
      chargeAccount: ['', Validators.required],
      amountValue: ['', Validators.required],
      currencyID: ['', Validators.required],

// step 6:Document upload details




      signed: ['', Validators.required],
      documentDescription: ['', Validators.required]
    });

  }

  public onSubmit() {

  }
}