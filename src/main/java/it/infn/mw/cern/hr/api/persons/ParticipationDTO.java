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

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.infn.mw.cern.hr.api.experiments.ExperimentDTO;
import it.infn.mw.cern.hr.api.institutes.InstituteDTO;

@JsonInclude(NON_EMPTY)
public class ParticipationDTO {

  VOPersonDTO voPerson;

  ExperimentDTO experiment;
  InstituteDTO institute;

  Date startDate;
  Date endDate;

  public ParticipationDTO() {
    // empty ctor
  }

  public VOPersonDTO getVoPerson() {
    return voPerson;
  }

  public void setVoPerson(VOPersonDTO voPerson) {
    this.voPerson = voPerson;
  }

  public ExperimentDTO getExperiment() {
    return experiment;
  }

  public void setExperiment(ExperimentDTO experiment) {
    this.experiment = experiment;
  }

  public InstituteDTO getInstitute() {
    return institute;
  }

  public void setInstitute(InstituteDTO institute) {
    this.institute = institute;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  


}
