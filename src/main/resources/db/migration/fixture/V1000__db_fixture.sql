-- Runtime test fixture
insert into countries(iso_code,before_place_or_country,name,prefix_or_suffix,ptt_code)
 select * from csvread('src/test/resources/db/csv/countries.csv', null, 'fieldSeparator=|');
 
insert into institute_addresses(address_id,country_code,place,postbox,postal_code,street,suffix)
  select * from csvread('src/test/resources/db/csv/institutes_addresses.csv', null, 'fieldSeparator=|');

insert into institutes(code,english_name,library,name,original_name,place,status,institute_type,url,address_id,country_code,parent_institute)
  select * from csvread('src/test/resources/db/csv/institutes.csv', null, 'fieldSeparator=|');
  
insert into experiments(name,gb_flag,status)
  select * from csvread('src/test/resources/db/csv/experiments.csv', null, 'fieldSeparator=|');
  
insert into voms_persons(person_id,at_cern,ident,first_name,name,email,physical_email,institute,nationality1)
  select * from csvread('src/test/resources/db/csv/voms_persons.csv', null, 'fieldSeparator=|');
  
insert into person_participation(experiment,institute,person_id,start_date,end_date)
  select experiment,institute,person_id, parsedatetime(start_date, 'dd-MMM-yy'),
  parsedatetime(end_date, 'dd-MMM-yy')
  from csvread('src/test/resources/db/csv/person_participation.csv', null, 'fieldSeparator=|');