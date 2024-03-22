import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewMakersComponent } from './Makers/view-makers/view-makers.component';
import { AddMakersComponent } from './Makers/add-makers/add-makers.component';


const routes: Routes = [
{path:'view',component:ViewMakersComponent},
{path:'add',component:AddMakersComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
