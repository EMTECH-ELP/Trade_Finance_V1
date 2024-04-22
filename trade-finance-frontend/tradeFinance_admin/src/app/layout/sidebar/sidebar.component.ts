import { Router, NavigationEnd } from "@angular/router";
import { DOCUMENT } from "@angular/common";
import { ViewChild, } from '@angular/core';


import {
  Component,
  Inject,
  ElementRef,
  OnInit,
  Renderer2,
  HostListener,
  OnDestroy,
} from "@angular/core";
import { ROUTES } from "./sidebar-items";
import { Role } from "src/app/core/models/role";
import { TokenStorageService } from "src/app/core/service/token-storage.service";
import { BaseComponent } from "src/app/shared/components/base/base.component";

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.sass"],
})

export class SidebarComponent extends BaseComponent implements OnInit, OnDestroy {
  public sidebarItems: any[];
  level1Menu = "";
  level2Menu = "";
  level3Menu = "";
  public innerHeight: any;
  public bodyTag: any;
  listMaxHeight: string;
  listMaxWidth: string;
  userFullName: string;
  userImg: string;
  userType: string;
  headerHeight = 60;
  currentRoute: string;
  routerObj = null;

  currentUser: any;

  constructor(
    @Inject(DOCUMENT) private document: Document,
    private renderer: Renderer2,
    public elementRef: ElementRef,
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {
    super();
    const body = this.elementRef.nativeElement.closest("body");
    this.routerObj = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {

        const role = ["ADMIN", "STAFF", "MANUFACTURER", "WAREHOUSE", "SERVICE_PROVIDER"];

        const currenturl = event.url.split("?")[0];
        const firstString = currenturl.split("/").slice(1)[0];

        if (role.indexOf(firstString) !== -1) {
          this.level1Menu = event.url.split("/")[2];
          this.level2Menu = event.url.split("/")[3];
        } else {
          this.level1Menu = event.url.split("/")[1];
          this.level2Menu = event.url.split("/")[2];
        }

        // close sidebar on mobile screen after menu select
        this.renderer.removeClass(this.document.body, "overlay-open");
      }
    });
  }
  @HostListener("window:resize", ["$event"])
  windowResizecall(event) {
    this.setMenuHeight();
    this.checkStatuForResize(false);
  }
  @HostListener("document:mousedown", ["$event"])
  onGlobalClick(event): void {
    if (!this.elementRef.nativeElement.contains(event.target)) {
      this.renderer.removeClass(this.document.body, "overlay-open");
    }
  }
  callLevel1Toggle(event: any, element: any) {
    if (element === this.level1Menu) {
      this.level1Menu = "0";
    } else {
      this.level1Menu = element;
    }
    const hasClass = event.target.classList.contains("toggled");
    if (hasClass) {
      this.renderer.removeClass(event.target, "toggled");
    } else {
      this.renderer.addClass(event.target, "toggled");
    }
  }
  callLevel2Toggle(event: any, element: any) {
    if (element === this.level2Menu) {
      this.level2Menu = "0";
    } else {
      this.level2Menu = element;
    }
  }
  callLevel3Toggle(event: any, element: any) {
    if (element === this.level3Menu) {
      this.level3Menu = "0";
    } else {
      this.level3Menu = element;
    }
  }
  ngOnInit() {

    this.currentUser = this.tokenStorageService.getUser();
    const role = this.currentUser.role;

    if (this.currentUser) {
      
      let userRole = this.currentUser.roles[0].role;
      console.log("role", userRole)

      this.userFullName = this.currentUser.firstName;
      this.userImg = "assets/images/prof.png";

      this.sidebarItems = ROUTES.filter((x) => x.role.indexOf(userRole) !== -1);
      console.log(userRole);

      if (userRole === Role.Admin) {
        this.userType = Role.Admin;
      }
    }

    // this.sidebarItems = ROUTES.filter((sidebarItem) => sidebarItem);
    this.initLeftSidebar();
    this.bodyTag = this.document.body;
  }
  ngOnDestroy() {
    this.routerObj.unsubscribe();
  }
  initLeftSidebar() {
    const _this = this;
    // Set menu height
    _this.setMenuHeight();
    _this.checkStatuForResize(true);
  }
  setMenuHeight() {
    this.innerHeight = window.innerHeight;
    const height = this.innerHeight - this.headerHeight;
    this.listMaxHeight = height + "";
    this.listMaxWidth = "500px";
  }
  isOpen() {
    return this.bodyTag.classList.contains("overlay-open");
  }
  checkStatuForResize(firstTime) {
    if (window.innerWidth < 1170) {
      this.renderer.addClass(this.document.body, "ls-closed");
    } else {
      this.renderer.removeClass(this.document.body, "ls-closed");
    }
  }
  mouseHover(e) {
    const body = this.elementRef.nativeElement.closest("body");
    if (body.classList.contains("submenu-closed")) {
      this.renderer.addClass(this.document.body, "side-closed-hover");
      this.renderer.removeClass(this.document.body, "submenu-closed");
    }
  }
  mouseOut(e) {
    const body = this.elementRef.nativeElement.closest("body");
    if (body.classList.contains("side-closed-hover")) {
      this.renderer.removeClass(this.document.body, "side-closed-hover");
      this.renderer.addClass(this.document.body, "submenu-closed");
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(["/authentication/signin"]);
    //window.location.reload();
  }

  showDropdown = false;

  @ViewChild('dropdownContent', { static: false }) dropdownContent: ElementRef;
  @ViewChild('dropdownButton', { static: false }) dropdownButton: ElementRef;

  toggleDropdown() {
    this.showDropdown = !this.showDropdown;

    if (this.showDropdown) {
      // Position the dropdown content below the button
      const buttonRect = this.dropdownButton.nativeElement.getBoundingClientRect();
      this.dropdownContent.nativeElement.style.top = `${buttonRect.bottom}px`;
      this.dropdownContent.nativeElement.style.left = `${buttonRect.left}px`;
    }
  }

  // Optional: Programmatic navigation using Router (can be triggered elsewhere)
  navigateToComponent(componentName: string) {
    this.router.navigate([`/bonds/${componentName}`]);
  }
}
