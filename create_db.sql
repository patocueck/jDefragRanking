--sqlplus "sys as sysdba" password vacio
create tablespace dfrankdb_tabspace
datafile 'dfrankdb_tabspace.dat'
size 548M autoextend on;
--alter database datafile 'crmdb_tabspace.dat' resize 4024M;

create temporary tablespace dfrankdb_tabspace_temp
tempfile 'dfrankdb_tabspace_temp.dat'
size 548M autoextend on;

create user dfrankdb
identified by dfrankdb
default tablespace dfrankdb_tabspace
temporary tablespace dfrankdb_tabspace_temp;

grant create session to dfrankdb;
grant create table to dfrankdb;
grant create any procedure to dfrankdb;
grant unlimited tablespace to dfrankdb;
grant create sequence to dfrankdb;
grant create trigger to dfrankdb;