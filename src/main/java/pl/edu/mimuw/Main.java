package pl.edu.mimuw;

import java.io.IOException;
xd
public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    // TODO: play with bank:
    // - add new clients
    // - add different actions on clients accounts
    //    * try to do it with some bigger collections of actions (maybe even use streams)

    System.out.println(bank);
  }
}
