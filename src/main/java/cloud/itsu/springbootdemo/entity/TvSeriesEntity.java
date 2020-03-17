package cloud.itsu.springbootdemo.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TvSeriesEntity {
    private String name;
    private String description;
    private Map<String, Integer> episodeSeasonMap = new HashMap<>();

    public TvSeriesEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TvSeriesEntity(String name, String description, Map<String, Integer> episodeSeasonMap) {
        this.name = name;
        this.description = description;
        this.episodeSeasonMap = episodeSeasonMap;
    }
}
