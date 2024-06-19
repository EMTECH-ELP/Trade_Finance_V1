import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-transfer-funds',
  templateUrl: './transfer-funds.component.html',
  styleUrls: ['./transfer-funds.component.sass']
})
export class TransferFundsComponent implements OnInit {
  fundingForm: FormGroup;

  constructor( private router: Router,
    private builder: FormBuilder,
    private fb: FormBuilder, 
    private dialog: MatDialog,
    private invDiscountingService: InvDiscountingService,
    public dialogRef: MatDialogRef<TransferFundsComponent>
    ) { }

  ngOnInit(): void {
    this.fundingForm = this.fb.group({
      discountRate: ['', Validators.required],
      fundingAmount: ['', Validators.required],
      creditLimit: ['', Validators.required],
      creditAccount: ['', Validators.required],
      disbursalDate: ['', Validators.required],
      repaymentDate: ['', Validators.required]
    });

    this.onChanges();
  }

  onChanges(): void {
    this.fundingForm.get('discountRate').valueChanges.subscribe(value => {
      if (value) {
        // Assuming you have a service to fetch the funding amount and credit limit
        this.fetchFundingDetails(value);
      }
    });
  }

  fetchFundingDetails(discountRate: number): void {
    // Call your service here and set the values to the form controls
    this.invDiscountingService.getDataBasedOnDiscountRate(discountRate).subscribe(data => {
      this.fundingForm.patchValue({
        fundingAmount: data.fundingAmount,
        creditLimit: data.creditLimit
      });
    });
  }

  closeDialog():void{
    this.router.navigate(["/invoice-discounting/viewInvoice"])
    this.dialogRef.close();
  }
  saveForm(){
    console.log(this.fundingForm.value)
    // this. invDiscountingService.saveFundingData().subscribe({
    //  next: ((response) => {

    //    console.log("Invoice Form response", response);
    //  }),
  //    error: ((err) => {
  //      console.error(err)
  //    }),
  //    complete: (() => { })
  //  })
  //  this.dialogRef.close();
  //  Add logic to change status to paid once amount equals the pending amount.
 }
}
