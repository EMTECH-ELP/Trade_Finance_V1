import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModifyComponent } from './components/modify/modify.component';

const routes: Routes = [

  {path:"modify",component:ModifyComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule {

}
