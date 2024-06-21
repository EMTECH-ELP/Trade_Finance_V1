import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray, Validators, FormControl } from '@angular/forms';
import { UserManagementService } from '../../user-management.service';


@Component({
  selector: 'app-privileges',
  templateUrl: './privileges.component.html',
  styleUrls: ['./privileges.component.scss']
})
export class PrivilegesComponent implements OnInit {
  privilegeForm: FormGroup;
  privilegeDescriptions: Array<{label: string, controlName: string}> = [];
  isLoading = true; // Added loading state
  privileges: any[] = [];

  constructor(private fb: FormBuilder,private router: Router, private userManagementService: UserManagementService) { 
    this.privilegeForm = this.fb.group({
      privilegeName: ['', Validators.required],
      privilegeDescription: ['', Validators.required],
      additionalDescriptions: this.fb.array([]),

    });

  }

  ngOnInit(): void {
    this.privilegeTable()
  }

addPrivilege(){
  this.router.navigate(['/users/createPrivilege'])
  }
  refresh(){
  //FOR ERRORS
  }
  
  applyFilter(event: Event){
    //FOR ERRORS
  }

cancel(){
  this.router.navigate(['/users/view-roles'])
}



addPrivilegeDescription() {
  const label = prompt('Enter more new privilege description:');
  if (label) {
    const controlName = `privilegeDescription${this.privilegeDescriptions.length + 1}`;
    this.privilegeDescriptions.push({ label, controlName });
    this.privilegeForm.addControl(controlName, new FormControl('', Validators.required));
  }
}


onSubmit() {
  console.log('Form data', this.privilegeForm.value);
  if (this.privilegeForm.valid) {
    this.userManagementService.submitPrivilege(this.privilegeForm.value).subscribe(response => {
      // Handle response here
      console.log('Submission successful', response);
      this.router.navigate(['/users/add-roles']); // Navigate to a success page or reset the form
      return;
    },
    error => {
      console.error('Submission failed', error);
    });
    
  }

}


navRole(){
  this.router.navigate(['/users/add-roles'])
}

mainPrivilege(){
  this.router.navigate(['/users/view-roles'])
}

privilegeTable(){
  this.userManagementService.getPrivileges().subscribe(
    data => {
      this.privileges = data;
      this.isLoading = false;
    },
    error => {
      console.error('Error fetching privileges:', error);
      this.isLoading = false;
    }
  );
}
}




