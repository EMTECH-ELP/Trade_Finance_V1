
import { Injectable } from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { TokenCookieService } from "../service/token-storage-cookies.service";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private tokenCookieService: TokenCookieService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let currentUser = this.tokenCookieService.getUser();
    if (currentUser && currentUser.accessToken) {
      const accessToken = currentUser.token
      const headers = new HttpHeaders({
        Authorization: `${'Bearer ' + accessToken}`,
        UserName: `${currentUser.username}`,
        DepartmentCode: `${currentUser.departmentCode}`,
        BranchCode: `${currentUser.branchCode}`,
        CostCenterCode: `${currentUser.costCenterCode}`,
        MemberCode: `${currentUser.memberCode}`,
      });

      const cloneReq = request.clone({ headers, withCredentials: false });

      // console.log("cloneReq: ", cloneReq)

      return next.handle(cloneReq);
    } else {
        // clone the request and add the Authorization header
        const cloneReq = request.clone({
          withCredentials: false 
        });
  
        // send the modified request
        return next.handle(cloneReq);
    }


    return next.handle(request.clone());

  }
}

