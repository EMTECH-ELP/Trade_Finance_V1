
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
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent  {

  // constructor(    private tokenCookieService: TokenCookieService,) {}
  // ngOnInit() {
    
  // }

  
  @ViewChildren("chart") chart: AnalyticsComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor() {
    this.chartOptions = {
      series: [
        {
          name: "LCs",
          data: this.generateDayWiseTimeSeries(
            new Date("11 Feb 2017 GMT").getTime(),
            20,
            {
              min: 10,
              max: 20
            }
          )
        },

        {
          name: "Invoices",
          data: this.generateDayWiseTimeSeries(
            new Date("11 Feb 2017 GMT").getTime(),
            20,
            {
              min: 10,
              max: 20
            }
          )
        },
        {
          name: "BGs",
          data: this.generateDayWiseTimeSeries(
            new Date("11 Feb 2017 GMT").getTime(),
            20,
            {
              min: 10,
              max: 20
            }
          )
        },

        {
          name: "DCs",
          data: this.generateDayWiseTimeSeries(
            new Date("11 Feb 2017 GMT").getTime(),
            20,
            {
              min: 10,
              max: 20
            }
          )
        },
        {
          name: "BILLS",
          data: this.generateDayWiseTimeSeries(
            new Date("11 Feb 2017 GMT").getTime(),
            20,
            {
              min: 10,
              max: 20
            }
          )
        }
      ],

      chart: {
        height: 350,
    
        stacked: true,
        events: {
          selection: function(chart, e) {
            console.log(new Date(e.xaxis.min));
          }
        }
      },
      colors: ["#008FFB","orange","#CED4DC","#9B2827","green"],
      dataLabels: {
        enabled: false
      },
      fill: {
        type: "gradient",
        gradient: {
          opacityFrom: 0.6,
          opacityTo: 0.8
        }
      },
      legend: {
        position: "top",
        horizontalAlign: "left"
      },
      xaxis: {
        type: "datetime"
      }
    };
  }

  public generateDayWiseTimeSeries = function(baseval, count, yrange) {
    var i = 0;
    var series = [];
    while (i < count) {
      var x = baseval;
      var y =
        Math.floor(Math.random() * (yrange.max - yrange.min + 1)) + yrange.min;

      series.push([x, y]);
      baseval += 86400000;
      i++;
    }
    return series;
  };
}


 




