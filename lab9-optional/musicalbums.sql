
drop sequence album_id_auto;
/
drop sequence artist_auto_inc;
/
drop table top_albums_sales_chart;
/
drop table billboard_album_chart;
/

drop table albums;
/
drop table artists;
/
drop SEQUENCE album_chart_billboard;
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
create table billboard_album_chart(id int not null,
                albumId int not null,
                albumName varchar2(100) not null,
                artistId int not null,release_year int not null,nr_votes int not null,primary key(id),
                constraint fk_artistId FOREIGN KEY(artistId) REFERENCES artists(id),constraint fk_albumId FOREIGN KEY(albumId) REFERENCES albums(id));
                
                
                create sequence album_chart_billboard minvalue 1 start with 1 increment by 1;