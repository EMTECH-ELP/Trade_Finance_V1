import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LcRoutingModule } from './lc-routing.module';
import { CreateComponent } from './components/create/create.component';


@NgModule({
  declarations: [
    CreateComponent
  ],
  imports: [
    CommonModule,
    LcRoutingModule
  ]
})
export class LcModule { }
