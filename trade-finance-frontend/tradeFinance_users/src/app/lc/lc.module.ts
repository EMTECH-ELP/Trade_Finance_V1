import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransferlcComponent } from './components/transferlc/transferlc.component';
import { HttpClientModule } from '@angular/common/http';
import { LcRoutingModule } from './lc-routing.module';
import {MatStepperModule} from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { ComponentsModule } from '../shared/components/components.module';
import { CreateComponent } from './components/create/create.component';
import { ModifyComponent } from './components/modify/modify.component';



@NgModule({
  declarations: [
    TransferlcComponent,
    CreateComponent,
    ModifyComponent
  ],
  imports: [
    CommonModule,
    LcRoutingModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    ComponentsModule,
    ReactiveFormsModule
  ]
})
export class LcModule { }
