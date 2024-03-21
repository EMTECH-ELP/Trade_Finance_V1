import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD

const routes: Routes = [];
=======
import { CheckersComponent } from './checkers/checkers.component';
import { MakersComponent } from './makers/makers.component';

const routes: Routes = [
  { path: "checkers", component: CheckersComponent},
  { path: "makers", component: MakersComponent }
];
>>>>>>> 2890b0679c4d44e443ad1846515c74e7e2f96e7e

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
