import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  public listCategories(){
    return this.http.get(`${baseUrl}categoria/`);
  }

  public addCategory(category:any){
    return this.http.post(`${baseUrl}categoria/`,category);
  }
}
