import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewInvoiceComponent } from './components/view-invoice/view-invoice.component';
import { CreateInvoiceComponent } from './components/create-invoice/create-invoice.component';
import { ModifyInvoiceComponent } from './components/modify-invoice/modify-invoice.component';
import { CreatedformComponent } from './components/createdform/createdform.component';



const routes: Routes = [
  {path:"viewInvoiceForm",component:ViewInvoiceComponent},
  {path:"createInvoiceForm",component:CreateInvoiceComponent},
  {path: "modifyInvoice",component:ModifyInvoiceComponent},
  {path: "createdform",component:CreatedformComponent},
 


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InvoiceDiscountingRoutingModule { }
