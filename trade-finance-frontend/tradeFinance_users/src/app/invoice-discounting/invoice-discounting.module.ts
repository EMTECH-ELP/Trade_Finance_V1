import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvoiceDiscountingRoutingModule } from './invoice-discounting-routing.module';
import { ModifyInvoiceComponent } from './components/modify-invoice/modify-invoice.component';


@NgModule({
  declarations: [
    ModifyInvoiceComponent
  ],
  imports: [
    CommonModule,
    InvoiceDiscountingRoutingModule
  ]
})
export class InvoiceDiscountingModule { }
