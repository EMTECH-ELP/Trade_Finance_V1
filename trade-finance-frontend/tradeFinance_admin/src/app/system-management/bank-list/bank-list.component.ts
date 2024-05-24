import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bank, MasterdataService } from '../masterdata.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddbankPopupComponent } from '../addbank-popup/addbank-popup.component';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-bank-list',
  templateUrl: './bank-list.component.html',
  styleUrls: ['./bank-list.component.scss']
})
export class BankListComponent implements OnInit{
isLoading: any;

refresh() {
throw new Error('Method not implemented.');
}
add() {
throw new Error('Method not implemented.');
}


banks: any[] = []; // Initialize banks array here

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = [ 'no','bankName', 'bankCountry', 'branchName',  'branchCode','swiftCode',  'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

searchText: string;

  constructor(
    private bankService: MasterdataService,
    private router: Router,
    private snackBar: MatSnackBar,
    private dialog: MatDialog
  ) {   this.dataSource = new MatTableDataSource(this.banks);}
  
  ngOnInit(): void {
     this.getBanks();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  openAddBankDialog(): void {
    const dialogRef:MatDialogRef<AddbankPopupComponent> = this.dialog.open(AddbankPopupComponent, {
      width: '600px',
    });
    dialogRef.afterClosed().subscribe(
      ((res) => {
        //this.getBanks()
      })
    )
    
  }

  addBank(newBank: any): void {
    this.banks.push(newBank);
    this.snackBar.open("Bank added successfully", "Close", {
      duration: 5000,
      horizontalPosition: 'end',
      verticalPosition: 'top',
      panelClass: 'notify-success'
    });
  }

  getBanks(): void {
    console.log('Fetching Bank List...');
    this.bankService.getBanks().subscribe({
      next: (res: any) => {  
        console.log('Response:', res); 
        const banks = res.map((banklist: any, index: number) => ({     
          no: index + 1,
          bankName: banklist.bankName,  
          bankCountry: banklist.bankCountry,        
          branchName: banklist.branchName, 
          branchCode: banklist.branchCode,
          swiftCode: banklist.bankSwiftCode,
          actions: 'Actions', // Replace this with actual actions logic
        }));
        
        this.dataSource = new MatTableDataSource(banks);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err: any) => {
        console.error('Error fetching bank list:', err);
      }
    });
  }
}

  // goToCreateBank() {
  //   this.router.navigate(['/system/createBank']);
  // }

  // editBank: number | null = null; // Initialize it as null or any default value



  // saveBank(index: number) {
  //   console.log('Save Bank:', this.banks[index]);
  //   this.bankService.updateBank
  //   // Implement save logic
  //   this.editBank = null;
  // }

  // openUpdateBankDialog(bank: any): void {
  //   const dialogRef = this.dialog.open(AddbankPopupComponent, {
  //     width: '300px',
  //     data: { bank } // Pass bank data to the dialog
  //   });

  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log('The dialog was closed');
  //     // Optionally handle dialog close event
  //   });
  // }
  // addBank(newBank: any): void {
  //   this.banks.push(newBank);
  //   this.snackBar.open("Bank added successfully", "Close", {
  //     duration: 5000,
  //     horizontalPosition: 'end',
  //     verticalPosition: 'top',
  //     panelClass: 'notify-success'
  //   });
  // }
  // openDialog(): void {
  //   const dialogRef = this.dialog.open(AddbankPopupComponent , {
  //     width: '600px',
  //     // height: '300px'
  //   });

  //   dialogRef.afterClosed().subscribe(result => {
  //     if (result) {
  //       this.addBank(result);
  //     }
  //   });
  // }
// }
  // deletebank(id: number) {
  //   this.bankService.deleteBank(id).subscribe(
  //     (res: any) => {
  //       console.log(res);
  //       this.getBanks(); // Update the list of banks after successful deletion
  //       this.snackBar.open("Successfully deleted bank", "Close", {
  //         duration: 5000,
  //         horizontalPosition: 'end',
  //         verticalPosition: 'top',
  //         panelClass: 'notify-success'
  //       });
  //     },
  //     (error: any) => {
  //       console.error('Error deleting bank:', error);
  //       this.snackBar.open("Error deleting bank. Please try again later.", "Close", {
  //         duration: 5000,
  //         horizontalPosition: 'end',
  //         verticalPosition: 'top',
  //         panelClass: 'notify-error'
  //       });
  //     }
  //   );
  // }

// export class BankListComponent implements OnInit {
//   searchText: string = '';
//   banks: Bank[] = [];

//   constructor(public dialog: MatDialog, private route: ActivatedRoute,
//     private router: Router,private bankService: MasterdataService) { }



  
//     ngOnInit(): void {
//       // this.banks = this.bankService.getBanks();
//     }
  
//     filteredBanks(): Bank[] {
//       if (!this.searchText) {
//         return this.banks;
//       }
//       return this.banks.filter(bank =>
//         bank.bankName.toLowerCase().includes(this.searchText.toLowerCase()) ||
//         bank.branchName.toLowerCase().includes(this.searchText.toLowerCase()) ||
//         bank.branchCode.includes(this.searchText) ||
//         bank.swiftCode.includes(this.searchText) ||
//         bank.country.toLowerCase().includes(this.searchText.toLowerCase())
//       );
//     }
  
//     editBank(index: number): void {
//       // Handle edit logic here
//     }
  
//     deleteBank(index: number): void {
//       this. bankService.deleteBank(index);
//       this.banks = this. bankService.getBanks();
//     }
  
   
    


