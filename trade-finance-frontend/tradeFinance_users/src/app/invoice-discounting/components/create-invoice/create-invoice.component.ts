import { Component, OnInit, ViewChild, ElementRef, Renderer2} from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { LookupComponent } from 'src/app/lookups/lookup/lookup.component';
import{ Router } from '@angular/router';
import {  map, startWith } from 'rxjs';
import { Subscription } from 'rxjs';
import { Subject, takeUntil } from "rxjs";

interface CityResponse {
  cities: string[]; // Adjust the type according to the actual structure of your data
}
@Component({
  selector: 'create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.sass']
})
export class CreateInvoiceComponent implements OnInit{
  @ViewChild('countrySelect') countrySelect!: ElementRef;
  // @ViewChild('citySelect') citySelect!: ElementRef;
  nationalId: number;
  [x: string]: any;
  today = new Date().toISOString().split('T')[0]; // Formats today's date as YYYY-MM-DD
  ShowLookupComponent: boolean = false;
  selectedValue: string;

  applicationForm: FormGroup;
  additionalInvoices: FormArray;
applicantsForm:FormGroup;

private countrySubscription: Subscription;

  formData: any = {}; // Initialize your form data
  isLinear: true;
  query: string = '';
  searchData: any;
  cities: string[]; 
  selected = 'pending';
  selectedFiles: any;

  applicantDetails :any;
  invoiceDetails: any;
  fundingDetails: any
  
  countries: string[] = [];
  selectedCountry: string;
  countryName: Array<{ value: string }> = [];
  
  // cities: string[] = [];
  selectedCity: string = '';
  countryCity: Array<{ value: string }> = [];
  filteredCountries: string[];
  filteredCities: string[];
  destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(private builder: FormBuilder,
    private invDiscountingService: InvDiscountingService,
    private dialog: MatDialog,
    private router: Router,
    private renderer: Renderer2,
    private snackBar: MatSnackBar,
 
  ) { 
    this.applicationForm = this.builder.group({
      countryFilter: [''],
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

      invoiceDate: ['', Validators.required],
      invoiceNumber: ['', Validators.required],
      invoiceAmount: ['', Validators.required],
      applicantBusinessName: ['', Validators.required],
      applicantBusinessAddress: ['', Validators.required],
      dueDate: ['', Validators.required],
      // invoices: ['', Validators.required],    //file upload
      // applicationForm: ['', Validators.required],       //file upload
      buyerName: ['', Validators.required],
      buyerBusinessName: ['', Validators.required],
      buyerCity: ['', Validators.required],
      buyerCountry: ['', Validators.required],
      countryName: ['', Validators.required],
      buyerAddress: ['', Validators.required],
      buyerEmailAddress: ['', [Validators.required, Validators.email]],
      // additionalInvoices: this.builder.array([]), 
    
      //  Funding details
      // fundingAmount: ['', Validators.required],
      // disbursalDate: ['', Validators.required],
      // repaymentDate: ['', Validators.required],
      // creditAccount: ['', Validators.required],
      // creditLimit: ['', Validators.required],
      //creditAppraisalForm: ['', Validators.required],   //file upload
 
      additionalInvoices: new FormArray ([
        new FormGroup({
           invoiceNo: new FormControl(''),
           invoiceAmount: new FormControl(''),
           applicantCompanyName: new FormControl(''),
           businessAddress: new FormControl(''),
           invoiceDate: new FormControl(''),
           due: new FormControl(''),
           files: new FormControl(''),
        })
    ]),
    importerDetails: new FormArray ([
      new FormGroup({
         fullName: new FormControl(''),
         email: new FormControl(''),
         buyerBusinessName: new FormControl(''),
         importerCountry: new FormControl(''),
         importerCity: new FormControl(''),
      })
  ]),
})
}


  ngOnInit(): void {
    this.invDiscountingService.getCountries().pipe(
      takeUntil(this.destroy$)
      ).subscribe(
      (response: any) => {
        if (response.message === 'success' && Array.isArray(response.data)) {
          this.countries = response.data.map((country: any) => country.countryName);
          this.filteredCountries = this.countries;
        }
        console.log('Response from getCountries:', response);
      },
      (error: any) => console.log('Error fetching countries', error)
    );
    
    this.applicationForm.get('countryFilter')!.valueChanges
     .pipe(
        startWith(''),
        map(value => this.filterCountries(value))
      )
     .subscribe(filtered => {
        this.filteredCountries = filtered;
      });
    
}
ngOnDestroy(): void {
  this.destroy$.next(true);
  this.destroy$.complete();
}

getCitiesByCountry(countryName: string): void {
  this.invDiscountingService.getCitiesByCountry(countryName).subscribe(
    (cities: string[]) => {
      this.cities = cities;
    },
    (error: any) => {
      console.error('Failed to load cities:', error);
      // Optionally, you can assign an empty array to cities or handle the error in another way
      this.cities = [];
    }
  );
}


  
onCountrySelect(countryName: string): void {
  this.selectedCountry = countryName;
  this.invDiscountingService.getCitiesByCountry(countryName).subscribe(
    (response: any) => {
      console.log('Received response:', response); // Diagnostic log
      if (!response.data || typeof response.data!== 'object') {
        console.error('Expected response.data to be an object but got:', response.data);
        return; // Exit early if response.data is not an object
      }
      const cityName = response.data.countryCity; // Directly access the city name
      this.cities = [cityName]; // Wrap the city name in an array since the input expects an array
      // Assuming you want to set the city as the default value
      this.applicationForm.controls['buyerCity'].setValue(this.cities[0], {emitEvent: false});
    },
    (error: any) => console.error('Error fetching cities:', error)
  );
}


filterCountries(value: string): string[] {
  if (!value || !this.countries) return [];
  const filterValue = value.toLowerCase();
  return this.countries.filter(country => country.toLowerCase().includes(filterValue));
}


  ngAfterViewInit(): void {
    // Populate the country options after the view initializes
    this.populateCountryOptions();
    // this.populateCityOptions();
  }


  populateCountryOptions(): void {
    if (this.countrySelect) {
      const countrySelectElement = this.countrySelect.nativeElement;
      this.countries.forEach((country) => {
        const option = this.renderer.createElement('mat-option');
        this.renderer.setProperty(option, 'value', country);
        const text = this.renderer.createText(country);
        this.renderer.appendChild(option, text);
        this.renderer.appendChild(countrySelectElement, option);
      });
    }
  }


  addRowbtn1(){
    const formgroup = new FormGroup({
      invoiceNo: new FormControl(''),
      invoiceAmount: new FormControl(''),
      applicantCompanyName: new FormControl(''),
      businessAddress: new FormControl(''),
      invoiceDate: new FormControl(''),
      due: new FormControl(''),
      files: new FormControl(''),
    });
    (<FormArray>this.applicationForm.get('additionalInvoices')).push(formgroup);
  }
  addRowbtn2(){
    const formgroup = new FormGroup({
      fullName: new FormControl(''),
           email: new FormControl(''),
           buyerBusinessName: new FormControl(''),
           importerCountry: new FormControl(''),
           importerCity: new FormControl(''),
    });
    (<FormArray>this.applicationForm.get('importerDetails')).push(formgroup);
  }
  
  files: FileList | null = null;

  onFileSelected(event: Event) {
    this.files = (event.target as HTMLInputElement).files;
  }
  

  openLookup(): void {
    // Create a MatDialogConfig object
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { accountNumber: this.applicationForm.get('accountNumber').value };

    // Open the LookupComponent dialog with the dialog config
    const dialogRef = this.dialog.open(LookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("passed email", res.data[0].email)

        this.patchApplicationForm(res.data[0])
      }
    })
  }

//Full form submission

  onSubmit() {
    const data = this.applicationForm.value
    const items = {
      "accountNumber":  data.accountNumber,
      "cifId": data.cifId,
      "nationalId": data.nationalId,
      "accountName": data.accountName,
      "currency": data.currency,
      "email": data.email,
      "phoneNumber": data.phoneNumber,
      "address": data.address,
      "city": data.city,
      "postalCode": data.postalCode,
      "countryCode": data.countryCode,
      "country": data.country,
   
      "invoices": [
        {
          "invoiceDate": data.invoiceDate,
          "invoiceNumber": data.invoiceNumber,
          "invoiceAmount": data.invoiceAmount,
          "applicantBusinessName": data.applicantBusinessName,
          "applicantBusinessAddress": data.applicantBusinessAddress,
          "dueDate": data.dueDate,
          // "invoices": data.invoices,
          // "applicationForm": data.applicationForm,
          "buyerName": data.buyerName,
          "buyerBusinessName": data.buyerBusinessName,
          "buyerCity": data.buyerCity,
          "buyerCountry": data.buyerCountry,
          "countryName": data.countryName,
          "buyerAddress": data.buyerAddress,
          "buyerEmailAddress": data.buyerEmailAddress,
          // "termsAndCondition": data.terms_and_condition,
          "status": data.status,
        }
      ]
    }
  
  
  // Prepare FormData
  const formData = new FormData();
  Object.keys(data).forEach(key => {
    if (key === 'invoices') {
      data[key].forEach((item, index) => {
        Object.keys(item).forEach(subKey => {
          formData.append(`${subKey}[${index}]`, item[subKey]);
        });
      });
    } else {
      formData.append(key, data[key]);
    }
  });

  // Append files
  if (this.files) {
    Array.from(this.files).forEach((file, index) => {
      formData.append(`documents[${index}]`, file, file.name);
    });
  }
    // const invoiceData = { /* your invoice data here */ };
    console.log("Form data", this.applicationForm.value);
    this.invDiscountingService.sendData(items).subscribe({
      next: ((response) => {

        console.log("Invoice Form response", response);
      }),
      error: ((err) => {
        console.error(err)
      }),
      complete: (() => { })
    })
    this.applicationForm.reset()
    this.ngOnInit()
    let result = window.confirm('Click OK to submit. Click Cancel to abort');
    if (result) {
      alert('Form Submitted Successfully!');
      this.router.navigate(["/invoice-discounting/viewInvoice"]);
    } else {
      alert('Application Cancelled');
      this.router.navigate(["/invoice-discounting/createInvoice"]);
    }
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

}



