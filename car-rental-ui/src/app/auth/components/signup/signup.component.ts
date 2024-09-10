import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  isSpinning: boolean = false;
  signupform!: FormGroup;

  constructor(
    private fb: FormBuilder
  ){}

  ngOnInit(){
    this.signupform = this.fb.group({
      name: [null,[Validators.required]],
      email: [null,[Validators.required,Validators.email]],
      password: [null,[Validators.required]],
      checkPassword: [null,[Validators.required,this.confirmation]]
    });
  }

  confirmation = (control: FormControl): {[s: string]:boolean}=>{
    if(!control.value){
      return {required: true};
    }else{
      return {confirm: true, error: true};
    }
    return {};
  };

  register(){
    console.log(this.signupform.value);
  }

}
