package cloud.itsu.springbootdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tv_series")
public class TvSeriesEntity {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String address;

    public TvSeriesEntity() { }

    public TvSeriesEntity(String name) {
        this.id = id;
        this.name = name;
    }

    public TvSeriesEntity(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
