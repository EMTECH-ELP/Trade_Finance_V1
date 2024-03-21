import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ComponentsModule } from 'src/app/shared/components/components.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { GenWidgetsComponent } from './gen-widgets/gen-widgets.component';
import { NgApexchartsModule } from 'ng-apexcharts';
import { PagesComponent } from './pages/pages.component';


@NgModule({
  declarations: [
    DashboardComponent,
    GenWidgetsComponent,
    PagesComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ComponentsModule,
    SharedModule,
    NgApexchartsModule
  ]
})
export class DashboardModule { }
