package it.infn.mw.cern.hr.api.experiments;

import org.mapstruct.Mapper;

import it.infn.mw.cern.hr.persistence.entity.ExperimentEntity;

@Mapper(componentModel = "spring")
public interface ExperimentMapper {

  ExperimentDTO entityToDto(ExperimentEntity e);
  
}
