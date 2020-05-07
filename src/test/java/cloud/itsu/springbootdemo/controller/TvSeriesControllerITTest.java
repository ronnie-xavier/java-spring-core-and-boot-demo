package cloud.itsu.springbootdemo.controller;

import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TvSeriesControllerITTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getTvSeries_typical() throws Exception {
        int idTestObject = 5;
        ResponseEntity<TvSeriesEntity> response = testRestTemplate.exchange(
                new URL("http://localhost:" + port + "/tv-series/get/" + idTestObject).toString(),
                HttpMethod.GET,
                null,
                TvSeriesEntity.class
        );
        TvSeriesEntity testObject = response.getBody();
        assertEquals(testObject.getId(), idTestObject);
        assertEquals(testObject.getName(), "the evaluated name is The name does not start with A or R Test String");
    }
}