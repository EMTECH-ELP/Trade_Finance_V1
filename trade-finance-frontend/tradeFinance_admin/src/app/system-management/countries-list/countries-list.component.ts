import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryService } from '../country.service';
import { Country } from '../country.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.scss']
})
export class CountriesListComponent implements OnInit {
  countryForm: FormGroup;
  displayedColumns: string[] = ['name', 'code', 'capital', 'city1', 'city2', 'city3'];

  countries: any[] = [
    { name: 'Country 1', code: 'C1', capital: 'Capital 1', city1: 'City 1', city2: 'City 2', city3: 'City 3' },
    { name: 'Country 2', code: 'C2', capital: 'Capital 2', city1: 'City A', city2: 'City B', city3: 'City C' },
    // Add more countries as needed
  ];

  constructor(private formBuilder: FormBuilder, private countryService: CountryService, private router:Router) { }

  ngOnInit(): void {
    this.countryForm = this.formBuilder.group({
      name: ['', Validators.required],
      code: ['', Validators.required],
      capital:['', Validators.required],
      city1: [''],
      city2: [''],
      city3: ['']
    });

    this.loadCountries();
  }

  loadCountries() {
    this.countryService.getCountries().subscribe(countries => {
      this.countries = countries;
    });
  }

  addCountry() {
    if (this.countryForm.valid) {
      const newCountry: Country = {
        name: this.countryForm.value.name,
        code: this.countryForm.value.code,
        capital: this.countryForm.value.capital,
        city1: this.countryForm.value.city1,
        city2: this.countryForm.value.city2,
        city3: this.countryForm.value.city3
      };

      this.countryService.addCountry(newCountry).subscribe(() => {
        this.loadCountries();
        this.countryForm.reset();
      });
    }
  }
}
