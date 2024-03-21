import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';
<<<<<<< HEAD
import { ViewMakersComponent } from './Makers/view-makers/view-makers.component';
=======
import { CheckersComponent } from './checkers/checkers.component';
import { MakersComponent } from './makers/makers.component';
import { ComponentsModule } from '../shared/components/components.module';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
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
>>>>>>> 2890b0679c4d44e443ad1846515c74e7e2f96e7e


@NgModule({
  declarations: [
<<<<<<< HEAD
    ViewMakersComponent
  ],
  imports: [
    CommonModule,
    UserManagementRoutingModule
=======
    CheckersComponent,
    MakersComponent
  ],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    ComponentsModule,
    SharedModule,
    MatTableModule,
    MatTableExporterModule,
    MatMenuModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
    MatTabsModule,
    MatButtonToggleModule,
    FormsModule
>>>>>>> 2890b0679c4d44e443ad1846515c74e7e2f96e7e
  ]
})
export class UserManagementModule { }
