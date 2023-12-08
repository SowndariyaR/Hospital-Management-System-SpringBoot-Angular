import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { IndexComponent } from './index/index.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserregisterComponent } from './userregister/userregister.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { CreatedoctorComponent } from './createdoctor/createdoctor.component';
import { UpdatedoctorComponent } from './updatedoctor/updatedoctor.component';
import { DoctorlistComponent } from './doctorlist/doctorlist.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { UserApointmentComponent } from './user-apointment/user-apointment.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { UserdoctorComponent } from './userdoctor/userdoctor.component';
import { UpdateappointmentComponent } from './updateappointment/updateappointment.component';

const routes: Routes = [
  {path:'',component:IndexComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'adminpage',component:AdminpageComponent},

  {path:'userhome',component:UserhomeComponent},
  {path:'userlogin',component:UserloginComponent},
  {path:'userregister',component:UserregisterComponent},
  {path: 'userhome/appointment',component:UserApointmentComponent},

  {path:'adminpage/Doctor/createdoctor',component:CreatedoctorComponent},
  {path:'adminpage/Doctor/doctordetails/:id', component:DoctordetailsComponent},
  {path:'adminpage/Doctor/updatedoctor/:id', component:UpdatedoctorComponent},
  {path:'adminpage/Doctor', component:DoctorlistComponent},
  {path:'adminpage/Doctor/book-appointment', component:BookAppointmentComponent},

  {path:'adminpage/Appointment', component:BookAppointmentComponent},
  {path:'adminpage/Appointment/updateappointment/:id', component:UpdateappointmentComponent},

  {path:'userhome/aboutus', component:AboutusComponent},
  {path:'userhome/Doctor', component:UserdoctorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
