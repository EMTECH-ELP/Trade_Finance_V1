import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewInvoiceComponent } from './components/view-invoice/view-invoice.component';
import { CreateInvoiceComponent } from './components/create-invoice/create-invoice.component';

import { CreatedformComponent } from './components/createdform/createdform.component';
import { CdkColumnDef } from '@angular/cdk/table';

import { ModifyInvoiceComponent } from './components/modify-invoice/modify-invoice.component';


const routes: Routes = [
  {path:"viewInvoice",component:ViewInvoiceComponent},
  {path:"createInvoice",component:CreateInvoiceComponent},
  { path: 'modify/:invoiceNumber', component: ModifyInvoiceComponent},
  {path: "createdform",component:CreatedformComponent},
 


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],

    providers: [CdkColumnDef]

})
export class InvoiceDiscountingRoutingModule { }
