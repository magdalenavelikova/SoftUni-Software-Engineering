import {Component, Input, OnInit} from '@angular/core';
import { Book } from '../model/book';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.scss']
})
export class BookDetailComponent implements OnInit {

  @Input() book?: Book;

  constructor() { }

  ngOnInit(): void {
  }

}
