import { Component, OnInit } from '@angular/core';
import { UsersactService } from '../../usersact.service';
@Component({
  selector: 'app-user-activities',
  templateUrl: './user-activities.component.html',
  styleUrls: ['./user-activities.component.scss']
})
export class UserActivitiesComponent implements OnInit {

  users: any[] = [];
  showUsers: boolean = false;
  displayedColumns: string[] = ['id', 'username', 'email', 'role', 'productType', 'loginStatus', 'action'];

  constructor(private UsersactService: UsersactService) {}

  ngOnInit(): void {}

  loadUsers(): void {
    this.UsersactService.getUsers().subscribe((data) => {
      this.users = data;
      this.showUsers = true;
    });
  }

}
