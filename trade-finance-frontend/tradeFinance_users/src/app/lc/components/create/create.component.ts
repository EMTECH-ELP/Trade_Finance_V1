import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LcService } from '../../services/lc.service';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.sass']
})
export class CreateComponent implements OnInit {


  selectedValue: string;
  applicationForm: FormGroup;

  constructor(private fb: FormBuilder,
    private lcService: LcService) { }
 

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
      subType: ['', Validators.required],
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
      billOfLading: ['', Validators.required],
      numberOfCopies: ['', Validators.required],
      signed: ['', Validators.required],
      documentDescription: ['', Validators.required]
    });
  
  }

  public  onSubmit() {

    console.log("Form data", this.applicationForm.value);
    this.lcService.createLc(this.applicationForm.value).subscribe({
      next: ((response) => {

        console.log("Lc create response", response);
      }),
      error: ((err) => {

      }),
       complete: (() => {})
    })
  }
}