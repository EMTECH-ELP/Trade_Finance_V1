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
   
        if (res.body.statusCode === 207) {
          this.tokenCookieService.saveUser(res.body.entity)
          console.log("routing to otp")
          this.router.navigate(["/authentication/OTP"]);
          return; // Exit the function to prevent further navigation
        }
  
  
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
        // if (this.authForm.invalid) {
        //   this.error = "Email/password  not valid!";
        //   this.snackbar.showNotification(
        //     "snackbar-success",
        //   "Email/Password not valid")
        //   return;
        // } else {
        //   console.log(this.authForm.value);
    
        // }
      },
      (err) => {
        console.log(err);
        this.snackbar.showNotification("snackbar-danger", "Server Error");
        // this.error = err.message;
        this.submitted = false;
        this.loading = false;
      }
    
    );
  }
  
  
}

//       (err) => {
//         console.error(err);
//         // if (err.status === 401) {
//           // this.snackbar.showNotification("snackbar-danger", "An error occurred. Please try again later.");
//         } else {
//           // this.snackbar.showNotification("snackbar-danger", "Invalid email or password");
//         }
//       }
//     );
  
// }

