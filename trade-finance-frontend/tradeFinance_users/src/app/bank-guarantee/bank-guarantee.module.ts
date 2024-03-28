import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BankGuaranteeRoutingModule } from './bank-guarantee-routing.module';
import { CreateBgComponent } from './components/create-bg/create-bg.component';
import { ComponentsModule } from "../shared/components/components.module";
import {MatStepperModule} from '@angular/material/stepper';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ViewBgComponent } from './components/view-bg/view-bg.component';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';


@NgModule({
    declarations: [
        CreateBgComponent,
        ViewBgComponent
    ],
    imports: [
        CommonModule,
        BankGuaranteeRoutingModule,
        ComponentsModule,
        MatStepperModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatOptionModule
        
    ]
})
export class BankGuaranteeModule { }
