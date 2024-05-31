import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpProviderService } from '../Service/http-provider.service';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-post',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-post.component.html',
  styleUrl: './view-post.component.scss'
})
export class ViewPostComponent implements OnInit {
  @Input() viewMode = false;
  theLoaiList: any = [];
  @Input() currentPost: any = {
    moTa: '',
    noiDung: '',
    thumbnail: '',
    tieuDe: '',
    theLoai: ''
  };
  constructor(private route: ActivatedRoute,
    private router: Router, private httpProvider: HttpProviderService) { }
  message = '';
  ngOnInit(): void {
    this.getAllTheLoai();
    if (!this.viewMode) {
      this.message = '';
      this.getPost(this.route.snapshot.params["id"]);
    }
  }

  getPost(id: string): void {
    this.httpProvider.getPostDetailById(id)
      .subscribe({
        next: (data) => {
          this.currentPost = data.body;
          console.log(this.currentPost);
        },
        error: (e) => console.error(e)
      });
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
