import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import { ModifyComponent } from './components/modify/modify.component';

const routes: Routes = [

  {path:"modify",component:ModifyComponent}
=======
import { CreateComponent } from './components/create/create.component';

const routes: Routes = [
  {path: "create", component: CreateComponent}
>>>>>>> 5a23c5b72a9210bd7c0a56e234a55a5f26154a12
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule {

}
