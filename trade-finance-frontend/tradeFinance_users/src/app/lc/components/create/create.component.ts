import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {
  selectedValue: string;

  constructor(private fb: FormBuilder) { }
  // applicant Details
  applicantsForm= this.fb.group ({
    firstName: [],
    middleName: [],
    lastName: [],
    phoneNumber: [],
    businessName: [],
    email: [],
    accountName: [],
    accountNumber: [],
    address: [],
  })
  // beneficiary details
  beneficiaryForm= this.fb.group({
    firsttName: [],
    middleName: [],
    lastName: [],
    country: [],
    city: [],
    address: [],
    bankName: [],
    accountName: [],
    accountNumber: [],
    bankCode: [],
    swiftCode: [],
  })
  // LC Details
  lcForm= this.fb.group({
    portOfLoading: [],
    shipmentDate: [],
    portOfDischarge: [],
    incoterms:[],
    expiryDate: []
  })

//Collateral Details
collateralForm= this.fb.group({
  collateralType: [],
  collateralId: [],
  collateralValue: [],
  phoneNumber: []
})

//Guarantee Details
guaranteeForm= this.fb.group({
  fullName: [],
  phoneNumber: [],
  email: [],
  address: [],
  guaranteeAmount: [],
})
//Documents Upload Section
documentsForm= this.fb.group({
})

  ngOnInit() {
    // ngOnInit code goes here
  }
}
