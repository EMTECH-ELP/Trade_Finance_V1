import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BankGuaranteeRoutingModule } from './bank-guarantee-routing.module';
import { DeleteBgComponent } from './components/delete-bg/delete-bg.component';


@NgModule({
  declarations: [
    DeleteBgComponent
  ],
  imports: [
    CommonModule,
    BankGuaranteeRoutingModule
  ]
})
export class BankGuaranteeModule { }
