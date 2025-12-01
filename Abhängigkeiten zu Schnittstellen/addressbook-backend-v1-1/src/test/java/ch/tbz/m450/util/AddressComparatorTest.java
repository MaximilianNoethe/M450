package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressComparatorTest {

    private AddressComparator comparator;
    private Address a1;
    private Address a2;
    private Address a3;

    @BeforeEach
    void setUp() {
        comparator = new AddressComparator();

        a1 = new Address(1, "Hans", "Meier", "111", new Date(1_000_000));
        a2 = new Address(2, "Peter", "Meier", "222", new Date(2_000_000));
        a3 = new Address(3, "Anna", "Alber", "333", new Date(3_000_000));
    }

    @Test
    void comparatorSortsByLastnameThenFirstnameThenId() {
        List<Address> list = Arrays.asList(a2, a3, a1);

        list.sort(comparator);

        // Erwartete Reihenfolge:
        // 1) Alber, Anna
        // 2) Meier, Hans
        // 3) Meier, Peter
        assertEquals(Arrays.asList(a3, a1, a2), list);
    }
}
