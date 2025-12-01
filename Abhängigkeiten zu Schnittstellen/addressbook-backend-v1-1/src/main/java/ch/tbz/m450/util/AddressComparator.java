package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;
import java.util.Date;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // 1) Nach Nachname (case-insensitive)
        int cmp = safeString(a1.getLastname()).compareToIgnoreCase(safeString(a2.getLastname()));
        if (cmp != 0) {
            return cmp;
        }

        // 2) Wenn Nachname gleich: nach Vorname
        cmp = safeString(a1.getFirstname()).compareToIgnoreCase(safeString(a2.getFirstname()));
        if (cmp != 0) {
            return cmp;
        }

        // 3) Wenn Name komplett gleich: nach Registrierungsdatum (älteres Datum zuerst)
        cmp = compareDates(a1.getRegistrationDate(), a2.getRegistrationDate());
        if (cmp != 0) {
            return cmp;
        }

        // 4) Wenn auch Datum gleich: nach Telefonnummer
        return safeString(a1.getPhonenumber()).compareTo(safeString(a2.getPhonenumber()));
    }

    private String safeString(String value) {
        return value == null ? "" : value;
    }

    private int compareDates(Date d1, Date d2) {
        if (d1 == null && d2 == null) {
            return 0;
        }
        if (d1 == null) {
            // null soll als "älter" (= kleiner) gelten
            return -1;
        }
        if (d2 == null) {
            return 1;
        }
        return d1.compareTo(d2);
    }
}
