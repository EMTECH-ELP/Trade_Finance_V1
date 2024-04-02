import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BillsRoutingModule } from './bills-routing.module';
import { CreateBillComponent } from './components/create-bill/create-bill.component';
import { ViewBillComponent } from './components/view-bill/view-bill.component';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource,MatTable,MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from 'mat-table-exporter';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ComponentsModule } from "../shared/components/components.module";
import { FormsModule } from '@angular/forms';
import {MatStepperModule} from '@angular/material/stepper';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
    declarations: [
        CreateBillComponent,
        ViewBillComponent
    ],
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
        ReactiveFormsModule
    ]
})
export class BillsModule { }
