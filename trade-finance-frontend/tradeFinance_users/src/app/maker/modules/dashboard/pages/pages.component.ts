import { Component, OnInit } from '@angular/core';
import {
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexStroke,
  ApexMarkers,
  ApexYAxis,
  ApexGrid,
  ApexTitleSubtitle,
  ApexTooltip,
  ApexLegend,
  ApexFill,
  ApexResponsive,
} from "ng-apexcharts";
import { TokenCookieService } from 'src/app/core/service/token-storage-cookies.service';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  dataLabels: ApexDataLabels;
  markers: ApexMarkers;
  colors: string[];
  yaxis: ApexYAxis;
  grid: ApexGrid;
  legend: ApexLegend;
  tooltip: ApexTooltip;
  fill: ApexFill;
  title: ApexTitleSubtitle;
  responsive: ApexResponsive[];
  labels: any;
};

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.sass']
})
export class PagesComponent implements OnInit {

  public performanceRateChartOptions: Partial<ChartOptions>;

  public lineChartOptions: Partial<ChartOptions>;
  public pieChartOptions: any;
  //  color: ["#3FA7DC", "#F6A025", "#9BC311"],

  currentUser: any;

  constructor( private tokenCookieService: TokenCookieService) { }

  ngOnInit(): void {

    this.currentUser = this.tokenCookieService.getUser().username;
    this.chart1();
    this.chart2();
  }

  private chart1() {
    this.lineChartOptions = {
      series: [
        {
          name: "Year 2021",
          data: [150, 130, 120, 200, 170, 105, 210,40, 250, 50, 120, 210],
        },
        {
          name: "Year 2022",
          data: [130, 250, 70, 170, 200, 170, 150,50, 130, 85, 105, 130],
        },
        {
          name: "Yer 2023",
          data: [105, 170, 105, 205, 110, 130, 170, 130, 65, 195, 60, 150],
        },
      ],
      chart: {
        height: 360,
        type: "line",
        foreColor: "#9aa0ac",
        dropShadow: {
          enabled: true,
          color: "#000",
          top: 18,
          left: 7,
          blur: 10,
          opacity: 0.2,
        },
        toolbar: {
          show: false,
        },
      },
      colors: ["#A5A5A5", "#875692", "#4CB5AC"],
      stroke: {
        curve: "smooth",
      },
      grid: {
        row: {
          colors: ["transparent", "transparent"], // takes an array which will be repeated on columns
          opacity: 0.5,
        },
      },
      markers: {
        size: 3,
      },
      xaxis: {
        categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"],
        title: {
          text: "Month",
        },
      },
      yaxis: {
        // opposite: true,
        title: {
          text: "Completed Transactions",
        },
      },
      legend: {
        position: "top",
        horizontalAlign: "right",
        floating: true,
        offsetY: -25,
        offsetX: -5,
      },
      tooltip: {
        theme: "dark",
        marker: {
          show: true,
        },
        x: {
          show: true,
        },
      },
    };
  }

  private chart2() {
    this.pieChartOptions = {
      series: [56, 42, 17, 48, 32, 48],
      chart: {
        type: "donut",
        width: 225,
      },
      legend: {
        show: false,
      },
      dataLabels: {
        enabled: false,
      },
      labels: ["Lc", "Bank Guarantee", "Dc", "Invoice Discounting", "Bills", "Remittances"],
      responsive: [
        {
          breakpoint: 480,
          options: {},
        },
      ],
    };
  }
}
