import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/core/service/auth.service';
import { LookupComponent } from '../../lookup/lookup.component';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.scss']
})
export class AddUsersComponent implements OnInit {

  error:any;
  loading:any;
  
  
    selectedStatus:string
    checkerForm: FormGroup
    name: string;
    employeeID: any;
    status: string;
    branchCode: any;
    branchName: string;
    email: string;
    role:string;
    hide: boolean;
  
  
    constructor(
      public dialogRef:MatDialogRef<AddUsersComponent>,
      private fb:FormBuilder,
      private dialog: MatDialog,
      private route: ActivatedRoute,
      private router: Router,
      private authservice:AuthService,
      private snackbar:MatSnackBar,
      private lookupDialog: MatDialogRef<LookupComponent>
    
    
    
    ) { }
  
    ngOnInit(): void {
      this.checkerForm = this.fb.group({
        fullName: ['', Validators.required],
        employeeID: ['', Validators.required],
        email: ['', Validators.required],
        branchName: ['', Validators.required],
        branchCode: ['', Validators.required],
        status: ['', Validators.required],
        role: ['', Validators.required]
    });
  }
  
  registerChecker(): void {
    this.loading = true;
    
    if (this.checkerForm.invalid) {
      this.error = "Please fill in all required fields.";
      this.loading = false;
      return;
    }
  
    const userData = {
      fullName: this.checkerForm.get('fullName')?.value,
      employeeId: this.checkerForm.get('employeeID')?.value,
      email: this.checkerForm.get('email')?.value,
      branchName: this.checkerForm.get('branchName')?.value,
      branchCode: this.checkerForm.get('branchCode')?.value,
      status: this.checkerForm.get('status')?.value,
      role: this.checkerForm.get('role')?.value,
    };
    
    this.authservice.addNewUser(userData).subscribe({
      next: (res) => {
        console.log("Res", res);
        this.checkerForm.reset(); // Reset the form to its initial state
        this.hide = false;
        this.openSnackBar('Registration successful'); // Call openSnackBar method
        this.dialogRef.close()
      },
      error: (error) => {
        console.log("Error:", error);
        this.error = error.message;
      },
      complete: () => {
        this.loading = false;
      }
    });
  }
  
  
  // onSumbit(){
  //   console.log(this.checkerForm.value);
  //   this.authservice.addNewUser(this.checkerForm.value).subscribe((ressponse)=>{
  //     console.log(ressponse);
  //     this.openSnackBar('Registration successful'); // Call openSnackBar method
        
  //       this.router.navigate(["/users/users"]);
  //   })
  // }
  
  openSnackBar(message: string): void {
    this.snackbar.open(message, 'Close', {
      duration: 2000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      panelClass: ['success-snackbar']
    });
  }
  
  
  onSubmit(): void {
   if (this.checkerForm.valid) {
    console.log("got here .....")
    this.authservice.addNewUser(this.checkerForm.value).subscribe({
      next: (response: any)=> {
        console.log("user data", response)
        this.snackbar.open("User Registered Successfully", 'Okay')
        this.dialogRef.close();
      },
      error: (error) => {
        console.log('error response', error);
        this.dialogRef.close();
      }
    })   
    }
  }
  
  saveUser() {
    const savedUser = this.checkerForm.value;
    // Here you can handle the savedUser object as needed
    console.log(savedUser); // Example: Log the savedUser object
    // You can also perform any further operations like sending the data to a server
  }
  
    onClose(): void {
      this.dialogRef.close();
    }
  
    onClick(){
      this.dialogRef.close();
    }
  
  
  
    openLookUp(){
   // Create a MatDialogConfig object
   const dialogConfig = new MatDialogConfig();
   dialogConfig.width = '500px';
   dialogConfig.data = { branchCode: this.checkerForm.get('branchCode').value };
  
   // Open the LookupComponent dialog with the dialog config
   const dialogRef = this.dialog.open(LookupComponent, dialogConfig);
  
   dialogRef.afterClosed().subscribe({
     next: (res: any) => {
       console.log("received data", res),
  
        //  console.log("passed email", res.data[0].email)
  
       this.patchcheckerForm(res)
     }
   })
  
  
    }
  
    public patchcheckerForm(data:any):void{
      this.checkerForm.patchValue({
        branchCode:data.branchCode,
        branchName:data.branchName,
      })
    }
    // patchcheckerForm(arg0: any) {
    //   this.patchcheckerForm.patchValue(sampleData);
    // }
  }
