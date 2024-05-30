import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BillsService  } from '../../services/bills.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.sass']
})
export class CreateBillComponent implements OnInit {
  applicationForm: FormGroup;
  additionalFileUploads: any;
  ShowLookupComponent: boolean = false;
  selectedValue: string;

  constructor(
    private fb: FormBuilder,
    private billsService: BillsService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private httpClient: HttpClient,
  ) { }

  ngOnInit() {
    this.applicationForm = this.fb.group({
      accountName: ['', Validators.required],
      accountNumber: ['', Validators.required],
      address: ['', Validators.required],
      advisingBankBic: ['', Validators.required],
      advisingBankCountry: ['', Validators.required],
      advisingBankName: ['', Validators.required],
      amount: ['', Validators.required],
      applicableRules: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryAddress: ['', Validators.required],
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryBankAddressLine2: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],
      beneficiaryCountry: ['', Validators.required],
      beneficiaryCountryCode: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryIban: ['', Validators.required],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryMiddleName: ['', Validators.required],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryPostalCode: ['', Validators.required],
      billType: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      cifId: ['', Validators.required],
      city: ['', Validators.required],
      collateralId: ['', Validators.required],
      collateralType: ['', Validators.required],
      collateralValue: ['', Validators.required],
      commodityCode: ['', Validators.required],
      country: ['', Validators.required],
      countryCode: ['', Validators.required],
      countyOfOrigin: ['', Validators.required],
      currency: ['', Validators.required],
      currencyCode: ['', Validators.required],
      documentDescription1: ['', Validators.required],
      documentName1: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      expiryDate: ['', Validators.required],
      goodsQuantity: ['', Validators.required],
      guarantorAddress: ['', Validators.required],
      guarantorEmail: ['', Validators.required],
      guarantorName: ['', Validators.required],
      guarantorPhoneNumber: ['', Validators.required],
      isExpired: ['', Validators.required],
      issueDate: ['', Validators.required],
      nationalId: ['', Validators.required],
      negotiationPeriod: ['', Validators.required],
      partialShipment: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      portOfDischarge: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      postalCode: ['', Validators.required],
      pricePerUnit: ['', Validators.required],
      shipmentDate: ['', Validators.required],
      shipmentTerms: ['', Validators.required],
      transShipment: ['', Validators.required],
      transferable: ['', Validators.required],
    });
  }


  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    // this.row = this.applicationForm.value;
    this.billsService.createBill(this.applicationForm.value).subscribe({
      next: ((response) => {
        console.log("Bill Form response", response);
        alert('Form Submitted Successfully!')
      }),
      error: ((err) => {
        console.error(err);
        alert('An error occurred while submitting the form. Please try again later.');

      }),
      complete: (() => { })
    })
    // this.applicationForm.reset()
    this.ngOnInit()
    this.router.navigate(["/bills/view-bill"]);
  }



  openLookup(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log('received data', res);
        console.log('passed email', res.data[0].email);
        this.patchApplicationForm(res.data[0]);
      }
    });
  }

  public patchApplicationForm(data: any): void {
    this.applicationForm.patchValue({
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

  addFileUpload() {
    throw new Error('Method not implemented.');
  }

  onFileSelected($event: any) {
    throw new Error('Method not implemented.');
  }
}












// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { BillsService} from '../../services/bills.service';
// import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
// import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
// import { ActivatedRoute, Router } from '@angular/router';
// import { Injectable } from '@angular/core';
// import { HttpClient, HttpErrorResponse } from '@angular/common/http';
// import { catchError } from 'rxjs/operators';
// import { throwError } from 'rxjs';

// @Component({
//   selector: 'app-create',
//   templateUrl: './create-bill.component.html',
//   styleUrls: ['./create-bill.component.sass']
// // })
// // @Injectable({
// //   providedIn: 'root'
// // })
// // export class BillsService {
// //   private apiUrl = 'http://192.168.89.2:8085/api/v1/bills';

// //   constructor(private http: HttpClient) { }

// //   createBill(bill: any) {
// //     return this.http.post(`${this.apiUrl}/create`, bill)
// //       .pipe(
// //         catchError(this.handleError)
// //       );
// //   }

// //   private handleError(error: HttpErrorResponse) {
// //     let errorMessage = '';
// //     if (error.error instanceof ErrorEvent) {
// //       // Client-side error
// //       errorMessage = `Client-side error: ${error.error.message}`;
// //     } else {
// //       // Server-side error
// //       errorMessage = `Server-side error: ${error.status} ${error.message}`;
// //     }
// //     console.error(errorMessage);
// //     return throwError(errorMessage);
// //   }
// // }

// export class CreateBillComponent implements OnInit {
// applicationForm: FormGroup;
// addFileUpload() {
// throw new Error('Method not implemented.');
// }
// additionalFileUploads: any;
// onFileSelected($event: any) {
// throw new Error('Method not implemented.');
// }
//   ShowLookupComponent: boolean = false;
//   selectedValue: string;
//   // dialog: any;
//   //router: any;


//   constructor(private fb: FormBuilder,
//     private billsService: BillsService,
//     private dialog: MatDialog,
//     private route: ActivatedRoute,
//     private router: Router,
//     private http: HttpClient,
//         // private lookupDialog: MatDialogRef<LookupComponent>
//   ) { }




// }

 
//   onSubmit() {
//     if (this.applicationForm.valid) {
//       console.log('Form data', this.applicationForm.value);
//       this.billsService.createBill(this.applicationForm.value).subscribe({
//         next: response => {
//           console.log('Bill create response', response);
//         },
//         error: err => {
//           console.error('Error occurred:', err);
//           alert(`Error: ${err}`);
//         },
//         complete: () => {
//           console.log('Request completed');
//         }
//       });
//     } else {
//       console.log('Form is invalid');
//     }
//     this.applicationForm.reset()
//     this.ngOnInit()
//     alert('Form Submitted Successfully!')
//     this.router.navigate(["/bills/viewbill"]);
//   }
//   }

//   openLookup(): void {
//     // Create a MatDialogConfig object
//     const dialogConfig = new MatDialogConfig();
//     dialogConfig.width = '500px';
//     dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };
  
//     // Open the LookupComponent dialog with the dialog config
//     const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

//     dialogRef.afterClosed().subscribe({
//       next: (res: any) => {
//         console.log("received data", res),

//         console.log("passed email", res.data[0].email)
        
//         this.patchApplicationForm(res.data[0])
//       }
//     })
//   }

//   public patchApplicationForm(data: any): void {
//     this.applicationForm.patchValue({
//     accountNumber: data.accountNumber,
//     cifId: data.cifId,
//     nationalId: data.nationalId,
//     accountName: data.accountName,
//     currency: data.currency,
//     email: data.email,
//     phoneNumber: data.phoneNumber,
//     address: data.address,
//     city: data.city,
//     postalCode: data.postalCode,
//     countryCode: data.countryCode ? data.countryCode : 'NAN', 
//     country: data.country
//  });
// }
  
// function openLookup() {
//   throw new Error('Function not implemented.');
// }

// function ngOnInit() {
//   throw new Error('Function not implemented.');
// }

