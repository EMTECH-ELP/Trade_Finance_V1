import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransferlcComponent } from './components/transferlc/transferlc.component';
import { HttpClientModule } from '@angular/common/http';
import { LcRoutingModule } from './lc-routing.module';
import { MatStepperModule } from '@angular/material/stepper';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { ComponentsModule } from '../shared/components/components.module';
import { BreadcrumbComponent } from '../shared/components/breadcrumb/breadcrumb.component';
import { CreateComponent } from './components/create/create.component';
import { ModifyComponent } from './components/modify/modify.component';
import { ViewComponent } from './components/view/view.component';
import { MatOption } from '@angular/material/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatTableExporterModule } from 'mat-table-exporter';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { DeleteLcComponent } from './components/delete-lc/delete-lc.component';
import { TestComponent } from './test/test.component';
import { VerifyLcComponent } from './components/verify-lc/verify-lc.component';
import { ModifyLookupComponent } from './components/modify/modify-lookup/modify-lookup.component';

@NgModule({
  declarations: [
    TransferlcComponent,
    CreateComponent,
  ModifyComponent,
    DeleteLcComponent,
    ViewComponent,
    TestComponent,
    VerifyLcComponent,
    
  ],
  imports: [
    CommonModule,
    LcRoutingModule,
    MatStepperModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
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
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    




  ]
})
export class LcModule { } import { } from './components/create/create.component';


