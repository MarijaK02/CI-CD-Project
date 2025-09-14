import { Routes } from '@angular/router';
import { SubjectListComponent } from './components/subject-list/subject-list.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'subjects', component: SubjectListComponent },
];

