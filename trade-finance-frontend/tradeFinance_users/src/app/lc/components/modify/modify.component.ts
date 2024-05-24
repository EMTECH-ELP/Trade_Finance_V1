import { Component, OnInit } from '@angular/core';
import { LcService } from '../../services/lc.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ModifyLookupComponent } from './modify-lookup/modify-lookup.component';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.scss']
})
export class ModifyComponent implements OnInit {
  selectedValue: string;
  modificationForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private lcService: LcService,
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit() {
    this.modificationForm = this.fb.group({
      lcNumber: ['', Validators.required],
      lcType: [''],
      applicableRules: ['', Validators.required],
      currencyCode: ['', Validators.required],
      amount: ['', [Validators.required]],
      expiryDate: ['', Validators.required],
      chargesBorneBy: ['', Validators.required],
      negotiationPeriod: ['', Validators.required],
      issueDate: ['', Validators.required],
      tenor: ['', Validators.required],
      transferable: ['', Validators.required],
      confirm: ['', Validators.required],
      advise: ['']
    });
  }
  public onModify() {
    console.log("Form data", this.modificationForm.value);
    this.lcService.modifyLc(this.modificationForm.value).subscribe({
      next: (response) => {
        console.log("Lc modify response", response);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        alert('Modification done successfully and records updated!');
        this.router.navigate(["view"]);
      }
    });
    this.modificationForm.reset();
    this.ngOnInit();
  }

  public onSubmit() {
    console.log("Form data", this.modificationForm.value);
    this.lcService.ModifyLc(this.modificationForm.value).subscribe({
      next: (response) => {
        console.log("Lc create response", response);
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        console.log('Submission complete');
      }
    });
  }

  openModifyLookup() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '500px';
    dialogConfig.data = { lcNumber: this.modificationForm.get('lcNumber').value };

    const dialogRef = this.dialog.open(ModifyLookupComponent, dialogConfig);

    dialogRef.afterClosed().subscribe({
      next: (res: any) => {
        console.log("received data", res);

        if (res && res.data && res.data[0]) {
          this.patchModificationForm(res.data[0]);
        }
      },
      error: (err) => {
        console.error("Error in dialog after close", err);
      }
    });
  }

  patchModificationForm(data: any) {
    if (data) {
      this.modificationForm.patchValue({
        lcNumber: data.lcNumber,
        lcType: data.lcType,
        applicableRules: data.applicableRules,
        currencyCode: data.currencyCode,
        amount: data.amount,
        expiryDate: data.expiryDate,
        chargesBorneBy: data.chargesBorneBy,
        negotiationPeriod: data.negotiationPeriod,
        issueDate: data.issueDate,
        tenor: data.tenor,
        transferable: data.transferable,
        confirm: data.confirm,
        advise: data.advise,
      });
    }
  }
}
