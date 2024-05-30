import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BankListComponent } from './bank-list/bank-list.component';
import { ComponentsModule } from '../shared/components/components.module';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { SystemManagementRoutingModule } from './system-management-routing.module';
import { SharedModule } from '../shared/shared.module';

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
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';

import { AddbankPopupComponent } from './addbank-popup/addbank-popup.component';
import { MasterdataComponent } from './masterdata/masterdata.component';


@NgModule({
  declarations: [
    BankListComponent,
    AddbankPopupComponent,
    MasterdataComponent
   
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    SystemManagementRoutingModule,
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
    MatButtonToggleModule,
  ],
})
export class SystemManagementModule { }
