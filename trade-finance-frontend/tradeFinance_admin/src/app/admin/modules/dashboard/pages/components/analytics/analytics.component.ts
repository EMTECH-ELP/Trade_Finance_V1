
// import { Component,OnInit,ViewChildren } from "@angular/core";

// import {
//   ChartComponent,
//   ApexAxisChartSeries,
//   ApexChart,
//   ApexFill,
//   ApexTooltip,
//   ApexXAxis,
//   ApexColors,
//   ApexLegend,
//   ApexDataLabels,
//   ApexTitleSubtitle,
//   ApexYAxis
// } from "ng-apexcharts";

// export type ChartOptions = {
//   series: ApexAxisChartSeries;
//   chart: ApexChart;
//   xaxis: ApexXAxis;
//   markers: any; //ApexMarkers;
//   stroke: any; //ApexStroke;
//   yaxis: ApexYAxis | ApexYAxis[];
//   dataLabels: ApexDataLabels;
//   title: ApexTitleSubtitle;
//   legend: ApexLegend;
//   colors: string[];
//   fill: ApexFill;
//   tooltip: ApexTooltip;
// };

//  @Component({
//   selector: 'app-analytics',
//   templateUrl: './analytics.component.html',
//   styleUrls: ['./analytics.component.scss']
// })

// export class AnalyticsComponent {
//   @ViewChildren("chart") chart: ChartComponent;
//   @ViewChildren("charty") charty: ChartComponent;

//   public chartOptions: Partial<ChartOptions>;
//   public chartOptions1: Partial<ChartOptions>;

//   constructor() {
//     this.chartOptions = {
//       series: [
       
//         {
//           name: "Transactions volumes",
//           type: "column",
//           data: [3, 3.1, 4, 4.5,4.9],
//           color: "#920a0a 50%"
//         },
//         {
//           name: "Transactions volumes",
//           type: "column",
//           data: [3, 3.1, 4, 4.5,4.9],
//           // Change colors to an array
//           color: ["#920a0a", "#920a0a", "#920a0a", "#920a0a", "#920a0a"]
//         },
       
//         {
//           name: "Pending Transaction",
//           type: "line",
//           data: [0, 10, 5, 20, 40, ]
//         },
        

//       ],
//       chart: {
//         height: 400,
//         type: "line",
//         stacked: false,
//       },
      
//       dataLabels: {
//         enabled: true
        
//       },

//       stroke: {
//         width: [1, 1, 4]
//       },
//       title: {
//         text: " APROVED AND PENDINGS TRANSACTIONS ANALYSIS ",
//         align: "left",
//         offsetX: 110
//       },
      
//       xaxis: {
//         categories: ["lcs", "Invoices", "bills", "BGs", "DCs"],
//         color:["#920a0a 50%","#920a0a 50%","#920a0a 50%","#920a0a 50%","#920a0a 50%"]
      
//     },
//       yaxis: [
//         {
//           axisTicks: {
//             show: true
//           },
//           axisBorder: {
//             show: true,
//             color: "#920a0a 50%"
//           },
//           labels: {
//             style: {
//               // color: "#920a0a 50%)"
//             }
//           },
//           title: {
//             text: "volumes> ",
//             style: {
//               color: "#920a0a 50%"
//             }
//           },
//           tooltip: {
//             enabled: true
//           }
//         },
//         {
//           seriesName: "Income",
//           opposite: true,
//           axisTicks: {
//             show: true
//           },
//           axisBorder: {
//             show: true,
//             color: "#00E396"
//           },
//           labels: {
//             style: {
//               // color: "#00E396"
//             }
//           },
//           title: {
//             text: "Operating Cashflow (thousand crores)",
//             style: {
//               color: "#00E396"
//             }
//           }
//         },
//         {
//           seriesName: "Revenue",
//           opposite: true,
//           axisTicks: {
//             show: true
//           },
//           axisBorder: {
//             show: true,
//             color: "#FEB019"
//           },
//           labels: {
//             style: {
//               // color: "#FEB019"
//             }
//           },
//           title: {
//             text: "Revenue (thousand crores)",
//             style: {
//               color: "#FEB019"
//             }
//           }
//         },
//         {
//           seriesName: "Transaction",
//           opposite: true,
//           axisTicks: {
//             show: true
//           },
//           axisBorder: {
//             show: true,
//             color: "##FFC879"
//           },
//           labels: {
//             style: {
//               // color: "##FFC879"
//             }
//           },
//           title: {
//             text: "Transaction (thousand crores)",
//             style: {
//               color: ""
//             }
//           }
//         }
//       ],
//       tooltip: {
//         fixed: {
//           enabled: true,
//           position: "topLeft", // topRight, topLeft, bottomRight, bottomLeft
//           offsetY: 50,
//           offsetX: 100
//         }
//       },
//       legend: {
//         horizontalAlign: "left",
//         offsetX: 40
//       }
//     };
  
//   }
// }



import { Component, ViewChildren } from "@angular/core";
import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexFill,
  ApexTooltip,
  ApexXAxis,
  ApexLegend,
  ApexDataLabels,
  ApexTitleSubtitle,
  ApexYAxis
} from "ng-apexcharts";
import { TokenCookieService } from "src/app/core/service/token-storage-cookies.service";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  markers: any; //ApexMarkers;
  stroke: any; //ApexStroke;
  yaxis: ApexYAxis | ApexYAxis[];
  dataLabels: ApexDataLabels;
  title: ApexTitleSubtitle;
  legend: ApexLegend;
  colors:string[];// Change to string array
  fill: ApexFill;
  tooltip: ApexTooltip;
};

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.sass']
})
export class AnalyticsComponent {
  @ViewChildren("chart") chart: ChartComponent;
  @ViewChildren("charty") charty: ChartComponent;

  public chartOptions: Partial<ChartOptions>;
  public chartOptions1: Partial<ChartOptions>;
  currentUser: any;
  lineChartOptions: {
    series: { name: string; type: string; data: number[]; }[]; chart: { height: number; type: string; stacked: boolean; }; dataLabels: { enabled: boolean; }; stroke: { width: number[]; }; title: { text: string; align: string; offsetX: number; }; xaxis: { categories: string[]; }; yaxis: { axisTicks: { show: boolean; }; axisBorder: { show: boolean; color: string; }; labels: { style: {}; }; title: { text: string; style: { color: string; }; }; tooltip: { enabled: boolean; }; }[]; tooltip: {
      fixed: {
        enabled: boolean; position: string; // topRight, topLeft, bottomRight, bottomLeft
        offsetY: number; offsetX: number;
      };
    }; legend: { horizontalAlign: string; offsetY: number; offsetX: number; }; colors: string[];
  };

  constructor(    private tokenCookieService: TokenCookieService,) {}
  ngOnInit() {
    this.currentUser = this.tokenCookieService.getUser().username;
    this.chart1();
   
  }

  private chart1() {
    this.lineChartOptions = {
      series: [
        {
          name: "Transactions volumes",
          type: "column",
          data: [3, 3.1, 4, 4.5, 4.9,]
          
        },

        {
          name: "Pending Transaction",
          type: "line",
          data: [0, 10, 5, 20,36]
        },
        {
          name: "Approved transactions ",
          type: "line",
          data: [8, 29, 37, 36,45]
        },
        
      ],
      chart: {
        height: 350,
        type: "line",
        stacked: false,
        
      },
      dataLabels: {
        enabled: true
      },
      stroke: {
        width: [1, 1,4,]
      },
      title: {
        text: "APPROVED AND PENDINGS TRANSACTIONS ANALYSIS",
        align: "left",
        offsetX: 110
      },
      xaxis: {
        categories: ["lcs","bills","Invoices", "BGs", "DCs"]
       
      },
      yaxis: [
        {
          axisTicks: {
            show: true
          },
          axisBorder: {
            show: true,
            color: "black"
          },
          labels: {
            style: {
              // color: "#920a0a"
            }
          },
          title: {
            text: "volumes>",
            style: {
              color: "black"
            }
          },
          tooltip: {
            enabled: true
          }
        }
        // Other y-axis configurations...
      ],
      tooltip: {
        fixed: {
          enabled: true,
          position: "topLeft", // topRight, topLeft, bottomRight, bottomLeft
          offsetY: 50,
          offsetX: 100
        }
        
      },
      legend: {
        horizontalAlign: "left",
        offsetY: 50,
        offsetX: 100
      },

    
      colors: ["#920a0a", "yellow","blue",]
    };
  }
};
