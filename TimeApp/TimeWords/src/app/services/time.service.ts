import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from '../models/Event';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TimeService {
  
  constructor(private http: HttpClient) { }

  timeurl = "http://localhost:8080/events";

  getEvents(): Observable<Event[]>{
    return this.http.get<Event[]>(this.timeurl);
  }

  getTimeInString(time: String){
    return this.http.post(this.timeurl + "/gettime", {time}, httpOptions);
  }

  makeEvent(event: Event){
    return this.http.post(this.timeurl, event, httpOptions);
  }

}


