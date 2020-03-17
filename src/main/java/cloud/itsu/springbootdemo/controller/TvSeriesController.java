package cloud.itsu.springbootdemo.controller;

import cloud.itsu.springbootdemo.dto.TvSeriesDto;
import cloud.itsu.springbootdemo.service.TvSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TvSeriesController {

    @Autowired
    TvSeriesService tvSeriesService;

    @GetMapping ("/tv-series/get/")
    public List<TvSeriesDto> get() {
        System.out.println("Inside Get Controller for TV Series");
        return tvSeriesService.getAllTvSeries();
    }
}
