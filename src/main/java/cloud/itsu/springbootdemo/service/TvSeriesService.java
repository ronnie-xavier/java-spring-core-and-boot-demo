package cloud.itsu.springbootdemo.service;

import cloud.itsu.springbootdemo.dto.TvSeriesDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TvSeriesService {

    public List<TvSeriesDto> getAllTvSeries() {
        return new ArrayList<TvSeriesDto>();
    }
}
