import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BillsRoutingModule } from './bills-routing.module';
import { CreateBillComponent } from './components/create-bill/create-bill.component';
import { ViewBillComponent } from './components/view-bill/view-bill.component';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource,MatTable,MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from 'mat-table-exporter';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ComponentsModule } from "../shared/components/components.module";

import {MatStepperModule} from '@angular/material/stepper';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { MatOptionModule } from '@angular/material/core';
import { MatSelect, MatSelectModule } from '@angular/material/select';

@NgModule({
    declarations: [
        CreateBillComponent,
        ViewBillComponent
    ], 
    imports: [
        MatFormFieldModule,
        MatOptionModule,
        CommonModule,
        BillsRoutingModule,
        MatIconModule,
        MatTableExporterModule,
        MatTableModule,
        MatMenuModule,
        MatPaginatorModule,
        ComponentsModule,
        FormsModule,
        ReactiveFormsModule,
        MatSelectModule,
        MatStepperModule
    ]
})
export class BillsModule { }
