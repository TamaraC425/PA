drop sequence album_id_auto;
/
drop sequence artist_auto_inc;
/
drop sequence album_chart_billboard;
/
drop sequence album_chart_sales;
/
drop table albums;
/
drop table artists;
/
create table artists(
id int not null,
name varchar(100) not null,
country varchar(100),
primary key (id)
);
create table albums(
    id int not null ,
    name varchar(100) not null,
    artist_id int not null,
    release_year int,
    primary key (id),
    constraint fk_artist_id FOREIGN KEY(artist_id) REFERENCES artists(id)
);
/
create sequence album_id_auto minvalue 1 start with 1 increment by 1;
/
create sequence artist_auto_inc minvalue 1 start with 1 increment by 1;
/
drop table billboard_album_chart;
/
drop table top_albums_sales_chart;
/
create table billboard_album_chart(
nr int not null,
albumId int not null,
albumName varchar2(100) not null,
artistId int not null,
release_year int not null, 
primary key(nr),
constraint fk_artistId FOREIGN KEY(artistId) REFERENCES artists(id),
constraint fk_albumId FOREIGN KEY(albumId) REFERENCES albums(id)
);
create sequence album_chart_billboard minvalue 1 start with 1 increment by 1;
/
create table top_albums_sales_chart(nr int not null,album_id int not null,album_name varchar2(100) not null,id_artist int not null,release_year int not null,primary key(nr),constraint fk_id_artist FOREIGN KEY(id_artist) REFERENCES artists(id),constraint fk_album_id FOREIGN KEY(album_id) REFERENCES albums(id));

/
create sequence album_chart_sales minvalue 1 start with 1 increment by 1;
