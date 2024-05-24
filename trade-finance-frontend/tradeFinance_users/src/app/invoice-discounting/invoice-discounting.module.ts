import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvoiceDiscountingRoutingModule } from './invoice-discounting-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ModifyInvoiceComponent } from './components/modify-invoice/modify-invoice.component';
import { CreateInvoiceComponent } from './components/create-invoice/create-invoice.component';
import { ViewInvoiceComponent } from './components/view-invoice/view-invoice.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatTable, MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from 'mat-table-exporter';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ComponentsModule } from "../shared/components/components.module";
import { MatStepperModule } from '@angular/material/stepper';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { SharedModule } from '../shared/shared.module';
import {  MatDialogModule } from '@angular/material/dialog';
import { RepaymentdetailsComponent } from './components/repaymentdetails/repaymentdetails.component';
import { InvoiceLookupComponent } from './invoice-lookup/invoice-lookup.component';
import { DeleteInvoiceComponent } from './components/delete-invoice/delete-invoice.component';

import { CreatedformComponent } from './components/createdform/createdform.component';


@NgModule({
  declarations: [
    ModifyInvoiceComponent,
    CreateInvoiceComponent,
    ViewInvoiceComponent,
    RepaymentdetailsComponent,

    InvoiceLookupComponent,
    DeleteInvoiceComponent, 
    CreatedformComponent
  
  ],
  imports: [
    CommonModule,
    InvoiceDiscountingRoutingModule,
    MatPaginatorModule,
    MatIconModule,
    MatMenuModule,
    MatTableModule,
    MatTableExporterModule,
    FormsModule,
    ReactiveFormsModule,
    ComponentsModule,
    MatStepperModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    HttpClientModule,
    SharedModule,
    MatDialogModule,
  
  
  // AppRoutingModule,
  ],

})
export class InvoiceDiscountingModule { }