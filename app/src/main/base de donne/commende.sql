 create table livre(id_livre int primary key ,titre varchar(20),description varchar(300),couverture varchar(30),id_auteur int, nombre_pages int );
 create table auteur(id_auteur int primary key ,nom_auteur varchar(20),prenom_auteur varchar(20),bio_auteur varchar(300));
 create table tag(id_tag int primary key , nom_tag varchar(20));
 create table etudiant(cne varchar(20) primary key , nom_etudiant varchar(20) ,prenom_etudiant varchar(20),email_etudiant varchar(30),mdp_etudiant varchar(30),filiere varchar(10),telephone varchar(15));
 create table admin(id_admin int primary key , nom_admin varchar(20) ,prenom_admin varchar(20),email_admin varchar(30),mdp_admin varchar(30));
create table avoir( id_tag int ,id_livre int ,primary key(id_tag,id_livre));
 create table reserve(cne varchar(20) ,id_livre int ,date_debut date ,date_fin date , primary key(cne,id_livre));
 ALTER TABLE livre ADD CONSTRAINT fk_1 FOREIGN KEY (id_auteur) REFERENCES auteur(id_auteur);
 ALTER TABLE avoir  ADD CONSTRAINT fk_2 FOREIGN KEY (id_tag) REFERENCES tag(id_tag);
ALTER TABLE avoir  ADD CONSTRAINT fk_3 FOREIGN KEY (id_livre) REFERENCES livre(id_livre);
ALTER TABLE reserve  ADD CONSTRAINT fk_4 FOREIGN KEY (cne) REFERENCES etudiant(cne);
 ALTER TABLE reserve  ADD CONSTRAINT fk_5 FOREIGN KEY (id_livre) REFERENCES livre(id_livre);
 create sequence idlivre start with 1 increment by 1 ;
create sequence idtag start with 1 increment by 1 ;
 insert into livre values (4,'ilias','ilias','ilias',2,1800);

 CREATE TRIGGER livre_trg
   BEFORE INSERT ON livre
    FOR EACH ROW
    BEGIN
      SELECT idlivre.NEXTVAL
      INTO :new.id_livre
      FROM dual;         
    END;
    /

     CREATE TRIGGER tag_trg
   BEFORE INSERT ON tag
    FOR EACH ROW
    BEGIN
      SELECT idtag.NEXTVAL
      INTO :new.id_tag
      FROM dual;         
    END;
    /



CREATE TRIGGER exemplaire_m
    BEFORE INSERT ON reserve
    
    BEGIN
      update livre
    set  new:EXEMPLAIRE= old:EXEMPLAIRE-1
    where livre.id_livre=reserve.id_livre;
   END;
   /
<<<<<<< HEAD

 
    create table favoris (id number , id_etudiant number , id_livre number );
     alter table favoris modify id number primary key;
      alter table favoris modify id_etudiant VARCHAR2(20) ;
       alter table favoris add constraint foreign_id_etudiant foreign key ( id_etudiant ) references etudiant (CNE) ;
    alter table favoris add constraint foreign_id_books foreign key ( id_livre ) references livre (id_livre) on delete cascade;
  alter table favoris modify constraint foreign_id_books foreign key ( id_livre ) references livre (id_livre) on delete cascade;
 create sequence idtag start with 1 increment by 1 ;
  create sequence idfavoris start with 1 increment by 1 ;
  CREATE TRIGGER favoris_trg
    BEFORE INSERT ON favoris
    FOR EACH ROW
    BEGIN
      SELECT idfavoris.NEXTVAL
     INTO :new.id
     FROM dual;
   END;
   /

   CREATE TABLE reserve (
  id_reserve NUMBER(10) PRIMARY KEY,
  CNE VARCHAR2(20) NOT NULL,
  ID_LIVRE NUMBER(38) NOT NULL,
  DATE_DEBUT DATE,
  DATE_FIN DATE,
  CONSTRAINT fk_reserve_etudiant FOREIGN KEY (CNE)
    REFERENCES etudiant (CNE),
  CONSTRAINT fk_reserve_livre FOREIGN KEY (ID_LIVRE)
    REFERENCES livre (ID_LIVRE)
);
ALTER TABLE reserve ADD reserve_now VARCHAR2(3) NOT NULL;
create sequence reserve_sequence start with 1 increment by 1;
 create sequence idtag start with 1 increment by 1 ;
  CREATE TRIGGER reserve_trg
   BEFORE INSERT ON reserve
    FOR EACH ROW
    BEGIN
      SELECT reserve_sequence.nextval
      INTO :new.ID_RESERVE
      FROM dual;         
    END;
    /
    alter table livre add exemplaire NUMBER;
    CREATE OR REPLACE TRIGGER trg_update_exemplaire
  AFTER INSERT ON reserve
   FOR EACH ROW

   BEGIN

  UPDATE livre
    SET exemplaire = exemplaire - 1
WHERE ID_LIVRE = :NEW.ID_LIVRE;
 END;
  /
   create view reserve_now_view as select * from reserve where RESERVE_NOW='yes';

   // new commande 5/1/2023 
   alter table livre add nb_like number(20) ;
   alter table reserve drop constraint FK_RESERVE_LIVRE ;
   alter table reserve add constraint fk_bookid_reserve foreign key ( id_livre ) references livre (id_livre) on delete cascade;
   alter table avoir drop constraint FK_3 ;
   ALTER TABLE avoir  ADD CONSTRAINT fk_3 FOREIGN KEY (id_livre) REFERENCES livre(id_livre) on delete cascade;

  


