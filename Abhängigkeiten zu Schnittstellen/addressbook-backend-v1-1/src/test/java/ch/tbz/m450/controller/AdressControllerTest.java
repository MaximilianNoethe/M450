package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address(1, "Hans", "Meier", "111", new Date(1_000_000));
    }

    @Test
    void getAddressesReturns200AndList() throws Exception {
        when(addressService.getAll()).thenReturn(Collections.singletonList(address));

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname").value("Hans"))
                .andExpect(jsonPath("$[0].lastname").value("Meier"));
    }

    @Test
    void getAddressByIdFoundReturns200() throws Exception {
        when(addressService.getAddress(1)).thenReturn(Optional.of(address));

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("Hans"));
    }

    @Test
    void getAddressByIdNotFoundReturns404() throws Exception {
        when(addressService.getAddress(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/address/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createAddressReturns201() throws Exception {
        when(addressService.save(address)).thenReturn(address);

        String json = """
                {
                  "id": 1,
                  "firstname": "Hans",
                  "lastname": "Meier",
                  "phonenumber": "111"
                }
                """;

        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname").value("Hans"));
    }
}
