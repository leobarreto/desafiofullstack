import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes, provideRouter, withComponentInputBinding } from '@angular/router';
import { CurrencyMaskModule } from 'ng2-currency-mask';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { TopComponent } from './top/top.component';
import { PanelComponent } from './panel/panel.component';
import { ListComponent } from './list/list.component';
import { EditComponent } from './edit/edit.component';
import { NewItemComponent } from './new-item/new-item.component';

const routes: Routes = [
  { path: 'create', component: NewItemComponent },
  { path: 'list', component: ListComponent },
  { path: 'edit/:id', component: EditComponent, pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    TopComponent,
    PanelComponent,
    ListComponent,
    EditComponent,
    NewItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    CurrencyMaskModule
  ],
  providers: [
    provideRouter(routes, withComponentInputBinding()),
  ],
  bootstrap: [AppComponent]
})
  export class AppModule { };
