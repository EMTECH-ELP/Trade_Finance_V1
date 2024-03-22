import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

interface LetterOfCredit {
  name: string;
  employeeId: string;
  email: string;
  branchName: string;
  branchCode: string;
  status: string;
}

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.sass']
})
export class ViewComponent implements OnInit {

  loggedInUser: { name: string; role: string } = { name: 'User Name', role: 'maker' }; // Replace with actual user data
  totalCreatedLetters = 0;
  totalPendingLetters = 0;
  totalApprovedLetters = 0;
  selectedStatus = 'all';

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'customerName', 'description', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator; 
  @ViewChild(MatSort) sort: MatSort;
  isLoading = true;
  products: any;
  constructor(private dialog: MatDialog) { }

  
  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts() {
        this.products = [
          {
              no: 1,
              productCategory: 'Electronics',
              description: 'Smartphone with advanced features',
              actions: ['View Details', 'Add to Cart']
          },
          {
              no: 2,
              productCategory: 'Clothing',
              description: 'Casual T-shirt made of cotton',
              actions: ['View Details', 'Add to Cart']
          },
          {
              no: 3,
              productCategory: 'Home & Kitchen',
              description: 'Stainless steel cookware set',
              actions: ['View Details', 'Add to Cart']
          },
          // Add more mock data items as needed
      ];;
        console.log("Products list:", this.products);
        if (this.products) {
          this.isLoading = false
        }
        this.dataSource = new MatTableDataSource(this.products);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
  }
  
  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public add(){

  }

  public refresh(){
    this.getProducts();
  }

  public verify(){

  }
}
