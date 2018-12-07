--
-- Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2018
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--     http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- Test fixture
insert into countries(iso_code,before_place_or_country,name,prefix_or_suffix,ptt_code)
 select * from csvread('classpath:/db/csv/countries.csv', null, 'fieldSeparator=|');
 
insert into institute_addresses(address_id,country_code,place,postbox,postal_code,street,suffix)
  select * from csvread('classpath:/db/csv/institutes_addresses.csv', null, 'fieldSeparator=|');

insert into institutes(code,english_name,library,name,original_name,place,status,institute_type,url,address_id,country_code,parent_institute)
  select * from csvread('classpath:/db/csv/institutes.csv', null, 'fieldSeparator=|');
  
insert into experiments(name,gb_flag,status)
  select * from csvread('classpath:/db/csv/experiments.csv', null, 'fieldSeparator=|');
  
insert into voms_persons(person_id,at_cern,ident,first_name,name,email,physical_email,institute,nationality1)
  select * from csvread('classpath:/db/csv/voms_persons.csv', null, 'fieldSeparator=|');
  
--insert into person_participation(experiment,institute,person_id,start_date,end_date)
--  select experiment,institute,person_id, parsedatetime(start_date, 'dd-MMM-yy'),
--  parsedatetime(end_date, 'dd-MMM-yy')
--  from csvread('classpath:/db/csv/person_participation.csv', null, 'fieldSeparator=|');