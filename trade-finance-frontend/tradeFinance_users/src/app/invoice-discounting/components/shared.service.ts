import { Injectable } from '@angular/core';

import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private nationalIdSource = new BehaviorSubject<number>(null);
  currentNationalId = this.nationalIdSource.asObservable();

  changeNationalId(nationalId: number) {
    this.nationalIdSource.next(nationalId);
  }
  constructor() { }
}
