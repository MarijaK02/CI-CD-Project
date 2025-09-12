import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SubjectService } from '../../../services/subject.service';
import { Subject } from '../../model/subjects';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  selector: 'app-subject',
  templateUrl: './subject-list.component.html',
  styleUrl: './subject-list.component.css'
})
export class SubjectListComponent implements OnInit {
  subjects: Subject[] = [];
  newSubject: Subject = {
    name: '', description: '', credits: 0,
    id: ''
  };

  constructor(private service: SubjectService) {}

  ngOnInit() { this.load(); }

  load() { this.service.getAll().subscribe(data => this.subjects = data); }

  add() {
    this.service.create(this.newSubject).subscribe(() => {
      this.newSubject = { name: '', description: '', credits: 0 };
      this.load();
    });
  }

  update(subject: Subject) {
    if (subject.id) this.service.update(subject.id, subject).subscribe(() => this.load());
  }

  delete(subject: Subject) {
    if (subject.id) this.service.delete(subject.id).subscribe(() => this.load());
  }
}
