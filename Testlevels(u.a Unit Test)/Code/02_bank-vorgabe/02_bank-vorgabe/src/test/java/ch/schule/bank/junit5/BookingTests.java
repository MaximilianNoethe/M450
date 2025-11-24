package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
class BookingTests
{
	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	void testInitialization()
	{
		Booking b = new Booking(123, 456_789);
		assertEquals(123, b.getDate());
		assertEquals(456_789, b.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	void testPrint()
	{
		Booking b = new Booking(123, 456_789);
		// Just check that print() does not throw
		assertDoesNotThrow((org.junit.jupiter.api.function.Executable) () -> b.print(100_000));
	}
}
