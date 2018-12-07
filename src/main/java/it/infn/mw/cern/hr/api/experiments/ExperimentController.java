/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2018
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
package it.infn.mw.cern.hr.api.experiments;

import static it.infn.mw.cern.hr.api.utils.ErrorSuppliers.notFoundError;
import static java.lang.String.format;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.infn.mw.cern.hr.api.Constants;
import it.infn.mw.cern.hr.api.dto.ListResponseDTO;
import it.infn.mw.cern.hr.api.utils.PageUtils;
import it.infn.mw.cern.hr.persistence.entity.ExperimentEntity;
import it.infn.mw.cern.hr.persistence.repository.ExperimentRepository;

@RestController
@RequestMapping(value = ExperimentController.RESOURCE)
public class ExperimentController {

  public static final String RESOURCE = Constants.API_PREFIX + "/Experiments";

  static final int EXPERIMENTS_MAX_PAGE_SIZE = 100;

  final ExperimentRepository repo;
  final ExperimentMapper mapper;

  @Autowired
  public ExperimentController(ExperimentRepository repo, ExperimentMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @GetMapping("/{name}")
  ExperimentDTO findByName(@PathVariable String name) {
    ExperimentEntity e = repo.findByNameIgnoreCase(name)
      .orElseThrow(notFoundError(format("Experiment not found: %s", name)));

    return mapper.entityToDto(e);
  }


  @GetMapping
  ListResponseDTO<ExperimentDTO> getExperiments(@RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, EXPERIMENTS_MAX_PAGE_SIZE, Sort.by("name"));

    Page<ExperimentEntity> pagedResults = repo.findAll(pageRequest);

    ListResponseDTO.Builder<ExperimentDTO> response = ListResponseDTO.builder();

    response.fromPage(pagedResults);
    response.resources(
        pagedResults.getContent().stream().map(mapper::entityToDto).collect(Collectors.toList()));

    return response.build();

  }
}
