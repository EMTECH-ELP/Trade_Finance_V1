import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-verify-lc',
  templateUrl: './verify-lc.component.html',
  styleUrls: ['./verify-lc.component.sass']
})
export class VerifyLcComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  reject(): void {
    const reason = prompt('Please insert reason for rejection:');
    if (reason) {
      // Logic to send back LC to maker for approval with reason
      // Example: this.letterOfCreditService.rejectLetterOfCredit(this.data.id, reason);
      // this.dialogRef.close();
    }
  }

  approve(): void {
    // Logic to generate MT798
    alert('MT798 has successfully been generated.');
    // this.dialogRef.close();
  }


}
