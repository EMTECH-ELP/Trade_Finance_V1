import { Component, Inject , OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Bank, MasterdataService } from '../masterdata.service';


@Component({
  selector: 'app-deletebankdialogue',
  templateUrl: './deletebankdialogue.component.html',
  styleUrls: ['./deletebankdialogue.component.scss']
})
export class DeletebankdialogueComponent implements OnInit {
  branchCode: string;

  constructor(
    private bankService: MasterdataService,
 
    public dialogRef: MatDialogRef<DeletebankdialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit(): void {
  }

  
    isValid(): boolean {
      return!!this.branchCode;
    }
  
    onNoClick(): void {
      this.dialogRef.close();
    }
  
    onOkClick(): void {
      this.dialogRef.close({ branchCode: this.branchCode });
      
    }
  }
  

