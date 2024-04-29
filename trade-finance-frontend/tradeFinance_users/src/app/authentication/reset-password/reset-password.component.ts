import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { FormBuilder, FormGroup, Validators, ValidationErrors,FormControl, AbstractControl  } from "@angular/forms";
import { AuthService } from 'src/app/core/service/auth.service';
import { Subject, takeUntil, Subscription, throwError, catchError } from "rxjs";
import { SnackbarService } from "src/app/shared/services/snackbar.service";
import { HttpErrorResponse } from "@angular/common/http";


@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.sass'],

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
      // });
  //     alert('Password changed successfully,Kindly Login with your new password');
  //     this.router.navigate(["/authentication/signin"]);
      
  //       catchError(error => {
  //         console.error('Error occurred:', error);
  //         let errorMessage = "An error occurred while resetting the password. Please try again later.";
  //         if (error && error.message) {
  //           errorMessage = error.message;
  //         }
  //         this.snackbar.showNotification("snackbar-danger", errorMessage);
  //         return throwError(error);
  //       })
  //   }
  // }
  // }

//   this.snackbar.showNotification(
//     "snackbar-danger",
//     "Passwords don't match, please check and retry!"
//   );
    // if (this.authForm.invalid) {
    //   return;
    // }
    // this.authservice.resetPassword(this.authForm.value).subscribe(
    //   (res) => {
    //     console.log("Res: ",res);

    //     if(res.body.statusCode === 207) {
    //       this.tokenCookieService.saveUser(res.body.entity)
    //       console.log("routing to signin")
    //       this.router.navigate(["/authentication/signin"]);
    //      //  Exit the function to prevent further navigation
    //         // alert('Password changed successfully')
    //         // this.router.navigate(["/authentication/signin"])
    //         return;
    //     }





    
        // If OTP is not required, handle role-based navigation
        // if (res.entity && res.entity.role === "SUPER_ADMIN") {
        //   this.router.navigate(["/checker/dashboard/analtics"]);
        // } else if (res.entity && (res.entity.role === "MAKER" || res.entity.role === "USER")) {
        //   if (res.entity.isFirstTimeLogin) {
        //     this.router.navigate(["/authentication/reset-password"]);
        //   } else {
        //     this.router.navigate(["/authentication/OTP"]);
        //   }
          
        // }
    //   },
    //   (err) => {
    //     console.log(err);
    //     this.error = err.message;
    //     this.submitted = false;
    //     this.loading = false;
    //   }
    // );
//   }
  
  
