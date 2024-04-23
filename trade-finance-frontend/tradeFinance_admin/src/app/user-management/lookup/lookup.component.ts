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
  dialogRef: any;
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
        this.checkerForm = data;
        // Emit the application form event
        this.applicationFormEvent.emit(this.checkerForm);
        const result = data
        this.dialog.close(result)
      },
      (error) => {
        // Handle error
        console.error('Error fetching application form details:', error);
      }
    );
  }
}