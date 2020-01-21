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
package it.infn.mw.cern.hr.persistence.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.infn.mw.cern.hr.persistence.entity.ParticipationEntity;
import it.infn.mw.cern.hr.persistence.entity.VOPersonEntity;

public interface VOPersonRepository extends PagingAndSortingRepository<VOPersonEntity, Long> {

  @Query("select p from VOPersonEntity p where lower(p.email) = lower(:email) or lower(p.physicalEmail) = lower(:email)")
  Optional<VOPersonEntity> findByEmail(String email);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.id.experiment) = lower(:experimentName)")
  Page<VOPersonEntity> findbyExperimentParticipation(String experimentName, Pageable pageable);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.id.experiment) = lower(:experimentName) and pp.id.startDate < :instant and (pp.endDate is null or :instant < pp.endDate )")
  Page<VOPersonEntity> findByValidExperimentParticipation(String experimentName, Date instant,
      Pageable pageable);

  @Query("select pp from VOPersonEntity p join p.participations pp where lower(pp.id.experiment) = lower(:experimentName) and pp.id.startDate < :instant and (pp.endDate is null or :instant < pp.endDate ) and p.id = :personId")
  Optional<ParticipationEntity> findValidExperimentParticipationByPersonId(String experimentName,
      Date instant, Long personId);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.id.experiment) = lower(:experimentName) and pp.endDate between :since and :now")
  Page<VOPersonEntity> findByExpiredExperimentParticipation(String experimentName, Date now,
      Date since, Pageable pageable);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.id.experiment) = lower(:experimentName) and pp.id.startDate <: now and pp.endDate between :now and :then")
  Page<VOPersonEntity> findByExpiringExperimentParticipation(String experimentName, Date now,
      Date then, Pageable pageable);

}
