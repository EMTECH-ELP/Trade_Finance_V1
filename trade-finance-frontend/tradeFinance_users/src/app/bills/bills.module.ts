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
import { MatFormFieldModule } from '@angular/material/form-field';
import { RecoveryComponent } from './components/recovery/recovery.component';


@NgModule({
    declarations: [
        CreateBillComponent,
        ViewBillComponent,
        RecoveryComponent
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
        ReactiveFormsModule,
        MatFormFieldModule
    ]
})
export class BillsModule { }
