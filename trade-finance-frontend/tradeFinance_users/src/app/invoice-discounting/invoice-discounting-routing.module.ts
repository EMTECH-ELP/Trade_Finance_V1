import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewInvoiceComponent } from './components/view-invoice/view-invoice.component';
import { CreateInvoiceComponent } from './components/create-invoice/create-invoice.component';
import { ModifyInvoiceComponent } from './components/modify-invoice/modify-invoice.component';

const routes: Routes = [
  {path:"viewInvoice",component:ViewInvoiceComponent},
  {path:"createInvoice",component:CreateInvoiceComponent},
  {path: "modifyInvoice",component:ModifyInvoiceComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InvoiceDiscountingRoutingModule { }
