
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
searchResults: any;
  applicationForm: any;
handleSearchClick() {
throw new Error('Method not implemented.');
}


  selectedValue: string;
  modificationForm: FormGroup;
  router: any;
searchForm: any;

  constructor(private fb: FormBuilder,
    private lcService: LcService) { }


  ngOnInit() {

    this.modificationForm = this.fb.group({
      lcNumber: ['', Validators.required],
      lcType: [''],
      applicableRules: ['', Validators.required],
      currencyCode: ['', Validators.required],
      amount: ['', [Validators.required, Validators.email]],
      expiryDate: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      negotiationPeriod: ['', Validators.required],
      issueDate: ['', Validators.required],
      tenor: ['', Validators.required],
      transferable: ['', Validators.required],
      confirm: ['', Validators.required],
      advise: [''],

    });

  }

  public onModify() {

    console.log("Form data", this.modificationForm.value);
    this.lcService.ModifyLc(this.modificationForm.value).subscribe({
      next: ((response) => {

        console.log("Lc modify response", response);
      }),
      error: ((err) => {
        console.error(err)
      }),
      complete: (() => { })
    })
    this.modificationForm.reset()
    this.ngOnInit()
    alert('Modification done Successfully and records updated!')
    
    this.router.navigate(["view"]);
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





