import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserActivitiesComponent } from './workflow-manangement/user-activities/user-activities.component';

const routes: Routes = [
  {path:'user-activities',component:UserActivitiesComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManangementRoutingModule { }
