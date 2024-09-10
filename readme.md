
# Projet de Gestion de Bibliothèque

## Description du projet
Ce projet a pour objectif de développer une application de gestion de bibliothèque permettant de gérer les documents (livres, magazines, journaux scientifiques, thèses universitaires) et les utilisateurs (étudiants et professeurs). L'application intègre une base de données relationnelle et utilise des concepts avancés de la programmation orientée objet (POO) en Java.

## Objectif général de l'application
L'application permet :
- La gestion des documents (ajout, modification, suppression, consultation).
- La gestion des utilisateurs avec des droits d'emprunt et de réservation spécifiques.
- La gestion des emprunts et des retours de documents.
- La gestion des réservations de documents.

## Technologies utilisées
- **Java 8**
- **PostgreSQL**
- **JDBC**
- **Maven**
- **Git**, **JIRA**
- **Java Time API**

## Structure du projet
### Couche de présentation :
- **ConsoleUI** : Interface utilisateur console.

### Couche de métier :
- **Document** : Classe abstraite représentant un document générique.
    - **Livre**, **Magazine**, **JournalScientifique**, **ThèseUniversitaire** : Sous-classes avec des attributs spécifiques.
- **Bibliotheque** : Gère la collection de documents (CRUD) et la recherche.
- **Interfaces** : `Empruntable`, `Réservable`.

### Couche de persistance :
- **DAO** : `DocumentDAO`, `LivreDAO`, etc., pour gérer l'accès aux données.

### Couche utilitaire :
- **DateUtils** : Manipulation des dates.
- **InputValidator** : Validation des entrées utilisateur.

### Gestion des utilisateurs :
- **Utilisateur (classe abstraite)** : Classe générique pour les utilisateurs.
    - **Etudiant**, **Professeur** : Sous-classes avec droits spécifiques.

## Description brève de l'architecture adoptée
L'application est organisée en plusieurs couches : présentation, métier, persistance, et utilitaire. Chaque couche est responsable de son domaine fonctionnel, assurant ainsi la séparation des responsabilités et la flexibilité.

## Instructions d'installation et d'utilisation
### Prérequis
- **Java 8**
- **PostgreSQL**

### Étapes pour configurer la base de données
1. **Créer la base de données** :
   ```sql
   CREATE DATABASE gestion_bibliotheque;
