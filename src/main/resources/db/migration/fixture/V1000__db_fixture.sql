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

insert into gdt2511_voms_institutes(id,longname,town,country)
  select * from csvread('src/test/resources/db/csv/institutes.csv', null, 'fieldSeparator=|');

insert into gdt2511_voms_persons(person_id,first_name,name,email,physical_email,institute)
  select * from csvread('src/test/resources/db/csv/vo_persons.csv', null, 'fieldSeparator=|');
  
insert into gdt2511_voms_participation(experiment,institute,person_id,start_date,end_date)
  select experiment,institute,person_id, parsedatetime(start_date, 'dd-MMM-yy'),
  parsedatetime(end_date, 'dd-MMM-yy')
  from csvread('src/test/resources/db/csv/participations.csv', null, 'fieldSeparator=|');