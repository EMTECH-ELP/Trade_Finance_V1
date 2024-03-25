
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

  constructor() {
    this.chartOptions = {
      series: [
        {
          name: "Financial instruments",
          type: "column",
          data: [1.1, 3, 3.1, 4, 4.1, 4.9],
          color:  "#920a0a"
        },
        {
          name: "APPROVED TRANSACTION",
          type: "line",
          data: [10, 40, 50, 24, 45, ]
        },

        {
          name: "PENDING TRANSACTIONS ",
          type: "line",
          data: [20, 37, 36, 44, 45, ]
        }
      ],
      chart: {
        height: 350,
        type: "line",
        stacked:false
      },
      dataLabels: {
        enabled: true
      },
      stroke: {
        width: [1, 1, 4]
      },
      title: {
        text: "PENDING AND APPROVED TRANSACTIONS ANALYSIS",
        align: "left",
        offsetX: 110
      },
      xaxis: {
        categories: ["LCs", "invoices", "BGs", "Bills","DCs", ]
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
              // color: "#008FFB",,#920a0a
            }
          },
          title: {
            text: "TRANSACTION INSTRUMENTS VOLUMES",
            style: {
              color: "#black"
            }
          },
          tooltip: {
            enabled: true
          }
        },
        {
          seriesName: "Income",
          opposite: true,
          axisTicks: {
            show: true
          },
          axisBorder: {
            show: true,
            color: "black"
          },
          labels: {
            style: {
              // color: "#00E396"
            }
          },
          
        },
        {
          seriesName: "Revenue",
          opposite: true,
          axisTicks: {
            show: true
          },
          axisBorder: {
            show: true,
            color: "#FEB019"
          },
          labels: {
            style: {
              // color: "#FEB019"
            }
          },
          
        }
      ],
      tooltip: {
        fixed: {
          enabled: true,
          position: "topLeft", // topRight, topLeft, bottomRight, bottomLeft
          offsetY: 30,
          offsetX: 60
        }
      },
      legend: {
        horizontalAlign: "left",
        offsetX: 40
      }
    };
  }
};
