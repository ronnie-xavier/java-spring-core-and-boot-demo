package cloud.itsu.springbootdemo.controller;

import cloud.itsu.springbootdemo.dto.TvSeriesDto;
import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import cloud.itsu.springbootdemo.service.TvSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tv-series/")
public class TvSeriesController {

    @Autowired
    TvSeriesService tvSeriesService;

    @GetMapping ("/get/")
    public List<TvSeriesEntity> get() {
        System.out.println("Inside Get Controller for TV Series");
        return tvSeriesService.getAllTvSeries();
    }

    @GetMapping ("/get/{id}")
    public TvSeriesEntity get(@PathVariable int id) {
        System.out.println("Inside Get Controller for TV Series");
        return tvSeriesService.getTvSeries(id);
    }

    @PostMapping ("/save/{id}")
    public String save(@RequestParam String name, @PathVariable int id) {
        System.out.println("name is " + name);
        System.out.println("id is " + id);
        return tvSeriesService.saveTvSeries(id, name);
    }

    @PostMapping (value="/save-body/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public String save(@RequestBody TvSeriesDto tvSeriesDto) {
        return tvSeriesService.saveTvSeriesFromBody(tvSeriesDto);
    }
}
