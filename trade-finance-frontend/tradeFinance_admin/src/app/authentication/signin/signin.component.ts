import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
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

    this.tokenCookieService.deleteUser();
  }
  
  

  
  onSubmit() {
    this.authService.login(this.authForm.value).subscribe(
      (res) => {
        console.log("Res: ", res);
  
  
        // If reset-password is not required, handle role-based navigation for second,third etc time users
        if (res.body.entity && res.body.entity.role === "SUPER_ADMIN") {
                  this.tokenCookieService.saveUser(res.body.entity)
          this.router.navigate(["/admin/dashboard/view"]);
        } else if (res.body.entity && (res.body.entity.role === "ADMIN" || res.body.entity.role === "USER")) {
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





//   onSubmit() {

//     localStorage.clear();

//     this.submitted = true;
//     this.loading = true;
//     this.error = "";
//     if (this.authForm.invalid) {
//       this.error = "Username or Password not valid !";
//       return;
//     } else {

//       this.authService.login(this.authForm.value).subscribe({
//         next: (res) => {
//           console.log("res: ", res.body);

//           if (res.body.statusCode == 200) {

//             this.tokenCookieService.saveUser(res.body.entity);

            

//             this.snackbar.showNotification(
//               "snackbar-success",
//               res.body.message
//             );
//             console.log("User", this.tokenCookieService.getUser());
//             this.router.navigate(["/admin/dashboard/view"]);
//           } else {
//             this.snackbar.showNotification("snackbar-danger", res.body.message);
//           }

//           this.loading = false;
//         },
//         error: (error) => {
//           this.snackbar.showNotification(
//             "snackbar-danger",
//             error.message
//           );
//           this.loading = false;
//         }
//       });
//     }
//   }
// }


    // localStorage.clear();

    // this.submitted = true;
    // this.loading = true;
    // this.error = "";
    // if (this.authForm.invalid) {
    //   this.error = "Username or Password not valid !";
    //   return;
    // } else {
    //   this.authService
    //     .login(this.authForm.value)
    //     .pipe(takeUntil(this.destroy$))
    //     .subscribe({
    //       next: (res) => {
    //         console.log("res: ", res.body);

    //         if (res.body.statusCode == 200) {

    //           this.tokenCookieService.saveUser(res.body.entity);

    //           this.snackbar.showNotification(
    //             "snackbar-success",
    //             res.body.message
    //           );
    //           this.router.navigate(["/authentication/OTP"]);
    //         } else {
    //           this.snackbar.showNotification("snackbar-danger", res.body.message);
    //         }

    //         this.loading = false;
    //       },
    //       error: (err) => {
    //         this.snackbar.showNotification(
    //           "snackbar-danger",
    //           err.message
    //         );
    //         this.loading = false;
    //       },
    //       complete: () => {},
    //     }),
    //     Subscription;


    //   console.log(this.authForm.value);
    // }
