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
  today = new Date().toISOString().split('T')[0];
  constructor( private router: Router,
    private builder: FormBuilder,
    private fb: FormBuilder, 
    private dialog: MatDialog,
    private invDiscountingService: InvDiscountingService,
    public dialogRef: MatDialogRef<TransferFundsComponent>
    ) { }

  ngOnInit(): void {
    this.fundingForm = this.fb.group({
      discountRate: [''],
      fundingAmount: [''],
      creditLimit: ['']
   
    });

    this.onChanges();
  }

  onChanges(): void {
    this.fundingForm.get('discountRate').valueChanges.subscribe(value => {
      if (value) {
        this.fetchFundingDetails(value);
      }
    });
  }

  fetchFundingDetails(discountRate: number): void {
    this.invDiscountingService.getDataBasedOnDiscountRate(discountRate).subscribe(data => {
      this.fundingForm.patchValue({
        fundingAmount: data.fundingAmount,
       
      });
    }, error => {
      console.error('Error fetching funding details:', error);
      // Handle error as needed (e.g., show user-friendly message)
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
