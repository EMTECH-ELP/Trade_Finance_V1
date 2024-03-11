import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MonthsService {

  constructor() { }
  months() {
  return  [
      {
        value: 1,
        name: 'JANUARY'
      },
      {
        value: 2,
        name: 'FEBRUARY'
      },
      {
        value: 3,
        name: 'MARCH'
      },
      {
        value: 4,
        name: 'APRIL'
      },
      {
        value: 5,
        name: 'MAY'
      },
      {
        value: 6,
        name: 'JUNE'
      },
      {
        value: 7,
        name: 'JULY'
      },
      {
        value: 8,
        name: 'AUGUST'
      },
      {
        value: 9,
        name: 'SEPTEMBER'
      },
      {
        value: 10,
        name: 'OCTOBER'
      }, {
        value: 11,
        name: 'NOVEMBER'
      },
      {
        value: 12,
        name: 'DECEMBER'
      },
    ]
  }
}
