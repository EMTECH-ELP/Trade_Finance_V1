import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { TransferlcComponent } from './components/transferlc/transferlc.component';


const routes: Routes = [
  {path: "create", component: CreateComponent},
  // {path: "transferlc", component: TransferlcComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LcRoutingModule { }
