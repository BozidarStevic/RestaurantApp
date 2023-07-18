import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AppService } from 'src/app/services/app.service';
import { User } from 'src/app/model/item.model';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  username: string;
  password: string;

  constructor(private appService: AppService, private router: Router, private dataService: DataService) { 
    this.username = '';
    this.password = '';
  }

  ngOnInit(): void {
  }
  
  login(){
    this.appService.login(this.username, this.password).subscribe((res) => {
      if(res != null) {
        window.localStorage.setItem('loggedUser', JSON.stringify(res));
        this.dataService.changeLoginStatus(true);
        this.router.navigate(['/main']);

      } else {
        alert("Username or password is wrong!");
      }      
    });
  }

}
