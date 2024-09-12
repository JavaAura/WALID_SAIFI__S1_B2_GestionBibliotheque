# Projet de Gestion de Bibliothèque

## Description du projet
Le projet "Gestion de Bibliothèque" est une application destinée aux bibliothèques municipales pour automatiser la gestion des documents tels que les livres, magazines, journaux scientifiques, et thèses universitaires. L'application permet également la gestion des utilisateurs (étudiants et professeurs), les emprunts, les retours et les réservations. Ce projet utilise Java et PostgreSQL pour assurer une bonne gestion de la base de données et offrir une interface utilisateur via une console.

## Objectifs
Les principaux objectifs de cette application sont :
- Automatiser la gestion des documents dans une bibliothèque.
- Suivre les emprunts et les retours en temps réel.
- Gérer les réservations de documents par les utilisateurs.
- Simplifier la gestion des utilisateurs et définir des droits spécifiques pour chaque type d’utilisateur.

## Fonctionnalités principales
- **Gestion des documents :**
  - Ajouter, modifier, supprimer et consulter des documents.
  - Différents types de documents gérés : livres, magazines, journaux scientifiques, thèses universitaires.
- **Gestion des utilisateurs :**
  - Support des étudiants et professeurs avec des privilèges spécifiques.
  - Gestion des emprunts et retours de documents par les utilisateurs.
- **Emprunts et retours :**
  - Suivi des emprunts avec des dates d'échéance.
  - Gestion des pénalités de retard (fonctionnalité à venir).
- **Réservation de documents :**
  - Réservation de documents déjà empruntés.
  - Notification des utilisateurs lorsque les documents sont disponibles (fonctionnalité future).
- **Rapports et statistiques :**
  - Génération de rapports sur les documents les plus empruntés.
  - Statistiques sur les utilisateurs actifs.

## Technologies utilisées
- **Java 8** : Utilisé pour la logique métier et la gestion des interactions avec la base de données.
- **PostgreSQL** : Base de données relationnelle pour stocker les informations des documents et des utilisateurs.
- **JDBC** : Pour la connexion et l'interaction avec la base de données PostgreSQL.
- **Maven** : Gestionnaire de dépendances et outil de construction.
- **Git** : Pour le contrôle de version et la gestion collaborative du code.
- **JIRA** : Utilisé pour la gestion des tâches et la planification du projet.
- **Java Time API** : Utilisé pour gérer les dates et les heures, notamment pour les emprunts et retours.

## Architecture de l'application
### Couche présentation
- **ConsoleUI** : Interface utilisateur basée sur la console. Cette couche permet d'interagir avec l'utilisateur final pour entrer des informations telles que les titres des documents, les dates de retour, etc. Elle affiche également les résultats des opérations comme la liste des documents disponibles ou les détails d'un document.

### Couche métier
- **Document** : Classe abstraite qui représente les documents génériques dans la bibliothèque. Les sous-classes suivantes héritent de cette classe :
  - **Livre** : Représente un livre avec des attributs comme `isbn`, `auteur`, `titre`, `dateDePublication`, `nombreDePages`.
  - **Magazine** : Représente un magazine avec des informations spécifiques telles que le `numéro`.
  - **JournalScientifique** : Représente les journaux scientifiques avec des détails comme la date de publication.
  - **ThèseUniversitaire** : Représente les thèses avec des détails comme le domaine de recherche et l'université d'origine.
- **Bibliotheque** : Classe centrale qui gère l'inventaire des documents. Elle contient des méthodes pour ajouter, supprimer, consulter des documents, ainsi que pour emprunter, retourner ou réserver un document.
- **Utilisateur (classe abstraite)** : Gère les utilisateurs dans le système. Les sous-classes comprennent :
  - **Etudiant** : Les étudiants ont des limites spécifiques quant au nombre de documents qu'ils peuvent emprunter.
  - **Professeur** : Les professeurs ont plus de droits, notamment la possibilité d'emprunter plus de documents simultanément et pour une période plus longue.

### Couche persistance
- **DAO (Data Access Object)** : Cette couche gère les interactions avec la base de données PostgreSQL. Chaque classe de document et d'utilisateur a son DAO correspondant. Par exemple :
  - `LivreDAO` : Gère les opérations CRUD pour les livres.
  - `MagazineDAO` : Gère les opérations CRUD pour les magazines.
  - `UtilisateurDAO` : Gère les utilisateurs dans la base de données.
- **dbConnection** : Cette classe gère la connexion à la base de données PostgreSQL. Elle utilise un modèle Singleton pour garantir qu'une seule instance de la connexion est active à tout moment.

### Couche utilitaire
- **DateUtils** : Classe utilitaire pour la manipulation et le formatage des dates, notamment pour gérer les dates d'emprunt et de retour.
- **InputValidator** : Classe utilitaire pour valider les entrées utilisateur, comme les dates, les noms et les identifiants.

## Prérequis
Avant d'installer et d'exécuter ce projet, vous devez disposer des éléments suivants :
- **Java 8** doit être installé sur votre machine.
- **PostgreSQL** : Vous devez avoir un serveur PostgreSQL en cours d'exécution et avoir créé une base de données pour l'application.
- **Maven** : Assurez-vous que Maven est installé pour gérer les dépendances et la construction du projet.

## Installation

### Étapes d'installation
1. **Cloner le dépôt Git** :
   Clonez le projet à partir du dépôt GitHub.
   ```bash
   git clone https://github.com/votre-utilisateur/gestion-bibliotheque.git
