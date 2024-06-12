import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-model-lc',
  templateUrl: './model-lc.component.html',
  styleUrls: ['./model-lc.component.sass']
})
export class ModelLcComponent implements OnInit {
applicationForm = FormGroup
  constructor() { }

  ngOnInit(): void {
  }
  openLookup(){}
  getIban(){}
}
