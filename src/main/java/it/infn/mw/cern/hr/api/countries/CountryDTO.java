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
