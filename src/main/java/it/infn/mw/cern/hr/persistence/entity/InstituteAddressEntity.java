/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2006-2016
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSTITUTE_ADDRESSES")
public class InstituteAddressEntity implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "ADDRESS_ID", length = 7)
  Long id;

  @Column(name = "STREET", length = 35)
  String street;

  @Column(name = "POSTBOX", length = 35)
  String postBox;

  @Column(name = "COUNTRY_CODE", length = 2, nullable = false)
  String countryCode;

  @Column(name = "POSTAL_CODE", length = 10)
  String postalCode;

  @Column(name = "PLACE", length = 30)
  String place;

  @Column(name = "SUFFIX", length = 15)
  String suffix;

  public InstituteAddressEntity() {

  }

  public Long getId() {

    return id;
  }

  public void setId(Long id) {

    this.id = id;
  }

  public String getStreet() {

    return street;
  }

  public void setStreet(String street) {

    this.street = street;
  }

  public String getPostBox() {

    return postBox;
  }

  public void setPostBox(String postBox) {

    this.postBox = postBox;
  }

  public String getCountryCode() {

    return countryCode;
  }

  public void setCountryCode(String countryCode) {

    this.countryCode = countryCode;
  }

  public String getPostalCode() {

    return postalCode;
  }

  public void setPostalCode(String postalCode) {

    this.postalCode = postalCode;
  }

  public String getPlace() {

    return place;
  }

  public void setPlace(String place) {

    this.place = place;
  }

  public String getSuffix() {

    return suffix;
  }

  public void setSuffix(String suffix) {

    this.suffix = suffix;
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
    result = prime * result
      + ((countryCode == null) ? 0 : countryCode.hashCode());
    result = prime * result + ((place == null) ? 0 : place.hashCode());
    result = prime * result + ((postBox == null) ? 0 : postBox.hashCode());
    result = prime * result
      + ((postalCode == null) ? 0 : postalCode.hashCode());
    result = prime * result + ((street == null) ? 0 : street.hashCode());
    result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
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
    InstituteAddressEntity other = (InstituteAddressEntity) obj;
    if (countryCode == null) {
      if (other.countryCode != null)
        return false;
    } else if (!countryCode.equals(other.countryCode))
      return false;
    if (place == null) {
      if (other.place != null)
        return false;
    } else if (!place.equals(other.place))
      return false;
    if (postBox == null) {
      if (other.postBox != null)
        return false;
    } else if (!postBox.equals(other.postBox))
      return false;
    if (postalCode == null) {
      if (other.postalCode != null)
        return false;
    } else if (!postalCode.equals(other.postalCode))
      return false;
    if (street == null) {
      if (other.street != null)
        return false;
    } else if (!street.equals(other.street))
      return false;
    if (suffix == null) {
      if (other.suffix != null)
        return false;
    } else if (!suffix.equals(other.suffix))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("InstituteAddressEntity [id=").append(id).append(", countryCode=")
      .append(countryCode).append(", place=").append(place)
      .append(", postBox=").append(postBox).append(", postalCode=")
      .append(postalCode).append(", street=").append(street)
      .append(", suffix=").append(suffix).append("]");
    return builder.toString();
  }

}
