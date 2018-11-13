package it.infn.mw.cern.hr.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.infn.mw.cern.hr.persistence.entity.InstituteEntity;

public interface InstituteRepository extends PagingAndSortingRepository<InstituteEntity, String> {

  Optional<InstituteEntity> findByNameIgnoreCase(String name);

}
