import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmDeletionDialogComponent } from './confirm-deletion-dialog/confirm-deletion-dialog.component';
import { LcService } from '../../services/lc.service';

@Component({
  selector: 'app-delete-lc',
  templateUrl: './delete-lc.component.html',
  styleUrls: ['./delete-lc.component.sass']
})
export class DeleteLcComponent implements OnInit {
  lcNumber: string = '';
  comments: string = '';
  lcId: string; // Property to store the ID of the Letter of Credit
  deletionForm: FormGroup;

  constructor(private router: Router, public dialog: MatDialog, private fb: FormBuilder, private lcService :LcService) { }

  ngOnInit(): void {
    this.deletionForm = this.fb.group({
      lcNumber: ['', Validators.required],
      comments: ['']
    });
  }

  confirmDeletion() {
    const dialogRef = this.dialog.open(ConfirmDeletionDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result === 'yes') {
        this.deleteLC();
      }
    });
  }

  deleteLC() {
    this.lcService.deleteLC(this.deletionForm).subscribe({
      next: (response) => {
        console.log("LC Deletion response", response);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        alert('LC deleted successfully and records updated!');
        this.router.navigate(["/lc/view"]);
      }
    });
    console.log('Form deletion details', this.deletionForm.value);
    console.log('Deleting LC:', this.lcNumber);
    console.log('Comments:', this.comments);
  //  //this.lcService.deleteLC.
  //   // After deletion, navigate to another page or show a success message.
  //   this.router.navigate(['/lc/view']);
  }

  getLcNumber() {
    console.log('Lc Number retrieved successfully!');
  }
}
