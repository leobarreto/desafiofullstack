import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  formData: any = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.dataService.getData().subscribe(formData => {
      this.formData = formData;
    });
  }

}
