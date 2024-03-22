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
  ]
})
export class LcModule { }
