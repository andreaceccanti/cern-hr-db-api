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

create sequence hibernate_sequence start with 10000 increment by  1;

create table foundation_pub.gdt2511_voms_institutes (
  id varchar2(6 char) not null, 
  country varchar2(2 char), 
  longname varchar2(71 char), 
  town varchar2(30 char), 
  primary key (id));
  
create table foundation_pub.gdt2511_voms_participation (
  experiment varchar2(255 char) not null, 
  institute varchar2(255 char) not null, 
  person_id number(19,0) not null, 
  start_date date not null, 
  end_date date, 
  primary key (experiment, institute, person_id, start_date));
  
create table foundation_pub.gdt2511_voms_persons (
  person_id number(19,0) not null, 
  beep varchar2(5 char), 
  building varchar2(10 char), 
  depart varchar2(3 char), 
  email varchar2(60 char), 
  first_name varchar2(18 char) not null, 
  floor varchar2(2 char), 
  grp varchar2(3 char), 
  name varchar2(24 char) not null, 
  physical_email varchar2(60 char), 
  portable_phone varchar2(5 char), 
  room varchar2(4 char), 
  sect varchar2(3 char), 
  tel_1 varchar2(5 char), 
  tel_2 varchar2(5 char), 
  tel_3 varchar2(5 char), 
  institute varchar2(6 char), 
  primary key (person_id));
  
alter table foundation_pub.gdt2511_voms_participation 
  add constraint FKlcgtm1ucef1ucuwwf66jb9c2s foreign key (institute) references foundation_pub.gdt2511_voms_institutes;
alter table foundation_pub.gdt2511_voms_participation 
  add constraint FKceig7hcrhlwruyenibgqa97pm foreign key (person_id) references foundation_pub.gdt2511_voms_persons;
alter table foundation_pub.gdt2511_voms_persons
  add constraint FKph4cdpqifjhmtsxdbk9t8ttrl foreign key (institute) references foundation_pub.gdt2511_voms_institutes;