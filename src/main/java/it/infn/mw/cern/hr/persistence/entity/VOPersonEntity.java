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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GDT2511_VOMS_PERSONS", schema="foundation_pub")
public class VOPersonEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PERSON_ID")
  private Long id;

  @Column(name = "NAME", length = 24, nullable = false)
  private String name;

  @Column(name = "FIRST_NAME", length = 18, nullable = false)
  private String firstName;

  @Column(name = "DEPART", length = 3)
  private String department;

  @Column(name = "GRP", length = 3)
  private String group;

  @Column(name = "SECT", length = 3)
  private String sector;

  @Column(name = "BUILDING", length = 10)
  private String building;

  @Column(name = "FLOOR", length = 2)
  private String floor;

  @Column(name = "ROOM", length = 4)
  private String room;

  @Column(name = "TEL_1", length = 5)
  private String tel1;

  @Column(name = "TEL_2", length = 5)
  private String tel2;

  @Column(name = "TEL_3", length = 5)
  private String tel3;

  @Column(name = "PORTABLE_PHONE", length = 5)
  private String portablePhone;

  @Column(name = "BEEP", length = 5)
  private String beeper;

  @Column(name = "EMAIL", length = 60)
  private String email;

  @Column(name = "PHYSICAL_EMAIL", length = 60)
  private String physicalEmail;

  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "INSTITUTE")
  private InstituteEntity institute;

  @OneToMany(mappedBy = "voPerson", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<ParticipationEntity> participations = new HashSet<>();


  /**
   * @return the name
   */
  public String getName() {

    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {

    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  /**
   * @return the department
   */
  public String getDepartment() {

    return department;
  }

  /**
   * @param department the department to set
   */
  public void setDepartment(String department) {

    this.department = department;
  }

  /**
   * @return the group
   */
  public String getGroup() {

    return group;
  }

  /**
   * @param group the group to set
   */
  public void setGroup(String group) {

    this.group = group;
  }

  /**
   * @return the sector
   */
  public String getSector() {

    return sector;
  }

  /**
   * @param sector the sector to set
   */
  public void setSector(String sector) {

    this.sector = sector;
  }

  /**
   * @return the building
   */
  public String getBuilding() {

    return building;
  }

  /**
   * @param building the building to set
   */
  public void setBuilding(String building) {

    this.building = building;
  }

  /**
   * @return the floor
   */
  public String getFloor() {

    return floor;
  }

  /**
   * @param floor the floor to set
   */
  public void setFloor(String floor) {

    this.floor = floor;
  }

  /**
   * @return the room
   */
  public String getRoom() {

    return room;
  }

  /**
   * @param room the room to set
   */
  public void setRoom(String room) {

    this.room = room;
  }

  /**
   * @return the tel1
   */
  public String getTel1() {

    return tel1;
  }

  /**
   * @param tel1 the tel1 to set
   */
  public void setTel1(String tel1) {

    this.tel1 = tel1;
  }

  /**
   * @return the tel2
   */
  public String getTel2() {

    return tel2;
  }

  /**
   * @param tel2 the tel2 to set
   */
  public void setTel2(String tel2) {

    this.tel2 = tel2;
  }

  /**
   * @return the tel3
   */
  public String getTel3() {

    return tel3;
  }

  /**
   * @param tel3 the tel3 to set
   */
  public void setTel3(String tel3) {

    this.tel3 = tel3;
  }

  /**
   * @return the portablePhone
   */
  public String getPortablePhone() {

    return portablePhone;
  }

  /**
   * @param portablePhone the portablePhone to set
   */
  public void setPortablePhone(String portablePhone) {

    this.portablePhone = portablePhone;
  }

  /**
   * @return the beeper
   */
  public String getBeeper() {

    return beeper;
  }

  /**
   * @param beeper the beeper to set
   */
  public void setBeeper(String beeper) {

    this.beeper = beeper;
  }

  /**
   * @return the email
   */
  public String getEmail() {

    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return the physicalEmail
   */
  public String getPhysicalEmail() {

    return physicalEmail;
  }

  /**
   * @param physicalEmail the physicalEmail to set
   */
  public void setPhysicalEmail(String physicalEmail) {

    this.physicalEmail = physicalEmail;
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


  /**
   * @return the id
   */
  public Long getId() {

    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @return the participations
   */
  public Set<ParticipationEntity> getParticipations() {

    return participations;
  }

  /**
   * @param participations the participations to set
   */
  public void setParticipations(Set<ParticipationEntity> participations) {

    this.participations = participations;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VOPersonEntity other = (VOPersonEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
