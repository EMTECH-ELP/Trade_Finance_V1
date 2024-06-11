import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-transfer-funds',
  templateUrl: './transfer-funds.component.html',
  styleUrls: ['./transfer-funds.component.sass']
})
export class TransferFundsComponent implements OnInit {
  fundingForm: FormGroup;
  constructor() { }

  ngOnInit(): void {
  }

}
