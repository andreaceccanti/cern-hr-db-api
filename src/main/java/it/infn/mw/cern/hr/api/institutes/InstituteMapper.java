package it.infn.mw.cern.hr.api.institutes;

import org.mapstruct.Mapper;

import it.infn.mw.cern.hr.persistence.entity.InstituteEntity;

@Mapper(componentModel = "spring")
public interface InstituteMapper {
  
  InstituteDTO entityToDto(InstituteEntity e);
  

}
