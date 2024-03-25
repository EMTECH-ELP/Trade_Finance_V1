import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';

import { ComponentsModule } from '../shared/components/components.module';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableExporterModule } from 'mat-table-exporter';
import { ViewMakersComponent } from './Makers/view-makers/view-makers.component';
import { AddMakersComponent } from './Makers/add-makers/add-makers.component';
import { ViewCheckersComponent } from './Checkers/view-checkers/view-checkers.component';
import { AddCheckersComponent } from './Checkers/add-checkers/add-checkers.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatStepperModule } from '@angular/material/stepper';


@NgModule({
  declarations: [
  
  
    ViewMakersComponent,
           AddMakersComponent,
           ViewCheckersComponent,
           AddCheckersComponent
  ],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    FormsModule, 
    HttpClientModule,
    SharedModule,
    ComponentsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatTableModule,
    MatTableExporterModule,
    MatMenuModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatTabsModule,
    MatButtonToggleModule
  ]
})
export class UserManagementModule { }
