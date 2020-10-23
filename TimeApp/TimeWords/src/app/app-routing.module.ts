import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TimeComponent } from './time/time.component';
import { EventFormComponent } from './event-form/event-form.component';

const routes: Routes = [
  {path: 'home', component: TimeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'makeevent', component: EventFormComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
