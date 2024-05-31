import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WebApiService } from './web-api.service';

var apiUrl = "http://localhost:8087";

var httpLink = {
  getAllPost: apiUrl + "/tintuc",
  deletePostById: apiUrl + "/api/post/deletePostById",
  getPostDetailById: apiUrl + "/tintuc/",
  savePost: apiUrl + "/tintuc/DangBai",
  getAllTheLoai: apiUrl + "/theloai",
  getListTheLoai: apiUrl + "/tintuc/list/"
}

@Injectable({
  providedIn: 'root'
})

export class HttpProviderService {
  constructor(private webApiService: WebApiService) { }

  public getAllPost(): Observable<any> {
    return this.webApiService.get(httpLink.getAllPost);
  }
  public deletePostById(model: any): Observable<any> {
    return this.webApiService.post(httpLink.deletePostById + '?id=' + model, "");
  }
  public getPostDetailById(model: any): Observable<any> {
    return this.webApiService.get(httpLink.getPostDetailById + model);
  }
  public savePost(model: any): Observable<any> {
    return this.webApiService.post(httpLink.savePost, model);
  }
  public getAllTheLoai(): Observable<any> {
    return this.webApiService.get(httpLink.getAllTheLoai);
  }
  public getListByTheLoai(model: any): Observable<any> {
    return this.webApiService.get(httpLink.getListTheLoai + model);
  }
}
