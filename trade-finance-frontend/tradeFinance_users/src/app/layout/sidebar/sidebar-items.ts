import { Sidebar } from "angular-feather/icons";
import { RouteInfo } from "./sidebar.metadata";

export const ROUTES: RouteInfo[] = [

  // Checker Sidebar Items 
  
//   {
//     path: "/checker/dashboard/view",
//     title: "Dashboard",
//     moduleName: "dashboard",
//     iconType: "feather",
//     icon: "airplay",
//     class: "",
//     groupTitle: false,
//     badge: "",
//     badgeClass: "",
//     role: ["CHECKER"],
//     // privilege: ["Dashboard"],
//     submenu: [],
//   },

//   {
//     path: "/checker/dashboard",
//     title: "Services",
//     moduleName: "Services",
//     iconType: "feather",
//     icon: "activity",
//     class: "menu-toggle",
//     groupTitle: false,
//     badge: "",
//     badgeClass: "",
//     role: ["CHECKER"],
//     // privilege: ["All Roles", "Manage Role"],
//     submenu: [
//       {
//         path: "/lc/view",
//         title: "Letter of Credit",
//         moduleName: "Letter of Credit",
       
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["All Roles"],
//         submenu: [],
//       },
//       {
//         path: "/bills/viewbill",
//         title: "Bills",
//         moduleName: "bills",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },
//       {
//         path: "/bank-guarantee/viewbg",
//         title: "Bank Guarantee",
//         moduleName: "Bank Guarantee",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },
//       {
//         path: "/documentary-collection/viewDc",
//         title: "Documentary collection",
//         moduleName: "documentary collection",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },
//       {
//         path: "/invoice-discounting/viewInvoice",
//         title: "Invoice Discounting",
//         moduleName: "Invoice Discounting",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },
//       {
//         path: "/checker/dashboard",
//         title: "Bills",
//         moduleName: "Bills",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },
//       {
//         path: "/checker/dashboard",
//         title: "RTGS",
//         moduleName: "RTGS",
//         iconType: "feather",
//         icon: "user-check",
//         class: "ml-menu",
//         groupTitle: false,
//         badge: "",
//         badgeClass: "",
//         role: ["CHECKER"],
//         // privilege: ["Manage Role"],
//         submenu: [],
//       },

//     ],
//   },
//   {
//     path: "/checker/My tickets/analytics",
//     title: "My tickets",
//     moduleName: "My tickets",
//     iconType: "feather",
//     icon: "sliders",
//     class: "",
//     groupTitle: false,
//     badge: "",
//     badgeClass: "",
//     role: ["CHECKER"],
//     // privilege: ["Dashboard"],
//     submenu: [],
//   },
//   {
//     path: "/checker/Reports/analytics",
//     title: "Reports",
//     moduleName: "Reports",
//     iconType: "feather",
//     icon: "file-text",
//     class: "",
//     groupTitle: false,
//     badge: "",
//     badgeClass: "",
//     role: ["CHECKER"],
//     // privilege: ["Dashboard"],
//     submenu: [],
//   },
//   {
//       path: "/checker/Reports/analytics",
//       title: "Settings",
//       moduleName: "Settings",
//       iconType: "feather",
//       icon: "settings",
//       class: "",
//       groupTitle: false,
//       badge: "",
//       badgeClass: "",
//       role: ["CHECKER"],
//       // privilege: ["Dashboard"],
//       submenu: [],
//   },
// ]  

                 //Maker sidebar items
  {
    path: "/checker/dashboard/analytics",        // Temporarily used for the maker's dashboard.
    title: "Dashboard",
    moduleName: "dashboard",
    iconType: "feather",
    icon: "airplay",
    class: "",
    groupTitle: false,
    badge: "",
    badgeClass: "",
    role: ["MAKER"],
    // privilege: ["All Roles", "Manage Role"],
    submenu: []
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
    role: ["MAKER"],
    // privilege: ["All Roles", "Manage Role"],
    submenu: [
      {
        path: "/lc/view",
        title: "Letter of Credit",
        moduleName: "letter of credit",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["MAKER"],
        // privilege: ["All Roles"],
        submenu: [],
      },

      {
        path: "/bills/viewbill",
        title: "Bills",
        moduleName: "bills",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["MAKER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },
      {
        path: "/bank-guarantee/viewbg",
        title: "Bank Guarantee",
        moduleName: "bank guarantee",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["MAKER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },
      {
        path: "/documentary-collection/viewDc",
        title: "Documentary collection",
        moduleName: "documentary collection",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["MAKER"],
        // privilege: ["Manage Role"],
        submenu: [],
      },
      {
        path: "/invoice-discounting/viewInvoice",
        title: "Invoice Discounting",
        moduleName: "invoice discounting",
        iconType: "feather",
        icon: "user-check",
        class: "ml-menu",
        groupTitle: false,
        badge: "",
        badgeClass: "",
        role: ["MAKER"],
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
    role: ["MAKER"],
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
    role: ["MAKER"],
        // privilege: ["Dashboard"],
     submenu: [],
   },
]