import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bank, MasterdataService } from '../masterdata.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddbankPopupComponent } from '../addbank-popup/addbank-popup.component';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { HttpClient } from '@angular/common/http';
import { ModifyBankDialogueComponent } from '../modify-bank-dialogue/modify-bank-dialogue.component';
import { DeletebankdialogueComponent } from '../deletebankdialogue/deletebankdialogue.component';

@Component({
  selector: 'app-bank-list',
  templateUrl: './bank-list.component.html',
  styleUrls: ['./bank-list.component.scss']
})
export class BankListComponent implements OnInit {
  id: Number;
  isLoading: any;
  isFetching: boolean = false;



  banks: any[] = []; // Initialize banks array here

  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['no', 'bankName', 'bankCode', 'bankCountry', 'branchName', 'branchCode', 'bankSwiftCode', 'actions'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  searchText: string;


  constructor(
    private bankService: MasterdataService,
    private http: HttpClient,
    private router: Router,
    private snackBar: MatSnackBar,
    private dialog: MatDialog
  ) { this.dataSource = new MatTableDataSource(this.banks); }

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
    const dialogRef: MatDialogRef<AddbankPopupComponent> = this.dialog.open(AddbankPopupComponent, {
      width: '600px',
    });
    dialogRef.afterClosed().subscribe(
      ((res) => {
        this.getBanks()
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
    this.isFetching = true
    console.log('Fetching Bank List...');
    this.bankService.getBanks().subscribe({
      next: (res: any) => {
        console.log('Response:', res);
        const banks = res.map((banklist: any, index: number) => ({
          no: index + 1,
          id: banklist.bankId,
          bankName: banklist.bankName,
          bankCode: banklist.bankCode,
          bankCountry: banklist.bankCountry,
          branchName: banklist.branchName,
          branchCode: banklist.branchCode,
          bankSwiftCode: banklist.bankSwiftCode,
          actions: 'Actions', // Replace this with actual actions logic
        }));

        this.dataSource = new MatTableDataSource(banks);
        console.log("banks", banks);

        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err: any) => {
        console.error('Error fetching bank list:', err);
      },
      complete: () => {
        this.isFetching = false;
      },

    });
  }

  openEditBankDialog(bank: any): void {
    const dialogRef = this.dialog.open(ModifyBankDialogueComponent, {
      width: '400px',
      data: { isEditMode: true, bank }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getBanks();
      }
    });
  }

//Correct code to delete
  onDeleteBank(event: Event, id: number) {
    event.stopPropagation();
    if (confirm('Are you sure you want to delete this bank?')) 

    {
      this.bankService.onDeleteBank(id).subscribe(() => {
        this.snackBar.open('Bank deleted successfully', 'Close', {
          duration: 3000,
        });
        this.getBanks();
      });
    }
  }

//   public onDeleteBank(){
//     const dialogConfig = new MatDialogConfig()
//     dialogConfig.disableClose = true
//     dialogConfig.autoFocus = true
//     dialogConfig.width = '600px'
//     dialogConfig.data = { test: "row" }

//     const dialogRef = this.dialog.open(DeletebankdialogueComponent, dialogConfig);


//     dialogRef.afterClosed().subscribe((result) => {
//       console.log('closed');
//     });
// }
  
  
  

  
  // const enteredBranchCode = window.prompt(`Enter the No. to confirm deletion for bank ID ${bankId}:`); 
  

}


