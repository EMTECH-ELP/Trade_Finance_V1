import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MasterdataService } from '../masterdata.service';

@Component({
  selector: 'app-workflow-management',
  templateUrl: './workflow-management.component.html',
  styleUrls: ['./workflow-management.component.scss']
})
export class WorkflowManagementComponent implements OnInit {
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
