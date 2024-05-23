import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-deletion-dialog',
  templateUrl: './confirm-deletion-dialog.component.html',
})
export class ConfirmDeletionDialogComponent {
  constructor(public dialogRef: MatDialogRef<ConfirmDeletionDialogComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
