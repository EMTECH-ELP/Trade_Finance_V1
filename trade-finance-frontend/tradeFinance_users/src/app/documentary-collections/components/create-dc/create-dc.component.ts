import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
//import {HttpClient} from "@angular/common/http";
import { MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { DcServiceService } from '../../dc-service.service';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import { ActivatedRoute, Router } from '@angular/router';






@Component({
  selector: 'app-create-dc',
  templateUrl: './create-dc.component.html',
  styleUrls: ['./create-dc.component.sass'],
  providers: [ DcServiceService ],
})
export class CreateDcComponent implements OnInit {
  ShowLookupComponent: boolean = false;
  selectedValue: string;
  applicationForm: FormGroup;
  // dialog: any;
  // router: any;

  constructor(private fb: FormBuilder,
    private dcservice: DcServiceService,
    private dialog: MatDialog, private route: ActivatedRoute,
    private router: Router,
    // private lookupDialog: MatDialogRef<LookupComponent>
  ) { }


  // public lookup(row){
  //   const dialogConfig = new MatDialogConfig()
  //   dialogConfig.disableClose = true
  //   dialogConfig.autoFocus = true
  //   dialogConfig.width = '600px'
  //   dialogConfig.data = { rowData: row }

  //   const dialogRef = this.dialog.open (LookupComponent, dialogConfig)
  //   dialogRef.afterClosed().subscribe((result)=>{
  //     console.log('closed');

  //   })
  // }


  ngOnInit() {

    this.applicationForm = this.fb.group({
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
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryAddressLine1: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      advisingBankCountry: ['', Validators.required],
      advisingBankName: ['', Validators.required],
      advisingBankBic: ['', Validators.required],
      beneficiaryBankAddressLine2: ['', Validators.required],
      beneficiaryIban: ['', Validators.required],
      beneficiarySwiftCode: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],
      // beneficiaryPostalCode: ['', Validators.required],
      originCountry: ['', Validators.required],
      loadingPort: ['', Validators.required],
      dischargePort: ['', Validators.required],
      goodsDescription: ['', Validators.required],
      DCquantity: ['', Validators.required],
      portOfLoading: ['', Validators.required],
      shipDateStart: ['', Validators.required],
      shipDateEnd: ['', Validators.required],
      DCbillOfLading: ['', Validators.required],
      DCinvoice: ['', Validators.required],
      dcType: ['', Validators.required],
      dcSubType: ['', Validators.required],
      totPayableAmount: ['', Validators.required],
      chargeAccount: ['', Validators.required],
      payableAmount: ['', Validators.required],
      payingAmount: ['', Validators.required],
      invoices: [[], [Validators.required]],
    packingList: [[], Validators.required],
    billOfLading: [[], Validators.required],
    billOfExchange: [[], Validators.required],
    insuranceCertificate: [[]],
    inspectionCertificate: [[]],
    originCert: [[], Validators.required]
    });

  }

  

  onSubmit() {
    console.log("Form data", this.applicationForm.value);
    this.dcservice.createDc(this.applicationForm.value).subscribe({
        next: ((response) => {
            console.log("dc create response", response);
        }),
        error: ((err) => {
            console.error(err)
        }),
        complete: (() => { })
    });

    this.applicationForm.reset();
    this.ngOnInit();

    // Show alert
    alert('Form Submitted Successfully!');

    // Navigate to the desired URL after the alert is dismissed
    this.router.navigate(['/documentary-collection/viewDc']);
}


  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };
  
    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);
  }
  



  
  rows: any[] = [
    { documentType: 'Bill of Exchange', checked: false, formControlName: 'billOfExchange' },
    { documentType: 'Invoice', checked: false, formControlName: 'invoiceCertificate' },
    { documentType: 'Certificate of Origin', checked: false, formControlName: 'certificateOfOrigin' },
    { documentType: 'Insurance Certificate', checked: false, formControlName: 'insuranceCertificate' },
    { documentType: 'Packing List', checked: false, formControlName: 'packingList' },
    { documentType: 'Marine Bill of Lading', checked: false, formControlName: 'billOfLading' },
    { documentType: 'CMR/Airway Bill', checked: false, formControlName: 'airwayBill' },
    // Adds rows to html
  ];
  
  // Function to toggle row
  toggleRow(index: number) {
   this.rows[index].checked = !this.rows[index].checked;
   }
   addRow() {
    const documentType = prompt("Enter document type:");
    if (documentType) {
      this.rows.push({
        documentType: documentType,
        checked: false,
        // Add more properties as needed
      });
    }
  }
   





  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];

    // Check if a file is selected
    if (selectedFile) {
      // Check file type
      if (selectedFile.type !== 'application/pdf') {
        // Display an error message or take appropriate action
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
  


//    onFileSelected(event: any) {
//      const selectedFile = event.target.files[0];

//     // Check if a file is selected
//   if (selectedFile) {
//         // Check file type
//         if (selectedFile.type !== 'application/pdf') {
//            // Display an error message or take appropriate action
//             alert('Please select a PDF file.');
            
//              // Clear the file input and disable it
//             event.target.value = '';
//            return;
//         }
//     }
//  }




additionalFileUploads: { label: string }[] = [];

addFileUpload() {
  const newLabel = prompt('Enter Document Name for the New File Upload:'); // Prompts the user to enter the label

  if (newLabel) { // Check if the user entered a label
    // Add the new file upload section with the specified label
    const newRow = {
      label: newLabel.trim(), // Trim to remove leading/trailing spaces
    };
    this.additionalFileUploads.push(newRow);
  }
}


}