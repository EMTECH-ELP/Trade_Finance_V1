import { Component, OnInit } from '@angular/core';
import { LcService } from '../../services/lc.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.scss']
})


export class ModifyComponent implements OnInit {


  searchForm: FormGroup;
  searchByOptions = ['ID', 'Email', 'firstname', 'Businessname', 'account no'];
  selectedSearchBy: string = 'ID';
  searchTerm: string = '';
  searchResults: any[] = [];

  constructor(private LcService: LcService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.searchForm = this.formBuilder.group({

    });
  }

  search(): void {

  }

  onsubmit() { }

  onModify() { }

  Modify(result: any): void {
    // Implement modify functionality here
  }
}

