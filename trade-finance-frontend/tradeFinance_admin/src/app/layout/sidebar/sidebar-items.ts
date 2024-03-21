import { RouteInfo } from "./sidebar.metadata";

export const AdminModule: RouteInfo[] = [
  {
    path: "/admin/dashboard",
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
    path: "",
    title: "User Management",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "users",
    class: "menu-toggle",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["All Roles", "Manage Role"],
    submenu: [
      {
        path: "/users/checkers",
        title: "Checkers",
        moduleName: "dashboard",
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
        path: "/users/makers",
        title: "Makers",
        moduleName: "dashboard",
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
    path: "/admin/dashboard",
    title: "Security Management",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "key",
    class: "",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [],
  },

  {
    path: "/admin/dashboard",
    title: "System management",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "settings",
    class: "menu-toggle",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [
      {
        path: "/admin/dashboard",
        title: "Master data",
        moduleName: "dashboard",
        iconType: "feather",
        icon: "setting",
        class: "",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["ROLE_SUPERUSER"],
        // privilege: ["Dashboard"],
        submenu: [],
      },
      {
        path: "/admin/dashboard",
        title: "Workflows Management",
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
      }
    ],
  },
  {
    path: "/admin/dashboard",
    title: "Report and Analytics",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "bar-chart-2",
    class: "menu-toggle",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["ROLE_SUPERUSER"],
    // privilege: ["Dashboard"],
    submenu: [
      {
        path: "/admin/dashboard",
        title: "Transactions Reports",
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
      }
    ],
  }
  
]