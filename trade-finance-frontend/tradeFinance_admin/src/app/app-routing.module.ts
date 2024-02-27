import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { Page404Component } from "./authentication/page404/page404.component";
import { AuthGuard } from "./core/guard/auth.guard";
import { Role } from "./core/models/role";
import { AuthLayoutComponent } from "./layout/app-layout/auth-layout/auth-layout.component";
import { MainLayoutComponent } from "./layout/app-layout/main-layout/main-layout.component";
import { MainDashboardComponent } from "./layout/app-layout/main-dashboard/main-dashboard.component";
const routes: Routes = [
  {
    path: "",
    component: MainLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      { path: "", redirectTo: "/authentication/signin", pathMatch: "full" },
      // {
      //   path: "dashboard",
      //   loadChildren: () =>
      //     import("./dashboard/dashboard.module").then((m) => m.DashboardModule),
      // },
      {
        path: "admin",
        loadChildren: () =>
          import("./admin/admin.module").then((m) => m.AdminModule),
      }
    ],
  },

  {
    path: "account",
    component: MainDashboardComponent,
    loadChildren: () =>
      import("./account/account.module").then((m) => m.AccountModule),
  },
  {
    path: "authentication",
    component: AuthLayoutComponent,
    loadChildren: () =>
      import("./authentication/authentication.module").then(
        (m) => m.AuthenticationModule
      ),
  },

  { path: "**", component: Page404Component },
];
@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: "legacy" })],
  exports: [RouterModule],
})
export class AppRoutingModule { }
