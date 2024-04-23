import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
// import { SearchService } from '../../services/search.service';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { MatDialogConfig } from '@angular/material/dialog';
import { InvoiceLookupComponent } from '../../invoice-lookup/invoice-lookup.component';
import { Router } from '@angular/router';



@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.sass']
})
export class CreateInvoiceComponent implements OnInit {
  ShowLookupComponent: boolean = false;

  selectedValue: string;
  invoiceDiscountingForm: FormGroup;
 
  isLinear: true;
   query: string = '';
   searchData: any;
  
   selected = 'created';
  dialog: any;
// invoiceStatus: any;
  
 
   onOptionChange() {
    //  console.log('Selected option:', this.selectedOption);
     // You can perform any actions based on the selected option here
   }
 
  constructor(private builder: FormBuilder,
    private invDiscountingService: InvDiscountingService,
    //private searchService: SearchService
    ) { }

  ngOnInit(): void {
    this.invoiceDiscountingForm = this.builder.group({
      accountNumber: ['', Validators.required],
      cifId: ['', Validators.required],
      nationalId: ['', Validators.required],
      accountName: ['', Validators.required],
      currency: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postalCode: ['', Validators.required],
      countryCode: ['', Validators.required],
      country: ['', Validators.required],
// invoice details
     invoiceDate: new FormControl(null, [Validators.required,]),
     invoiceNumber: new FormControl(null, [Validators.required,]),
     invoiceAmount: new FormControl(null, [Validators.required,]),
     businessName:new FormControl(null,[Validators.required,]),
     businessAddress: new FormControl(null, [Validators.required,]),
     dueDate: new FormControl(null, [Validators.required,]),
     taxIdentificationNumber: new FormControl(null, [Validators.required,]),
     status: new FormControl(null, [Validators.required,]),
     invoices: new FormControl(null, [Validators.required,]),

    //  Funding details
     fundingAmount: new FormControl(null, [Validators.required,]),
     disbursalDate: new FormControl(null, [Validators.required,]),
     repaymentDate: new FormControl(null, [Validators.required,]),
     creditAccount: new FormControl(null, [Validators.required,]),
     creditLimit: new FormControl(null, [Validators.required,]),
    //  importer details
    buyerName: new FormControl(null, [Validators.required,]),
    buyerEmailAddress: new FormControl(null, [Validators.required,]),
    buyerCountry: new FormControl(null, [Validators.required,]),
    buyerCity: new FormControl(null, [Validators.required,]),

  //  referee details 
  refereeFullName: new FormControl(null, [Validators.required,]),
  refereeEmail: new FormControl(null, [Validators.required,]),
  refereeBussinessNumber: new FormControl(null, [Validators.required,]),
  refereeBusinessnumber: new FormControl(null, [Validators.required,]),
  refereeBusinessName: new FormControl(null, [Validators.required,]),

  
  });

  }
  search(): void {
    // this.searchService.search(this.query)
    //   .subscribe(data => {
    //     this.searchData = data;
    //   });
  }
  openLookup(): void {
  
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.invoiceDiscountingForm.get('accountNumber').value };
  
    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(InvoiceLookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("received data", res),

        console.log("passed email", res.data[0].email)
        
        this.patchinvoiceDiscountingForm(res.data[0])
      }
    })
  }
 
  onSubmit() {
     console.log(this.invoiceDiscountingForm.value)
     this. invDiscountingService.postData(this.invoiceDiscountingForm.value).subscribe({
      next: ((response) => {

        console.log("Invoice Form response", response);
      }),
      error: ((err) => {
        console.error(err)
      }),
      complete: (() => { })
      
    })
  } public patchinvoiceDiscountingForm(data: any): void {
    this.invoiceDiscountingForm.patchValue({
    accountNumber: data.accountNumber,
    cifId: data.cifId,
    nationalId: data.nationalId,
    accountName: data.accountName,
    currency: data.currency,
    email: data.email,
    phoneNumber: data.phoneNumber,
    address: data.address,
    city: data.city,
    postalCode: data.postalCode,
    countryCode: data.countryCode ? data.countryCode : 'NAN', 
    country: data.country
 });
}
  

}
 

// getBeneficiaryDetails(){
//   return this.invoiceDiscountingForm.get("beneficiaryDetails") as FormGroup
// }
// getBankDetails(){
//   return this.invoiceDiscountingForm.get("bankDetails") as FormGroup
// }
// getContactDetails(){
//   return this.invoiceDiscountingForm.get("contact") as FormGroup
// }
// onSubmit(){
//   if(this.invoiceDiscountingForm.valid){
//     console.log(this.invoiceDiscountingForm.value);
//   }
// }

