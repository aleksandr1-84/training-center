import {EventEmitter, Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import "rxjs/Rx"

import {Observable} from "rxjs/Observable";
import {Song} from "./song.model";

@Injectable()
export class SongsService {

  onSongAdded = new EventEmitter<Song>();
  onSongDeleted= new EventEmitter<Song>();


  constructor(private http: Http) { }

  findAll(){
    return this.http.get('/songs').map(
      (response: Response) => {return response.json();}
    );
  }
  delete(id: number) {
    return this.http.delete('/delete-song/' + id).map(res => res.json);
  }
  editSong(id: number, songName: string){
    return this.http.post('/edit/song/' + id + '/' + songName, {}).map(res => res.json)
  }
  addSong(song: Song){
    return this.http.post('/new-song', song).map((response: Response) => {
      return response.json();
    });
  }
  getSong(id: number){
    return this.http.get('/get-song/' + id).map((response: Response) => response.json());
  }
}
