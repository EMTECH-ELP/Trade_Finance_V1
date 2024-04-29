import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { MatDialogRef } from '@angular/material/dialog';
import { FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';

@Component({
  selector: 'app-repaymentdetails',
  templateUrl: './repaymentdetails.component.html',
  styleUrls: ['./repaymentdetails.component.sass']
})
export class RepaymentdetailsComponent implements OnInit {
  formData: any;
  date: Date;
  invoiceId: string;
  amount: string;
  debitAccount: string;
  repaymentForm: any;
currency: any;
  
  // dialogRef: any;


  constructor( private router: Router,
    private builder: FormBuilder,
    private dialog: MatDialog,
    private invDiscountingService: InvDiscountingService,
    public dialogRef: MatDialogRef<RepaymentdetailsComponent>
    ) { }

  ngOnInit(): void {
    this.repaymentForm = this.builder.group({
      date: new FormControl(null, [Validators.required,]),
      amount: new FormControl(null, [Validators.required,]),
      debitAccount: new FormControl(null, [Validators.required,]),
      invoiceId: new FormControl(null, [Validators.required,]),
      
    });
  }
 
    closeDialog():void{
      this.router.navigate(["/invoice-discounting/viewInvoice"])
      this.dialogRef.close();
    }
    submitForm(){
      console.log(this.repaymentForm.value)
      this. invDiscountingService.postData(this.repaymentForm.value).subscribe({
       next: ((response) => {
 
         console.log("Invoice Form response", response);
       }),
       error: ((err) => {
         console.error(err)
       }),
       complete: (() => { })
     })
     this.dialogRef.close();
    //  Add logic to change status to paid once amount equals the pending amount.
   }
    }
