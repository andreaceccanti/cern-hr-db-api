package it.infn.mw.cern.hr.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.infn.mw.cern.hr.persistence.entity.ExperimentEntity;

public interface ExperimentRepository extends PagingAndSortingRepository<ExperimentEntity, String> {

  Optional<ExperimentEntity> findByNameIgnoreCase(String name);
}
