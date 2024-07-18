import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private nationalIdSource = new BehaviorSubject<number>(null);
  currentNationalId = this.nationalIdSource.asObservable();
  
  private invoiceCountSource = new BehaviorSubject<number>(0);
  invoiceCount$ = this.invoiceCountSource.asObservable();

  setInvoiceCount(count: number) {
    this.invoiceCountSource.next(count);
  }
  
  changeNationalId(nationalId: number) {
    this.nationalIdSource.next(nationalId);
  }

  constructor() { }
}
