import { Component, OnInit } from '@angular/core';
import { MasterdataService } from '../masterdata.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-activities',
  templateUrl: './user-activities.component.html',
  styleUrls: ['./user-activities.component.scss']
})
export class UserActivitiesComponent implements OnInit {

  users: any[] = [];
  showUsers: boolean = true;
  displayedColumns: string[] = ['id', 'username', 'email', 'role', 'productType', 'loginStatus', 'action'];

  constructor
  (private UsersactService: MasterdataService,
    private router: Router,
  ) {}

  ngOnInit(): void {}

  loadUsers(): void {
    this.UsersactService.getUsers().subscribe((data) => {
      this.users = data;
      this.showUsers = true;
    });
  }

}
