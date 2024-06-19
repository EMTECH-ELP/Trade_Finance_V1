import { Component, OnInit, Output,EventEmitter,Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import {  MasterdataService } from '../masterdata.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
import { Bank } from '../bank.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addbank-popup',
  templateUrl: './addbank-popup.component.html',
  styleUrls: ['./addbank-popup.component.scss']
})
export class AddbankPopupComponent implements OnInit{
  @Output() bankAdded = new EventEmitter<any>();
  addBankForm: FormGroup;

  isEditMode = false;
  bank: Bank | undefined;
  

  selectedStatus:string
  bankName:string;
  bankCode:string;
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
    private snackbar: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public data: Bank

  ) {   
    this.addBankForm = this.fb.group({
     bankName: ['', Validators.required],
     bankCode: ['', Validators.required],
    bankCountry: ['', Validators.required],
      branchName: ['', Validators.required],
        branchCode: ['', Validators.required],
        bankSwiftCode: ['', Validators.required],
       
    });
    if (this.isEditMode) {
      // Assume `bank` is available and populated with existing bank data
      this.addBankForm.patchValue({
        bankName: this.bank.bankName,
        bankCode: this.bank.bankCode,
        branchName: this.bank.branchName,
        branchCode: this.bank.branchCode,
        bankCountry: this.bank.bankCountry,
        bankSwiftCode: this.bank.swiftCode
      });
    }
   }

  ngOnInit(): void {
    if (this.data) {
      this.isEditMode = true;
      this.bank = this.data;
      this.addBankForm.patchValue(this.data);
      console.log(this.data); 
    } else {
      // Initialize form controls here if not in edit mode
      this.addBankForm.reset({
        bankName: '',
        bankCode: '',
        bankCountry: '',
        branchName: '',
        branchCode: '',
        bankSwiftCode: ''
      });
    }
}
// onNoClick(): void {
//   this.dialogRef.close();
// }

//Update OR ADD Bank
// postBank(addBankForm): void {
//   if (this.addBankForm.valid) {
//     const bankData = this.addBankForm.value;
//     if (this.isEditMode) {
//       this.bankService.updateBank(bankData).subscribe(() => {
//         this.dialogRef.close(true);
//       }, error => {
//         console.error('Error updating bank:', error);
//       });
//       console.log('Updating bank:', bankData);
//       alert('Edited Successfully')
//     } else {
//       this.bankService.postbank(bankData).subscribe(() => {
//         this.dialogRef.close(true);
//       }, error => {
//         console.error('Error adding bank:', error);
//       });
//       console.log('Adding bank:', bankData);
//       alert('Bank added Successfully')
//     }
//   }
// }

// toggleEditMode(): void {
//   this.isEditMode =!this.isEditMode;
//   if (!this.isEditMode) {
//     // Clear form if toggling away from edit mode
//     this.addBankForm.reset();
//   }
// }

//Addbank
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
    
  }
}


onClose(): void {
  this.dialogRef.close();
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
      bankCode: bankDetails.bankCode,
      branchName: bankDetails.branchName,
      branchCode: bankDetails.branchCode,
      bankCountry: bankDetails.bankCountry,
     bankSwiftCode: bankDetails.bankSwiftCode,
   
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
   




