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
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.infn.mw.cern.hr.api.countries.CountryDTO;
import it.infn.mw.cern.hr.api.institutes.InstituteDTO;

@JsonInclude(NON_EMPTY)
public class VOPersonDTO {

  Long id;
  Long cernId;

  String name;
  String firstName;

  String email;
  String physicalEmail;

  String department;
  String group;
  String sector;
  String building;
  String floor;
  String room;
  String tel1;
  String tel2;
  String tel3;
  String portablePhone;
  String beeper;
  String firm;
  String atCern;
  String personClass;
  Boolean supervisorOfExternalStuff;

  CountryDTO nationality1;
  InstituteDTO institute;

  Date dateOfBirth;
  Date processingStartDate;
  Date processingEndDate;
  
  Set<ParticipationDTO> participations;

  public VOPersonDTO() {
    // empty ctor
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCernId() {
    return cernId;
  }

  public void setCernId(Long cernId) {
    this.cernId = cernId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhysicalEmail() {
    return physicalEmail;
  }

  public void setPhysicalEmail(String physicalEmail) {
    this.physicalEmail = physicalEmail;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getTel1() {
    return tel1;
  }

  public void setTel1(String tel1) {
    this.tel1 = tel1;
  }

  public String getTel2() {
    return tel2;
  }

  public void setTel2(String tel2) {
    this.tel2 = tel2;
  }

  public String getTel3() {
    return tel3;
  }

  public void setTel3(String tel3) {
    this.tel3 = tel3;
  }

  public String getPortablePhone() {
    return portablePhone;
  }

  public void setPortablePhone(String portablePhone) {
    this.portablePhone = portablePhone;
  }

  public String getBeeper() {
    return beeper;
  }

  public void setBeeper(String beeper) {
    this.beeper = beeper;
  }

  public String getFirm() {
    return firm;
  }

  public void setFirm(String firm) {
    this.firm = firm;
  }

  public String getAtCern() {
    return atCern;
  }

  public void setAtCern(String atCern) {
    this.atCern = atCern;
  }

  public String getPersonClass() {
    return personClass;
  }

  public void setPersonClass(String personClass) {
    this.personClass = personClass;
  }

  public Boolean getSupervisorOfExternalStuff() {
    return supervisorOfExternalStuff;
  }

  public void setSupervisorOfExternalStuff(Boolean supervisorOfExternalStuff) {
    this.supervisorOfExternalStuff = supervisorOfExternalStuff;
  }

  public CountryDTO getNationality1() {
    return nationality1;
  }

  public void setNationality1(CountryDTO nationality1) {
    this.nationality1 = nationality1;
  }

  public InstituteDTO getInstitute() {
    return institute;
  }

  public void setInstitute(InstituteDTO institute) {
    this.institute = institute;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Date getProcessingStartDate() {
    return processingStartDate;
  }

  public void setProcessingStartDate(Date processingStartDate) {
    this.processingStartDate = processingStartDate;
  }

  public Date getProcessingEndDate() {
    return processingEndDate;
  }

  public void setProcessingEndDate(Date processingEndDate) {
    this.processingEndDate = processingEndDate;
  }

  public Set<ParticipationDTO> getParticipations() {
    return participations;
  }

  public void setParticipations(Set<ParticipationDTO> participations) {
    this.participations = participations;
  }
  
}
