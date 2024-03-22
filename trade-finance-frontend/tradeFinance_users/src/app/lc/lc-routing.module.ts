import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModifyComponent } from './components/modify/modify.component';
import { CreateComponent } from './components/create/create.component';
import { TransferlcComponent } from './components/transferlc/transferlc.component';
import { ViewComponent } from './components/view/view.component';




const routes: Routes = [
  {path: "create", component: CreateComponent},
  {path: "transferlc", component: TransferlcComponent},
  {path: "view", component: ViewComponent},
  {path:"modify",component:ModifyComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule {

}
