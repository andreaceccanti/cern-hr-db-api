create sequence hibernate_sequence start with 1 increment by  1;

create table countries (iso_code varchar2(2 char) not null, 
  before_place_or_country varchar2(1 char) not null, 
  name varchar2(17 char) not null, 
  prefix_or_suffix varchar2(1 char) not null, 
  ptt_code varchar2(4 char), 
  primary key (iso_code));
  
create table experiments (name varchar2(60 char) not null, 
  beam varchar2(20 char), 
  documentation_page varchar2(150 char), 
  email varchar2(150 char), 
  gb_flag varchar2(1 char) not null, 
  home_page varchar2(150 char), 
  mnemonic varchar2(20 char), 
  programme varchar2(10 char), 
  status varchar2(2 char) not null, 
  title varchar2(300 char), 
  parent_experiment varchar2(60 char), 
  primary key (name));

create table institute_addresses (address_id number(19,0) not null, 
  country_code varchar2(2 char) not null, 
  place varchar2(30 char), 
  postbox varchar2(35 char), 
  postal_code varchar2(10 char), 
  street varchar2(35 char), 
  suffix varchar2(15 char), 
  primary key (address_id));

create table institutes (code varchar2(6 char) not null, 
  english_name varchar2(71 char), 
  library varchar2(1 char) not null, 
  name varchar2(71 char), 
  original_name varchar2(71 char), 
  place varchar2(30 char) not null, 
  status varchar2(1 char) not null, 
  institute_type varchar2(2 char), 
  url varchar2(100 char), 
  address_id number(19,0), 
  country_code varchar2(2 char), 
  parent_institute varchar2(6 char), 
  primary key (code));

create table person_participation (experiment varchar2(255 char) not null, 
  institute varchar2(255 char) not null, 
  person_id number(19,0) not null, 
  start_date date not null, 
  end_date date, 
  fax_number varchar2(30 char), 
  greybook varchar2(1 char),
  subexperiment varchar2(255 char), 
  telephone_number varchar2(30 char), 
  primary key (experiment, institute, person_id, start_date));

create table voms_persons (person_id number(19,0) not null, 
  at_cern varchar2(1 char) not null, 
  beep varchar2(5 char), 
  building varchar2(10 char), 
  ident number(19,0), 
  date_of_birth date, 
  depart varchar2(3 char), 
  email varchar2(60 char), 
  firm varchar2(14 char), 
  first_name varchar2(18 char) not null, 
  floor varchar2(2 char), 
  grp varchar2(3 char), 
  name varchar2(24 char) not null, 
  person_class varchar2(6 char), 
  physical_email varchar2(60 char), 
  portable_phone varchar2(5 char), 
  processing_end_date timestamp, 
  processing_start_date timestamp, 
  room varchar2(4 char), 
  sect varchar2(3 char), 
  supervisor_of_external_staff number(1,0), 
  tel_1 varchar2(5 char), 
  tel_2 varchar2(5 char), 
  tel_3 varchar2(5 char), 
  institute varchar2(6 char), 
  nationality1 varchar2(2 char), 
  primary key (person_id));

alter table countries add constraint UK_1pyiwrqimi3hnl3vtgsypj5r unique (name);
alter table experiments add constraint FKmcvks023d6d02kl1jgklrhr03 foreign key (parent_experiment) references experiments;
alter table institutes add constraint FKf6omfpsy85mgpi6kcv9ke7oi5 foreign key (address_id) references institute_addresses;
alter table institutes add constraint FKtes90rkgacam7a7a13btq5ds6 foreign key (country_code) references countries;
alter table institutes add constraint FKqvryoom2act1h3mi25yyeevws foreign key (parent_institute) references institutes;
alter table person_participation add constraint FKl41gyj505qkyk87sdqi86uip foreign key (experiment) references experiments;
alter table person_participation add constraint FKtff6lo3plvl59evksuw76dd8j foreign key (institute) references institutes;
alter table person_participation add constraint FKklts2h90amiticmkw8ockelu foreign key (person_id) references voms_persons;
alter table voms_persons add constraint FK8fa5p3n7cw662ue5vonje6ns9 foreign key (institute) references institutes;
alter table voms_persons add constraint FKllchk1a39s55sagh9x0nmymrt foreign key (nationality1) references countries;