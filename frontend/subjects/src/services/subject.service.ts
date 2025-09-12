import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subject } from '../app/model/subjects';

@Injectable({ providedIn: 'root' })
export class SubjectService {
  private baseUrl = 'http://localhost:9090/api/subjects';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Subject[]> {
    return this.http.get<Subject[]>(this.baseUrl);
  }

  create(subject: Subject): Observable<Subject> {
    return this.http.post<Subject>(this.baseUrl, subject);
  }

  update(id: string, subject: Subject): Observable<Subject> {
    return this.http.put<Subject>(`${this.baseUrl}/${id}`, subject);
  }

  delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
