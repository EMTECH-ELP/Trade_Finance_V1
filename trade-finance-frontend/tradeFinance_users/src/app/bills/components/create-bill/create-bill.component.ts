import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-create-bill',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.sass']
})
export class CreateBillComponent implements OnInit {
onSubmit: any;
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  selectedValue: string;
  applicationForm: FormGroup}
