import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-dc',
  templateUrl: './create-dc.component.html',
  styleUrls: ['./create-dc.component.sass']
})
export class CreateDcComponent implements OnInit {



  selectedValue: string;
  applicationForm: FormGroup;
onSubmit: any;
  constructor() { }

  ngOnInit(): void {
  }

}
