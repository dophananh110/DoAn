import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpProviderService } from '../Service/http-provider.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-post',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './add-post.component.html',
  styleUrl: './add-post.component.scss'
})

export class AddPostComponent implements OnInit {
  postForm!: FormGroup;
  theLoaiList: any = [];
  constructor(private httpProvider: HttpProviderService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
    this.getAllTheLoai();
  }

  initForm(): void {
    this.postForm = this.fb.group({
      moTa: ['', [Validators.required, Validators.maxLength(1000)]],
      noiDung: ['', [Validators.required, Validators.maxLength(1000)]],
      thumbnail: ['', [Validators.required]],
      tieuDe: ['', [Validators.required, Validators.maxLength(1000)]],
      theLoai: this.fb.group({
        id: [''],
        code: [''],
        theLoai: ['']
      })
    })
  }


  onSubmit() {
    console.log(this.postForm.value);
    this.httpProvider.savePost(this.postForm.value).subscribe((res) => {
      if (res != null) {
        console.log(res);
      }
      (error: any) => {
        if (error) {
          console.log(error.status);
        }
      }
    })
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
    });
  }

}
