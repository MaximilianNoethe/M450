package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
class BankTests {
    /**
     * Tests to create new Accounts
     */
    @Test
    void testCreate() {
        Bank bank = new Bank();
        String id1 = bank.createSavingsAccount();
        String id2 = bank.createPromoYouthSavingsAccount();
        String id3 = bank.createSalaryAccount(-100_000);
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
        // SalaryAccount with positive creditLimit should return null
        assertNull(bank.createSalaryAccount(100_000));
    }
    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    void testDeposit() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        assertTrue(bank.deposit(id, 0, 500_000));
        assertEquals(500_000, bank.getBalance(id));
        // Deposit to non-existent account
        assertFalse(bank.deposit("NOPE", 0, 100_000));
    }
    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    void testWithdraw() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        bank.deposit(id, 0, 500_000);
        assertTrue(bank.withdraw(id, 1, 200_000));
        assertEquals(300_000, bank.getBalance(id));
    }

    /**
     * Experimente mit print().
     */
    @Test
    void testPrint() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        bank.deposit(id, 0, 100_000);
        bank.deposit(id, 1, 200_000);
        bank.withdraw(id, 2, 50_000);
        // Just check that print() does not throw
        assertDoesNotThrow((org.junit.jupiter.api.function.Executable) () -> bank.print(id));
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    void testMonthlyPrint() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        bank.deposit(id, 0, 100_000); // 01.01.1970
        bank.deposit(id, 31, 200_000); // 01.02.1970
        bank.withdraw(id, 62, 50_000); // 03.03.1970
        // Should print only for March 1970
        assertDoesNotThrow((org.junit.jupiter.api.function.Executable) () -> bank.print(id, 1970, 3));
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    void testBalance() {
        Bank bank = new Bank();
        String id1 = bank.createSavingsAccount();
        String id2 = bank.createSavingsAccount();
        bank.deposit(id1, 0, 100_000);
        bank.deposit(id2, 0, 200_000);
        assertEquals(100_000, bank.getBalance(id1));
        assertEquals(200_000, bank.getBalance(id2));
        // Bank balance is negative sum of all accounts (see Bank.java)
        assertEquals(-300_000, bank.getBalance());
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    void testTop5() {
        Bank bank = new Bank();
        for (int i = 0; i < 6; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 0, i * 100_000);
        }
        // Just check that printTop5 does not throw
        assertDoesNotThrow((org.junit.jupiter.api.function.Executable) bank::printTop5);
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    void testBottom5() {
        Bank bank = new Bank();
        for (int i = 0; i < 6; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 0, i * 100_000);
        }
        // Just check that printBottom5 does not throw
        assertDoesNotThrow((org.junit.jupiter.api.function.Executable) bank::printBottom5);
    }

}
