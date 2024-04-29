import { Component, OnInit , HostListener} from "@angular/core";
import { Router, ActivatedRoute ,  NavigationStart,
  NavigationEnd,
  NavigationError,} from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthService } from "src/app/core/service/auth.service";
import { UnsubscribeOnDestroyAdapter } from "src/app/shared/UnsubscribeOnDestroyAdapter";
import { TokenCookieService } from "src/app/core/service/token-storage-cookies.service";
import { MatDialog } from "@angular/material/dialog";
import { Subject, takeUntil, Subscription } from "rxjs";
import { SnackbarService } from "src/app/shared/services/snackbar.service";



@Component({
  selector: "app-signin",
  templateUrl: "./signin.component.html",
  styleUrls: ["./signin.component.scss"],
})
export class SigninComponent
extends UnsubscribeOnDestroyAdapter
implements OnInit {


authForm: FormGroup;
submitted = false;
loading = false;
error = "";
hide = true;

isLoggedIn = false;
isLoginFailed = false;
errorMessage = "";
roles: string[] = [];

passwordFlag: any;
destroy$: Subject<boolean> = new Subject<boolean>();

constructor(
  private formBuilder: FormBuilder,
  private route: ActivatedRoute,
  private router: Router,
  private authService: AuthService,
  private tokenCookieService: TokenCookieService,
  private dialog: MatDialog,
  private snackbar: SnackbarService
) {
  super();
  this.router.onSameUrlNavigation = "reload";
}

ngOnInit() {
  this.authForm = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
  });
}
  // this.tokenCookieService.deleteUser();

  onSubmit() {
    this.authService.login(this.authForm.value).subscribe(
      (res) => {
        console.log("Res: ", res);
   
        // if (res.body.statusCode === 207 ) {
        //   this.tokenCookieService.saveUser(res.body.entity)
        //   console.log("routing to reset-password")
        //   // this.router.navigate(["/authentication/reset-password"]);
        //  // Exit the function to prevent further navigation
        // }
  
        // If reset-password is not required, handle role-based navigation for second,third etc time users
        if (res.body.entity && res.body.entity.role === "SUPER_ADMIN") {
                  this.tokenCookieService.saveUser(res.body.entity)

          this.router.navigate(["/admin/dashboard/view"]);
        } else if (res.body.entity && (res.body.entity.role === "MAKER" || res.body.entity.role === "USER")) {
          if ( res.body.entity.firstLogin === 'Y') {
            this.tokenCookieService.saveUser(res.body.entity)
            this.snackbar.showNotification(
              "snackbar-success",
            "Login Successful, Kindly reset your password")
            this.router.navigate(["/authentication/reset-password"]);
          } else {
            this.tokenCookieService.saveUser(res.body.entity)
            this.snackbar.showNotification(
              "snackbar-success",
            " Kindly enter the OTP sent to your email")
            this.router.navigate(["/authentication/OTP"]);
            return;
          }
        }
      },
      (err) => {
        console.log(err);
        this.snackbar.showNotification("snackbar-danger", "Email or Password is incorrect!");
        // this.error = err.message;
        this.submitted = false;
        this.loading = false;
      }
    );
  }
  
  
}



// res.entity.firstLogin === 'Y'


// onSubmit() {
//   if (this.authForm.invalid) {
//     return;
//   }

//   this.loading = true;

//   this.authService
//     .login(this.authForm.value)
//     .subscribe({
//       next: (response: any) => {
//         console.log(response);
//         if (response.entity && response.statusCode === 200) {
//           const accessToken = response.entity.accessToken;
//           localStorage.setItem("token", accessToken);
//           this.tokenCookieService.saveUser(response.entity);

//           if (response.entity.role === "SUPER_ADMIN") {
//             this.router.navigate(["/dashboard/dashboard"]);
//           } else if (response.entity.role != "SUPER_ADMIN") {
//             if (response.entity.firstLogin === "Y") {
//               console.log("reached");
//               this.router.navigate([
//                 "/supplier-authentication/reset-password",
//               ]);
//             } else {
//               this.router.navigate(["/supplier-authentication/otp"]);
//             }
//           }
//         } else {
//           console.error("Invalid response from server");
//           this.error = "Invalid email or password";
//           this.loading = false;
//         }
//       },
//       error: (error) => {
//         console.error("Error:", error);
//         this.error = "Invalid email or password";
//         this.loading = false;
//       },
    // })



  // console.log("Res: ", res);
        // console.log(res.statusCode);
        // Check if it's a first login




//     this.authService.login(this.authForm.value).subscribe(
//       (res) => {
//         console.log("Res: ", res);
  
//         if (res.body.statusCode === 207) {
//           this.tokenCookieService.saveUser(res.body.entity)
//           console.log("routing to otp")
//           this.router.navigate(["/authentication/OTP"]);
//           return; // Exit the function to prevent further navigation
//         }
  
//         // If OTP is not required, handle role-based navigation
//         if (res.entity && res.entity.role === "SUPER_ADMIN") {
//           this.router.navigate(["/checker/dashboard/analytics"]);
//         } else if (res.entity && (res.entity.role === "MAKER" || res.entity.role === "USER")) {
//           if (res.entity.isFirstTimeLogin) {
//             this.router.navigate(["/authentication/reset-password"]);
//           } else {
//             this.router.navigate(["/authentication/OTP"]);
//           }
//         }
//       },
//       (err) => {
//         console.log(err);
//         this.error = err.message;
//         this.submitted = false;
//         this.loading = false;
//       }
//     );
//   }
  
  
// }









   