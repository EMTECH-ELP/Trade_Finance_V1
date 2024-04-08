import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvoiceDiscountingRoutingModule } from './invoice-discounting-routing.module';
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

@NgModule({
  declarations: [
    ModifyInvoiceComponent,
    CreateInvoiceComponent,
    ViewInvoiceComponent
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
    MatStepperModule
  ],

})
export class InvoiceDiscountingModule { }