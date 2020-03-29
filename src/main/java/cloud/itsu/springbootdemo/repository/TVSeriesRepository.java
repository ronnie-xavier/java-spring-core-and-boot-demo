package cloud.itsu.springbootdemo.repository;

import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVSeriesRepository extends CrudRepository <TvSeriesEntity, Integer> {

}
