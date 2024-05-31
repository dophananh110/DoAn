import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpProviderService } from '../Service/http-provider.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  [x: string]: any;
  postList: any = [];
  theLoaiList: any = [];
  filterdPostList: any = [];
  constructor(private router: Router, private httpProvider: HttpProviderService, private fb: FormBuilder) { }
  searchForm!: FormGroup;
  ngOnInit(): void {
    this.searchForm = this.fb.group({
      search: ['']
    });
    this.searchForm.controls['search'].valueChanges.subscribe(query => {
      this.filterPosts(query);
    });
    this.getAllPost();
    this.getAllTheLoai();
  }

  filterPosts(query: string): void {
    if (!query) {
      this.filterdPostList = [...this.postList];
    } else {
      console.log(query);
      this.filterdPostList = this.postList.filter((post: any) =>
        post.tieuDe.toLowerCase().includes(query.toLowerCase()) ||
        post.noiDung.toLowerCase().includes(query.toLowerCase())
      );
    }
  }

  onSearchSubmit(): void {
    const query = this.searchForm.controls['search'].value;
    this.filterPosts(query);
  }



  async getAllPost() {
    this.httpProvider.getAllPost().subscribe((data: any) => {
      if (data != null && data.body != null) {
        var resultData = data.body;
        if (resultData) {
          this.postList = resultData;
          this.filterdPostList = resultData;
        }
      }
      (error: any) => {
        if (error) {
          if (error.status == 404) {
            if (error.error && error.error.message) {
              this.postList = [];
            }
          }
        }
      }
    })
  }
  addPost() {
    this.router.navigate(['AddPost']);
  }

  async getAllTheLoai() {
    this.httpProvider.getAllTheLoai().subscribe((data: any) => {
      if (data != null && data.body != null) {
        var resultData = data.body;
        if (resultData) {
          console.log(resultData);
          this.theLoaiList = resultData;
        }
      }
      (error: any) => {
        if (error) {
          if (error.status == 404) {
            if (error.error && error.error.message) {
              this.theLoaiList = [];
            }
          }
        }
      }
    })
  }
}
