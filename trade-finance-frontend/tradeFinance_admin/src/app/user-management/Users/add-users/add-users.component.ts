import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/core/service/auth.service';
import { LookupComponent } from '../../lookup/lookup.component';
import { UserManagementService } from '../../user-management.service';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.scss']
})
export class AddUsersComponent implements OnInit {

  error: any;
  loading: any;
  selectedStatus: string;
  checkerForm: FormGroup;
  hide: boolean;
  // userRoles: Array<{value: string, viewValue:string}> = [{value:'CHECKER', viewValue: 'Checker'}, {value: 'Maker', viewValue: 'Maker'}, {value: 'ADMIN', viewValue: 'Admin'}];
  userRoles: Array<{ value: string, viewValue: string }> = [];

  constructor(
    public dialogRef: MatDialogRef<AddUsersComponent>,
    private fb: FormBuilder,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private authservice: AuthService,
    private snackbar: MatSnackBar,
    private userService: UserManagementService
  ) {}

  ngOnInit(): void {
    this.checkerForm = this.fb.group({
      fullName: ['', Validators.required],
      employeeID: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      branchName: ['', Validators.required],
      branchCode: ['', Validators.required],
      status: ['', Validators.required],
      role: ['', Validators.required]
    });
    this.getAllRoles();
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
        this.checkerForm.reset();
        this.hide = false;
        this.openSnackBar('Registration successful');
        this.dialogRef.close();
      },
      error: (error) => {
        console.log("Error:", error);
        this.error = error;
        this.loading = false;
      },
      complete: () => {
        this.loading = false;
      }
    });
  }

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
      this.authservice.addNewUser(this.checkerForm.value).subscribe({
        next: (response: any) => {
          console.log("user data", response)
          this.snackbar.open("User Registered Successfully", 'Okay')
          this.dialogRef.close();
        },
        error: (error) => {
          console.log('error response', error);
          this.dialogRef.close();
        }
      });
    }
  }

  openLookUp() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { branchCode: this.checkerForm.get('branchCode').value };

    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("received data", res);
        this.patchcheckerForm(res);
      }
    });
  }

  public patchcheckerForm(data: any): void {
    this.checkerForm.patchValue({
      branchCode: data.branchCode,
      branchName: data.branchName,
    });
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onClick(): void {
    this.dialogRef.close();
  }

  getAllRoles() {
    this.userService.getAllRoles().subscribe({
      next: (roles: Array<{ value: string, viewValue: string }>) => {
        this.userRoles = roles;
      },
      error: (error) => {
        console.error('Error fetching roles:', error);
        this.snackbar.open('Failed to load roles', 'Close', { duration: 2000 });
      }
    });
  }

}
