import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { DataService } from '../data.service';
import { Item } from '../Item';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  @Output()
  onSumbit = new EventEmitter<Item>();

  @Input()
  btnText!: String;

  @Input()
  itemData: Item | null = null;

  createForm!: FormGroup;
  formData: any = {};
  item!: Item;

  constructor(private dataService: DataService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.createForm = new FormGroup({
      nomeItem: new FormControl(this.itemData ? this.itemData.nomeItem : '', [Validators.required]),
      unidadeMedida: new FormControl(this.itemData ? this.itemData.unidadeMedida : '', [Validators.required]),
      valorItem: new FormControl(this.itemData ? this.itemData.valorItem : '', [Validators.required]),
      dtFabricacao: new FormControl(this.itemData ? this.itemData.dtFabricacao : '', [Validators.required]),
      qtItem: new FormControl(this.itemData ? this.itemData.qtItem : ''),
      perecivel: new FormControl(this.itemData ? this.itemData.perecivel : ''),
      dtValidade: new FormControl(this.itemData ? this.itemData.dtValidade : '')
    });
  }

  get nomeItem() {
    return this.createForm.get('nomeItem')!;
  }

  get unidadeMedida() {
    return this.createForm.get('unidadeMedida')!;
  }

  get qtItem() {
    return this.createForm.get('qtItem')!;
  }

  get valorItem() {
    return this.createForm.get('valorItem')!;
  }

  get dtFabricacao() {
    return this.createForm.get('dtFabricacao')!;
  }

  get perecivel() {
    return this.createForm.get('perecivel')!;
  }

  get dtValidade() {
    return this.createForm.get('dtValidade');
  }

  submit() {
    if (this.createForm.invalid) {
      return;
    }

    this.onSumbit.emit(this.createForm.value);

    window.location.reload();
  }

}
