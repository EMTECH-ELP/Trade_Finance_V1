import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { Bank, MasterdataService } from '../masterdata.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';


@Component({
  selector: 'app-addbank-popup',
  templateUrl: './addbank-popup.component.html',
  styleUrls: ['./addbank-popup.component.scss']
})
export class AddbankPopupComponent implements OnInit{
  @Output() bankAdded = new EventEmitter<any>();
  addBankForm: FormGroup;

  selectedStatus:string
  bankName:string;
  branchName: string;
  branchCode: number;
 bankCountry:string;
 bankSwiftCode:string;
  loading: false;
  error: string;

  constructor(
    public dialogRef:MatDialogRef<AddbankPopupComponent>,
    private fb:FormBuilder,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private bankService: MasterdataService,
    private snackbar: MatSnackBar

  ) {   this.addBankForm = this.fb.group({
     bankName: ['', Validators.required],
    bankCountry: ['', Validators.required],
      branchName: ['', Validators.required],
        branchCode: ['', Validators.required],
        bankSwiftCode: ['', Validators.required],
       
    }); }

  ngOnInit(): void {
  //   this.addBankForm = this.fb.group({
  //     bankName: ['', Validators.required],
  //     bankCountry: ['', Validators.required],
  //     branchName: ['', Validators.required],
  //     branchCode: ['', Validators.required],
  //     swiftCode: ['', Validators.required],
     
  // });
}


postBank(addBankForm): void {
  if (addBankForm.valid) {
    const newBank = addBankForm.value;
    this.bankService.postbank(newBank).subscribe(
      ((res) => {
        console.log(res);
        
      }),
      ((error) => {
        console.log(error);
        
      }),
      () => {
        alert("bank added")
      }
    )
    this.bankAdded.emit(newBank);
    console.log(addBankForm.value)
    this.dialogRef.close();
  }else{
    alert("form invalid")
  }
}


onClose(): void {
  this.dialogRef.close(false);
}

openSnackBar(message: string): void {
  this.snackbar.open(message, 'Close', {
    duration: 2000,
    horizontalPosition: 'end',
    verticalPosition: 'top'
  });
}
  // onSubmit(): void {
  //   // this.loading = true;
  //   if (this.addBankForm.invalid) {
  //     this.error = "Please fill in all required fields.";
  //     this.loading = false;
  //     return;
  //   }
  //   const bankData = this.addBankForm.value;
  
  //   // this.bankService.addBank(bankData).subscribe({
  //   //   next: (res) => {
  //   //     console.log("Res", res);
  //   //     const registeredbank = res.bank; // Assuming the response contains bank details
  //   //     this.populateFormWithbankDetails(registeredbank);
  //   //     this.addBankForm.reset(); // Reset the form to its initial state
  //   //     // this.hide = true; // Hide the registration form
  //   //     // this.openSnackBar('Bank added successfully');
  //   //     this.router.navigate(["/system/banks"]);
  //   //   },
    
  //   //   error: (error) => {
  //   //     console.log("Error:", error);
  //   //     this.error = error.message || "An error occurred .";
  //   //     this.loading = false;
  //   //   }
  //   // });
  // }
  private populateFormWithbankDetails(bankDetails: any): void {
    this.addBankForm.patchValue({
      bankName: bankDetails.bankName,
      branchName: bankDetails.branchName,
      branchCode: bankDetails.branchCode,
     swiftCode: bankDetails.bankSwiftCode,
     bankCountry: bankDetails.bankCountry
    });
  }


}
// addBankForm: FormGroup;
//   error = "";
//   hide = false;
//   loading = false;
//   bank: Bank = { bankName: '', branchName: '', branchCode: '', swiftCode: '', country: '' };
//   @Output() onClose = new EventEmitter<void>();
// amount: any;
//   constructor(
//     public dialogRef: MatDialogRef<AddbankPopupComponent>,
//     private bankService: MasterdataService,
//     private formBuilder: FormBuilder,
//     private snackBar: MatSnackBar,
//     private router: Router
//   ) {}
//   ngOnInit(): void {
//     this.addBankForm = this.formBuilder.group({
//       bankName: ['', Validators.required],
//       branchName: ['', [Validators.required, Validators.required]],
//       branchCode:  [''],
//       swiftCode: ['', [Validators.required, Validators.required]], // Use Validators.pattern to enforce numeric input
//      bankCountry: ['', Validators.required],
     
//     });
   




