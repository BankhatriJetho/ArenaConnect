package com.arenaconnect.backend.controllers;

import com.arenaconnect.backend.controllers.BookingController;
import com.arenaconnect.backend.models.Booking;
import com.arenaconnect.backend.services.BookingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(BookingController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;


    private BookingController bookingController;

    @Test
    @WithMockUser(username = "testuser")
    public void testCreateBooking() throws Exception {
        Booking booking = new Booking();
        when(bookingService.createBooking(any(Booking.class))).thenReturn(booking);  // Update to createBooking

        mockMvc.perform(post("/api/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"bookingDetails\": \"Test Booking\" }"))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "testuser")
    public void testGetBookingsByUserId() throws Exception {
        when(bookingService.getBookingsByUserId(1L)).thenReturn(Arrays.asList(new Booking()));  // Replace with test data

        mockMvc.perform(get("/api/bookings/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "testuser")
    public void testCancelBooking() throws Exception {
        doNothing().when(bookingService).cancelBooking(1L);  // Update to cancelBooking

        mockMvc.perform(delete("/api/bookings/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Booking successfully canceled."));
    }

}

