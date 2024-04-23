import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { LcService } from 'src/app/lc/services/lc.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modify-lookup',
  templateUrl: './modify-lookup.component.html',
  styleUrls: ['./modify-lookup.component.sass']
})
export class ModifyLookupComponent implements OnInit {
lcNumber: any;
  searchForm: any;
  modificationForm: any;
  modificationFormEvent: any;

constructor(private http: HttpClient, private formBuilder: FormBuilder, private modifyLookupService: LcService, private dialog: MatDialogRef<ModifyLookupComponent>) { 
  this.searchForm = this.formBuilder.group({
    lcNumber: [''],
    lcType: [''],
    applicableRules: [''],
    currencyCode: [''],
    amount: [''],
    expiryDate: [''],
    chargesBornlcNumber: [],
    negotiationPeriod: [''],
    issueDate: [''],
    tenor: [''],
    transferable: [''],
    confirm: [''],
    advise: ['']
  });
}

  ngOnInit(): void {
  }

  searchLc(){
    this.modifyLookupService.getLcDetailsByLcNumber().subscribe(
      (data) => {
        // Handle successful response
        this.modificationForm = data;
        // Emit the application form event
        this.modificationFormEvent.emit(this.modificationForm);
        const result = data
        this.dialog.close(result)
      },
      (error) => {
        // Handle error
        console.error('Error fetching LC details:', error);
      }
    );
  }
}
