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
  private apiUrl = 'http://localhost:3000/users';
  private banksSubject: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  public banks$: Observable<any[]> = this.banksSubject.asObservable();
  updatebankUrl: any;
  idCounter: any;

  private banks: Bank[] = [];
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };
  // bankUrl: any;
  constructor(private http: HttpClient) { }

  //Banks
  public getBanks(): Observable<any> {
    const url = `${environment.bankUrl}/api/banks`;     //Fetching banks
    return this.http.get<any>(url)
    // return this.http.get<any>(`${this.bankUrl}api/banks`, this.httpOptions);
  }
  public postbank(data: any): Observable<any> {        //Adding Banks
    const url = `${environment.bankUrl}/api/banks`;
    return this.http.post<any>(url, data); 
  }
 
  public updateBank(bank: any): Observable<Bank> {
    const url = `${environment.bankUrl}/api/banks/update/${bank.id}`;
    return this.http.put<any>(url, bank);
    // return this.http.put<Bank>(`${this.bankUrl}/${bank.id}`, bank);
  }
  // deleteBank(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
  onDeleteBank(Id: Number): Observable<any> {
    const url = `${environment.bankUrl}/api/banks/delete/${Id}`
    return this.http.delete(url);
  }
  // onDeleteBank(Id: Number): Observable<any> {
  //   const url = `${environment.bankUrl}/api/banks/delete${Id}`
  //   return this.http.delete(url);
  // }
  
  deleteBank(index: number): void {
    this.banks.splice(index, 1);
  }


  //Currency & Ports
  public getCurrency(): Observable<any> {
    const url = `${environment.currencyUrl}/api/currencies`;
    return this.http.get<any>(url)

  }

  //Workflow

  getUsers(): Observable<any[]> {
    // Replace with actual HTTP request in a real-world application
    return this.http.get<any[]>(this.apiUrl);
  }
}








