import { Component, Inject,OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MasterdataService } from '../masterdata.service';

@Component({
  selector: 'app-modify-bank-dialogue',
  templateUrl: './modify-bank-dialogue.component.html',
  styleUrls: ['./modify-bank-dialogue.component.scss']
})
export class ModifyBankDialogueComponent implements OnInit {
  bankForm: FormGroup;
  isEditMode: boolean;

  constructor(
    public dialogRef: MatDialogRef<ModifyBankDialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder,
    private bankService: MasterdataService,
  ) {
    this.isEditMode = data.isEditMode;
    this.bankForm = this.fb.group({
      id: [data.bank?.id || ''],
      bankName: [data.bank?.bankName || '', Validators.required],
      bankCode: [data.bank?.bankCode || '', Validators.required],
      bankCountry: [data.bank?.bankCountry || '', Validators.required],
      branchName: [data.bank?.branchName || '', Validators.required],
      branchCode: [data.bank?.branchCode || '', Validators.required],
      bankSwiftCode: [data.bank?.bankSwiftCode || '', Validators.required] // Populate Swift code with existing value
    });
  
 // Subscribe to value changes of form controls
 this.bankForm.valueChanges.subscribe(value => {
  // Update data object with form values
  Object.assign(this.data.bank, value);
});
}
  ngOnInit(): void {
     }

     onSave(): void {
      if (this.bankForm.valid) {
        const updatedBank = this.bankForm.value;
        this.bankService.updateBank(updatedBank).subscribe( 
          () => this.dialogRef.close(true),
        
          error => {
            console.error('Error updating bank', error);
            this.dialogRef.close(false);
            alert('Error updating bank')
          }
        );
      }
    }
  //   this.authService.updateUser(updatedUser).subscribe(
  //     (response) => {
  //       console.log('User updated successfully:', response);
  //       // Optionally, perform any additional actions upon successful update

  //       // Close the dialog
  //       this.dialogRef.close();
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.error('Error updating user:', error);
  //       // Handle the error appropriately
  //       this.snackBar.open("Error updating user. Please try again later.", "Close", {
  //         duration: 5000,
  //         horizontalPosition: 'end',
  //         verticalPosition: 'top',
  //         panelClass: 'notify-error'
  //       });
  //     }
  //   );
  // }
  
    onCancel(): void {
      this.dialogRef.close();
    }
  }