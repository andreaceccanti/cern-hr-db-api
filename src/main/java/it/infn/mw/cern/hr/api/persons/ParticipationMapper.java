package it.infn.mw.cern.hr.api.persons;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.infn.mw.cern.hr.persistence.entity.ParticipationEntity;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {

  @Mapping(source="vomsPerson", target="voPerson")
  ParticipationDTO entityToDto(ParticipationEntity e);
}
