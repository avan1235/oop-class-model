package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    // TODO: play with bank:
    // - add new clients
    // - add different actions on clients accounts
    //    * try to do it with some bigger collections of actions (maybe even use streams)
    final var exAction = new DepositBankAction(200,new Timestamp(10),new Timestamp(1000));
    System.out.println(exAction);

//    System.out.println(bank);
  }
}
