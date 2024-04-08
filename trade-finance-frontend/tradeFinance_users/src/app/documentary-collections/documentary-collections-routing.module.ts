import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewDcComponent } from './components/view-dc/view-dc.component';
import { CreateDcComponent } from './components/create-dc/create-dc.component';

const routes: Routes = [
  {path:"viewDc",component:ViewDcComponent},
  {path:"createDc",component:CreateDcComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentaryCollectionsRoutingModule { }
