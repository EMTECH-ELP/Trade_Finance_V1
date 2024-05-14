
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewBillComponent } from './components/view-bill/view-bill.component';
import { CreateBillComponent } from './components/create-bill/create-bill.component';
import { RecoveryBillComponent } from './components/recovery-bill/recovery-bill.component';


const routes: Routes = [
  {path:'viewbill',component:ViewBillComponent},
  {path:'createbill',component:CreateBillComponent},
  {path:'recoverybill',component:RecoveryBillComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BillsRoutingModule { }
