import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Country } from './country.model';


@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiUrl = 'your-country-api-url'; // Replace this with your actual API URL

  constructor(private http: HttpClient) { }

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.apiUrl)
      .pipe(
        catchError(this.handleError<Country[]>('getCountries', []))
      );
  }

  addCountry(country: Country): Observable<Country> {
    return this.http.post<Country>(this.apiUrl, country)
      .pipe(
        catchError(this.handleError<Country>('addCountry'))
      );
  }

  // Implement updateCountry and deleteCountry methods if needed

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      // You can log the error and handle it accordingly
      return of(result as T);
    };
  }
}
