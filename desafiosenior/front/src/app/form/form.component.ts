import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  formData: any = {};

  constructor(private dataService: DataService) { }

  ngOnInit(): void {

  }

  create() {
    this.dataService.create(this.formData);
  }

}
