import { Component, OnInit } from '@angular/core';
import { color } from 'echarts';
import {
  ApexNonAxisChartSeries,
  ApexResponsive,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexStroke,
  ApexYAxis,
  ApexLegend,
  ApexFill,
  ApexAxisChartSeries,
  ApexMarkers,
  ApexGrid,
  ApexTitleSubtitle
} from 'ng-apexcharts';

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent implements OnInit {
  public chartOptions: any;
  public lineChartOptions: any;

  constructor() {}

  ngOnInit() {

    this.chartOptions = {
      series: [180, 100, 120, 130, 150],
      chart: {
        width: 380,
        type: 'pie',
        
      colors: ['#c3002f', '#262369', '#ccb034', '#ff5722', '#e040fb']
      },
      title: {
        text: 'Volume average on a Monthly Basis in Millions',
        align: 'left'
      },
      dataLabels: {
        enabled: true,
        formatter: function(val:any, opt:any) {
          return Math.round(val);
        },
      },
      labels: ['LCs', 'DCs', 'BGs', 'Invoice', 'Bills'],
      responsive: [
        {
          breakpoint: 480,
          options: {
            chart: {
              width: 200
            },
            legend: {
              position: 'bottom'
            }
          }
        }
      ]
    };
    this.lineChartOptions = {
      series: [
        {
          name: 'LCs - 2023',
          data: [28, 29, 33, 36, 32, 32]
        },
        {
          name: 'DCs - 2023',
          data: [12, 19, 24, 28, 17, 23]
        },
        {
          name: 'BGs - 2023',
          data: [16, 23, 33, 16, 22, 34]
        },
        {
          name: 'Bills - 2023',
          data: [11, 19, 25, 16, 34, 32]
        },
        {
          name: 'Invoices- 2023',
          data: [12, 19, 23, 26, 17, 22]
        },
        
      ],
      chart: {
        height: 350,
        type: 'line',
        dropShadow: {
          enabled: true,
          color: '#000',
          top: 18,
          left: 7,
          blur: 10,
          opacity: 0.2
        },
        toolbar: {
          show: false
        }
      },
      colors: ['#c3002f', '#262369', '#ccb034', '#ff5722', '#e040fb'],
      dataLabels: {
        enabled: true
      },
      stroke: {
        curve: 'smooth'
      },
      title: {
        text: 'Average Transactions on a Monthly Basis',
        align:'left'

      },
      grid: {
        borderColor: '#e7e7e7',
        row: {
          colors: ['#f3f3f3', 'transparent'],
          opacity: 0.5
        }
      },
      markers: {
        size: 1
      },
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        title: {
          text: 'Month'
        }
      },
      yaxis: {
        title: {
          text: 'TRANSACTIONS'
        },
        min: 5,
        max: 40
      },
      legend: {
        position: 'top',
        horizontalAlign: 'right',
        floating: true,
        offsetY: -25,
        offsetX: -5
      }
    }
  }
};
