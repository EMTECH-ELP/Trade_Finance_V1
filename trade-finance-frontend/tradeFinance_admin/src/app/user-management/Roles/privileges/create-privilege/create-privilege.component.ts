import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { UserManagementService } from 'src/app/user-management/user-management.service'; 


@Component({
  selector: 'app-create-privilege',
  templateUrl: './create-privilege.component.html',
  styleUrls: ['./create-privilege.component.scss']
})
export class CreatePrivilegeComponent implements OnInit {
  privilegeForm: FormGroup;
  privilegeDescriptions: Array<{label: string, controlName: string}> = [];

  constructor(private fb: FormBuilder,private router: Router, private userManagementService: UserManagementService) { 
    this.privilegeForm = this.fb.group({
      privilegeName: ['', Validators.required],
      privilegeDescription: ['', Validators.required],
      additionalDescriptions: this.fb.array([]),

    });

  }

  ngOnInit(): void {
  }

  cancel(){
    this.router.navigate(['/users/view-roles'])
  }

  onSubmit() {
    console.log('Form data', this.privilegeForm.value);
    // if (this.privilegeForm.valid) {
      
      this.userManagementService.submitPrivilege(this.privilegeForm.value).subscribe(response => {
        // Handle response here
        console.log('Submission successful', response);
        this.router.navigate(['/users/privileges']); // Navigate to a success page or reset the form
        return;
      }, error => {
        console.error('Submission failed', error);
      });
      
    // }
  
  }

  

  addPrivilegeDescription() {
    const label = prompt('Enter more new privilege description:');
    if (label) {
      const controlName = `privilegeDescription${this.privilegeDescriptions.length + 1}`;
      this.privilegeDescriptions.push({ label, controlName });
      this.privilegeForm.addControl(controlName, new FormControl('', Validators.required));
    }
  }
  
}