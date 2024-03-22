import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-checkers',
  templateUrl: './add-checkers.component.html',
  styleUrls: ['./add-checkers.component.scss']
})
export class AddCheckersComponent implements OnInit {

  selectedStatus:string
  form:FormGroup


  constructor(private dialogRef:MatDialogRef<AddCheckersComponent>,
    private fb:FormBuilder) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required],
      employeeId: ['', Validators.required],
      email: ['', Validators.required],
      branchName: ['', Validators.required],
      branchCode: ['', Validators.required],
      status: ['', Validators.required]
  });
}


  onSubmit(): void {
    
    // Here you can handle form submission
    // For example, you can emit an event or call a service
    // After submitting, close the dialog
    this.dialogRef.close();
  }

  onClose(): void {
    this.dialogRef.close();
  }

}