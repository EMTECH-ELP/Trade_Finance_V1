import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { SharedService } from "src/app/invoice-discounting/components/shared.service";

@Component({
  selector: "app-gen-widgets",
  templateUrl: "./gen-widgets.component.html",
  styleUrls: ["./gen-widgets.component.scss"],
})
export class GenWidgetsComponent implements OnInit {

  totalCreatedLetters : number = 10;
  totalCreatedGuarantees : number= 0;
  totalCreatedInvoices: number = 0;
  totalCreatedBills: number= 0;
  expenseCount: number = 0;
  costCentersCount: number = 0;
  usersCount: number = 0;
  // all: number = 0;


  constructor(private router: Router,private sharedService: SharedService) {}

  ngOnInit(): void {
    // Initial fetch or logic to set the initial count
    this.totalCreatedInvoices = 0;
    this.sharedService.setInvoiceCount(this.totalCreatedInvoices);
  }

  suppliers() {
   // this.router.navigateByUrl('/admin/supplier/suppliers-management/all');

  }
  expenses() {
    //this.router.navigateByUrl('/admin/supplier/expenses-management/all');
    
  }
  costCenters() {
   // this.router.navigateByUrl('/admin/supplier/cost-centers-management/all');
  }
  userManagement() {
    //this.router.navigateByUrl('/admin/user-accounts/all');
  }

  getExpenses(){
    // this.expenseService.getExpenses
    // ()
    // .subscribe(
    //   (res) => {
    //     this.expenseCount = res.length;
    //   },
    //   (err) => {
    //     console.log(err);
    //   })
  }

  getSuppliers() {
    // this.supplierService
    //   .getSuppliers()
    //   .subscribe(
    //     (res) => {
    //       this.suppliersCount = res.length;
    //     },
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
  }
  getCostCenters() {
    // this.costCenterService
    //   .getCostCenters()
    //   .subscribe(
    //     (res) => {
          
    //       this.costCentersCount = res.length;

         
    //     },
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
  }
  getAllUsers() {
    // this.accountService
    //   .listActiveAccounts()
    //   .subscribe(
    //     (res) => {
    //       this.usersCount = res.length;          
    //     },
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
  }


}


