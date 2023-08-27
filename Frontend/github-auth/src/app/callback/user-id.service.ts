import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})

export class UserIdService {

  baseUrl = "http://localhost:8080"

  constructor(private httpClient: HttpClient) { }


  public getUserID(pid:any){
    return this.httpClient.get(this.baseUrl + "/api/callback?code="+ pid)
  }

  public addUser(user: User){
    return this.httpClient.post<User>(this.baseUrl + "/user/registerNewUser", user)
  }
 
}
