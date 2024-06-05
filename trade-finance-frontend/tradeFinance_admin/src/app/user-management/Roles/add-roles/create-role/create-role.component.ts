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
  

  constructor(private fb: FormBuilder, private router : Router,private userManagementService: UserManagementService) {
    this.roleForm = this.fb.group({
      roleName: ['', Validators.required],
      roleDescription: ['', Validators.required],
      privileges: this.fb.array([]),
      additionalDescriptions: this.fb.array([]),

    });

   }


  ngOnInit(): void {
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
    // if (this.privilegeForm.valid) {
      
      this.userManagementService.submitRole(this.roleForm.value).subscribe(response => {
        // Handle response here
        console.log('Submission successful', response);
        this.router.navigate(['/users/add-roles']); // Navigate to a success page or reset the form
        return;
      }, error => {
        console.error('Submission failed', error);
      });
      
    // }
  
  }


}
