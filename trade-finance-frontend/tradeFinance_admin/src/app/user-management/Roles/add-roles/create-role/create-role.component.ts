import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserManagementService } from 'src/app/user-management/user-management.service';
import { MatCheckboxModule } from '@angular/material/checkbox'; 
import { SnackbarService } from 'src/app/shared/services/snackbar.service';

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
  

  constructor(private fb: FormBuilder, private router : Router,private userManagementService: UserManagementService, private snackbar:SnackbarService) {
    this.roleForm = this.fb.group({
      roleName: ['', Validators.required],
      roleDescription: ['', Validators.required],
      privilegeCode: this.fb.array([]),
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
    console.log('Form data', this.roleForm.value);
    if (this.roleForm.valid) {
      
      this.userManagementService.submitRole(this.roleForm.value).subscribe(response => {
        // Handle response here
        console.log('Submission successful', response);
        this.snackbar.showNotification(
          "snackbar-success",
        " Role added successfully")
        this.router.navigate(['/users/add-roles']);// Navigate to a success page or reset the form
        
        return;
      }, error => {
        console.error('Submission failed', error);
      });
      
    }
  
  }


  
}

