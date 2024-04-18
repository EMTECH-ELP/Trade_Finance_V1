import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LookUpService {
  applicationForm: any;
  searchForm: any;
  accountNumber: any;
  dialogRef: any;

  constructor(private httpClient: HttpClient) { }
    // Make an HTTP request to fetch application form details based on the account number

  public getFormDetailsByAccountNumber(accountNumber: string): Observable<any> {
    const url = `${environment.getApiUrl}/api/account/account-details?accountNumber=${accountNumber}`;
    console.log('hdfgvbhjmhmj', url)
    const response = this.httpClient.get<any>(url);
    console.log('Response Body', response)

    return response;
  }

  public patchSearchForm(data: any): void {
       this.searchForm.patchValue({
      accountNumber: data.accountNumber,
      cifId: data.cifId,
      currency: data.currency,
      email: data.email,
      phoneNumber: data.phoneNumber,
      address: data.address,
      city: data.city,
      postalCode: data.postalCode,
      countryCode: data.countryCode,
      country: data.country
    });
  }

  public emitApplicationForm(data: any): void {
    // Emit an event with application form details
    this.applicationForm.emit(data);
  }

  public closeDialog(): void {
    // Close the dialog
    this.dialogRef.close();
  }
}
