import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { InvDiscountingService } from '../../services/inv-discounting.service';
import { SnackbarService } from 'src/app/shared/services/snackbar.service';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-createdform',
  templateUrl: './createdform.component.html',
  styleUrls: ['./createdform.component.sass']
})
export class CreatedformComponent implements OnInit {
  createdform;
  createdformNo;

  applicationForm: any;
  mockData: any;
  rowData: any;
  invoiceId:number

    // applicationForm!: applicationFormDetails: 
    constructor(
      @Inject(MAT_DIALOG_DATA) private data,
      private router: Router,
      public service:InvDiscountingService,
      private activatedRoute: ActivatedRoute, 
      public dialogRef:MatDialogRef<CreatedformComponent>, 
      private snackbar: SnackbarService) { }
  
    ngOnInit(): void {
      const invoice = this.data.data
      if (invoice) {
        this.rowData = invoice
        console.log("data", invoice);
        
      }
    }


    // this.createdformNo =  this.activatedRoute.snapshot.paramMap.get('no');  //new approach
       
    //   this.createdform = this.invDiscountingService.forms.find(x => x.no == this.createdformNo);

    
    // this.activatedRoute.queryParams.subscribe(params => {
    //   if (params['data']) {
    //     this.rowData = JSON.parse(params['data']);
    //     console.log('Received data:', this.rowData);
    //   }
    // });

    getInvoiceDataById(){
      const url = `${environment.invUrl}/invoices${this.invoiceId}`
      this.service.getData(url).subscribe(
        ((response) => {
          console.log(response);
          
        }),
        ((error) => {}),
        () => {

        }
      )
    }
    onClose(): void {
      this.dialogRef.close(false);
    }
  }
  