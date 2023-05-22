import { Component, OnInit } from '@angular/core';

import { Item } from '../Item';
import { DataService } from '../data.service';

@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {
  btnText = 'Cadastrar'

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
      
  }

  async createHandler(item: Item) {
    await this.dataService.create(item);
  }

}
