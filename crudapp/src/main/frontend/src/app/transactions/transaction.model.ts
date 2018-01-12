export class BitcoinTransaction {
  public id: number;
  public sender: string;
  public recipient: string;
  public amount: string;

  constructor(id: number, sender: string, recipient: string, amount: string) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
  }

}
