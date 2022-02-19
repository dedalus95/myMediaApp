package it.myMediaApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myMediaApp.domain.TvSeries;
import it.myMediaApp.dto.TvSeriesDTO;
import it.myMediaApp.parser.ProviderParser;
import it.myMediaApp.parser.TvSeriesAuthorParser;
import it.myMediaApp.parser.TvSeriesParser;
import it.myMediaApp.repository.TvSeriesRepository;

@Service
public class TvSeriesService {
	
	@Autowired
	TvSeriesRepository tvSeriesRepository;

	public TvSeriesDTO addTvSeries(TvSeriesDTO tvSeries) {

		TvSeries parsed = TvSeriesParser.fromDTOToEntity(tvSeries);
		
		parsed = tvSeriesRepository.save(parsed);
		
		if(parsed == null)
			return null;
		
		return TvSeriesParser.fromEntityToDTO(parsed);
	}

	public TvSeriesDTO updateSong(TvSeriesDTO tvSeries) {

		Optional<TvSeries> toUpdateTvSeries = tvSeriesRepository.findById(tvSeries.getId());
		
		if(toUpdateTvSeries.isEmpty())
			return null;
		
		updateTvSeriesBean(toUpdateTvSeries.get(), tvSeries);
		
		tvSeriesRepository.save(toUpdateTvSeries.get());
		
		return TvSeriesParser.fromEntityToDTO(toUpdateTvSeries.get());
	}

	private void updateTvSeriesBean(TvSeries oldTvSeries, TvSeriesDTO newTvSeries) {
		
		oldTvSeries.setAuthor(TvSeriesAuthorParser.fromDTOToEntity(newTvSeries.getAuthor()));
		oldTvSeries.setDescription(newTvSeries.getDescription());
		oldTvSeries.setEpisodeNum(newTvSeries.getEpisodesNum());
		
		if(newTvSeries.getProvider() != null) 
			oldTvSeries.setProvider(ProviderParser.fromListDTOToEntity(newTvSeries.getProvider()));
		
		
		oldTvSeries.setSeasonsNum(newTvSeries.getSeasonsNum());
		oldTvSeries.setTitle(newTvSeries.getTitle());
		oldTvSeries.setYear(newTvSeries.getYear());
	}

	public TvSeriesDTO getTvSeries(Long id) {
		
		Optional<TvSeries> found = tvSeriesRepository.findById(id);
		
		if(found.isEmpty())
			return null;
		
		return TvSeriesParser.fromEntityToDTO(found.get());
	}
	
	

	public TvSeriesDTO deleteTvSeries(Long id) {
		
		Optional<TvSeries> found = tvSeriesRepository.findById(id);

		if(found.isEmpty())
			return null;
		
		tvSeriesRepository.deleteById(found.get().getId());;
		
		return TvSeriesParser.fromEntityToDTO(found.get());
	}

	public List<TvSeriesDTO> getAllTvSeries() {
		
		List<TvSeries> allTvSeries = (List<TvSeries>) tvSeriesRepository.findAll();
		
		if(allTvSeries == null)
			return null;
		
		return TvSeriesParser.fromListEntityToDTO(allTvSeries);
		
	}

}
