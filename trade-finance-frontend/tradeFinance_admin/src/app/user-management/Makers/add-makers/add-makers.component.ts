import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-makers',
  templateUrl: './add-makers.component.html',
  styleUrls: ['./add-makers.component.scss']
})
export class AddMakersComponent implements OnInit {

  dialogRef: any;
  selectedStatus:string=''

  constructor() { }

  ngOnInit(): void {
  }


  onSubmit(): void {
    // Here you can handle form submission
    // For example, you can emit an event or call a service
    // After submitting, close the dialog
    this.dialogRef.close();
  }

  onClose(): void {
    this.dialogRef.close();
  }

}
