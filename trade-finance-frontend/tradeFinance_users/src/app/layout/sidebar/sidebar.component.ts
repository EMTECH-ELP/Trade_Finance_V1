import { Router, NavigationEnd } from "@angular/router";
import { DOCUMENT } from "@angular/common";
import {
  Component,
  Inject,
  ElementRef,
  OnInit,
  Renderer2,
  HostListener,
  OnDestroy,
} from "@angular/core";
// import { ROUTES } from "./sidebar-items";
import { AuthService } from "src/app/core/service/auth.service";
import { Role } from "src/app/core/models/role";

import { TokenCookieService } from "src/app/core/service/token-storage-cookies.service";
// import { NotificationService } from "src/app/erp-procurement/data/services/notification.service";
import {
  AdminModule,
  // BudgetModule,
  // FinanceModule,
  // FixedAssetsModule,
  // HumanResourceModule,
  // ImprestModule,
  // InventoryModule,
  // PrepaymentModule,
  // ProcurementModule,
  // SuppliersManagementModule,
} from "./sidebar-items";

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.sass"],
})
export class SidebarComponent implements OnInit, OnDestroy {
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

  userName = "";
  userRole = "";

  // private myPrivileges = privileges;

  constructor(
    @Inject(DOCUMENT) private document: Document,
    private renderer: Renderer2,
    public elementRef: ElementRef,
    private authService: AuthService,
    // private tokenStorageService: TokenStorageService,
    private tokenCookieService: TokenCookieService,
    private router: Router,
    // private notificationService: NotificationService
  ) {
    const body = this.elementRef.nativeElement.closest("body");
    this.routerObj = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // logic for select active menu in dropdown
        const role = ["ROLE_ADMIN", "ROLE_CLERK", "ROLE_SUPERUSER"];
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

  privileges: any[] = [];
  

  ngOnInit() {

    this.currentUser = this.tokenCookieService.getUser();
    if (this.currentUser) {
      console.log("this.currentUser:::: ", this.currentUser);
      this.userName = this.currentUser.username;
      this.userRole = this.currentUser.role.name;
      this.userFullName = this.currentUser.username;
      this.userImg = "assets/images/user/profile_img.png";

      console.log("this.currentUser : ", this.currentUser);
      
      const userId = this.currentUser.id;
      const module = JSON.parse(
        localStorage.getItem(`selectedModule_${userId}`) || "{}"
      );
      const myPrivileges = JSON.parse(
        localStorage.getItem(`userPrivileges_${userId}`) || "{}"
      );

      console.log("module ::: ", module);
      console.log("myPrivileges :::: ", myPrivileges);

      const moduleMapping = {
        AdminModule: AdminModule
      };

      if (module in moduleMapping) {
        this.sidebarItems = moduleMapping[module].filter((route) => {
          const isRouteVisible = route.privilege.some((privilege) =>
            myPrivileges.includes(privilege)
          );
          if (!isRouteVisible) {
            return false;
          }
          if (route.submenu.length === 0) {
            return true;
          }
          route.submenu = route.submenu.filter((submenu) =>
            submenu.privilege.some((privilege) =>
              myPrivileges.includes(privilege)
            )
          );
          return route.submenu.length > 0;
        });
        console.log("myPrivileges: ", myPrivileges);
      } else {
        // this.notificationService.alertWarning(
        //   "No sidebar items available for this module...!!"
        // );
      }

      this.sidebarItems = AdminModule.filter((x) => x.role.indexOf(this.userRole) !== -1);
      if (this.userRole === Role.Superuser) {
        this.userType = Role.Superuser;
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
    this.router.navigate(["/authentication/signin"]);
  }
}
