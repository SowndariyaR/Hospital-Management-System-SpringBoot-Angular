import { Component } from '@angular/core';
import { NavbarService } from '../navbar.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {

/*  email: string = "";
  password: string = "";

  constructor(private router: Router, private http: HttpClient, private navbarService: NavbarService) { }

  userlogin() {
    console.log(this.email);
    console.log(this.password);

    let bodyData = {
      email: this.email,
      password: this.password,
    };

    this.http.post("http://localhost:8080/api/v1/user/login", bodyData).subscribe((resultData: any) => {
      console.log(resultData);

      if (resultData.message == "Email not exits") {
        alert("Email not exits");
      } else if (resultData.message == "Login Success") {
        const userName = this.extractNameFromEmail(this.email);
        this.router.navigate(['/userhome'], { queryParams: { name: userName } });
      } else {
        alert("Incorrect Email and Password not match");
      }
    });
  }

  private extractNameFromEmail(email: string): string {
    const atIndex = email.indexOf('@');
    if (atIndex !== -1) {
      return email.substring(0, atIndex);
    }
    return email; // If no '@' found, return the whole email as the name
  }*/
  email: string = '';
  password: string = '';

  constructor(private router: Router, private httpClient: HttpClient) {}
  guide(){
    confirm("Welcome. If you are a previous user, please provide your login credentials below to sign in.");
    confirm("If you are a new user, click on 'Register' to sign up.");
    confirm("If you are an admin, scroll down, click on 'Admin Login', provide your admin credentials, and sign in to the admin dashboard.");
   confirm("Thank you.");
    
  }

  navigateToRegistration() {
    this.router.navigate(['/userregister']);
  }

  userLogin() {
    const credentials = {
      email: this.email,
      password: this.password
    };

    this.httpClient.post('http://localhost:8080/api/v1/user/login', credentials).subscribe(
      (response: any) => {
        alert("Login successful");
        console.log('Login successful:', response);
        this.router.navigate(['/userhome']);
      },
      (error: any) => {
        alert("Login failed. Please check your credentials.");
        console.error('Login failed:', error);
      }
    );
  }

}
