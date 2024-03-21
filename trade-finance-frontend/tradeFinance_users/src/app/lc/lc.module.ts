import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LcRoutingModule } from './lc-routing.module';
import { TransferlcComponent } from './components/transferlc/transferlc.component';


@NgModule({
  declarations: [
    TransferlcComponent
  ],
  imports: [
    CommonModule,
    LcRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ]
})
export class LcModule { }
