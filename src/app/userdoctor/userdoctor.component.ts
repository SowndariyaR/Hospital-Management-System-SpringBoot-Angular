import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userdoctor',
  templateUrl: './userdoctor.component.html',
  styleUrls: ['./userdoctor.component.css']
})
export class UserdoctorComponent implements OnInit {

  doctor!:Doctor[];
  constructor(private doctorService:DoctorService,private router:Router)
  {}
  ngOnInit(): void{
    this.getDoctors();
  }
  private getDoctors()
  {
    this.doctorService.getDoctorList().subscribe(data=>
      {
        this.doctor=data;
      });
  }

}