import { Injectable } from '@angular/core';
import { MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition, MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class NotificationServiceService {
  showSuccessNotification(arg0: string) {
    throw new Error('Method not implemented.');
  }
  showSuccess(arg0: string) {
    throw new Error('Method not implemented.');
  }
  showError(message: any) {
    throw new Error('Method not implemented.');
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(
    private snackBar: MatSnackBar
  ) {
   }
  alertSuccess(message:any){
    this.snackBar.open(message, "OK", {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 5000,
      panelClass: ['mat-toolbar', 'green-snackbar']
    });
  }
  alertWarning(message:any){
    this.snackBar.open(message, "X", {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 5000,
      panelClass: ['mat-toolbar', 'red-snackbar']
    });
  }
}
