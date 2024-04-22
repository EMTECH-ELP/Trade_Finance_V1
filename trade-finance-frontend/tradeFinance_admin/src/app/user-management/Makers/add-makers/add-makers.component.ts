import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { LookupComponent } from '../../lookup/lookup.component';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-add-makers',
  templateUrl: './add-makers.component.html',
  styleUrls: ['./add-makers.component.scss']
})
export class AddMakersComponent implements OnInit {


  selectedStatus:string
  makerForm: FormGroup
  name: string;
  employeeId: any;
  status: string;
  branchCode: any;
  branchName: string;
  email: string;
  role:string;


  constructor(
    public dialogRef:MatDialogRef<AddMakersComponent>,
    private fb:FormBuilder,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    // private lookupDialog: MatDialogRef<LookupComponent>
  
  
  
  ) { }

  ngOnInit(): void {
    this.makerForm = this.fb.group({
      name: ['', Validators.required],
      employeeId: ['', Validators.required],
      email: ['', Validators.required],
      branchName: ['', Validators.required],
      branchCode: ['', Validators.required],
      status: ['', Validators.required],
      role: ['', Validators.required]
  });
}


  
onSubmit(): void {
  if (this.makerForm.valid) {
    this.saveUser();
    this.dialogRef.close();
  }
}

saveUser() {
  const savedUser = this.makerForm.value;
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
 dialogConfig.data = { branchCode: this.makerForm.get('branchCode').value };

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
    this.makerForm.patchValue({
      branchCode:data.branchCode,
      branchName:data.branchName,
    })
  }
  // patchcheckerForm(arg0: any) {
  //   this.patchcheckerForm.patchValue(sampleData);
  // }
}