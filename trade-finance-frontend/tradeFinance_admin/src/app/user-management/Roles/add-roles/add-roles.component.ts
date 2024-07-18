import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserManagementService } from 'src/app/user-management/user-management.service';


interface privilege{
  name:string;
  description:string;
}

@Component({
  selector: 'app-add-roles',
  templateUrl: './add-roles.component.html',
  styleUrls: ['./add-roles.component.scss']
})
export class AddRolesComponent implements OnInit {
  roleForm: FormGroup;
  showPrivilegesTable = false;
  roleDescriptions: Array<{label: string, controlName: string}> = [];
  roles: any[] = [];
  isLoading = true; // Added loading state

  searchText: string;
  

  constructor(private fb: FormBuilder, private router : Router,private snackBar: MatSnackBar, private userManagementService: UserManagementService) {
    this.roleForm = this.fb.group({
      roleName: ['', Validators.required],
      roleDescription: ['', Validators.required],
      privileges: this.fb.array([]),
      additionalDescriptions: this.fb.array([]),

    });

   }


   

  togglePrivilegesTable() {
    this.showPrivilegesTable = !this.showPrivilegesTable;
  }

  // addPrivilege() {
  //   const privilegeGroup = this.fb.group({
  //     name: [''],
  //     description: ['']
  //   });
  //   this.privileges.push(privilegeGroup);
  // }

  callAdd(){
    console.log('privilege called successfully!');

    this.router.navigate(["/users/privileges"]);
  }


  ngOnInit(): void {
    this.roleTable()
  }

  cancel(){
    this.router.navigate(['/users/view-roles'])
  }

  

  addRoleDescription() {
    const label = prompt('Enter more new role description:');
    if (label) {
      const controlName = `roleDescription${this.roleDescriptions.length + 1}`;
      this.roleDescriptions.push({ label, controlName });
      this.roleForm.addControl(controlName, new FormControl('', Validators.required));
    }
  }

  addRole(){
    this.router.navigate(['/users/createRole'])
    }
    refresh(){
    //FOR ERRORS
    }
    
    applyFilter(event: Event){
      //FOR ERRORS
    } 

    privilege(){
      this.router.navigate(['/users/privileges'])
    }

    mainRole(){
      this.router.navigate(['/users/view-roles'])
    }


roleTable(){
  this.userManagementService.getRoles().subscribe(
    data => {
      this.roles = data;
      this.isLoading = false;
    },
    error => {
      console.error('Error fetching roles:', error);
      this.isLoading = false;
    }
  );
}
   
}







// togglePrivileges() {
  //   this.showPrivileges = !this.showPrivileges;
  // }

  // editPrivilege(privilege: privilege) {
  //   // Logic to edit the privilege
  //   console.log('Editing privilege:', privilege);
  // }

  // deletePrivilege(privilege: privilege) {
  //   // Logic to delete the privilege
  //   this.privileges.data = this.privileges.data.filter(p => p !== privilege);
  //   this.selection.deselect(privilege);
  //   console.log('Deleted privilege:', privilege);
  // }


  // toggleSelection(Privilege: privilege) {
  //   this.selection.toggle(Privilege);
  //   console.log('Selected privileges:', this.selection.selected);
  // }

  // isAllSelected() {
  //   const numSelected = this.selection.selected.length;
  //   const numRows = this.privileges.data.length;
  //   return numSelected === numRows;
  // }

  // masterToggle() {
  //   this.isAllSelected() ?
  //     this.selection.clear() :
  //     this.privileges.data.forEach(row => this.selection.select(row));
  // }
