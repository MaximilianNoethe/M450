package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
class AccountTests {
    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
       void testInit() {
           Account acc = new SavingsAccount("A123");
           assertEquals("A123", acc.getId());
           assertEquals(0, acc.getBalance());
           assertTrue(acc instanceof Account);
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
       void testDeposit() {
           Account acc = new SavingsAccount("A123");
           boolean result = acc.deposit(0, 500_000); // 5 CHF
           assertTrue(result);
           assertEquals(500_000, acc.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
       void testWithdraw() {
           Account acc = new SavingsAccount("A123");
           acc.deposit(0, 500_000); // 5 CHF
           // Withdraw less than balance
           assertTrue(acc.withdraw(1, 200_000));
           assertEquals(300_000, acc.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
       void testReferences() {
           SavingsAccount sa = new SavingsAccount("S1");
           Account ref = sa;
           assertSame(sa, ref);
           ref.deposit(0, 100_000);
           assertEquals(100_000, sa.getBalance());
    }

    /**
     * teste the canTransact Flag
     */
    @Test
       void testCanTransact() {
           Account acc = new SavingsAccount("A123");
           // No bookings yet, should be true
           assertTrue(acc.canTransact(0));
           acc.deposit(0, 100_000);
           // Same date as last booking
           assertTrue(acc.canTransact(0));
    }

    /**
     * Experimente mit print().
     */
    @Test
       void testPrint() {
              Account acc = new SavingsAccount("A123");
              acc.deposit(0, 100_000);
              acc.deposit(1, 200_000);
              acc.withdraw(2, 50_000);
              // Just check that print() does not throw
              assertDoesNotThrow((org.junit.jupiter.api.function.Executable) acc::print);
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
       void testMonthlyPrint() {
              Account acc = new SavingsAccount("A123");
              acc.deposit(0, 100_000); // 01.01.1970
              acc.deposit(31, 200_000); // 01.02.1970
              acc.withdraw(62, 50_000); // 03.03.1970
              // Should print only for March 1970
              assertDoesNotThrow((org.junit.jupiter.api.function.Executable) () -> acc.print(1970, 3));
    }

}
