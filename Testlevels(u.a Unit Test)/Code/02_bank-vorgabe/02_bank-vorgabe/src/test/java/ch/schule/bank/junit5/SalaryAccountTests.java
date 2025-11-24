package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
class SalaryAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	void test() {
		SalaryAccount acc = new SalaryAccount("P1", -200_000);
		// Deposit
		assertTrue(acc.deposit(0, 100_000));
		assertEquals(100_000, acc.getBalance());

		// Withdraw within balance
		assertTrue(acc.withdraw(1, 50_000));
		assertEquals(50_000, acc.getBalance());

		// Withdraw into credit limit (down to -200_000)
		assertTrue(acc.withdraw(2, 200_000));
		assertEquals(-150_000, acc.getBalance());

		// Withdraw beyond credit limit (should fail)
		assertFalse(acc.withdraw(3, 100_000));
		assertEquals(-150_000, acc.getBalance());

		// Withdraw negative amount (should fail)
		assertFalse(acc.withdraw(4, -10_000));
		assertEquals(-150_000, acc.getBalance());
	}
}
