import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../model/item.model';
import { AppService } from '../services/app.service';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  @Input() items: Item[];
  item: Item;

  @Input() public loggedIn: boolean;

  @Output() itemDeleted: EventEmitter<Item> = new EventEmitter();

  constructor(private dataService: DataService, private appService: AppService, private router: Router) { 
    this.items = [];
    this.item = new Item({
      name: "",
      category: {},
      price : 0
    });
    this.loggedIn = false;


    
  }

  ngOnInit(): void {
    if (window.localStorage.getItem("loggedUser")) {
      this.loggedIn = true;
    }
    else {
      this.loggedIn = false;
    }
  }

  deleteItem(id:number | undefined){
    this.appService.deleteItem(id).subscribe(res => {
      alert(`Item ${res.name} is deleted!`);
      this.itemDeleted.emit();
    });
  }

  editItem(item: Item) {
    this.dataService.setItemForEdit(item);
  }

}
