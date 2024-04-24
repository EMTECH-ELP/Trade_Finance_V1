import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LookupService } from './lookup.service';
import { MatDialogRef } from '@angular/material/dialog';



@Component({
  selector: 'app-lookup',
  templateUrl: './lookup.component.html',
  styleUrls: ['./lookup.component.scss']
})
export class LookupComponent implements OnInit {

  searchForm: FormGroup; 
  branchCode: any;
  branchName:any
  checkerForm: any;

  @Output() applicationFormEvent = new EventEmitter<any>();
  


  constructor(private http: HttpClient, private formBuilder: FormBuilder, private lookUpService: LookupService, private dialog: MatDialogRef<LookupComponent>) { 
    this.searchForm = this.formBuilder.group({
      branchCode: [''],
      branchName: [''],
    
    });
  }

  ngOnInit(): void {
    // Initialization code here
  }

  search() {
    this.lookUpService.getFormDetailsByBranchCode(this.branchCode).subscribe(
      (data) => {
        // Handle successful response
        console.log('Response Body', data); // Log the response body
        
        // Update the checkerForm with the received data
        this.checkerForm = data;
        console.log("checker", this.checkerForm)
        
        // Emit the application form event
        this.applicationFormEvent.emit(this.checkerForm);
        
        // Close the dialog with the received data
        this.dialog.close(data);
      },
      (error) => {
        // Handle error
        console.error('Error fetching application form details:', error);
      }
    );
  }
  
}