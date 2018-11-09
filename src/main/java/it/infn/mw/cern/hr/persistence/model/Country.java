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
package it.infn.mw.cern.hr.persistence.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "ISO_CODE", length = 2)
  String isoCode;

  @Column(nullable = false, unique = true, name = "NAME", length = 17)
  String name;

  @Column(name = "PTT_CODE", length = 4)
  String pttCode;

  @Column(nullable = false, length = 1, name = "PREFIX_OR_SUFFIX")
  String prefixOrSuffix;

  @Column(nullable = false, length = 1, name = "BEFORE_PLACE_OR_COUNTRY")
  String beforePlaceOrCountry;

  public Country() {

  }

  public String getIsoCode() {

    return isoCode;
  }

  public String getName() {

    return name;
  }

  public String getPttCode() {

    return pttCode;
  }

  public String getPrefixOrSuffix() {

    return prefixOrSuffix;
  }

  public String getBeforePlaceOrCountry() {

    return beforePlaceOrCountry;
  }

  public void setIsoCode(String isoCode) {

    this.isoCode = isoCode;
  }

  public void setName(String name) {

    this.name = name;
  }

  public void setPttCode(String pttCode) {

    this.pttCode = pttCode;
  }

  public void setPrefixOrSuffix(String prefixOrSuffix) {

    this.prefixOrSuffix = prefixOrSuffix;
  }

  public void setBeforePlaceOrCountry(String beforePlaceOrCountry) {

    this.beforePlaceOrCountry = beforePlaceOrCountry;
  }

  @Generated("eclipse")
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Generated("eclipse")
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Country other = (Country) obj;
    if (isoCode == null) {
      if (other.isoCode != null)
        return false;
    } else if (!isoCode.equals(other.isoCode))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
