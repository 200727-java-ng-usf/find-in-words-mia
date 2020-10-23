import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Event } from '../models/Event';
import { TimeService } from '../services/time.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent implements OnInit {

  name: String;
  loc: String;
  time: String;

  constructor(private timeService: TimeService,  private router: Router) { }

  ngOnInit(): void {
  }

  
  async onSubmit() {

    let newEvent = new Event(this.name, this.loc, this.time);
    console.log(newEvent);
    await this.timeService.makeEvent(newEvent).subscribe(
      resp => {
        this.router.navigate([`/home`]);
      }
    )
  }
}
