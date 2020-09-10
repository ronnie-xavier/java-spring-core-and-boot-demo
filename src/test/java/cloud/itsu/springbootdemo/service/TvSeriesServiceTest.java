package cloud.itsu.springbootdemo.service;

import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import cloud.itsu.springbootdemo.repository.TVSeriesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TvSeriesServiceTest {

    public static final String TEST_STRING = "test string";
    public static final String SAMPLE_ONE = "sample One";
    public static final String SAMPLE_TWO = "sample Two";
    public static final String SAMPLE_THREE = "sample Three";
    public static final String TWO = "Two";
    public static final String SAMPLEFOUR = "samplefour";

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

    @Test
    public void getOne_whenTypical() {
        when(tvSeriesRepository.findAll()).thenReturn(getSampleTvSeriesEntityList());
        TvSeriesEntity testEntity = testObject.getOneTvSeries();
        assertThat(TWO, equalTo(testEntity.getName()));

    }

    private List<TvSeriesEntity> getSampleTvSeriesEntityList() {
        TvSeriesEntity sampleOne = new TvSeriesEntity(SAMPLE_ONE);
        TvSeriesEntity sampleTwo = new TvSeriesEntity(SAMPLE_TWO);
        TvSeriesEntity sampleThree = new TvSeriesEntity(SAMPLE_THREE);
        TvSeriesEntity sampleFour = new TvSeriesEntity(SAMPLEFOUR);

        return Arrays.asList(sampleOne, sampleTwo, sampleThree, sampleFour);
    }

}
