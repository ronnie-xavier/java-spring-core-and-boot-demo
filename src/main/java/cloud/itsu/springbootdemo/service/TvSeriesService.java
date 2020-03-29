package cloud.itsu.springbootdemo.service;

import cloud.itsu.springbootdemo.dto.TvSeriesDto;
import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import cloud.itsu.springbootdemo.exception.TvSeriesNotFoundException;
import cloud.itsu.springbootdemo.repository.TVSeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TvSeriesService {

    @Autowired
    TVSeriesRepository tvSeriesRepository;

    public List<TvSeriesEntity> getAllTvSeries() {
        return (List<TvSeriesEntity>) tvSeriesRepository.findAll();
    }

    public String saveTvSeries(int id, String name) {
        tvSeriesRepository.save(new TvSeriesEntity(id, name));
        log.info("successfully saved request id " + id);
        return "successfully saved request id " + id;
    }

    public String saveTvSeriesFromBody(TvSeriesDto tvSeriesDto) {
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        BeanUtils.copyProperties(tvSeriesDto,tvSeriesEntity);
        tvSeriesRepository.save(tvSeriesEntity);
        log.info("successfully saved request id " + tvSeriesEntity.getId());
        return "successfully saved request id " + tvSeriesEntity.getId();
    }

    public TvSeriesEntity getTvSeries(int id) {
        return tvSeriesRepository.findById(id)
                .orElseThrow(() -> new TvSeriesNotFoundException(id));
    }
}
