import {Component, OnInit} from "@angular/core";
import {BitcoinTransactionService} from "./transaction.service";
import {BitcoinTransaction} from "./transaction.model";
import {Observable} from "rxjs/Observable";
import {tryParse} from "selenium-webdriver/http";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  providers: [BitcoinTransactionService]
})
export class TransactionsComponent implements OnInit {
  transactions: BitcoinTransaction[] = [];
  addingTransaction: BitcoinTransaction = new BitcoinTransaction(0, '', '', '');

  constructor(private transactionService: BitcoinTransactionService) {

  }

  ngOnInit() {
    // initial load of data
    this.transactionService.getAll()
      .subscribe(
        (transactions: any[]) => {
          this.transactions = transactions
        },
        (error) => console.log(error)
      );
    // get notified when a new transaction has been added
    this.transactionService.onTransactionAdded.subscribe(
      (transaction: BitcoinTransaction) => this.transactions.push(transaction)
    );
    this.transactionService.onTransactionDeleted.subscribe(
      (transaction: BitcoinTransaction) => this.transactions.splice(this.transactions.indexOf(transaction), 1)
    );
  }

  onTransactionAdd() {
    if(!this.checkValidity(this.addingTransaction)){
      return;
    }

    this.transactionService.add(this.addingTransaction)
      .catch(
        (response: Response) => {
          alert(response.text);
          return Observable.throw(response);
        }
      )
      .subscribe(
        (newTransaction: BitcoinTransaction) => {
          this.addingTransaction = new BitcoinTransaction(0, '', '', '');
          this.transactionService.onTransactionAdded.emit(newTransaction);
        }
      );
  }

  onTransactionDelete(transaction: BitcoinTransaction) {
    this.transactionService.delete(transaction.id)
      .subscribe(
        () => {
          this.transactionService.onTransactionDeleted.emit(transaction);
        }
      );
  }

  onTransactionEdit(transaction: BitcoinTransaction){
    if(!this.checkValidity(transaction)){
      return;
    }

    let oldTransaction: BitcoinTransaction;
    this.transactionService.get(transaction.id)
      .subscribe(
        (old: BitcoinTransaction) => {
          oldTransaction = old;
          alert(oldTransaction);

          if(!isNullOrUndefined(oldTransaction)) {
            if (oldTransaction.sender != transaction.sender) {
              this.transactionService.editSender(transaction.id, transaction.sender).subscribe();
            }
            if (oldTransaction.recipient != transaction.recipient) {
              this.transactionService.editRecipient(transaction.id, transaction.recipient).subscribe();
            }
            if (oldTransaction.amount != transaction.amount) {
              this.transactionService.editAmount(transaction.id, parseFloat(transaction.amount)).subscribe();
            }
          }
        }
      );
  }

  checkValidity(transaction:BitcoinTransaction){
    if (transaction.sender.trim().length == 0) {
      alert("Please write sender");
      return false;
    }
    if(transaction.recipient.trim().length==0){
      alert("Please write recipient");
      return false;
    }
    if(parseFloat(transaction.amount).toString() != transaction.amount){
      alert("Please write correct amount");
      return false;
    }

    return true;
  }
}
