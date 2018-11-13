package it.infn.mw.cern.hr.api.experiments;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_EMPTY)
public class ExperimentDTO {
  
  String name;
  String status;
  String gbFlag;
  
  ExperimentDTO parent;
  
  public ExperimentDTO() {
    // empty ctor
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getGbFlag() {
    return gbFlag;
  }

  public void setGbFlag(String gbFlag) {
    this.gbFlag = gbFlag;
  }

  public ExperimentDTO getParent() {
    return parent;
  }

  public void setParent(ExperimentDTO parent) {
    this.parent = parent;
  }
  
}
