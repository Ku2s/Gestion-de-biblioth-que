-- Table Adherents
CREATE TABLE IF NOT EXISTS Adherents (
    Adherent_ID INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(255),
    Prenom VARCHAR(255),
    Statut ENUM('Enseignant', 'Étudiant')
);

-- Table Documents
CREATE TABLE IF NOT EXISTS Documents (
    Document_ID INT AUTO_INCREMENT PRIMARY KEY,
    Titre VARCHAR(255),
    Auteur VARCHAR(255)
);

-- Table Livres
CREATE TABLE IF NOT EXISTS Livres (
    Livre_ID INT AUTO_INCREMENT PRIMARY KEY,
    Document_ID INT,
    FOREIGN KEY (Document_ID) REFERENCES Documents(Document_ID),
    -- Autres attributs spécifiques aux livres
);

-- Table BandesDessinees
CREATE TABLE IF NOT EXISTS BandesDessinees (
    BandeDessinee_ID INT AUTO_INCREMENT PRIMARY KEY,
    Document_ID INT,
    FOREIGN KEY (Document_ID) REFERENCES Documents(Document_ID),
    -- Autres attributs spécifiques aux bandes dessinées
);

-- Table Materiels
CREATE TABLE IF NOT EXISTS Materiels (
    Materiel_ID INT AUTO_INCREMENT PRIMARY KEY,
    Marque VARCHAR(255),
    OS ENUM('LINUX', 'WINDOWS')
);

-- Table Emprunts
CREATE TABLE IF NOT EXISTS Emprunts (
    Emprunt_ID INT AUTO_INCREMENT PRIMARY KEY,
    Adherent_ID INT,
    Document_ID INT,
    Materiel_ID INT,
    Date_emprunt DATE DEFAULT CURRENT_DATE,
    Date_retour DATE,
    FOREIGN KEY (Adherent_ID) REFERENCES Adherents(Adherent_ID),
    FOREIGN KEY (Document_ID) REFERENCES Documents(Document_ID),
    FOREIGN KEY (Materiel_ID) REFERENCES Materiels(Materiel_ID),
    -- Contrainte pour limiter à 5 emprunts par adhérent
    CONSTRAINT max_emprunts CHECK (Adherent_ID NOT IN (
        SELECT Adherent_ID FROM Emprunts WHERE Date_retour IS NULL
        GROUP BY Adherent_ID
        HAVING COUNT(*) >= 5
    ))
);
