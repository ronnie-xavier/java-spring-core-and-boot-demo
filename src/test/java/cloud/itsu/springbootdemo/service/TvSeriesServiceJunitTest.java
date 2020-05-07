package cloud.itsu.springbootdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class TvSeriesServiceJunitTest {

    private static final String TEST_STRING = "Test String";

    @Autowired
    private TvSeriesService testObject;

    @Test
    void saveTvSeries_whenTypical() {
        String evaluatedString = testObject.saveTvSeries(TEST_STRING);
        assertThat(evaluatedString, equalTo("successfully saved request with name " + TEST_STRING));
    }
}
