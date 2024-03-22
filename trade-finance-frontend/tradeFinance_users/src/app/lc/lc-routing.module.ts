import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModifyComponent } from './components/modify/modify.component';
import { CreateComponent } from './components/create/create.component';




const routes: Routes = [
  {path: "create", component: CreateComponent},
  
  {path:"modify",component:ModifyComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule {

}
