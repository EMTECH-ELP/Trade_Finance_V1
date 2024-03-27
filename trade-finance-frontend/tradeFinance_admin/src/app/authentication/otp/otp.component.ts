import { HttpParams } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from "@angular/material/snack-bar";
import { Router } from "@angular/router";
import { Subject, takeUntil, Subscription } from "rxjs";

import { AuthService } from "src/app/core/service/auth.service";
import { TokenCookieService } from "src/app/core/service/token-storage-cookies.service";
import { SnackbarService } from "src/app/shared/services/snackbar.service";

@Component({
  selector: "app-otp",
  templateUrl: "./otp.component.html",
  styleUrls: ["./otp.component.scss"],
})
export class OtpComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = "end";
  verticalPosition: MatSnackBarVerticalPosition = "top";

  otpForm: FormGroup;
  currentEmail: any;
  maskedEmail: any;
  currentUser: any;

  destroy$: Subject<boolean> = new Subject<boolean>();

  constructor(
    private fb: FormBuilder,
    private tokenCookieService: TokenCookieService,
    private router: Router,
    private authService: AuthService,

    private snackbar: SnackbarService
  ) { }

  ngOnInit(): void {
    this.getEmail();

    this.otpForm = this.fb.group({
      first: ["", Validators.required],
      second: ["", Validators.required],
      third: ["", Validators.required],
      fourth: ["", Validators.required],
    });
  }

  getEmail() {

    this.currentEmail = this.tokenCookieService.getUser().email;
    this.currentUser = this.tokenCookieService.getUser().username;

    console.log("this.currentEmail: ", this.currentEmail);
    const email = this.currentEmail;
    const atIndex = email.indexOf("@");
    const username = email.slice(0, atIndex);
    const domain = email.slice(atIndex);

    const maskedUsername =
      username.charAt(0) +
      "*".repeat(username.length - 2) +
      username.charAt(username.length - 1);
    const maskedEmail = maskedUsername + domain;
    this.maskedEmail = maskedEmail;
    console.log("The masked email is", maskedEmail); // Output: s********n@gmail.com
  }

  loading: boolean = false;
  error: any;
  onSubmit() {
    this.loading = true;
    this.error = "";
    if (this.otpForm.invalid) {
      this.error = "Invalid OTP!";
      return;
    } else {
      const otpValue = Number(
        this.otpForm.controls.first.value +
        this.otpForm.controls.second.value +
        this.otpForm.controls.third.value +
        this.otpForm.controls.fourth.value
      );

      console.log(otpValue);

      const params = new HttpParams()
        // .set("format", type)
        .set("username", this.currentUser)
        .set("otpCode", otpValue);

      console.log("params: ", params);

      //this.tokenCookieService.saveUser(userJSON);

      //this.router.navigate(["/admin/dashboard"]);


      this.tokenCookieService.clearSharedTokenOrCookie();


      // this.authService
      //   .verifyOTP(params)
      //   .pipe(takeUntil(this.destroy$))
      //   .subscribe({
      //     next: (res) => {
      //       console.log("res: ", res);

      //       if (res.statusCode == 200) {
      //         this.tokenCookieService.saveUser(res.entity);
      //         console.log("res.entity: ", res.entity)
      //         this.tokenCookieService.setSharedRefreshTokenToCookie(res.entity.refreshToken);
      //         console.log("set refreshToken: ", res.entity.refreshToken)

      //         this.snackbar.showNotification(
      //           "snackbar-success",
      //           "Login Successful"
      //         );

              this.router.navigateByUrl("/admin/dashboard/view");
            // } else {
            //   this.snackbar.showNotification("snackbar-danger", res.message);
            // }

        //     this.loading = false;
        //   },
        //   error: (err) => {
        //     this.snackbar.showNotification(
        //       "snackbar-danger",
        //       "Server Error: !!"
        //     );
        //     this.loading = false;
        //   },
        //   complete: () => { },
        // }),
        // Subscription;
    }
  }

  ngAfterViewInit() {

    const inputs = document.querySelectorAll<HTMLInputElement>('input[type="text"]');
    inputs.forEach((input, index) => {
      input.addEventListener("input", (event) => {
        const target = event.target as HTMLInputElement;
        const maxLength = target.maxLength;
        const inputLength = target.value.length;

        if (inputLength === maxLength) {
          const nextIndex = index + 1;
          if (inputs[nextIndex]) {
            (inputs[nextIndex] as HTMLInputElement).focus();
          }
        }
      });
      input.addEventListener("click", (event) => {
        const target = event.target as HTMLInputElement;
        target.value = ""; 
      });

      input.addEventListener("focus", (event) => {
        const target = event.target as HTMLInputElement;
        target.value = ""; // Clear the input field when it gains focus
      });
    });
  }
}
