import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, Subject } from 'rxjs';
import { CategoryInterface, Item, User } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private itemsUrl = 'http://localhost:8080/api/items';
  private userUrl = 'http://localhost:8080/api/user';
  private categoriesUrl = 'http://localhost:8080/api/categories';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { 
  }

  getItems(nameFilter: string, currentPage: number): Observable<Item[]> {
    return this.http
      .get<Item[]>(
        `${this.itemsUrl}?name=${nameFilter}&page=${currentPage}`
      );
  }

  getItemsCount(nameFilter: string): Observable<number> {
    return this.http
      .get<number>(
        `${this.itemsUrl}/count?name=${nameFilter}`
      );
  }

  getCategories(): Observable<CategoryInterface[]> {
    return this.http
      .get<CategoryInterface[]>(`${this.categoriesUrl}`)
      .pipe(catchError(this.handleError<Item[]>('getCategories', [])));
  }

  addItem(item: Item): Observable<Item> {
    return this.http
      .post<Item>(this.itemsUrl, item, this.httpOptions)
      .pipe(catchError(this.handleError<Item>('addItem')));
  }

  login(username: string, password: string): Observable<User> {
    return this.http
      .get<User>(`${this.userUrl}?username=${username}&password=${password}`)
      .pipe(catchError(this.handleError<User>('login')));
  }

  deleteItem(id: number | undefined): Observable<Item> {
    const url = `${this.itemsUrl}/${id}`;

    return this.http
      .delete<Item>(url, this.httpOptions)
      .pipe(catchError(this.handleError<Item>('deleteItem')));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
