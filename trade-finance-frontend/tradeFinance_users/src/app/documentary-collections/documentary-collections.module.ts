import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentaryCollectionsRoutingModule } from './documentary-collections-routing.module';
import { DeleteDcComponent } from './components/delete-dc/delete-dc.component';
import { CreateDcComponent } from './components/create-dc/create-dc.component';
import { ViewDcComponent } from './components/view-dc/view-dc.component';
import { ComponentsModule } from "../shared/components/components.module";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatTableExporterModule } from 'mat-table-exporter';
import { MatTableModule } from '@angular/material/table';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatStepperModule } from '@angular/material/stepper';


@NgModule({
  declarations: [
    DeleteDcComponent,
    CreateDcComponent,
    ViewDcComponent
  ],
  imports: [
    CommonModule,
    DocumentaryCollectionsRoutingModule,
    ComponentsModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatTableExporterModule,
    MatTableModule,
    MatMenuModule,
    MatPaginatorModule,
    MatStepperModule
  ]
})
export class DocumentaryCollectionsModule { }
