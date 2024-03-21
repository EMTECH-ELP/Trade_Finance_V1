import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckersComponent } from './checkers/checkers.component';
import { MakersComponent } from './makers/makers.component';

const routes: Routes = [
  { path: "checkers", component: CheckersComponent},
  { path: "makers", component: MakersComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
