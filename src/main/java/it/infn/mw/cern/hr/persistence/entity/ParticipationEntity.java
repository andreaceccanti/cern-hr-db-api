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
package it.infn.mw.cern.hr.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GDT2511_VOMS_PARTICIPATION", schema="foundation_pub")
public class ParticipationEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private Id id = new Id();

  @Temporal(TemporalType.DATE)
  @Column(name = "END_DATE")
  private Date endDate;

  @ManyToOne
  @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false)
  VOPersonEntity voPerson;

  @ManyToOne
  @JoinColumn(name = "INSTITUTE", insertable = false, updatable = false)
  InstituteEntity institute;

  @Embeddable
  public static class Id implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "INSTITUTE")
    private String instituteId;

    @Column(name = "EXPERIMENT")
    private String experiment;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    public Id() {
      // empty ctor
    }

    /**
     * @return the personId
     */
    public Long getPersonId() {

      return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(Long personId) {

      this.personId = personId;
    }

    /**
     * @return the instituteId
     */
    public String getInstituteId() {

      return instituteId;
    }

    /**
     * @param instituteId the instituteId to set
     */
    public void setInstituteId(String instituteId) {

      this.instituteId = instituteId;
    }


    public String getExperiment() {
      return experiment;
    }

    public void setExperiment(String experiment) {
      this.experiment = experiment;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {

      return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {

      this.startDate = startDate;
    }

    @Override
    @Generated("eclipse")
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((experiment == null) ? 0 : experiment.hashCode());
      result = prime * result + ((instituteId == null) ? 0 : instituteId.hashCode());
      result = prime * result + ((personId == null) ? 0 : personId.hashCode());
      result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
      return result;
    }

    @Override
    @Generated("eclipse")
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Id other = (Id) obj;
      if (experiment == null) {
        if (other.experiment != null)
          return false;
      } else if (!experiment.equals(other.experiment))
        return false;
      if (instituteId == null) {
        if (other.instituteId != null)
          return false;
      } else if (!instituteId.equals(other.instituteId))
        return false;
      if (personId == null) {
        if (other.personId != null)
          return false;
      } else if (!personId.equals(other.personId))
        return false;
      if (startDate == null) {
        if (other.startDate != null)
          return false;
      } else if (!startDate.equals(other.startDate))
        return false;
      return true;
    }

  }

  /**
   * @return the id
   */
  public Id getId() {

    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Id id) {

    this.id = id;
  }

  /**
   * @return the endDate
   */
  public Date getEndDate() {

    return endDate;
  }

  /**
   * @param endDate the endDate to set
   */
  public void setEndDate(Date endDate) {

    this.endDate = endDate;
  }


  public VOPersonEntity getVoPerson() {
    return voPerson;
  }

  public void setVoPerson(VOPersonEntity voPerson) {
    this.voPerson = voPerson;
  }

  /**
   * @return the institute
   */
  public InstituteEntity getInstitute() {

    return institute;
  }

  /**
   * @param institute the institute to set
   */
  public void setInstitute(InstituteEntity institute) {

    this.institute = institute;
  }

  
  public Date getStartDate() {

    return id.getStartDate();
  }

  public void setStartDate(Date startDate) {

    id.setStartDate(startDate);
  }

  public String getExperiment() {
    return id.getExperiment();
  }

  public void setExperiment(String experiment) {
    id.setExperiment(experiment);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {

    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ParticipationEntity other = (ParticipationEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("ParticipationEntity [endDate=")
      .append(endDate)
      .append(", experiment=")
      .append(getExperiment())
      .append(", getStartDate()=")
      .append(getStartDate())
      .append("]");
    return builder.toString();
  }

}
