import { Routes } from '@angular/router';
import { SubjectListComponent } from './components/subject-list/subject-list.component';

export const routes: Routes = [
  { path: '', redirectTo: 'subjects', pathMatch: 'full' },
  { path: 'subjects', component: SubjectListComponent },
];

