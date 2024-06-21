import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BankListComponent } from './bank-list/bank-list.component';
import { RouterModule, Routes } from '@angular/router';
import { AddbankPopupComponent } from './addbank-popup/addbank-popup.component';
import { MasterdataComponent } from './masterdata/masterdata.component';
import { CurrencyComponent } from './currency/currency.component';
import { PortsComponent } from './ports/ports.component';
import { WorkflowManagementComponent } from './workflow-management/workflow-management.component';
import { CountriesListComponent } from './countries-list/countries-list.component';
import { CountryViewComponent } from './cities-list/country-view/country-view.component';

const routes: Routes = [
  {path:'banks',component:BankListComponent},
  {path:'createBank',component:AddbankPopupComponent},
  {path:'masterdata',component:MasterdataComponent},
  {path:'currency & ports',component:CurrencyComponent},
  {path:'ports',component:PortsComponent},
  {path:'user-activities',component:WorkflowManagementComponent},
  {path:'countries-list',component:CountriesListComponent},
  { path:'countryView', component:CountryViewComponent},

]
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManagementRoutingModule { }
