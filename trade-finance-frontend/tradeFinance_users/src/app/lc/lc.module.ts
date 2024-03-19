import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LcRoutingModule } from './lc-routing.module';
import { CreateComponent } from './components/create/create.component';
import {MatStepperModule} from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    CreateComponent,
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
    HttpClientModule
  ]
})
export class LcModule { }
