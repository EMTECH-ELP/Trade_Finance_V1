import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewMakersComponent } from './Makers/view-makers/view-makers.component';
import { AddMakersComponent } from './Makers/add-makers/add-makers.component';
import { AddCheckersComponent } from './Checkers/add-checkers/add-checkers.component';
import { ViewCheckersComponent } from './Checkers/view-checkers/view-checkers.component';
import { AddRolesComponent } from './Roles/add-roles/add-roles.component';
import { ViewRolesComponent } from './Roles/view-roles/view-roles.component';
import { AddUsersComponent } from './Users/add-users/add-users.component';
import { ViewUsersComponent } from './Users/view-users/view-users.component';
import { PrivilegesComponent } from './Roles/privileges/privileges.component';
import { CreatePrivilegeComponent } from './Roles/privileges/create-privilege/create-privilege.component';
import { CreateRoleComponent } from './Roles/add-roles/create-role/create-role.component';


const routes: Routes = [
  { path: 'view', component: ViewMakersComponent },
  { path: 'add', component: AddMakersComponent },
  { path: 'viewcheckers', component: ViewCheckersComponent },
  { path: 'add-roles', component: AddRolesComponent },
  { path: 'view-roles', component: ViewRolesComponent },
  { path: 'add-users', component: AddUsersComponent },
  { path: 'view-users', component: ViewUsersComponent },
  { path: 'privileges', component:PrivilegesComponent},
  {path:'createPrivilege', component:CreatePrivilegeComponent},
  {path:'createRole', component:CreateRoleComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
