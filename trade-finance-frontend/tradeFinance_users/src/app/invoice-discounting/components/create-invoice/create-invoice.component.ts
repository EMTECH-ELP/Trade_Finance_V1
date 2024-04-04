import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.sass']
})
export class CreateInvoiceComponent implements OnInit {


  selectedValue: string;
  applicationForm: FormGroup;
onSubmit: any;
  constructor() { }

  ngOnInit(): void {
  }

}
