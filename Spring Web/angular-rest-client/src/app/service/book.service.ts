import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Book} from "../model/book";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private booksUrl = 'http://localhost:8080/api/books';

  constructor(private http: HttpClient) {}

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl)
  }
}
