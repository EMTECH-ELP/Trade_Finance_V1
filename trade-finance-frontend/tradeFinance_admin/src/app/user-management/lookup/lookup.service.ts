import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';




@Injectable({
  providedIn: 'root'
})
export class LookupService {
 
  applicationForm: any;
  searchForm: any;
  accountNumber: any;
  dialogRef: any;
  checkerForm: any;
  makerForm: any;

  constructor(private httpClient: HttpClient) { }
    // Make an HTTP request to fetch application form details based on the account number

  public getFormDetailsByBranchCode(branchCode: string): Observable<any> {
    const url = `${environment.getBranchApiUrl}/api/branch/code?branchCode=${branchCode}`;
    console.log('hdfgvbhjmhmj', url)
    const response = this.httpClient.get<any>(url);
    console.log('Response Body', response)

    return response;
  }

  public patchSearchForm(data: any): void {
       this.searchForm.patchValue({
      branchCode: data.branchCode,
      branchName: data.branchName,
     
    });
  }

  public emitcheckerForm(data: any): void {
    // Emit an event with application form details
    this.checkerForm.emit(data);
  }

  public emitmakerForm(data: any): void {
    // Emit an event with application form details
    this.makerForm.emit(data);
  }



  public closeDialog(): void {
    // Close the dialog
    this.dialogRef.close();
  }
}