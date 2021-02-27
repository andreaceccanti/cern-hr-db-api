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
package it.infn.mw.cern.hr.api.institutes;

import static it.infn.mw.cern.hr.api.utils.ErrorSuppliers.notFoundError;
import static java.lang.String.format;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.infn.mw.cern.hr.api.Constants;
import it.infn.mw.cern.hr.api.dto.InstituteDTO;
import it.infn.mw.cern.hr.api.dto.ListResponseDTO;
import it.infn.mw.cern.hr.api.mappers.InstituteMapper;
import it.infn.mw.cern.hr.api.utils.PageUtils;
import it.infn.mw.cern.hr.persistence.entity.InstituteEntity;
import it.infn.mw.cern.hr.persistence.repository.InstituteRepository;

@RestController
@RequestMapping(value = InstituteController.RESOURCE)
@Transactional
public class InstituteController {

  public static final String RESOURCE = Constants.API_PREFIX + "/Institutes";

  static final int INSTITUTES_MAX_PAGE_SIZE = 100;

  private final InstituteRepository repo;
  private final InstituteMapper mapper;

  public InstituteController(InstituteRepository repo, InstituteMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @GetMapping("/{id}")
  InstituteDTO findById(@PathVariable String id) {
    InstituteEntity e =
        repo.findById(id).orElseThrow(notFoundError(format("Institute not found for id: %s", id)));

    return mapper.entityToDto(e);
  }
  

  @GetMapping
  ListResponseDTO<InstituteDTO> getInstitutes(@RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, INSTITUTES_MAX_PAGE_SIZE, Sort.by("name"));

    Page<InstituteEntity> pagedResults = repo.findAll(pageRequest);

    ListResponseDTO.Builder<InstituteDTO> response = ListResponseDTO.builder();

    response.fromPage(pagedResults);
    response.resources(
        pagedResults.getContent().stream().map(mapper::entityToDto).collect(Collectors.toList()));

    return response.build();
  }

}
