package it.infn.mw.cern.hr.persistence.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.infn.mw.cern.hr.persistence.entity.VOPersonEntity;

public interface VOPersonRepository extends PagingAndSortingRepository<VOPersonEntity, Long> {

  Optional<VOPersonEntity> findByCernId(Long cernId);

  @Query("select p from VOPersonEntity p where lower(p.email) = lower(:email) or lower(p.physicalEmail) = lower(:email)")
  Optional<VOPersonEntity> findByEmail(String email);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.experiment.name) = lower(:experimentName)")
  Page<VOPersonEntity> findbyExperimentParticipation(String experimentName, Pageable pageable);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.experiment.name) = lower(:experimentName) and pp.id.startDate < :instant and (pp.endDate is null or :instant < pp.endDate )")
  Page<VOPersonEntity> findByValidExperimentParticipation(String experimentName, Date instant,
      Pageable pageable);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.experiment.name) = lower(:experimentName) and pp.endDate between :since and :now")
  Page<VOPersonEntity> findByExpiredExperimentParticipation(String experimentName, Date now,
      Date since, Pageable pageable);

  @Query("select p from VOPersonEntity p join p.participations pp where lower(pp.experiment.name) = lower(:experimentName) and pp.id.startDate <: now and pp.endDate between :now and :then")
  Page<VOPersonEntity> findByExpiringExperimentParticipation(String experimentName, Date now,
      Date then, Pageable pageable);

}
