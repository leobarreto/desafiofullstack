import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  formData: any = [];
  id: number = 0;
  checked: number = -1;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(ret => {
      this.id = ret['id'];
    });
    this.findById(this.id);
  }

  findById(id: any) {
    this.dataService.getDataById(this.id).subscribe(formData => {
      this.formData = formData;
    });
  }

  update() {
    this.dataService.update(this.formData);
  }

}
