import { Component, Inject, OnInit } from '@angular/core';
import { ViewComponent } from '../components/view/view.component';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LcService } from '../services/lc.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.sass']
})
export class TestComponent implements OnInit {

  testForm: FormGroup

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ViewComponent>,
    private formBuilder: FormBuilder,
    private lcService: LcService,
    private snackbar: SnackbarService) { }

  ngOnInit(): void {

    this.testForm = this.formBuilder.group({
      applicantFirstName: ["", Validators.required],
      applicantLastName: ["", Validators.required],
      applicantEmail: ["", Validators.required],
      beneficiaryEmail: ["", Validators.required]
    })
  }

  public submit(){
    
    this.lcService.createLc(this.testForm.value, 546789).subscribe({
      next: ((res) => {

        console.log("Response", res);
        if (res){
          this.testForm.reset();
          this.dialogRef.close();
          this.snackbar.showNotification(""," LC created successfully");
        }else {
          this.snackbar.showNotification("", res.message);
        }
      }),
       error: ((err) => {
        this.snackbar.showNotification("", err);
       }),
      complete: (() => {})
    })
  }

  public onClick(){
    this.dialogRef.close();
  }

}
