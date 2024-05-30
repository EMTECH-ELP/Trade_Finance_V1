import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-masterdata',
  templateUrl: './masterdata.component.html',
  styleUrls: ['./masterdata.component.scss']
})
export class MasterdataComponent implements OnInit {
  totalBanks : number = 20;
  totalPorts : number= 0;
  totalCurrencies: number = 0;
 citiesList: number= 0;
 countriesList: number = 0;
 others: number = 0;
  usersCount: number = 0;



  constructor(private router: Router,) {}

  ngOnInit(): void {
  //   this.getSuppliers();
  //   this.getExpenses();
  //   this.getCostCenters();
  //   this.getAllUsers();
  }

 Banks() {
   // this.router.navigateByUrl('/admin/supplier/suppliers-management/all');

  }
  Countries() {
    //this.router.navigateByUrl('/admin/supplier/expenses-management/all');
    
  }
 Cities() {
   // this.router.navigateByUrl('/admin/supplier/cost-centers-management/all');
  }
  Ports() {
    //this.router.navigateByUrl('/admin/user-accounts/all');
  }

  Currency(){
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
 Others(){
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


