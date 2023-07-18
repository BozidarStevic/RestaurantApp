import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'restaurant';

  loggedIn: boolean;

  constructor(private router: Router, private dataService: DataService) { 
    this.loggedIn = false;
  }

  ngOnInit(): void {
    this.dataService.login.subscribe((resp) =>
    resp.valueOf() ? (this.loggedIn = true) : (this.loggedIn = false)
    );
    if (window.localStorage.getItem("loggedUser")) {
      this.loggedIn = true;
    }
    else {
      this.loggedIn = false;
    }
  }

  logout(){
    window.localStorage.clear();
    this.dataService.changeLoginStatus(false);
    this.loggedIn = false;
    window.location.reload();
  }

}
