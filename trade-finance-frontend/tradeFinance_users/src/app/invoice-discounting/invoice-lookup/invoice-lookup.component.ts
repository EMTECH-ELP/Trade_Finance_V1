import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-invoice-lookup',
  templateUrl: './invoice-lookup.component.html',
  styleUrls: ['./invoice-lookup.component.sass']
})
export class InvoiceLookupComponent implements OnInit {
  accountNumber: any

  constructor() { }

  ngOnInit(): void {
  } 

  searchInvoice(){
   console.log("invoice found")
  
  } 
}
