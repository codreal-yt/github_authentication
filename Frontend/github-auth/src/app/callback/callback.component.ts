import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserIdService } from './user-id.service';
import { User } from '../model/user';

@Component({
  selector: 'app-callback',
  templateUrl: './callback.component.html',
  styleUrls: ['./callback.component.css']
})
export class CallbackComponent {
  UserID = "";
  user: User = new User();

  constructor(
    private route: ActivatedRoute,
    private userServie : UserIdService
    ) {}

  ngOnInit() {
    const code = this.route.snapshot.queryParamMap.get('code');
    console.log('Code:', code);

    this.userServie.getUserID(code).subscribe((data)=>{
     console.log(data);
     
    },(error)=>{
      console.log(error.error.text);
      this.UserID =error.error.text;
    })

    this.startTimer();
  }


  startTimer() {
    setTimeout(() => {
      this.addUser();
    }, 30000); // 30 seconds in milliseconds
  }

  addUser() {
    // Put your code here that you want to execute after 30 seconds
    console.log('Method executed after 30 seconds.');
    this.user.userId = this.UserID;
    this.user.userPassword = this.UserID;

    this.userServie.addUser(this.user).subscribe((data)=>{
      console.log(data);
     },(error)=>{
       console.log(error.error.text);
     })
  }

}
