import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LcRoutingModule } from './lc-routing.module';
import {MatStepperModule} from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { ComponentsModule } from '../shared/components/components.module';


@NgModule({
  declarations: [
  
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
    ComponentsModule
  ]
})
export class LcModule { }
