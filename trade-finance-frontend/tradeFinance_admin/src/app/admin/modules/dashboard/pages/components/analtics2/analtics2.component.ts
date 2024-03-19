
import { Component, ViewChildren } from "@angular/core";

import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexStroke,
  ApexMarkers,
  ApexYAxis,
  ApexGrid,
  ApexTitleSubtitle,
  ApexLegend
} from "ng-apexcharts";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  dataLabels: ApexDataLabels;
  markers: ApexMarkers;
  tooltip: any; // ApexTooltip;
  yaxis: ApexYAxis;
  grid: ApexGrid;
  legend: ApexLegend;
  title: ApexTitleSubtitle;
};



@Component({selector: 'app-analtics2',
 templateUrl: './analtics2.component.html',
styleUrls: ['./analtics2.component.scss']
 })
 export class Analtics2Component {
 @ViewChildren("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

 constructor() {

  
    this.chartOptions = {
      series: [
        {
          name: "INVOICES",
          data: [20, 25, 45, 10, 55, 60, 75, 88, 65, 70, 90, 80]
        },

        {
          name: "Bills",
          data: [5, 20, 25, 35, 20, 40, 18, 45, 48, 50, 70, 95]
        },

        {
          name: "LCs",
          data: [15, 52, 38, 24, 33, 26, 21, 70, 10, 8, 10, 45]
        }, 


        {
          name: "DCss",
          data: [35, 90, 62, 42, 13, 18, 29, 37, 36, 51, 32, 35]
        },
        {
          name: "BGs",
          data: [10, 57, 74, 99, 75, 38, 62, 47, 82, 56, 45, 47]
        }
      ],
      chart: {
        height: 350,
        type: "line"
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 5,
        curve: "straight",
        dashArray: [0, 8, 5]
      },
      title: {
        text: "TRANSACTIONS TRENDS",
        align: "center"
      },
      legend: {
        tooltipHoverFormatter: function(val, opts) {
          return (
            val +
            " - <strong>" +
            opts.w.globals.series[opts.seriesIndex][opts.dataPointIndex] +
            "</strong>"
          );
        }
      },
      markers: {
        size: 0,
        hover: {
          sizeOffset: 6
        }
      },
      xaxis: {
        labels: {
          trim: false
        },
        categories: [
          "01 Jan",
          "02 Jan",
          "03 Jan",
          "04 Jan",
          "05 Jan",
          "06 Jan",
          "07 Jan",
          "08 Jan",
          "09 Jan",
          "10 Jan",
          "11 Jan",
          "12 Jan"
        ]
      },
      tooltip: {
        y: [
          {
            title: {
              formatter: function(val) {
                return val + " (mins)";
              }
            }
          },
          {
            title: {
              formatter: function(val) {
                return val + " per session";
              }
            }
          },
          {
            title: {
              formatter: function(val) {
                return val;
              }
            }
          }
        ]
      },
      grid: {
        borderColor: "#f1f1f1"
      }
    }
  }
};
 