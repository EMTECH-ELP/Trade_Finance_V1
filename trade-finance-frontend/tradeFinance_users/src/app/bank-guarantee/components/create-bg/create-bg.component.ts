import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-bg',
  templateUrl: './create-bg.component.html',
  styleUrls: ['./create-bg.component.sass']
})
export class CreateBgComponent implements OnInit {

  selectedValue: string;
  applicationForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }


  public onSubmit(){
    
  }
}
