import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { LcService } from '../../services/lc.service'; // Ensure this path is correct
import { Router } from '@angular/router';

@Component({
  selector: 'app-transferlc',
  templateUrl:'./transferlc.component.html',
  styleUrls: ['./transferlc.component.sass'],
})
export class TransferlcComponent implements OnInit {
  transferForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private lcService: LcService // Ensure service is injected here
  ) { }

  ngOnInit(): void {
    this.transferForm = this.fb.group({
      secondaryBeneficiaryFirstName: ['', [Validators.required]],
      secondaryBeneficiaryMiddleName: ['', [Validators.required]],
      secondaryBeneficiaryLastName: ['', [Validators.required]],
      secondaryBeneficiaryAddress: ['', [Validators.required]],
      secondaryBeneficiaryEmail: ['', [Validators.required, Validators.email]],
      secondaryBeneficiaryPhoneNumber: ['', [Validators.required]],
      secondaryBeneficiaryAccountNumber: ['', [Validators.required]],
      secondaryBeneficiaryAccountName: ['', [Validators.required]],
      secondaryBeneficiaryCity: ['', [Validators.required]],
      secondaryBeneficiaryCountry: ['', [Validators.required]],
      secondaryBeneficiaryBank: [''],
      secondaryBeneficiarySwiftCode: ['', [Validators.required]],
      newExpiryDate: ['', [Validators.required]],
      transferAmount: ['', [Validators.required]],
      latestShipmentDate: ['', [Validators.required]],
      transferDate: ['', [Validators.required]],
    });
  }

  onCancel(): void {
    this.router.navigate(['/lc/view']);
  }

  onSubmit(): void {
    if (this.transferForm.valid) {
      console.log('Form data', this.transferForm.value);

      this.lcService
        .transferLc(this.transferForm.value)
        .subscribe({
          next: (response) => {
            console.log('Lc transfer response', response);
          },
          error: (err) => {
            console.error('Error in transfer LC:', err);
          },
          complete: () => {
            console.log('Transfer LC process completed.');
          },
        });
    } else {
      // This handles form validation errors
      console.error('Form is invalid');

      // To identify which controls are invalid, you can log the errors
      Object.keys(this.transferForm.controls).forEach((key) => {
        const control = this.transferForm.get(key);
        if (control && control.invalid) {
          console.error(`Form control '${key}' is invalid. Errors:`, control.errors);
        }
      });
    }
    this.router.navigate(['/lc/view']);
  }

}
