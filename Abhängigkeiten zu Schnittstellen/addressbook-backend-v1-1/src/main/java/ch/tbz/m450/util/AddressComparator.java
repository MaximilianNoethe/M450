package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // Nach Nachname (case-insensitive)
        int cmp = a1.getLastname().compareToIgnoreCase(a2.getLastname());
        if (cmp != 0) return cmp;

        // Wenn Nachname gleich: nach Vorname
        cmp = a1.getFirstname().compareToIgnoreCase(a2.getFirstname());
        if (cmp != 0) return cmp;

        // Wenn auch Vorname gleich: nach id
        return Integer.compare(a1.getId(), a2.getId());
    }
}
