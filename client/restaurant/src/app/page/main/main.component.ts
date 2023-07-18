import { Component, Input, OnInit } from '@angular/core';
import { AppService } from 'src/app/services/app.service';
import { Item } from 'src/app/model/item.model';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  items: Item[];

  public currentPage: number;
  public pageCount: number;

  @Input() public loggedIn: boolean;
  public nameFilter: string;

  constructor(private appService: AppService, private dataService: DataService) {
    this.items = [];
    this.currentPage = 0;
    this.pageCount = 0;
    
    this.loggedIn = false;
    this.nameFilter = "";
  }

  ngOnInit(): void {
    if (window.localStorage.getItem("loggedUser")) {
      this.loggedIn = true;
    }
    else {
      this.loggedIn = false;
    }
    this.getItems();
  }

  getItems() {
    this.appService
      .getItems(this.nameFilter, this.currentPage)
      .subscribe(resp => {this.items = resp; });

    this.appService
      .getItemsCount(this.nameFilter)
      .subscribe(resp => {this.pageCount = this.countPage(resp)});
  }

  filterItems(nameFilter: string) {
    this.nameFilter = nameFilter;
    this.getItems();
  }

  private countPage(num: number): number {
    if (num % 10 == 0) {
      return num / 10;
    }
    else {
      return Math.floor(num / 10) + 1;
    }
  }

  decrementPage() {
    if (this.currentPage > 0) {
      this.currentPage = this.currentPage - 1;
      this.getItems();
    }
  }

  incrementPage() {
    if (this.currentPage < this.pageCount - 1) {
      this.currentPage = this.currentPage + 1;
      this.getItems();
    }
    
  }

}
