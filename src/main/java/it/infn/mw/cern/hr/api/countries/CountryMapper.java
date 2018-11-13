package it.infn.mw.cern.hr.api.countries;

import org.mapstruct.Mapper;

import it.infn.mw.cern.hr.persistence.entity.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryMapper {

  CountryDTO entityToDto(CountryEntity e);

  CountryEntity dtoToEntity(CountryDTO dto);
}
