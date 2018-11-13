package it.infn.mw.cern.hr.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.infn.mw.cern.hr.persistence.entity.CountryEntity;

public interface CountryRepository extends PagingAndSortingRepository<CountryEntity, String> {

  Optional<CountryEntity> findByNameIgnoreCase(String name);

}
