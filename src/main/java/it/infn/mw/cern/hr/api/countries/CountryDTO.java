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
package it.infn.mw.cern.hr.api.countries;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_EMPTY)
public class CountryDTO {

  String isoCode;
  String name;
  String pttCode;
  String prefixOrSuffix;
  String beforePlaceOrCountry;
  
  public CountryDTO() {
    // empty ctor
  }

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPttCode() {
    return pttCode;
  }

  public void setPttCode(String pttCode) {
    this.pttCode = pttCode;
  }

  public String getPrefixOrSuffix() {
    return prefixOrSuffix;
  }

  public void setPrefixOrSuffix(String prefixOrSuffix) {
    this.prefixOrSuffix = prefixOrSuffix;
  }

  public String getBeforePlaceOrCountry() {
    return beforePlaceOrCountry;
  }

  public void setBeforePlaceOrCountry(String beforePlaceOrCountry) {
    this.beforePlaceOrCountry = beforePlaceOrCountry;
  }
}
