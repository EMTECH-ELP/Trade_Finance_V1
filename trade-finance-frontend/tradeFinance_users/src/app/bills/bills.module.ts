import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { BillsRoutingModule } from "./bills-routing.module";
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from "@angular/material/icon";
import { MatTable, MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from "mat-table-exporter";
import { MatMenuModule } from "@angular/material/menu";
import { MatPaginatorModule } from "@angular/material/paginator";
import { ComponentsModule } from "../shared/components/components.module";
import { FormsModule } from "@angular/forms";
import { MatStepperModule } from "@angular/material/stepper";
import { ReactiveFormsModule } from "@angular/forms";
import { MatFormFieldModule, MatLabel } from "@angular/material/form-field";
import { ViewBillComponent } from "./components/view-bill/view-bill.component";
import { CreateBillComponent } from "./components/create-bill/create-bill.component";
import { RecoveryBillComponent } from "./components/recovery-bill/recovery-bill.component";
import { MatOptionModule } from '@angular/material/core';
import { MatSelect, MatSelectModule } from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from "../app-routing.module";


@NgModule({
  declarations: [
    RecoveryBillComponent,
    CreateBillComponent,
    ViewBillComponent],
  imports: [
    CommonModule,
    BillsRoutingModule,
    MatIconModule,
    MatTableExporterModule,
    MatTableModule,
    MatMenuModule,
    MatPaginatorModule,
    ComponentsModule,
    FormsModule,
    MatStepperModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    HttpClientModule,
    MatFormFieldModule,
     // AppRoutingModule,
    ],
  
  })
export class BillsModule {}





