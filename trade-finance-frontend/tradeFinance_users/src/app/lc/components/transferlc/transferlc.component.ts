
import { Component, Input, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { TransferService } from '../../services/transfer.service';


@Component({
  selector: 'app-transferlc',
  templateUrl: './transferlc.component.html',
  styleUrls: ['./transferlc.component.sass']
})
export class TransferlcComponent implements OnInit {
 

  
  transferForm!: FormGroup;
 
  constructor(private fb: FormBuilder, private _transferService: TransferService){};

  ngOnInit(): void {
    this.transferForm = this.fb.group({
      secondaryBeneficiaryFirstName: new FormControl(null, [Validators.required,]),
      secondaryBeneficiaryMiddleName: new FormControl(null, [Validators.required,]),
      secondaryBeneficiaryLastName: new FormControl(null, Validators.required,),
      secondaryBeneficiaryAddress: new FormControl(null, Validators.required,),
      secondaryBeneficiaryEmail: new FormControl(null, [Validators.required, Validators.email]),
      secondaryBeneficiaryPhoneNumber: new FormControl(null, Validators.required,),
      secondaryBeneficiaryAccountNumber: new FormControl(null, Validators.required,),
      secondaryBeneficiaryAccountName: new FormControl(null, Validators.required,),
      secondaryBeneficiaryCity: new FormControl(null, Validators.required),
      secondaryBeneficiaryCountry: new FormControl(null, Validators.required),
      secondaryBeneficiaryBank: new FormControl(null),
      secondaryBeneficiarySwiftCode: new FormControl(null, Validators.required),
      newExpiryDate: new FormControl(null, Validators.required),
      transferAmount: new FormControl(null, Validators.required),
      latestShipmentDate: new FormControl(null, Validators.required),
      transferDate: new FormControl(null, Validators.required),
        
     
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
