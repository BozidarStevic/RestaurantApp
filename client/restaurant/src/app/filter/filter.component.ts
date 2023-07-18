import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-filter-items',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  @Output() setNameFilter: EventEmitter<string> = new EventEmitter();
  
  public nameFilter: string;

  constructor() { 
    this.nameFilter = "";
  }

  ngOnInit(): void {
  }

  filterItems() {
    this.setNameFilter.emit(this.nameFilter);
  }

}
