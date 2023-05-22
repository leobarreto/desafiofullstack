import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  formData: any = [];
  id: number = 0;

  constructor(private dataService: DataService,
    private location: Location) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.dataService.getData().subscribe(formData => {
      this.formData = formData;
    });
  }

  delete(id: any){
    this.dataService.delete(id);
    window.location.reload();
  }

}
