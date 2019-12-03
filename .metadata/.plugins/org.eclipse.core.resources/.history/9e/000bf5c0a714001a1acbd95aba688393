package ca.mcgill.ecse321.eventregistration.service.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.*;
import ca.mcgill.ecse321.eventregistration.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCinema {

    @Autowired
    private EventRegistrationService service;

    @Autowired
    private CinemaRepository cinemaRepository;

    @After
    public void clearDatabase() {
        cinemaRepository.deleteAll();
    }

    @Test
    public void test_01_CreateCinema() {
        assertEquals(0, service.getAllCinemas().size());

        String name = "StarCite";
        String movie = "Inception";

        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.JANUARY, 18);
        Date cinemaDate = new Date(c.getTimeInMillis());

        LocalTime startTime = LocalTime.parse("09:00");
        LocalTime endTime = LocalTime.parse("18:00");

        try {
            service.createCinema(name, cinemaDate, Time.valueOf(startTime) , Time.valueOf(endTime), movie);
        } catch (IllegalArgumentException e) {
            fail();
        }

        checkResultCinema(name, cinemaDate, startTime, endTime, movie);
    }

    private void checkResultCinema(String name, Date cinemaDate, LocalTime startTime, LocalTime endTime, String movie) {
        assertEquals(0, service.getAllPersons().size());
        assertEquals(1, service.getAllCinemas().size());
        assertEquals(name, service.getAllCinemas().get(0).getName());
        assertEquals(cinemaDate.toString(), service.getAllCinemas().get(0).getDate().toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        assertEquals(startTime.format(formatter).toString(), service.getAllCinemas().get(0).getStartTime().toString());
        assertEquals(endTime.format(formatter).toString(), service.getAllCinemas().get(0).getEndTime().toString());
        assertEquals(movie, service.getAllCinemas().get(0).getMovie());
        assertEquals(0, service.getAllRegistrations().size());
    }

    @Test
    public void test_02_CreateCinemaNull() {
        assertEquals(0, service.getAllRegistrations().size());

        String name = null;
        String movie = null;
        Date cinemaDate = null;
        Time startTime = null;
        Time endTime = null;

        String error = null;
        try {
            service.createCinema(name, cinemaDate, startTime, endTime, movie);
        } catch (IllegalArgumentException e) {
            error = e.getMessage();
        }

        // Check error
        assertTrue(error.contains("Event name cannot be empty!"));
        assertTrue(error.contains("Event date cannot be empty!"));
        assertTrue(error.contains("Event start time cannot be empty!"));
        assertTrue(error.contains("Event end time cannot be empty!"));
        // Check model in memory
        assertEquals(0, service.getAllCinemas().size());
    }

    @Test
    public void test_03_CreateCinemaNameEmpty() {
        assertEquals(0, service.getAllCinemas().size());

        String name = "";
        String movie = "Fast and Furious";

        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.JANUARY, 18);
        Date cinemaDate = new Date(c.getTimeInMillis());

        LocalTime startTime = LocalTime.parse("09:00");
        LocalTime endTime = LocalTime.parse("18:00");

        String error = null;
        try {
            service.createCinema(name, cinemaDate, Time.valueOf(startTime), Time.valueOf(endTime), movie);
        } catch (IllegalArgumentException e) {
            error = e.getMessage();
        }

        // Check error
        assertEquals("Event name cannot be empty!", error);
        // Check model in memory
        assertEquals(0, service.getAllCinemas().size());
    }

    @Test
    public void test_05_CreateCinemaEndTimeBeforeStartTime() {
        assertEquals(0, service.getAllCinemas().size());

        String name = "District";
        String movie = "District 9";

        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.MARCH, 7);
        Date cinemaDate = new Date(c.getTimeInMillis());

        LocalTime startTime = LocalTime.parse("18:00");
        LocalTime endTime = LocalTime.parse("09:00");

        String error = null;
        try {
            service.createCinema(name, cinemaDate, Time.valueOf(startTime), Time.valueOf(endTime), movie);
        } catch (IllegalArgumentException e) {
            error = e.getMessage();
        }

        // Check error
        assertEquals("Event end time cannot be before event start time!", error);

        // Check model in memory
        assertEquals(0, service.getAllCinemas().size());
    }

    @Test
    public void test_07_CreateCinemaMovieSpaces() {
        assertEquals(0, service.getAllCinemas().size());

        String name = "Le Cinema";
        String movie = " ";

        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.NOVEMBER, 22);
        Date cinemaDate = new Date(c.getTimeInMillis());

        LocalTime startTime = LocalTime.parse("09:00");
        LocalTime endTime = LocalTime.parse("18:00");

        String error = null;
        try {
            service.createCinema(name, cinemaDate, Time.valueOf(startTime), Time.valueOf(endTime), movie);
        } catch (IllegalArgumentException e) {
            error = e.getMessage();
        }

        // Check error
        assertEquals("Cinema movie cannot be empty!", error);
        // Check model in memory
        assertEquals(0, service.getAllCinemas().size());
    }
}
