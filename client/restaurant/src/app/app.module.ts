import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './page/main/main.component';
import { LoginPageComponent } from './page/login-page/login-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { ItemListComponent } from './item-list/item-list.component';
import { FilterComponent } from './filter/filter.component';
import { AddItemComponent } from './add-item/add-item.component';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginPageComponent,
    PageNotFoundComponent,
    ItemListComponent,
    FilterComponent,
    AddItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
