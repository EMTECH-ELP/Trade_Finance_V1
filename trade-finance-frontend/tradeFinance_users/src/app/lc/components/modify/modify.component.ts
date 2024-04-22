// import { Component, OnInit } from '@angular/core';
// import { LcService } from '../../services/lc.service';
// import { FormBuilder, FormGroup } from '@angular/forms';

// @Component({
//   selector: 'app-modify',
//   templateUrl: './modify.component.html',
//   styleUrls: ['./modify.component.scss']
// })


// export class ModifyComponent implements OnInit {


//   searchForm: FormGroup;
//   searchByOptions = ['ID', 'Email', 'firstname', 'Businessname', 'account no'];
//   selectedSearchBy: string = 'ID';
//   searchTerm: string = '';
//   searchResults: any[] = [];

//   constructor(private LcService: LcService,
//     private formBuilder: FormBuilder) { }

//   ngOnInit(): void {

//     this.searchForm = this.formBuilder.group({

//     });
//   }

//   search(): void {

//   }

//   onsubmit() { }

//   onModify() { }

//   Modify(result: any): void {
//     // Implement modify functionality here
//   }
// }




// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { LcService } from '../../services/lc.service';


// @Component({
//   selector: 'app-create',
//   templateUrl: './create.component.html',
//   styleUrls: ['./create.component.sass']
// })
// export class CreateComponent implements OnInit 




import { Component, OnInit } from '@angular/core';
import { LcService } from '../../services/lc.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.scss']
})


export class ModifyComponent implements OnInit {


  selectedValue: string;
  modificationForm: FormGroup;
  router: any;

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

  public onSubmit() {

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
}