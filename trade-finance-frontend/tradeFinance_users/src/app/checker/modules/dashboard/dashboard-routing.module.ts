import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { DashboardComponent } from "./pages/dashboard/dashboard.component";
// import { RoutePrivilegeGuard } from "src/app/erp-procurement/data/services/_AccessControlAuthGuard.service";

const routes: Routes = [
  {
    path: 'analytics', component: DashboardComponent
  },
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule { }
