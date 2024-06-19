// src/app/lc-mt/lc-mt.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LcService } from '../../services/lc.service';
import { environment } from 'src/environments/environment';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-lc-mt',
  templateUrl: './lc-mt.component.html',
  styleUrls: ['./lc-mt.component.sass']
})
export class LcMtComponent implements OnInit {
  lcNumber: string = '';
  loading: boolean = false;
  errorMessage: string = '';
  form: FormGroup

  constructor(private http: HttpClient, private lcService:LcService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      lcNumber: ['', [Validators.required]]
    })
  }

  downloadReport() {
    if (this.form.invalid) {
      this.errorMessage = 'Please enter LC Number.';
      return;
    }

    this.loading = true;
    this.errorMessage = '';
    const url =`${environment.generateMtUrl}/generate-mt700/${this.form.value.lcNumber}`;
    this.http.get(url, {responseType: "blob"})
      .subscribe(
        (response: Blob) => {
          console.log("gxcvhbnmn", response)
          this.loading = false;
          const url = window.URL.createObjectURL(response);
          const a = document.createElement('a');
          a.href = url;
          a.download = `MT_Report_${this.lcNumber}.txt`;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
        },
        (error) => {
          this.loading = false;
          this.errorMessage = 'Error downloading the report. Please try again.';
        }
      );
  }
}
