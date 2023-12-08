/*
import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { FormGroup } from '@angular/forms';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createdoctor',
  templateUrl: './createdoctor.component.html',
  styleUrls: ['./createdoctor.component.css']
})
export class CreatedoctorComponent implements OnInit {
  doctor: Doctor = new Doctor();
  doctorForm!: FormGroup;

  constructor(
    protected doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void{

  }
  saveDoctor()
  {
    this.doctorService.createDoctor(this.doctor).subscribe((data:any)=>
    {
      console.log(data);
      this.goToDoctorList();
    },
    (error:any)=>console.log(error));
  }
  goToDoctorList()
  {
    this.router.navigate(['/adminpage/Doctor']);
  }
  onSubmit()
  {
    console.log(this.doctor);
    this.saveDoctor();
  }


}*/

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// Make sure to import the correct Doctor model
import { MatSnackBar } from '@angular/material/snack-bar';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Observable, Subscriber } from 'rxjs';
// Update the import statement



@Component({
  selector: 'app-create-doctor',
  templateUrl: './createdoctor.component.html',
  styleUrls: ['./createdoctor.component.css']
})
export class CreatedoctorComponent  implements OnInit {
  doctorForm: FormGroup;
  doctorObj: Doctor = new Doctor();
  file!: any[];

  constructor(private _snackBar: MatSnackBar, private doctorService: DoctorService) {
    this.doctorForm = new FormGroup({
      firstname: new FormControl("", [Validators.required]),
      lastname: new FormControl("", [Validators.required]),
      description: new FormControl("", [Validators.required]),
      licenseNumber: new FormControl("", [Validators.required]),
      speciliazation: new FormControl("", [Validators.required]),
      location: new FormControl("", [Validators.required]),
      experience: new FormControl("", [Validators.required])
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
    if (!this.doctorForm.invalid) {
      console.log(this.doctorForm.value);

      this.doctorObj.firstname = this.doctorForm.value.firstname;
      this.doctorObj.lastname = this.doctorForm.value.lastname;
      this.doctorObj.description = this.doctorForm.value.description;
      this.doctorObj.licenseNumber = this.doctorForm.value.licenseNumber;
      this.doctorObj.speciliazation = this.doctorForm.value.speciliazation;
      this.doctorObj.location = this.doctorForm.value.location;
      this.doctorObj.experience = this.doctorForm.value.experience;

      this.doctorService.createDoctor(this.doctorObj).subscribe((data) => {
        console.log(data);
        this.popup('Doctor added successfully', 'Success');
      });

      // To reset the form
      this.doctorForm.reset();
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
