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
import java.util.stream.Collectors;

@Slf4j
@Service
public class TvSeriesService {

    public static final String TWO = "Two";
    @Autowired
    TVSeriesRepository tvSeriesRepository;

    @Autowired
    NameEvaluationService nameEvaluationService;

    public List<TvSeriesEntity> getAllTvSeries() {
        return (List<TvSeriesEntity>) tvSeriesRepository.findAll();
    }

    public String saveTvSeries(String name) {
        String updatedName = "the evaluated name is " + nameEvaluationService.evaluateName(name);
        tvSeriesRepository.save(new TvSeriesEntity(updatedName));
        log.info("successfully saved request with name " + name);
        return "successfully saved 1 request with name " + name;
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

    public TvSeriesEntity getOneTvSeries() {
        List<TvSeriesEntity> tvSeriesEntities = (List<TvSeriesEntity>) tvSeriesRepository.findAll();
        tvSeriesEntities.forEach((tvSeriesEntity) -> {
            String[] splitName = tvSeriesEntity.getName().split(" ");
            String newName = splitName.length>1 ? splitName[1] : splitName[0];
            tvSeriesEntity.setName(newName);
        });
        tvSeriesEntities.forEach((tvSeriesEntity)->{
            System.out.println(tvSeriesEntity.getId());
            System.out.println(tvSeriesEntity.getName());
        });

        for (TvSeriesEntity tvEntity: tvSeriesEntities) {
            System.out.println("hello " + tvEntity.getName());
        }

        List<String> myStrings = tvSeriesEntities.stream().map(TvSeriesService::mapperFunction).collect(Collectors.toList());


        TvSeriesEntity filterTvSeriesEntity =
        tvSeriesEntities.stream().filter((tvSeriesEntity)->{
            return  TWO.equals(tvSeriesEntity.getName());
        }).findFirst().orElse(new TvSeriesEntity());

        return filterTvSeriesEntity;
    }

    private static String mapperFunction(TvSeriesEntity tvSeriesEntity) {
        return tvSeriesEntity.getName();
    }
}
