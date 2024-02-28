import { AuthService } from "../service/auth.service";
import { Injectable } from "@angular/core";
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { TokenCookieService } from "../service/token-storage-cookies.service";
import { Router } from "@angular/router";



@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(
    private router: Router, private tokenCookieService: TokenCookieService) { }

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((err) => {
        if (err.status === 401) {
          // auto logout if 401 response returned from api
          //this.router.navigate(["/authentication/signin"]);
          //location.reload();
        }

        const error = err;
        return throwError(error);
      })
    );
  }
}

//.error.message || err.statusText
