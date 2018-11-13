package it.infn.mw.cern.hr.api.countries;

import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.infn.mw.cern.hr.api.Constants;
import it.infn.mw.cern.hr.api.dto.ListResponseDTO;
import it.infn.mw.cern.hr.api.error.NotFoundError;
import it.infn.mw.cern.hr.api.utils.PageUtils;
import it.infn.mw.cern.hr.persistence.entity.CountryEntity;
import it.infn.mw.cern.hr.persistence.repository.CountryRepository;

@RestController
@RequestMapping(value = CountryController.RESOURCE)
public class CountryController {

  public static final String RESOURCE = Constants.API_PREFIX + "/Countries";

  static final int COUNTRIES_MAX_PAGE_SIZE = 100;

  private final CountryMapper mapper;
  private final CountryRepository repo;

  @Autowired
  public CountryController(CountryMapper mapper, CountryRepository repo) {
    this.mapper = mapper;
    this.repo = repo;
  }

  private Supplier<NotFoundError> notFoundError(String name) {
    return () -> new NotFoundError(String.format("No country found for name: %s", name));
  }

  @GetMapping("/{name}")
  CountryDTO findByName(@PathVariable String name) {
    CountryEntity e = repo.findByNameIgnoreCase(name).orElseThrow(notFoundError(name));
    return mapper.entityToDto(e);
  }

  @GetMapping
  ListResponseDTO<CountryDTO> getCountries(@RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, COUNTRIES_MAX_PAGE_SIZE, Sort.by("name"));

    Page<CountryEntity> pagedResults = repo.findAll(pageRequest);

    ListResponseDTO.Builder<CountryDTO> response = ListResponseDTO.builder();

    response.fromPage(pagedResults);
    response.resources(
        pagedResults.getContent().stream().map(mapper::entityToDto).collect(Collectors.toList()));

    return response.build();
  }

}
