package it.myMediaApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.myMediaApp.domain.TvSeries;

@Repository
public interface TvSeriesRepository extends CrudRepository<TvSeries, Long>{

}
