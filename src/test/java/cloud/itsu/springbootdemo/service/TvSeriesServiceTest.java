package cloud.itsu.springbootdemo.service;

import cloud.itsu.springbootdemo.repository.TVSeriesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class TvSeriesServiceTest {

    public static final String TEST_STRING = "test string";

    @InjectMocks
    private TvSeriesService testObject;

    @Mock
    private TVSeriesRepository tvSeriesRepository;

    @Spy
    private NameEvaluationService nameEvaluationService;

    @Test
    public void saveTvSeries_when_typical() {
        String evaluatedString = testObject.saveTvSeries(TEST_STRING);
        assertThat(evaluatedString, equalTo("successfully saved request with name " + TEST_STRING));
    }

}
