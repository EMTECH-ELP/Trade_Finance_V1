import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserManagementService } from 'src/app/user-management/user-management.service'; 


@Component({
  selector: 'app-create-role',
  templateUrl: './create-role.component.html',
  styleUrls: ['./create-role.component.scss']
})
export class CreateRoleComponent implements OnInit {
  roleForm: FormGroup;
  roleDescriptions: Array<{label: string, controlName: string}> = [];
  privileges: any[] = [];
  isLoading = true; // Added loading state
  

  constructor(private fb: FormBuilder, private router : Router,private userManagementService: UserManagementService) {
    this.roleForm = this.fb.group({
      roleName: ['', Validators.required],
      roleDescription: ['', Validators.required],
      privileges: this.fb.array([]),
      additionalDescriptions: this.fb.array([]),

    });

   }


  ngOnInit(): void {
this.getPrivileges()
  }
public getPrivileges(){
  this.userManagementService.getPrivileges().subscribe((data: any) => {
    this.privileges = data;
    const privilegeControls = this.privileges.map(() => this.fb.control(false));
    this.roleForm.setControl('privileges', this.fb.array(privilegeControls));
    this.isLoading = false; // Set loading to false when data is loaded
  }, error => {
    console.log('Failed to load privileges', error);
    this.isLoading = false; // Ensure spinner is hidden if there's an error
  });
}



  addRoleDescription() {
    const label = prompt('Enter more new role description:');
    if (label) {
      const controlName = `roleDescription${this.roleDescriptions.length + 1}`;
      this.roleDescriptions.push({ label, controlName });
      this.roleForm.addControl(controlName, new FormControl('', Validators.required));
    }
  }


  cancel(){
    this.router.navigate(['/users/view-roles'])
  }

  

  onSubmit() {
    // Get form value
    const formValue = this.roleForm.value;

    // Extract selected privileges
    const selectedPrivileges = formValue.privileges
      .map((checked: boolean, i: number) => checked ? this.privileges[i].privilege_id : null)
      .filter((v: any) => v !== null);

    // Prepare role data
    const roleData = {
      role_name: formValue.roleName,
      description: formValue.roleDescription,
      privilege_ids: selectedPrivileges,
      additional_descriptions: this.roleDescriptions.map(desc => ({
        label: desc.label,
        value: formValue[desc.controlName]
      }))
    };

    console.log('Form data', roleData);

    this.userManagementService.submitRole(roleData).subscribe(response => {
      console.log('Submission successful', response);
      this.router.navigate(['/users/add-roles']); // Navigate to a success page or reset the form
    }, error => {
      console.error('Submission failed', error);
    });
  }
}

