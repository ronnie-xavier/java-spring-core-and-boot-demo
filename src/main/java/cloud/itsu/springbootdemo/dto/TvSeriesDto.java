package cloud.itsu.springbootdemo.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TvSeriesDto {
    private String name;
    private String description;
    private Map<String, Integer> episodeSeasonMap = new HashMap<>();
}
