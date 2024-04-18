import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
// import { SearchService } from '../../services/search.service';
import { InvDiscountingService } from '../../services/inv-discounting.service';


@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.sass']
})
export class CreateInvoiceComponent implements OnInit {


  selectedValue: string;
  invoiceDiscountingForm: FormGroup;
 
  isLinear: true;
   query: string = '';
   searchData: any;

   selected = 'created';
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
      cifId:['', Validators.required],
      accountNumber:['', Validators.required],
      accountName:['', Validators.required],
      email: new FormControl(null, [Validators.required,]),
      businessNo: new FormControl(null, [Validators.required,]),
      businessName: new FormControl(null, [Validators.required,]),
      businessType: new FormControl(null, [Validators.required,]),
      industrySector: new FormControl(null, [Validators.required,]),
      phoneNumber: new FormControl(null, [Validators.required,]),
      alternativePhoneNumber: new FormControl(null, [Validators.required,]),
      address: new FormControl(null, [Validators.required,]),
      country: new FormControl(null, [Validators.required,]),
      postalCode: new FormControl(null, [Validators.required,]),
      city: new FormControl(null, [Validators.required,]),
      branchName: new FormControl(null, [Validators.required,]),
      branchCode: new FormControl(null, [Validators.required,]),
      // Invoice
     invoiceDate: new FormControl(null, [Validators.required,]),
     invoiceNumber: new FormControl(null, [Validators.required,]),
     invoiceAmount: new FormControl(null, [Validators.required,]),
     dueDate: new FormControl(null, [Validators.required,]),
     status: new FormControl(null, [Validators.required,]),
     invoices: new FormControl(null, [Validators.required,]),
    //  Funding 
     fundingAmount: new FormControl(null, [Validators.required,]),
     disbursalDate: new FormControl(null, [Validators.required,]),
     repaymentDate: new FormControl(null, [Validators.required,]),
    //  Repayment
    paymentTerms: new FormControl(null, [Validators.required,]),
    amount: new FormControl(null, [Validators.required,]),
    paymentDate: new FormControl(null, [Validators.required,]),
    
    
  });

  }
  search(): void {
    // this.searchService.search(this.query)
    //   .subscribe(data => {
    //     this.searchData = data;
    //   });
  }

    // Searching by CIF
  onSearch(){

  }
 //Searching by A/C No.
  onRetrieve(){

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

