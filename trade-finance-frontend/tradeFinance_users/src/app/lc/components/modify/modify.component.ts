
import { Component, OnInit } from '@angular/core';
import { LcService } from '../../services/lc.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.scss']
})


export class ModifyComponent implements OnInit {
  searchOption: any;
  searchTerm: any;
  selectedValue: string;
  applicationForm: FormGroup;


  searchQuery: string = '';
  formData: any = {
    lcno: '',
    cif: '',
    accountno: ''}
searchForm: any;
searchResults: any;

   modifies(){
      // this will updates the database on the changes made/modified
  
  }

  constructor(private fb: FormBuilder,
    private router: Router,
    private lcService: LcService) { }


  ngOnInit(): void {

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


  handleSearchClick() {
    this.router.navigate(["/create"])
    // throw new Error('Method not implemented.');
  }




  public onSubmit() {

  console.log("Form data", this.applicationForm.value);
  this.lcService.createLc(this.applicationForm.value).subscribe({
    next: ((response) => {

      console.log("Lc create response", response);
    }),
    error: ((err) => {

    }),
    complete: (() => { })
  })
}

}





