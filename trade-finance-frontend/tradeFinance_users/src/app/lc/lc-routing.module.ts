import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { DeleteLcComponent } from './components/delete-lc/delete-lc.component';

const routes: Routes = [
  {path: "create", component: CreateComponent},
  {path: "delete", component: DeleteLcComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule {

}
