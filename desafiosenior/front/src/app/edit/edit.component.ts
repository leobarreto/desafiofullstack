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

      if(this.formData.unidadeMedida == 'KG'){
        this.formData.value = 0;
        this.formData.desc = "Quilograma"
      } else if (this.formData.unidadeMedida == 'LT'){
        this.formData.value = 1;
        this.formData.desc = "Litro(s)"
      } else {
        this.formData.value = 2;
        this.formData.desc = "Unidade"
      }
    });
  }

  update() {
    // console.log(this.formData);
    this.dataService.update(this.formData);
  }

}
