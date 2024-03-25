import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-add-makers',
  templateUrl: './add-makers.component.html',
  styleUrls: ['./add-makers.component.scss']
})
export class AddMakersComponent implements OnInit {
selectedStatus:string
  form:FormGroup


  constructor(private dialogRef:MatDialogRef<AddMakersComponent>,
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
