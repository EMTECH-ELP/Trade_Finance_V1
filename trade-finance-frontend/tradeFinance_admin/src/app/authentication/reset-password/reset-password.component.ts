import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthService } from "src/app/core/service/auth.service";
import { UnsubscribeOnDestroyAdapter } from "src/app/shared/UnsubscribeOnDestroyAdapter";
import { TokenCookieService } from "src/app/core/service/token-storage-cookies.service";
import { MatDialog } from "@angular/material/dialog";
import { Subject, takeUntil, Subscription } from "rxjs";
import { SnackbarService } from "src/app/shared/services/snackbar.service";
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})


export class ResetPasswordComponent implements OnInit {
     
  authForm: FormGroup;
  submitted = false;
  returnUrl: string;
  hide = true;
  chide = true;
  error: any;
  loading: boolean;
  resetPasswordDetails: any;

  
  // roles: string[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authservice: AuthService,
    private snackbar: SnackbarService,
    // private tokenCookieservice: TokenCookieService,
  ) { 
  
  }

  ngOnInit() {

   this.authForm = this.formBuilder.group({
      email: [ "",[Validators.required, Validators.email, Validators.minLength(5)],],
      currentPassword: ["", Validators.required],
      newPassword: ["", Validators.required],
      confirmPassword: ["", Validators.required],
    
    });
    this.returnUrl = this.route.snapshot.queryParams["returnUrl"] || "/";
  }
  togglePasswordVisibility(): void {
    this.hide = !this.hide;
    
  }
    // get return url from route parameters or default to '/'
    // this.returnUrl = this.route.snapshot.queryParams["returnUrl"] || "/";
  
  get f() {
    return this.authForm.controls;
  }
  onResetPassword() {
    this.submitted = true;
    if (
  this.authForm.value.newPassword !==
  this.authForm.value.confirmPassword
) { this.snackbar.showNotification("snackbar-danger", "Passwords don't match, please check and retry!");
}  else {
    console.log({
      // token: this.authForm.value.token,
      currentPassword: this.authForm.value.currentPassword,
      email: this.authForm.value.email,
      newPassword: this.authForm.value.newPassword,
      confirmPassword: this.authForm.value.confirmPassword
     
    });
  }

    const resetPasswordDetails = {
      currentPassword: this.authForm.value.currentPassword,
      newPassword: this.authForm.value.newPassword,
      email: this.authForm.value.email,
      confirmPassword: this.authForm.value.confirmPassword
      
    }; 
    this.authservice.resetPassword(resetPasswordDetails).subscribe(
        (res:any) =>{
          console.log(res)
          if (res.statusCode === 200 ) {
        this.snackbar.showNotification(
          "snackbar-success",
        "Password reset Sucessful")
      this.router.navigate(["/authentication/signin"]);
          }
          },
          (err: HttpErrorResponse)=>{
            console.log(err)
            this.snackbar.showNotification(
              "snackbar-danger",
              "failed to reset!"
            );
          }
        )
      }
}
  