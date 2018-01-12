import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {BitcoinTransaction} from "./transaction.model";
import {EventEmitter, Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

@Injectable()
export class BitcoinTransactionService {
  onTransactionAdded = new EventEmitter<BitcoinTransaction>();
  onTransactionDeleted = new EventEmitter<BitcoinTransaction>();

  constructor(private http: Http) {
  }

  add(transaction: BitcoinTransaction) {
    return this.http.post('/api/add', transaction)
      .map(
        (response: Response) => {
          return response.json();
        }
      );
  }

  delete(id: number) {
    return this.http.delete('api/delete/' + id).map(res => res.json);
  }

  getAll(){
    return this.http.get('/api/getAll')
      .map(
        (response: Response) => {
          return response.json();
        }
      );
  }

  get(id: number){
    return this.http.get('/api/get/'+id)
      .map(
        (response: Response) => {
          return response.json();
        }
      );
  }

  editSender(id: number, sender: string) {
    return this.http.post('api/edit/sender/' + id + '/' + sender, {}).map(res => res.json);
  }

  editRecipient(id: number, recipient: string) {
    return this.http.post('api/edit/recipient/' + id + '/' + recipient, {}).map(res => res.json);
  }

  editAmount(id: number, amount: number) {
    return this.http.post('api/edit/amount/' + id + '/' + amount, {}).map(res => res.json);
  }
}
