package ch.tbz.m450.service;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    private Address a1;
    private Address a2;

    @BeforeEach
    void setUp() {
        a1 = new Address(1, "Hans", "Meier", "111", new Date(1_000_000));
        a2 = new Address(2, "Anna", "Alber", "222", new Date(2_000_000));
    }

    @Test
    void saveDelegatesToRepository() {
        when(addressRepository.save(a1)).thenReturn(a1);

        Address saved = addressService.save(a1);

        assertEquals(a1, saved);
        verify(addressRepository).save(a1);
    }

    @Test
    void getAllReturnsSortedListUsingComparator() {
        when(addressRepository.findAll()).thenReturn(Arrays.asList(a1, a2));

        List<Address> result = addressService.getAll();

        // Wegen Comparator muss Alber vor Meier kommen
        assertEquals(Arrays.asList(a2, a1), result);
    }

    @Test
    void getAddressReturnsOptionalFromRepository() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(a1));

        Optional<Address> result = addressService.getAddress(1);

        assertTrue(result.isPresent());
        assertEquals(a1, result.get());
    }
}
