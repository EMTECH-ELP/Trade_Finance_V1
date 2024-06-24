import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-country-view',
  templateUrl: './country-view.component.html',
  styleUrls: ['./country-view.component.scss']
})
export class CountryViewComponent implements OnInit {

  constructor(private fb: FormBuilder, private router : Router) { }

  ngOnInit(): void {
  }



  applyFilter(event: Event) {
  }



  openAddBankDialog(): void {
  }



  addBank(newBank: any): void {
  }


getBanks(): void {}


addCountry(){
  this.router.navigate(['/system/countries-list'])
  }
  refresh(){
  //FOR ERRORS
  }

view(){
  //view all countries logic
}

masterView(){
  this.router.navigate(['/system/masterdata'])
}
}
