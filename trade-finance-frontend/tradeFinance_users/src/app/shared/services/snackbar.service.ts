import { Injectable } from '@angular/core';
import { MatSnackBar } from "@angular/material/snack-bar";


@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
 

  constructor(private snackBar: MatSnackBar) { }

  
  showNotification(colorName, text) {
    // const cleanMessage = message.replace(/\s/g, '');
    this.snackBar.open(text, "", {
      duration: 3000,
      verticalPosition: "top",
      horizontalPosition: "center",
      panelClass: colorName,
    });
  }
}
