import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LcService } from '../../services/lc.service';

@Component({
  selector: 'app-verify',
  templateUrl: './verify-lc.component.html',
  styleUrls: ['./verify-lc.component.sass']
})
export class VerifylcComponent  implements OnInit {
  verifyForm: FormGroup;
  lcNumber: string = '';
  loading: boolean = false;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private lcService: LcService, private router: Router,) { }

  ngOnInit() {
    this.verifyForm = this.fb.group({
      lcNumber: ['', Validators.required]
    });
  }

  public onApprove() {
    const data = { ...this.verifyForm.value, status: 'Approved' };
    this.processAction(data);
  }

  public onReject() {
    const data = { ...this.verifyForm.value, status: 'Rejected' };
    this.processAction(data);
  }

  private processAction(data: any) {
    console.log("Form data", data);
    this.lcService.approveLc(data).subscribe({
      next: (response) => {
        console.log("LC approval/rejection response", response);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        alert('Action completed successfully and records updated!');
        this.router.navigate(["view"]);
      }
    });
    this.verifyForm.reset();
  }
}
