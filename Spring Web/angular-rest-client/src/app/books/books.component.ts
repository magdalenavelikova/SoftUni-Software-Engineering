import { Component, OnInit } from '@angular/core';
import {BookService} from "../service/book.service";
import {Book} from "../model/book";


@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.bookService.
    getBooks().
    subscribe(books => this.books = books)
  }

}
