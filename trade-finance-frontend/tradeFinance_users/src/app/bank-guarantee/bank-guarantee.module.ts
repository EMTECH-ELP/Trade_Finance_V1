import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BankGuaranteeRoutingModule } from './bank-guarantee-routing.module';
<<<<<<< HEAD
import { DeleteBgComponent } from './components/delete-bg/delete-bg.component';


@NgModule({
  declarations: [
    DeleteBgComponent
  ],
  imports: [
    CommonModule,
    BankGuaranteeRoutingModule
  ]
=======
import { CreateBgComponent } from './components/create-bg/create-bg.component';
import { ComponentsModule } from "../shared/components/components.module";
import {MatStepperModule} from '@angular/material/stepper';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ViewBgComponent } from './components/view-bg/view-bg.component';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatMenuModule } from '@angular/material/menu';
import { MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from 'mat-table-exporter';


@NgModule({
    declarations: [
        CreateBgComponent,
        ViewBgComponent
    ],
    imports: [
        CommonModule,
        BankGuaranteeRoutingModule,
        ComponentsModule,
        MatStepperModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatOptionModule,
        MatRadioModule,
        MatIconModule,
        MatPaginatorModule,
        MatMenuModule,
        MatTableModule,
        MatTableExporterModule,
        FormsModule
        
    ]
>>>>>>> 95206ed3ffb0e06b912b33e95092991b58ba6946
})
export class BankGuaranteeModule { }
