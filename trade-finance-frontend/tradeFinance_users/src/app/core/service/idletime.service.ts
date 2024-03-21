import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { TokenCookieService } from './token-storage-cookies.service';

@Injectable({
  providedIn: 'root'
})
export class IdleTimer {

  private timeout: number;
  private onTimeout: Function;
  private eventHandler = () => {
    this.updateExpiredTime();
  };
  private interval: any;
  private timeoutTracker: any;

  constructor(
    private snackBar: MatSnackBar,
    private tokenCookieService: TokenCookieService
  ) {}

  start({ timeout, onTimeout }) {
    const { getUser, getToken } = this.tokenCookieService;
    const currentUser = getUser();
    const token = getToken();

    if (currentUser) {
      this.timeout = timeout;
      this.onTimeout = onTimeout;
      this.eventHandler = this.updateExpiredTime.bind(this);
      this.tracker();
      this.startInterval();
    }
  }

  startInterval() {
    this.updateExpiredTime();

    this.interval = setInterval(() => {
      const expiredTime = parseInt(localStorage.getItem("_expiredTime"), 10);
      const timeLeft = (expiredTime - Date.now()) / 1000;

      if (timeLeft <= this.timeout * 0.1) {
        this.showSnackBar(`The system will sign you out in the next ${timeLeft.toFixed(0)} seconds!`);
      }

      if (expiredTime < Date.now()) {
        if (this.onTimeout) {
          this.onTimeout();
          this.clear();
        }
      }
    }, 1000);
  }

  updateExpiredTime() {
    if (this.timeoutTracker) {
      clearTimeout(this.timeoutTracker);
    }
    this.timeoutTracker = setTimeout(() => {
      localStorage.setItem("_expiredTime", (Date.now() + this.timeout * 1000).toString());
    }, 300);
  }

  tracker() {
    window.addEventListener("mousemove", this.eventHandler);
    window.addEventListener("scroll", this.eventHandler);
    window.addEventListener("keydown", this.eventHandler);
  }

  clear() {
    clearInterval(this.interval);
    window.removeEventListener("mousemove", this.eventHandler);
    window.removeEventListener("scroll", this.eventHandler);
    window.removeEventListener("keydown", this.eventHandler);
    localStorage.removeItem("_expiredTime");
  }

  showSnackBar(message: string) {
    const horizontalPosition: MatSnackBarHorizontalPosition = "end";
    const verticalPosition: MatSnackBarVerticalPosition = "top";
    const duration = 10000;
    const panelClass = ["snackbar-danger", "login-snackbar"];

    this.snackBar.open(message, "X", {
      horizontalPosition,
      verticalPosition,
      duration,
      panelClass,
    });
  }
}
