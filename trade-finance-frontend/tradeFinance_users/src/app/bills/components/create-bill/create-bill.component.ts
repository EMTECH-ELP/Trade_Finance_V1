import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-bill',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.sass']
})
export class CreateBillComponent implements OnInit {

  selectedValue: string;
  applicationForm: FormGroup;
onSubmit: any;

  constructor() { }

  ngOnInit(): void {
  }

}
