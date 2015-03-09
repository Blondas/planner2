


--------------------------------------------- ogolne
CREATE TABLE nazwy_slownikow
(
  ns_id numeric(38,0) PRIMARY KEY
  ,ns_nazwa text
)  ;

CREATE TABLE slownik
(
  s_id numeric(38,0) PRIMARY KEY
  ,s_nazwa_slownika_id numeric(38,0) PRIMARY KEY
  ,s_nazwa text
);  

create table uprawnienia
(
u_id numeric(38,0) PRIMARY KEY
,u_uprawnienie_id numeric(38,0)
,u_user_id numeric(38,0)
);

create table users
(
us_id numeric(38,0) PRIMARY KEY
,us_login text
,us_haslo text
,us_haslo_md5 text
);

--------------------------------------------- zestawy grup
CREATE TABLE jednostki_programu_studiow
(
  jds_id numeric(38,0) PRIMARY KEY
  ,jds_nazwa_id numeric(38,0)
  ,jds_typ_przedmiotu_id numeric(38,0)
);


CREATE TABLE grupy_studenckie
(
  gs_id numeric(38,0) PRIMARY KEY
  ,gs_oznaczenie_literowe_id numeric(38,0)
  ,gs_data_rozpoczecia date
  ,gs_data_zakonczenia date
  ,gs_kierunek_studiow_id numeric(38,0)
  ,gs_wydzial_id numeric(38,0)
);


create table agregaty 
(
a_id numeric(38,0) PRIMARY KEY
,a_awatar_id numeric(38,0) 
,a_jednostki_programu_studiow_id numeric(38,0) 
,a_grupy_studenckie_id numeric(38,0) 
);

create table awatary
(
aw_id numeric(38,0) PRIMARY KEY
aw_nazwa text
);

create table prowadzacy_zajecia
(
pz_id numeric(38,0) PRIMARY KEY
,pz_imie text
,pz_nazwisko text
,pz_awatar_id numeric(38,0)
);

--------------------------------------------- laczenie agregatow grup ,wykladowcow z datami i salami
create table zajecia_terminy_rel
(
ztr_id numeric(38,0) PRIMARY KEY
,ztr_agregat_id numeric(38,0) 
,ztr_plan_zajec_id numeric(38,0) 
);
-------------------------------------------
create table plany_zajec
(
pz_id numeric(38,0) PRIMARY KEY
,pz_nazwa_planu numeric(38,0)
,pz_data date
,pz_operator_id numeric(38,0)
);

------------------------------------------- agregaty sal, godzin oraz dat
create table salo_godzina
(
sg_id numeric(38,0) PRIMARY KEY
,sg_zajecia_termin_id numeric(38,0) 
,sg_godzina_od_id numeric(38,0) 
,sg_godzina do_id numeric(38,0) 
,sg_sala_id numeric(38,0) 
);


create table sale
(
s_id numeric(38,0) PRIMARY KEY
,s_numer_sali numeric(38,0)
,s_budynek_id numeric(38,0)
,s_ilosc_miejsc numeric(38,0)
,s_budynki_id numeric(38,0)
);

create table zestaw_terminow
(
zt_id numeric(38,0) PRIMARY KEY
,zt_zajecia_terminy_id numeric(38,0)
);

create table szablony(
sz_id numeric(38,0) PRIMARY KEY
,sz_nazwa text
,sz_zestawy_terminow_id numeric(38,0)
);

create table daty_konkretne(
dk_id numeric(38,0) PRIMARY KEY
,dk_data_prawdziwa date
,dk_szablony_id numeric(38,0)
);


  

