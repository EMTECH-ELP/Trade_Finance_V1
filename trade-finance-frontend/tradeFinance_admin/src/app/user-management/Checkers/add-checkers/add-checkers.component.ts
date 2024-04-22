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
  form: FormGroup
  name: string;
  employeeId: any;
  status: string;
  branchCode: any;
  branchName: string;
  email: string;


  constructor(public dialogRef:MatDialogRef<AddCheckersComponent>,
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
  if (this.form.valid) {
    this.saveUser();
    this.dialogRef.close();
  }
}

saveUser() {
  const savedUser = this.form.value;
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
}