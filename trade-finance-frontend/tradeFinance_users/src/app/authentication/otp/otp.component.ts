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
  otpBody: FormGroup
  otpValue: any
  currentEmail: string=""
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
    this.initOtpBody()
    this.otpForm = this.fb.group({
      first: ["", [Validators.required]],
      second: ["", [Validators.required]],
      third: ["", [Validators.required]],
      fourth: ["", [Validators.required]],
    });
  }

  initOtpBody() {
    this.otpBody = this.fb.group({
      otp: [this.otpValue, [Validators.required]],
      email: [this.currentEmail, [Validators.required]]
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
    console.log("The masked email is", maskedEmail); // Output: mailto:s********n@gmail.com
  }

  loading: boolean = false;
  error: any;
  onSubmit() {
    this.loading = true;
    this.error = "";
    console.log("at this stage 1")

    if (this.otpForm.invalid) {
      this.error = "Invalid OTP!";
      return;
    } else {
      console.log("at this stage")
      this.otpValue = Number(
        this.otpForm.controls.first.value +
        this.otpForm.controls.second.value +
        this.otpForm.controls.third.value +
        this.otpForm.controls.fourth.value
      );

      this.initOtpBody()

      console.log("value", this.otpValue);

      const params = new HttpParams()
        // .set("format", type)
        .set("username", this.currentUser)
        .set("otpCode", this.otpValue);

      console.log("params: ", params);

      //this.tokenCookieService.saveUser(userJSON);

      //this.router.navigate(["/admin/dashboard"]);


      // this.tokenCookieService.clearSharedTokenOrCookie();

      this.authService.validateOTP(this.otpBody.value).subscribe({
        next: (res: any) => {
            console.log("res: ", res);

            if (res.body.statusCode === 200) {
              this.tokenCookieService.saveUser(res.body.entity);
              console.log("res.entity: ", res.body.entity);
              this.tokenCookieService.setSharedRefreshTokenToCookie(res.body.entity.accessToken);
              console.log("set refreshToken: ", res.body.entity.accessToken)

              this.snackbar.showNotification(
                "snackbar-success",
                res.body.message
              );

          this.router.navigateByUrl("/checker/dashboard/analytics");
          } else {
            this.snackbar.showNotification("snackbar-danger", res.body.message);
          }

          this.loading = false;
          },
        error: (error) => {
          console.log("Error:  ", error)
          this.snackbar.showNotification(
              "snackbar-danger",
              error.message
            );
            this.loading = false;
        }
      })
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
