import { Component, OnInit } from '@angular/core';
import { AddRolesComponent} from '../add-roles/add-roles.component';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Component({
  selector: 'app-view-roles',
  templateUrl: './view-roles.component.html',
  styleUrls: ['./view-roles.component.scss']
})
export class ViewRolesComponent implements OnInit {

  constructor(private dialog: MatDialog,
    private router: Router) { }

  ngOnInit(): void {
  }


add(){
//FOR ERRORS
this.router.navigate (["/users/add-roles"])
}
refresh(){
//FOR ERRORS
}

applyFilter(event: Event){
  //FOR ERRORS
}
  
}
