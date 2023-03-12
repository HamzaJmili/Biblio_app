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



CREATE TRIGGER auteur_trg
    BEFORE INSERT ON auteur
    FOR EACH ROW
    BEGIN
      SELECT idauteur.NEXTVAL
     INTO :new.id_auteur
     FROM dual;
   END;
   /

 
    create table favoris (id number , id_etudiant number , id_livre number );
     alter table favoris modify id number primary key;
      alter table favoris modify id_etudiant VARCHAR2(20) ;
       alter table favoris add constraint foreign_id_etudiant foreign key ( id_etudiant ) references etudiant (CNE) ;
    alter table favoris add constraint foreign_id_books foreign key ( id_livre ) references livre (id_livre)
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