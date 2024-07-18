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
      {
        path: "checker",
        loadChildren: () =>
          import("./checker/checker.module").then((m) => m.CheckerModule),

      },
      {
        path: "maker",
        loadChildren: () =>
          import("./maker/maker.module").then((m) => m.MakerModule),

      },
      {
        path: "lc",
        loadChildren: () =>
          import("./lc/lc.module").then((m) => m.LcModule),
        canActivate: []
      },
      {
        path: "bank-guarantee",
        loadChildren: () =>
          import("./bank-guarantee/bank-guarantee.module").then((m) => m.BankGuaranteeModule),
      },
      {
        path: "bills",
        loadChildren: () =>
          import("./bills/bills.module").then((m) => m.BillsModule),
      },
      {
        path: "invoice-discounting",
        loadChildren: () =>
          import("./invoice-discounting/invoice-discounting.module").then((m) => m.InvoiceDiscountingModule),
      },
      {
        path: "documentary-collection",
        loadChildren: () =>
          import("./documentary-collections/documentary-collections.module").then((m) => m.DocumentaryCollectionsModule),
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
