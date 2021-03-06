/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2020
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.infn.mw.cern.hr.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import it.infn.mw.cern.hr.api.dto.VOPersonDTO;
import it.infn.mw.cern.hr.persistence.entity.VOPersonEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface VOPersonMapper {
  
  VOPersonDTO entityToDto(VOPersonEntity e);

}
