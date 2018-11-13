package it.infn.mw.cern.hr.api.persons;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import it.infn.mw.cern.hr.persistence.entity.VOPersonEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface VOPersonMapper {
  
  VOPersonDTO entityToDto(VOPersonEntity e);

}
