import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ports',
  templateUrl: './ports.component.html',
  styleUrls: ['./ports.component.scss']
})
export class PortsComponent implements OnInit {

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['port', 'city', 'country'];
  isLoading: boolean = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private router: Router) { }

  ngOnInit(): void {
    // Initialize dataSource
    this.dataSource = new MatTableDataSource([]);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    // Call API to get ports data
    this.getPorts();
  }

  getPorts() {
    // Simulate API call
    this.isLoading = true;
    setTimeout(() => {
      // Replace this with actual API call to fetch ports data
      const portsData = [
        { port: 'Port 1', city: 'City 1', country: 'Country 1' },
        { port: 'Port 2', city: 'City 2', country: 'Country 2' },
        // Add more port objects as needed
      ];
      this.dataSource.data = portsData;
      this.isLoading = false;
    }, 2000); // Simulating 2 seconds delay, replace with actual API call
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  onSelect(row: any) {
    // Handle row selection
    console.log('Selected row:', row);
  }


  addPort(){
    //add port navigation logic here
  }

  masterView(){
    this.router.navigate(['/system/masterdata'])
  }
}
