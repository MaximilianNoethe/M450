package ch.tbz.m450.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAndFindByIdWorks() {
        Address a = new Address(0, "Hans", "Meier", "111", new Date());
        Address saved = addressRepository.save(a);

        Optional<Address> found = addressRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Hans", found.get().getFirstname());
    }
}
