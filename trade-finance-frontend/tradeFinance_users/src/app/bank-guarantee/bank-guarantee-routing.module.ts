import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBgComponent } from './components/create-bg/create-bg.component';
import { ViewBgComponent } from './components/view-bg/view-bg.component';

const routes: Routes = [
  { path: 'viewbg', component: ViewBgComponent },
  { path: 'createbg', component: CreateBgComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BankGuaranteeRoutingModule { }
