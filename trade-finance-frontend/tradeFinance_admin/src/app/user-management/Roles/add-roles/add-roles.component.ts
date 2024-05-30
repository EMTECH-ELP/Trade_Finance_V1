import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';


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
  

  constructor(private fb: FormBuilder, private router : Router) {
    this.roleForm = this.fb.group({
      roleName: ['', Validators.required],
      roleDescription: ['', Validators.required],
      privileges: this.fb.array([]),
      additionalDescriptions: this.fb.array([]),

    });

   }


   get privileges(): FormArray {
    return this.roleForm.get('privileges') as FormArray;
  }

  togglePrivilegesTable() {
    this.showPrivilegesTable = !this.showPrivilegesTable;
  }

  addPrivilege() {
    const privilegeGroup = this.fb.group({
      name: [''],
      description: ['']
    });
    this.privileges.push(privilegeGroup);
  }
  callAdd(){
    console.log('privilege called successfully!');

    this.router.navigate(["/users/privileges"]);
  }


  ngOnInit(): void {
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


}

//undo here!!





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
