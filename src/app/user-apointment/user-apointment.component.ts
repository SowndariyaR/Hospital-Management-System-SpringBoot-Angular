import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Observable, Subscriber } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-user-apointment',
  templateUrl: './user-apointment.component.html',
  styleUrls: ['./user-apointment.component.css']
})
export class UserApointmentComponent implements OnInit {
  appointmentForm: FormGroup;
  appointmentObj: Appointment = new Appointment();
  file!: any[];

  constructor(private _snackBar: MatSnackBar, private appointmentService: AppointmentService) {
    this.appointmentForm = new FormGroup({
      patientname: new FormControl("", [Validators.required]),
      appointmentDate: new FormControl("", [Validators.required]),
      appointmentTime: new FormControl("", [Validators.required]),
      doctorname: new FormControl("", [Validators.required]),
      description: new FormControl("", [Validators.required])
    });
  }

  ngOnInit() {}

  onChange = ($event: Event) => {
    const target = $event.target as HTMLInputElement;
    const file: File = (target.files as FileList)[0];
    this.convertToBase64(file);
  }

  convertToBase64(file: File) {
    const observable = new Observable((subscriber: Subscriber<any>) => {
      this.readFile(file, subscriber);
    });
  }

  readFile(file: File, subscriber: Subscriber<any>) {
    const filereader = new FileReader();
    filereader.readAsDataURL(file);

    filereader.onload = () => {
      subscriber.next(filereader.result);
      subscriber.complete();
    };

    filereader.onerror = () => {
      subscriber.error();
      subscriber.complete();
    };
  }

  onSubmit() {
    if (!this.appointmentForm.invalid) {
      console.log(this.appointmentForm.value);

      this.appointmentObj.patientname = this.appointmentForm.value.patientname;
      this.appointmentObj.appointmentDate = this.appointmentForm.value.appointmentDate;
      this.appointmentObj.appointmentTime = this.appointmentForm.value.appointmentTime;
      this.appointmentObj.doctorname = this.appointmentForm.value.doctorname;
      this.appointmentObj.description = this.appointmentForm.value.description;

      this.appointmentService.createAppointment(this.appointmentObj).subscribe((data) => {
        console.log(data);
        this.popup('Appointment booked successfully', 'Success');
      });

      // To reset the form
      this.appointmentForm.reset();
    } else {
      this.popup('Input error', 'Retry');
    }
  }

  popup(var1: string, var2: string | undefined) {
    this._snackBar.open(var1, var2, {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }
}
