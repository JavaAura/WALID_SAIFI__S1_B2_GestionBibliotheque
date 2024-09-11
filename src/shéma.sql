CREATE TABLE Document (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255),
    date_de_publication DATE,
    nombre_de_pages INT,
    etat VARCHAR(50) -- Par exemple: disponible, emprunté, réservé
);



CREATE TABLE Livre (
    isbn VARCHAR(13) UNIQUE NOT NULL
) INHERITS (Document);


CREATE TABLE Magazine (
    numero VARCHAR(10) UNIQUE NOT NULL
) INHERITS (Document);

CREATE TABLE Utilisateur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) UNIQUE NOT NULL
);



CREATE TABLE Etudiant (
    matricule VARCHAR(20) UNIQUE NOT NULL
) INHERITS (Utilisateur);


CREATE TABLE Professeur (
    departement VARCHAR(255)
) INHERITS (Utilisateur);

CREATE TABLE Emprunt (
    id SERIAL PRIMARY KEY,
    document_id INT NOT NULL REFERENCES Document(id),
    utilisateur_id INT NOT NULL REFERENCES Utilisateur(id),
    date_emprunt DATE NOT NULL,
    date_retour DATE
);

CREATE TABLE Reservation (
    id SERIAL PRIMARY KEY,
    document_id INT NOT NULL REFERENCES Document(id),
    utilisateur_id INT NOT NULL REFERENCES Utilisateur(id),
    date_reservation DATE NOT NULL,
    date_annulation DATE
);


-- Table JournalScientifique qui hérite de Document
CREATE TABLE JournalScientifique (
    domaine_recherche VARCHAR(255)
) INHERITS (Document);


-- Table ThèseUniversitaire qui hérite de Document
CREATE TABLE TheseUniversitaire (
    universite VARCHAR(255),
    domaine VARCHAR(255)
) INHERITS (Document);

