import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { UpdateProfileComponent } from './pages/update-profile/update-profile.component';
import { ComponentsModule } from '../shared/components/components.module';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatTabsModule } from '@angular/material/tabs';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    UpdateProfileComponent
  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    ComponentsModule,
    SharedModule,
    MatTabsModule,
    MatCheckboxModule
  ]
})
export class AccountModule { }
