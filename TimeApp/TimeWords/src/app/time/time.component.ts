import { Component, OnInit } from '@angular/core';
import { TimeService } from '../services/time.service';
import { time } from '../models/time';
import { Event } from '../models/Event';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  clock;
  time: time;
  events: Event[];

  constructor(private timeService: TimeService) { }

  async ngOnInit(): Promise<void> {
    let date: Date = new Date();  
    
    let hours = date.getHours();
    let minutes = date.getMinutes(); 

    let Time = hours.toString() + ":" + minutes.toString();
    await this.timeService.getTimeInString(Time).subscribe(
      response =>
      {
        console.log(response);
        this.clock = setInterval(() => {
          this.time = <time> response;
        }, 1000);
      }
    );

    await this.timeService.getEvents().subscribe(
      resp =>
      {
        this.events = resp as Event[];
      }
    )
  }

  

}
