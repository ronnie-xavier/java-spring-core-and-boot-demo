package cloud.itsu.springbootdemo.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class TvSeriesDto {
    @Id
    private Integer id;
    private String name;

    public TvSeriesDto() { }

    public TvSeriesDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
