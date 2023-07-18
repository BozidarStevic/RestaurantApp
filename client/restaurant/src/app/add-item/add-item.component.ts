import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryInterface, Item } from '../model/item.model';
import { AppService } from '../services/app.service';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  @Output() newItemAdded: EventEmitter<Item> = new EventEmitter();

  public newItem: Item;
  public categories: CategoryInterface[] = [];

  constructor(private dataService: DataService, private appService: AppService, private router: Router) { 
    this.dataService.itemEdit$.subscribe
      ((item: Item) => { this.populateItemForEdit(item) });

    this.newItem = {
      id: 0,
      name: '',
      category: {},
      price: 0
    };
  }

  ngOnInit(): void {
    this.loadCategories();
  }

  populateItemForEdit(item: Item) {
    this.newItem = Object.assign({}, item);
  }

  loadCategories() {
    this.appService.getCategories().subscribe((res: CategoryInterface[]) => {
      this.categories = res;
    });
  }

  addItem() {
    this.appService.addItem(this.newItem).subscribe(res => {
      if (this.newItem.id) 
        alert(`Item ${res.name} is updated`);
      else
      alert(`Item ${res.name} is created`);

      this.newItemAdded.emit();

      this.newItem = {
        id: 0,
        name: '',
        category: {},
        price: 0
      };
    });
  }

}
