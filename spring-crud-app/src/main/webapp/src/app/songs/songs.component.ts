import { Component, OnInit } from '@angular/core';
import {SongsService} from "./songs.service";
import {Song} from "./song.model";
import {Observable} from "rxjs/Observable";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.css'],
  providers: [SongsService]
})
export class SongsComponent implements OnInit {

  songs: Song[] = [];
  newSong: Song = new Song(0, '');
  constructor(private songsService: SongsService) { }

  ngOnInit() {
    this.songsService.findAll().subscribe(
      (songs: any[]) => {this.songs = songs},
      (error)=> console.log(error)
    );
  }
  onSongAdd() {
    if(!this.checkValidity(this.newSong)){
      return;
    }

    this.songsService.addSong(this.newSong)
      .catch(
        (response: Response) => {
          alert(response.text);
          return Observable.throw(response);
        }
      )
      .subscribe(
        (song: Song) => {
          this.newSong = new Song(0, '');
          this.songsService.onSongAdded.emit(song);
        }
      );
  }

  onSongDelete(song: Song) {
    this.songsService.delete(song.id)
      .subscribe(
        () => {
          this.songsService.onSongDeleted.emit(song);
        }
      );
  }

  onSongEdit(song: Song){
    if(!this.checkValidity(song)){
      return;
    }

    let oldSong: Song;
    this.songsService.getSong(song.id)
      .subscribe(
        (old: Song) => {
          oldSong = old;
          alert(oldSong);

          if(!isNullOrUndefined(oldSong)) {
            if (oldSong.name != song.name) {
              this.songsService.editSong(song.id, song.name).subscribe();
            }
          }
        }
      );
  }

  checkValidity(song:Song){
    if (song.name.trim().length == 0) {
      alert("Name can't be empty");
      return false;
    }
    return true;
  }
}
