
import { Component, Input, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-transferlc',
  templateUrl: './transferlc.component.html',
  styleUrls: ['./transferlc.component.sass']
})
export class TransferlcComponent implements OnInit {
 

  
  transferForm!: FormGroup;
 
  constructor(private fb: FormBuilder){};

  ngOnInit(): void {
    this.transferForm = this.fb.group({
      beneficiaryId: new FormControl(null, [Validators.required,]),
      primaryBeneficiaryCif: new FormControl(null, [Validators.required,]),
      beneficiaryEmail: new FormControl(null, [Validators.required, Validators.email]),
      primaryBeneficiaryName: new FormControl(null, Validators.required,),
      primaryBeneficiaryAccount: new FormControl(null, Validators.required,),
      secondaryBeneficiaryName: new FormControl(null, Validators.required,),
      secondaryBeneficiaryAccount: new FormControl(null, Validators.required,),
      bankName: new FormControl(null, Validators.required,),
        state: new FormControl(null, Validators.required),
        beneficiaryCountry: new FormControl(null, Validators.required),
        beneficiaryCity: new FormControl(null),
        beneficiaryPostalCode: new FormControl(null, Validators.required),
        issueDate: new FormControl(null, Validators.required),
        expiryDate: new FormControl(null, Validators.required),
        transferableAmount: new FormControl(null, Validators.required),
        primaryBeneficiaryAmount: new FormControl(null, Validators.required),
        secondaryBeneficiaryeAmount: new FormControl(null, Validators.required),
        lcValue: new FormControl(null, Validators.required),
        unverifiedLcValue: new FormControl(null, Validators.required),
        swiftCode: new FormControl(null, Validators.required),
     
    });


  }
  OnSubmit() {
    // console.log(this.transferForm);
    // this._transferService.transfer(this.transferForm.value)
    // .subscribe(
    //   response => console.log('Success!', response),
    //   error => console.error('Error!',error)
    // );

  }


}
// if (this.reactiveForm.valid) {
//   const formData = this.reactiveForm.value;
//   this.dataService.submitFormData(formData).subscribe(
//       (response) => {
//           // Handle successful response
//       },
//       (error) => {
//           // Handle error response
//       }
//   );
