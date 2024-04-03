import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentaryCollectionsRoutingModule } from './documentary-collections-routing.module';
import { DeleteDcComponent } from './components/delete-dc/delete-dc.component';


@NgModule({
  declarations: [
    DeleteDcComponent
  ],
  imports: [
    CommonModule,
    DocumentaryCollectionsRoutingModule
  ]
})
export class DocumentaryCollectionsModule { }
