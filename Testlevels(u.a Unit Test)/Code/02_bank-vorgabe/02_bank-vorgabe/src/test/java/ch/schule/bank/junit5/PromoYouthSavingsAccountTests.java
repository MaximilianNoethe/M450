package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
class PromoYouthSavingsAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	void test() {
		PromoYouthSavingsAccount acc = new PromoYouthSavingsAccount("Y1");
		// Deposit 100_000 (should add 1% = 1_000 bonus)
		assertTrue(acc.deposit(0, 100_000));
		assertEquals(101_000, acc.getBalance());

		// Deposit 200_000 (should add 2_000 bonus)
		assertTrue(acc.deposit(1, 200_000));
		assertEquals(303_000, acc.getBalance());

		// Negative deposit should still add 1% bonus, but SavingsAccount/Account should reject negative
		assertFalse(acc.deposit(2, -100_000));
		assertEquals(303_000, acc.getBalance());

		// Withdraw less than balance
		assertTrue(acc.withdraw(3, 100_000));
		assertEquals(203_000, acc.getBalance());

		// Withdraw more than balance (should fail)
		assertFalse(acc.withdraw(4, 300_000));
		assertEquals(203_000, acc.getBalance());
	}
}
