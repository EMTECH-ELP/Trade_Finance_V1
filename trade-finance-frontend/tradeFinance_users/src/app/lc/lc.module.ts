// import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';

// import { LcRoutingModule } from './lc-routing.module';
// import {ModifyComponent } from './components/modify/modify.component';
// import { FormsModule ,ReactiveFormsModule,FormGroup,FormBuilder} from '@angular/forms';

// @NgModule({
//   declarations:[ModifyComponent],
//   imports: [
//     CommonModule,
//     LcRoutingModule,
//     FormsModule,
//     ReactiveFormsModule,
//   ]
// })
// export class LcModule { }


import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LcRoutingModule } from './lc-routing.module';
import { ModifyComponent } from './components/modify/modify.component'; // Ensure correct import path

@NgModule({
  declarations: [ModifyComponent], // Include ModifyComponent in the declarations array
  imports: [
    CommonModule,
    LcRoutingModule,
    FormsModule,
    ReactiveFormsModule,
=======
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


@NgModule({
  declarations: [
    TransferlcComponent,
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
  
>>>>>>> 5a23c5b72a9210bd7c0a56e234a55a5f26154a12
  ]
})
export class LcModule { }
