import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }

  
  private loginSubject = new BehaviorSubject<boolean>(false);
  login = this.loginSubject.asObservable();

  changeLoginStatus(val: boolean) {
    this.loginSubject.next(val);
  }


  private itemSubject = new Subject<Item>();
  itemEdit$ = this.itemSubject.asObservable();

  public setItemForEdit(item: Item) {
    this.itemSubject.next(item);
  }

}