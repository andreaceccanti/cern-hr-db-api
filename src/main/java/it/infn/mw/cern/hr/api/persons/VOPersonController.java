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
package it.infn.mw.cern.hr.api.persons;

import static java.util.stream.Collectors.toList;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

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
import it.infn.mw.cern.hr.api.dto.VOPersonDTO;
import it.infn.mw.cern.hr.api.mappers.ParticipationMapper;
import it.infn.mw.cern.hr.api.mappers.VOPersonMapper;
import it.infn.mw.cern.hr.api.utils.ErrorSuppliers;
import it.infn.mw.cern.hr.api.utils.PageUtils;
import it.infn.mw.cern.hr.persistence.entity.ParticipationEntity;
import it.infn.mw.cern.hr.persistence.entity.VOPersonEntity;
import it.infn.mw.cern.hr.persistence.repository.VOPersonRepository;

@RestController
@RequestMapping(value = VOPersonController.RESOURCE)
public class VOPersonController {

  public static final int VO_PERSONS_MAX_PAGE_SIZE = 100;
  public static final String RESOURCE = Constants.API_PREFIX + "/VOPersons";

  final VOPersonRepository repo;
  final VOPersonMapper mapper;
  final ParticipationMapper participationMapper;
  final Clock clock;

  public VOPersonController(VOPersonRepository repo, VOPersonMapper mapper, ParticipationMapper pm,
      Clock clock) {
    this.repo = repo;
    this.mapper = mapper;
    this.participationMapper = pm;
    this.clock = clock;

  }

  @GetMapping("/{personId}")
  public VOPersonDTO findByPersonId(@PathVariable Long personId) {
    VOPersonEntity e = repo.findById(personId)
      .orElseThrow(ErrorSuppliers
        .notFoundError(String.format("VO person not found for person id: %s", personId)));

    return mapper.entityToDto(e);
  }

  @GetMapping("/email/{email}")
  public VOPersonDTO findByEmail(@PathVariable String email) {
    VOPersonEntity e = repo.findByEmail(email)
      .orElseThrow(
          ErrorSuppliers.notFoundError(String.format("VO person not found for email: %s", email)));

    return mapper.entityToDto(e);
  }

  @GetMapping("/participation/{experiment}")
  public ListResponseDTO<VOPersonDTO> findWithExperimentParticipation(
      @PathVariable String experiment, @RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, VO_PERSONS_MAX_PAGE_SIZE, Sort.by("name"));

    Page<VOPersonEntity> pagedResults = repo.findbyExperimentParticipation(experiment, pageRequest);

    ListResponseDTO.Builder<VOPersonDTO> response = ListResponseDTO.builder();
    response.fromPage(pagedResults);

    response
      .resources(pagedResults.getContent().stream().map(mapper::entityToDto).collect(toList()));
    return response.build();
  }

  @GetMapping("/participation/{experiment}/valid")
  public ListResponseDTO<VOPersonDTO> findWithValidExperimentParticipation(
      @PathVariable String experiment, @RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final Date currentTime = Date.from(clock.instant());

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, VO_PERSONS_MAX_PAGE_SIZE, Sort.by("name"));

    Page<VOPersonEntity> pagedResults =
        repo.findByValidExperimentParticipation(experiment, currentTime, pageRequest);

    ListResponseDTO.Builder<VOPersonDTO> response = ListResponseDTO.builder();
    response.fromPage(pagedResults);

    response
      .resources(pagedResults.getContent().stream().map(mapper::entityToDto).collect(toList()));
    return response.build();
  }

  @GetMapping("/participation/{experiment}/valid/{personId}")
  public boolean hasValidExperimentParticipationForId(@PathVariable String experiment,
      @PathVariable Long personId) {

    final Date currentTime = Date.from(clock.instant());

    Optional<ParticipationEntity> p =
        repo.findValidExperimentParticipationByPersonId(experiment, currentTime, personId);

    return p.isPresent();
  }

  @GetMapping("/participation/{experiment}/expired")
  public ListResponseDTO<VOPersonDTO> findWithExpiredExperimentParticipation(
      @PathVariable String experiment, @RequestParam(required = false) final String since,
      @RequestParam(required = false) final Integer count,
      @RequestParam(required = false) final Integer startIndex) {

    final Instant now = clock.instant();
    final Date currentTime = Date.from(now);
    Date sinceTime = Date.from(Instant.EPOCH);

    if (!Objects.isNull(since) && !since.isEmpty()) {
      sinceTime = Date.from(now.minus(Duration.parse(since)));
    }

    final PageRequest pageRequest =
        PageUtils.buildPageRequest(count, startIndex, VO_PERSONS_MAX_PAGE_SIZE, Sort.by("name"));

    Page<VOPersonEntity> pagedResults =
        repo.findByExpiredExperimentParticipation(experiment, currentTime, sinceTime, pageRequest);

    ListResponseDTO.Builder<VOPersonDTO> response = ListResponseDTO.builder();
    response.fromPage(pagedResults);

    response
      .resources(pagedResults.getContent().stream().map(mapper::entityToDto).collect(toList()));

    return response.build();
  }

}
