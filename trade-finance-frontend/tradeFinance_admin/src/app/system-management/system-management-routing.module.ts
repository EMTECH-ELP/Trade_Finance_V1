import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BankListComponent } from './bank-list/bank-list.component';
import { RouterModule, Routes } from '@angular/router';
import { AddbankPopupComponent } from './addbank-popup/addbank-popup.component';

const routes: Routes = [
  {path:'banks',component:BankListComponent},
  {path:'createBank',component:AddbankPopupComponent},

]
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManagementRoutingModule { }
