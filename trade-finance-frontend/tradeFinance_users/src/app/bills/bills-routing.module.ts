import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewBillComponent } from './components/view-bill/view-bill.component';
import { CreateBillComponent } from './components/create-bill/create-bill.component';


const routes: Routes = [
{path:'viewbill',component:ViewBillComponent},
{path:'createbill',component:CreateBillComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BillsRoutingModule { }
