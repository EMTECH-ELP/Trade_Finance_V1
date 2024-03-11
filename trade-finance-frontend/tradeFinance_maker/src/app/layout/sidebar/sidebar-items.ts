import { RouteInfo } from "./sidebar.metadata";

export const AdminModule: RouteInfo[] = [
  {

    path: "/maker/dashboard/analytics",
    title: "Dashboard",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "airplay",
    class: "",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [],
  },

  {
    path: "/maker/dashboard",
    title: "Services",
    moduleName: "services",
    iconType: "feather",
    icon: "activity",
    class: "menu-toggle",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["All Roles", "Manage Role"],
    submenu: [
      {
        path: "/maker/dashboard",
        title: "Letter of Credit",
        moduleName: "letter of credit",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
        // privilege: ["All Roles"],
        submenu: [],
      },
      {
        path: "/maker/dashboard",
        title: "Bills",
        moduleName: "bills",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },
      {
        path: "/maker/dashboard",
        title: "Bank Guarantee",
        moduleName: "bank guarantee",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
       
        submenu: [],
      },
      {
        path: "/maker/dashboard",
        title: "Documentary collection",
        moduleName: "documentary collection",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },
      {
        path: "/maker/dashboard",
        title: "Invoice Discounting",
        moduleName: "invoice discounting",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },


    ],

  },
  {
    path: "/maker/dashboard",
    title: "My tickets",
    moduleName: "My tickets",
    iconType: "feather",
    icon: "sliders",
    class: "",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [],
  },
  {
    path: "/maker/dashboard",
    title: "Reports",
    moduleName: "reports",
    iconType: "feather",
    icon: "file-text",
    class: "",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [],
  },
]
