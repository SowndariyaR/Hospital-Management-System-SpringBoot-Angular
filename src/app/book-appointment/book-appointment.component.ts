import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {

  appointment!:Appointment[];
  constructor(private appointmentService:AppointmentService,private router:Router)
  {}
  ngOnInit(): void{
    this.getAppointments();
  }
  private getAppointments()
  {
    this.appointmentService.getAppointmentList().subscribe(data=>
      {
        this.appointment=data;
      });
  }
  updateAppointment(id:number)
  {
    this.router.navigate(['adminpage/Appointment/updateappointment',id]);  
  }
  deleteAppointment(id:number)
  {
    this.appointmentService.deleteAppointment(id).subscribe(data=>
      {
        console.log(data);
        this.getAppointments();
      });
  }

}
