import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewMakersComponent } from './Makers/view-makers/view-makers.component';
import { AddMakersComponent } from './Makers/add-makers/add-makers.component';
import { AddCheckersComponent } from './Checkers/add-checkers/add-checkers.component';
import { ViewCheckersComponent } from './Checkers/view-checkers/view-checkers.component';


const routes: Routes = [
  { path: 'view', component: ViewMakersComponent },
  { path: 'add', component: AddMakersComponent },
  { path: 'viewcheckers', component: ViewCheckersComponent },
  { path: 'add-roles', component: AddCheckersComponent },
  { path: 'view-roles', component: AddCheckersComponent },
  { path: 'add-users', component: AddCheckersComponent },
  { path: 'view-users', component: AddCheckersComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
