import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SystemManangementRoutingModule } from './system-manangement-routing.module';
import { UserActivitiesComponent } from './workflow-manangement/user-activities/user-activities.component';


@NgModule({
  declarations: [
    UserActivitiesComponent
  ],
  imports: [
    CommonModule,
    SystemManangementRoutingModule
  ]
})
export class SystemManangementModule { }
