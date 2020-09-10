package cloud.itsu.springbootdemo.controller;

import cloud.itsu.springbootdemo.dto.TvSeriesDto;
import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import cloud.itsu.springbootdemo.service.TvSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv-series/")
public class TvSeriesController {

    @Autowired
    TvSeriesService tvSeriesService;

    @GetMapping ("/get/")
    public List<TvSeriesEntity> get() {
        System.out.println("Inside Get 2 Controller for TV Series");
        return tvSeriesService.getAllTvSeries();
    }

    @GetMapping ("/get/{id}")
    public TvSeriesEntity get(@PathVariable int id) {
        System.out.println("Inside Get Controller for TV Series");
        return tvSeriesService.getTvSeries(id);
    }

    @PostMapping ("/save/")
    public String save(@RequestParam String name) {
        return tvSeriesService.saveTvSeries(name);
    }

    @PostMapping (value="/save-body/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public String save(@RequestBody TvSeriesDto tvSeriesDto) {
        return tvSeriesService.saveTvSeriesFromBody(tvSeriesDto);
    }

    @GetMapping ("/get-one/")
    public TvSeriesEntity getOne() {
        System.out.println("Inside Get Controller for TV Series");
        return tvSeriesService.getOneTvSeries();
    }
}
