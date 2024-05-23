import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";

import { environment } from "src/environments/environment";

export interface Bank {
  id: number;
  bankName: string;
  branchName: string;
  branchCode: string;
  swiftCode: string;
  country: string;
}

@Injectable({
  providedIn: 'root'
})
export class MasterdataService {
  private banksSubject: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  public banks$: Observable<any[]> = this.banksSubject.asObservable();
  updatebankUrl: any;
  idCounter: any;
 
  private banks: Bank[] = [];
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };
  // bankUrl: any;
  constructor(private http: HttpClient) {}

  // public register(user: any): Observable<any> {
  //   return this.http.post<any>(`${this.baseUrl}/api/v1/auth/signup`, user, this.httpOptions);
  // }
  // public addBank(user: any): Observable<any> {
  //   return this.http.post<any>(`${this.addBankUrl}/api/v1/auth/signup`, user, this.httpOptions);
  // }
  // public getAllForms(): Observable<any> {
  //   const url = `${environment.invUrl}/invoices/list`;     //FETCH FORMS
  //   return this.http.get<any>(url)
  // }
  public getBanks(): Observable<any> {
    const url = `${environment.bankUrl}/api/banks`;  
    return this.http.get<any>(url)
    // return this.http.get<any>(`${this.bankUrl}api/banks`, this.httpOptions);
  }
  public postbank(data: any): Observable<any> {      //Creating Invoice discounting form
    const url = `${environment.bankUrl}/api/banks`;
    return this.http.post<any>(url, data);   //Replace with correct endpoint
  }
 
  // getBanks(): Bank[] {
  //   return this.banks;
  // }

  // addBank(bank: any): void {
  //     const banks = this.getBanks();
  //     bank.id = this.idCounter++;
  //     banks.push(bank);
  //     this.banksSubject.next(banks);
  //   }
   
    deleteBank(index: number): void {
      this.banks.splice(index, 1);
    }
  }

  // updateBank(index: number, bank: Bank): void {
  //   this.banks[index] = bank;
  // }

 




 