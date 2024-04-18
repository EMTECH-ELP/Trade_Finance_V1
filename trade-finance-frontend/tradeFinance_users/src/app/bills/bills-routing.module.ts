
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBillComponent } from './components/create-bill/create-bill.component';


const routes: Routes = [
  {path:'createbill',component:CreateBillComponent},
  {}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BillsRoutingModule { }

