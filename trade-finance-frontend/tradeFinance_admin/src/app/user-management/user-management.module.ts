import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';

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


@NgModule({
  declarations: [
  
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
  ]
})
export class UserManagementModule { }
