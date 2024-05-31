import { Component, OnInit } from '@angular/core';
import { HttpProviderService } from '../Service/http-provider.service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-post',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './edit-post.component.html',
  styleUrl: './edit-post.component.scss'
})
export class EditPostComponent implements OnInit {
  [x: string]: any;
  postList: any = [];
  theLoaiList: any = [];
  constructor(private route: ActivatedRoute,
    private router: Router, private httpProvider: HttpProviderService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getAllPost();
    this.getAllTheLoai();
  }

  async getAllPost() {
    this.httpProvider.getListByTheLoai(this.route.snapshot.params["codeType"]).subscribe((data: any) => {
      if (data != null && data.body != null) {
        var resultData = data.body;
        console.log(resultData);
        if (resultData) {
          this.postList = resultData;
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
