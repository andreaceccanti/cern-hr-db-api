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
