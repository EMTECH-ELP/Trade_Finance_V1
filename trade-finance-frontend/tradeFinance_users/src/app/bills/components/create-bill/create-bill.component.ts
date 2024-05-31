import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BillsService } from '../../services/bills.service';
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
  additionalFileUploads: any[] = [];
  ShowLookupComponent: boolean = false;
  selectedValue: string = '';
  uploadedFile: File | null = null;
  fileUrl: string | null = null;

  constructor(
    private fb: FormBuilder,
    private billsService: BillsService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private httpClient: HttpClient,
  ) { }

  ngOnInit(): void {
    this.applicationForm = this.fb.group({
      //applicant
      accountNumber: ['', Validators.required],
      cifId: [''],
      nationalId: ['', Validators.required],
      accountName: ['', Validators.required],
      currency: ['', Validators.required],
      email: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postalCode: ['', Validators.required],
      countryCode: ['', Validators.required],
      country: ['', Validators.required],
//Account response
      // cifId: [''],
      // city: ['', Validators.required],
      // currency: ['', Validators.required],
      // nationalID: ['', Validators.required],
      // applicantEmail: ['', [Validators.required, Validators.email]],
      // commodityCode: ['', Validators.required],
    
       
//Beneficiary       
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryIban: ['', Validators.required],
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryAddressLine2: [''],
      beneficiaryCity: ['', Validators.required],
      beneficiaryPostalCode: ['', Validators.required],
      beneficiaryCountry: ['', Validators.required],
      beneficiaryCountryCode: ['', Validators.required],
      advisingBankName: ['', Validators.required],
      advisingBankCountry: ['', Validators.required],
      advisingBankBic: ['', Validators.required],

      //bill details
      billType: ['', Validators.required],
      amount: ['', Validators.required],
      issueDate: ['', Validators.required],
      dueDate: ['', Validators.required],
      tenor: [''],
      discountRate:[''],
      acceptanceDueDate:[''],
      acceptanceStatus: [''],
      negotiationAmount:[''],
      negotiationDate:[''],
      protestDate:[''],
      guarantor:[''],
//Documents
      documentDescription1: ['', Validators.required],
      documentName1: ['', Validators.required],

//Goods
      goodsName:[''],
      goodsDescription:[''],
      goodsValue:[''],
      goodsQuantity:[''],
      hsCode:[''],
//Shipment Details
      shipmentDate: ['', Validators.required],
      shipmentTerms: ['', Validators.required],
      countryOfOrigin: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      portOfDischarge:['', Validators.required],
      billOfLading:[''],
      airwayBill:[''],
 //
      avalisationStatus:[''],
      avalisationDate:[''],
      avalisationExpiryDate:['']    
          
    });
  }
  onSubmit(): void {
    console.log("Form data", this.applicationForm.value);
    //const data = this.createBiLL(this.applicationForm.value);
    this.billsService.createBill(this.applicationForm.value).subscribe({
      next: ((response) => {
        console.log("Bill create response", response);
      }),
      error: ((err) => {
        console.error(err);
        // alert('An error occurred while submitting the form. Please try again.');
      }),
      complete: (() => {})
    });
    this.applicationForm.reset();
    this.ngOnInit();
    alert('Form Submitted Successfully!');
    this.router.navigate(["/bills/viewbill"]);
  }
  openLookup(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber')?.value };

    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("received data", res);
        // console.log('passed email', res.data[0].email);
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
  onFileSelected(event: any) {
    const selectedFile = event.target.files[0]
  
    if (selectedFile) {
      if (selectedFile.type !== 'application/pdf') {
        // Display an error message 
        alert('Please select a PDF file.');
        // Clear the file input and disable it
        event.target.value = '';
        return;
      }
      // If the selected file is a PDF, read it as a data URL using FileReader
      const fileReader = new FileReader();
      fileReader.onload = () => {
        // Convert the PDF file content to a string
        const pdfString = fileReader.result as string;

        // Now you have the PDF content as a string (pdfString)
        // You can assign it to a form control or store it as needed
        // For example, you can store it in a form control named 'pdfContent'
        this.applicationForm.get('pdfContent')?.setValue(pdfString);
      };
      fileReader.readAsDataURL(selectedFile);
    }
  }
  addFileUpload() {
    const newLabel = prompt('Enter Document Name for the New File Upload:'); 
  
    if (newLabel) { 
      const newRow = {
        label: newLabel.trim(),
      };
      this.additionalFileUploads.push(newRow);
    }
  }
  }
