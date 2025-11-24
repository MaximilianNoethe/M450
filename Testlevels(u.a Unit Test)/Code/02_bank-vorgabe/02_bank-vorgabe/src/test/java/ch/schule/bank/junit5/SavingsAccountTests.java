package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
class SavingsAccountTests
{
	@Test
	void test() {
		SavingsAccount acc = new SavingsAccount("S1");
		// Deposit
		assertTrue(acc.deposit(0, 100_000));
		assertEquals(100_000, acc.getBalance());

		// Withdraw within balance
		assertTrue(acc.withdraw(1, 50_000));
		assertEquals(50_000, acc.getBalance());

		// Withdraw more than balance (should fail)
		assertFalse(acc.withdraw(2, 100_000));
		assertEquals(50_000, acc.getBalance());

		// Withdraw negative amount (should fail)
		assertFalse(acc.withdraw(3, -10_000));
		assertEquals(50_000, acc.getBalance());
	}
}

