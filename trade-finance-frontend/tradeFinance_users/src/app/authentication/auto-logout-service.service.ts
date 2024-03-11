// Import necessary Angular modules and libraries
import { Router } from "@angular/router";
import { Injectable, NgZone } from "@angular/core";
import * as store from "store";
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from "@angular/material/snack-bar";
import { TokenCookieService } from "../core/service/token-storage-cookies.service";

// Declare some constants
const MINUTES_UNTIL_AUTO_LOGOUT = 3;
const CHECK_INTERVAL = 1000;
const STORE_KEY = "lastAction";

// Decorate class with Injectable so it can be injected with services
@Injectable()
export class AutoLogoutService {

  horizontalPosition: MatSnackBarHorizontalPosition = "end";
  verticalPosition: MatSnackBarVerticalPosition = "top";


  // Declare some class variables
  pageReloaded = false;
  private checkInterval: any;

  // Initialize the class with services, and initialize the listener, interval, and check
  constructor(
    private snackBar: MatSnackBar,
    private router: Router,
    private ngZone: NgZone,
    private tokenCookieService: TokenCookieService
  ) {
    this.initListener();
    this.initInterval();
    this.check();
  }

  // Getter and setter for last action
  get lastAction(): number {
    return parseInt(store.get(STORE_KEY));
  }
  set lastAction(value: number) {
    store.set(STORE_KEY, value);
  }

  // Initialize the listener, which listens for user activity and calls the reset function
  initListener() {
    this.ngZone.runOutsideAngular(() => {
      document.body.addEventListener("click", () => this.reset());
      document.body.addEventListener("keydown", () => this.reset());
      document.body.addEventListener("mouseover", () => this.reset());
      document.body.addEventListener("mouseout", () => this.reset());
      document.body.addEventListener("mousedown", () => this.reset());
      document.body.addEventListener("mouseup", () => this.reset());
    });
  }

  // Initialize the interval, which calls the check function periodically
  initInterval() {
    this.ngZone.runOutsideAngular(() => {
      this.checkInterval = setInterval(() => {
        this.check();
      }, CHECK_INTERVAL);
    });
  }

  // Reset the last action to the current time
  reset() {
    this.lastAction = Date.now();
  }

  // Check if the user has been inactive for too long, and perform actions accordingly
  check() {
    const now = Date.now();
    const timeLeft = this.lastAction + MINUTES_UNTIL_AUTO_LOGOUT * 60 * 1000;
    const isTimeout = timeLeft - now < 60000;

    this.ngZone.run(() => {
      const currentUser = JSON.parse(localStorage.getItem("auth-user"));

      // If the user has been inactive for too long and is logged in, show the warning snackbar
      if (isTimeout && currentUser) {
        this.snackBar.open(
          "The system will sign you out in the next 1 minute.",
          "X",
          {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 60000,
            panelClass: ["snackbar-danger", "login-snackbar"],
          }
        );
      }

      // If the user has been inactive for too long, log them out
      if (timeLeft - now < 0) {
        location.reload();
        this.router.navigateByUrl("/authentication/signin");
        this.tokenCookieService.signOut();
        // this.router.navigate(["/authentication/signin"]);
        localStorage.clear();
        

      } else {
        // If the user is active, dismiss the snackbar and reset the last action
        document.body.addEventListener("click", () => {
          this.snackBar.dismiss();
          this.reset();
        });
        document.body.addEventListener("keydown", () => {
          this.snackBar.dismiss();
          this.reset();
        });
        document.body.addEventListener("mouseover", () => {
          this.snackBar.dismiss();

          this.reset();
        });
      }
    });
  }
}
