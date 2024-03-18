import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {
  selectedValue: string;
  constructor(private fb: FormBuilder) { }
  applicationForm= this.fb.group ({
    applicantFirstName: ['', Validators.required],
    applicantMiddleName: [''],
    applicantLastName: ['', Validators.required],
    applicantAddress: ['', Validators.required],
    applicantEmail: ['',[Validators.required, Validators.email]],
    applicantPhoneNumber: ['', Validators.required],
    businessName: ['', Validators.required],
    applicantAccountName: ['', Validators.required],
    applicantAccountNumber: ['', Validators.required],
    issuingBank: ['', Validators.required],
    issuingSwiftCode: ['', Validators.required],
    beneficiaryFirstName: ['', Validators.required],
    beneficiaryMiddleName: [''],
    beneficiaryLastName: ['', Validators.required],
    beneficiaryAddress: ['', Validators.required],
    beneficiaryEmail:  ['',[Validators.required, Validators.email]],
    beneficiaryPhoneNumber: ['', Validators.required],
    beneficiaryAccountName: ['', Validators.required],
    beneficiaryAccountNumber: ['', Validators.required],
    beneficiaryBank: ['', Validators.required],
    beneficiarySwiftCode: ['', Validators.required],
    beneficiaryCity: ['', Validators.required],
    lcType: ['', Validators.required],
    subType: ['', Validators.required],
    applicableRules: ['', Validators.required],
    isExpired: ['',Validators.required],
    shipmentDate: ['', Validators.required],
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
    billOfLading: ['', Validators.required],
    numberOfCopies: ['', Validators.required],
    signed: ['', Validators.required],
    documentDescription: ['', Validators.required]
  })
  

  ngOnInit() {
    // ngOnInit code goes here
  }
}
