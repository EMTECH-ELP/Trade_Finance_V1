import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
  HttpParams,
} from "@angular/common/http";
import {
  BehaviorSubject,
  catchError,
  map,
  Observable,
  of,
  throwError,
} from "rxjs";

import { Auth } from "../models/auth";
import { environment } from "src/environments/environment.prod";
import { Router } from "@angular/router";
import { MockSessionService } from "src/app/authentication/signin/mock-session.service";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
  withCredentials: true,
};

@Injectable({
  providedIn: "root",
})
// /auth/signin
export class AuthService {
  constructor(private http: HttpClient, private router: Router, private mockDataService: MockSessionService) {}

  headers = new HttpHeaders().set("Content-Type", "application/json");

  login(): Observable<any> {
    return this.mockDataService.getSessionData().pipe(
      map((sessionData: any) => {
        // Use the session data in your authentication logic
        const mockedResponse = {
          body: {
            statusCode: 200,
            entity: sessionData.entity, // Assuming 'entity' is the key in your session data
            message: sessionData.message || 'Mocked authentication successful'
          }
        };

        return mockedResponse;
      }),
      catchError((error: any) => {
        // Handle error loading session data (e.g., file not found)
        console.error('Error loading session data:', error);
        return of({
          body: {
            statusCode: 500, // Adjust the status code as needed
            message: 'Error loading session data'
          }
        });
      })
    );
  }
  

// Uncomment the code below when consuming endpoints. Then comment out the above,from login to catch error
  
  // login(data: any): Observable<any> {
  //   let CREATE_URL = `${environment.baseUrlAdmin}/api/v1/auth/signin`;
  //   return this.http
  //     .post(CREATE_URL, data, {
  //       observe: "response",
  //       headers: this.headers,
  //       withCredentials: true,
  //     })
  //     .pipe(
  //       map((res) => {

  //         return res || {};
  //       })
  //     );
  // }

  verifyOTP(params: any): Observable<any> {
    const OTP_URL = `${environment.baseUrlAdmin}/api/v1/auth/otp/verify`;

    return this.http.get<any>(OTP_URL, {
      params,
    });
  }

  resetPassword(resetPasswordDetails): Observable<{ message: string }> {
    const resetPasswordUrl = `${environment.baseUrlAdmin}/api/v1/auth/reset-password`;

    return this.http.post<{ message: string }>(
      resetPasswordUrl,
      resetPasswordDetails
    );
  }

  forgotPassword(email): Observable<any> {
    const resetPasswordUrl = `${environment.baseUrlAdmin}/soa/users/forgot-password`;

    return this.http.post<any>(resetPasswordUrl, email);
  }


  refreshAccessToken(refreshToken: string): Observable<any> {
    // Endpoint URL for refreshing the access token
    const REFRESH_URL = `${environment.baseUrlAdmin}/api/v1/auth/refreshtoken`;

    console.log("Checking for: ", refreshToken)

    let refreshTokenReq ={refreshToken: refreshToken} 

    return this.http.post<any>(REFRESH_URL, refreshTokenReq);
  }

  logout(refreshToken: string): Observable<any> {
    const LOGOUT_URL = `${environment.baseUrlAdmin}/api/v1/auth/logout`;

    // Define request parameters including the refresh token
    const requestParams = new HttpParams().set('refreshToken', refreshToken);

    // Make the PUT request to log out using the refresh token
    return this.http.put<any>(LOGOUT_URL, {}, {params: requestParams });
  }






  // Error handling
  errorMgmt(error: HttpErrorResponse) {
    let errorMessage = "";
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `${error.error.message}`;
    }
    return throwError(errorMessage);
  }
}
