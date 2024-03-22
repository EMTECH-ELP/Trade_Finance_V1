import { RouteInfo } from "./sidebar.metadata";

export const AdminModule: RouteInfo[] = [

  //Checker Sidebar Items
  {
    path: "/dashboard/dashboard",
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
    path: "/checker/dashboard",
    title: "Services",
    moduleName: "Services",
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
        path: "/lc/view",
        title: "Letter of Credit",
        moduleName: "Letter of Credit",
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
        path: "/checker/dashboard",
        title: "Documentary Credit",
        moduleName: "Documentary Credit",
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
        path: "/checker/dashboard",
        title: "Bank Guarantee",
        moduleName: "Bank Guarantee",
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
        path: "/checker/dashboard",
        title: "Invoice Discounting",
        moduleName: "Invoice Discounting",
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
        path: "/checker/dashboard",
        title: "Bills",
        moduleName: "Bills",
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
        path: "/checker/dashboard",
        title: "RTGS",
        moduleName: "RTGS",
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
    path: "/checker/My tickets/analytics",
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
    path: "/checker/Reports/analytics",
    title: "Reports",
    moduleName: "Reports",
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
  {
      path: "/checker/Reports/analytics",
      title: "Settings",
      moduleName: "Settings",
      iconType: "feather",
      icon: "settings",
      class: "",
      groupTitle: false,
      badge: "",
      badgeClass: "",
      role: ["ROLE_SUPERUSER"],
      // privilege: ["Dashboard"],
      submenu: [],
  },

  //Maker sidebar items
  // {
  //   path: "/maker/dashboard/analytics",
  //   title: "Dashboard",
  //   moduleName: "dashboard",
  //   iconType: "feather",
  //   icon: "activity",
  //   class: "",
  //   groupTitle: false,
  //   badge: "",
  //   badgeClass: "",
  //   role: ["ROLE_SUPERUSER"],
  //   // privilege: ["All Roles", "Manage Role"],
  //   submenu: []
  // },
  // {
  //   path: "/lc/create",
  //   title: "Services",
  //   moduleName: "services",
  //   iconType: "feather",
  //   icon: "activity",
  //   class: "menu-toggle",
  //   groupTitle: false,
  //   badge: "",
  //   badgeClass: "",
  //   role: ["ROLE_SUPERUSER"],
  //   // privilege: ["All Roles", "Manage Role"],
  //   submenu: [
  //     {
  //       path: "/maker/dashboard",
  //       title: "Letter of Credit",
  //       moduleName: "letter of credit",
  //       iconType: "feather",
  //       icon: "user-check",
  //       class: "ml-menu",
  //       groupTitle: false,
  //       badge: "",
  //       badgeClass: "",
  //       role: ["ROLE_SUPERUSER"],
  //       // privilege: ["All Roles"],
  //       submenu: [],
  //     },
  //     {
  //       path: "",
  //       title: "Bills",
  //       moduleName: "bills",
  //       iconType: "feather",
  //       icon: "user-check",
  //       class: "ml-menu",
  //       groupTitle: false,
  //       badge: "",
  //       badgeClass: "",
  //       role: ["ROLE_SUPERUSER"],
  //       // privilege: ["Manage Role"],
  //       submenu: [],
  //     },
  //     {
  //       path: "",
  //       title: "Bank Guarantee",
  //       moduleName: "bank guarantee",
  //       iconType: "feather",
  //       icon: "user-check",
  //       class: "ml-menu",
  //       groupTitle: false,
  //       badge: "",
  //       badgeClass: "",
  //       role: ["ROLE_SUPERUSER"],
  //       // privilege: ["Manage Role"],
  //       submenu: [],
  //     },
  //     {
  //       path: "",
  //       title: "Documentary collection",
  //       moduleName: "documentary collection",
  //       iconType: "feather",
  //       icon: "user-check",
  //       class: "ml-menu",
  //       groupTitle: false,
  //       badge: "",
  //       badgeClass: "",
  //       role: ["ROLE_SUPERUSER"],
  //       // privilege: ["Manage Role"],
  //       submenu: [],
  //     },
  //     {
  //       path: "",
  //       title: "Invoice Discounting",
  //       moduleName: "invoice discounting",
  //       iconType: "feather",
  //       icon: "user-check",
  //       class: "ml-menu",
  //       groupTitle: false,
  //       badge: "",
  //       badgeClass: "",
  //       role: ["ROLE_SUPERUSER"],
  //       // privilege: ["Manage Role"],
  //       submenu: [],
  //     },


  //   ],

  // },
  // {
  //   path: "",
  //   title: "My tickets",
  //   moduleName: "My tickets",
  //   iconType: "feather",
  //   icon: "sliders",
  //   class: "",
  //   groupTitle: false,
  //   badge: "",
  //   badgeClass: "",
  //   role: ["ROLE_SUPERUSER"],
  //   // privilege: ["Dashboard"],
  //   submenu: [],
  // },
  // {
  //   path: "",
  //   title: "Reports",
  //   moduleName: "reports",
  //   iconType: "feather",
  //   icon: "file-text",
  //   class: "",
  //   groupTitle: false,
  //   badge: "",
  //   badgeClass: "",
  //   role: ["ROLE_SUPERUSER"],
  //   // privilege: ["Dashboard"],
  //   submenu: [],
  // },
]