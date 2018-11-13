package it.infn.mw.cern.hr.api.institutes;

import org.mapstruct.Mapper;

import it.infn.mw.cern.hr.persistence.entity.InstituteAddressEntity;

@Mapper(componentModel = "spring")
public interface InstituteAddressMapper {
  InstituteAddressDTO entityToDto(InstituteAddressEntity e);
  InstituteAddressEntity dtoToEntity(InstituteAddressDTO dto);
}
