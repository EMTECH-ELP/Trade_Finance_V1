import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { HttpClient } from '@angular/common/http'; 
import { Router } from '@angular/router';
import { MasterdataService } from '../masterdata.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-currency-list',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.scss']
})
export class CurrencyComponent implements OnInit {
  isLoading: boolean = false; // Track loading state

  currencies: any[] = [];  // Initialize currencies array here
  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['currencyCode', 'currencyName'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  searchText: string;

  constructor
  (private http: HttpClient,
    private router:Router,private currencyService:MasterdataService) { // Inject HttpClient for API calls
    this.dataSource = new MatTableDataSource(this.currencies);
   
  }

  ngOnInit(): void {
    this.getCurrencies();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  getPorts(){
  this.router.navigate(["system-management/ports"])
  }
  getCurrencies(): void {
    this.isLoading = true; // Set loading state to true
    this.currencyService.getCurrency().subscribe({
      next: (res: any) => {  
        console.log('Response:', res); 
          const currencies = res.map((currency: any) => ({ // Assuming response structure
            currencyCode: currency.currencyCode,
            currencyName: currency.currencyName
          }));
          this.dataSource = new MatTableDataSource(currencies);
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator;
          this.isLoading = false; // Set loading state to false after successful fetch
        },
        error: (err) => {
          console.error('Error fetching currency list:', err);
          this.isLoading = false; // Set loading state to false after error
        }
      });
  }
}
// function subscribe(arg0: { next: (res: any) => void; error: (err: any) => void; }): {
//   headers?: import("@angular/common/http").HttpHeaders | { [header: string]: string | string[]; }; context?: import("@angular/common/http").HttpContext; observe?: "body"; params?: import("@angular/common/http").HttpParams | { //192.168.88.109:9000/api/currencies'; 
//     ;
//   }; reportProgress?: boolean; responseType: "arraybuffer"; withCredentials?: boolean;
// } {
//   throw new Error('Function not implemented.');
// }

