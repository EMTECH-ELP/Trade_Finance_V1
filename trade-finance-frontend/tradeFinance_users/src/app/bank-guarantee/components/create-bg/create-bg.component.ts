import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BankGuaranteeService } from '../../services/bank-guarantee.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';

@Component({
  selector: 'app-create-bg',
  templateUrl: './create-bg.component.html',
  styleUrls: ['./create-bg.component.sass']
})
export class CreateBgComponent implements OnInit {

  selectedValue: string;
  applicationForm: FormGroup;

  constructor(private fb: FormBuilder,
    private bgService: BankGuaranteeService,
    private dialog: MatDialog
  ) { }


  ngOnInit() {

    this.applicationForm = this.fb.group({
      //Step1: Applicants details
      accountNumber: ['', Validators.required],
      cifId: ['', Validators.required],
      nationalId: ['', Validators.required],
      accountName: ['', Validators.required],
      currency: ['', [Validators.required, Validators.email]],
      email: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      postalCode: ['', Validators.required],
      city: ['', Validators.required],
      countryCode: ['', Validators.required],
      country: ['', Validators.required],

      //  step 2: beneficiary details
      beneficiaryFirstName: ['', Validators.required],
      beneficiaryMiddleName: [''],
      beneficiaryLastName: ['', Validators.required],
      beneficiaryAddress: ['', Validators.required],
      beneficiaryEmail: ['', [Validators.required, Validators.email]],
      beneficiaryPhoneNumber: ['', Validators.required],
      beneficiaryAccountName: ['', Validators.required],
      beneficiaryAccountNumber: ['', Validators.required],
      beneficiaryBank: ['', Validators.required],
      beneficiarySwiftCode: ['', Validators.required],
      beneficiaryCity: ['', Validators.required],

      // step 3: Guarantee Details
      type: ['', Validators.required],
      guaranteeType: ['', Validators.required],
      purpose: ['', Validators.required],
      additionalInformation: [''],
      bankId: ['', Validators.required],
      guaranteeAmount: ['', Validators.required],
      guaranteeCurrency: ['', Validators.required],
      currencyRate: ['', Validators.required],
      expiryDate: ['', Validators.required],
      validityPeriod: ['', Validators.required],
      maxClaimPeriod: ['', Validators.required],
      applicableRules: ['', Validators.required],
      counterGuaranteeStatus: ['', Validators.required],
      guaranteeStatus: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      provisionAmount: ['', Validators.required],
      //Step 4: Counter Guarantee Details
      guaranteeNo: [''],
      counterGuaranteeAmount: [''],
      counterGuaranteeExpiryDate: [''],
      claimExpiryDate: [''],
      swiftCode: [''],
      branchCode: [''],
      remarks: [''],
      counteGuaranteeStatus: [''],
      //Step 5: Margin Details
      marginType: ['', Validators.required],
      marginAccount: ['', Validators.required],
      collectedMarginRate: ['', Validators.required],
      marginAmount: ['', Validators.required],
      collectedMarginAmount: ['', Validators.required],
      releasedMarginAmount: ['', Validators.required],
      //Step 6: Security Details
      securityType: ['', Validators.required],
      securityAmount: ['', Validators.required],
      securityCurrency: ['', Validators.required ],
      chargeAccount: ['', Validators.required ],
      description: ['', Validators.required],
      issuer: ['', Validators.required],
      maturityDate: ['', Validators.required],
      securityRating: ['', Validators.required],
      // step 7:Goods and shipment details
      goodsDescription: ['', Validators.required],
      quantityValue: ['', Validators.required],
      amountID: ['', Validators.required],
      countryName: ['', Validators.required],
      portLoading: ['', Validators.required],
      portDischarge: ['', Validators.required],
      shipmentDate: ['', Validators.required],
      billOfLading: ['', Validators.required],
      invoiceNo: ['', Validators.required],
 
      // step 8:Document upload details
      letterOfResolution: [''],
      documentDescription1: ['',]



      
    });

  }

  public onSubmit() {

  }
  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);
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