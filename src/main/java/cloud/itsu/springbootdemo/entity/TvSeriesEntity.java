package cloud.itsu.springbootdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TvSeriesEntity {
    @Id private Integer id;
    private String name;

    public TvSeriesEntity() { }

    public TvSeriesEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
