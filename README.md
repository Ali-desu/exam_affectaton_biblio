## Présentation du projet
Ce projet est un système de gestion de bibliothèque développé en utilisant Java Persistence API (JPA), JSON (Jackson), et des Servlets. Il utilise le modèle DAO (Data Access Object) et le modèle MVC pour une gestion efficace des données et inclut des opérations essentielles telles que l'emprunt, le retour de documents, et la gestion des utilisateurs.

**Note :**  
La partie de l'examen du projet se concentre sur les fonctionnalités de base telles que les classes DAO, JPA, et la gestion des entités. Elle ne comprend pas les Servlets ni la gestion JSON (Jackson). Malheureusement, je n'ai pas pu terminer tout pendant l'examen, et j'ai ajouté certaines améliorations par frustration après pour mieux démontrer les fonctionnalités.

## Fonctionnalités
- Afficher la liste de tous les documents disponibles
- Montrer les emprunts en cours
- Retourner un document emprunté
- Emprunter un document
- Enregistrer un nouvel utilisateur
- Ajouter un nouveau livre ou magazine

## Technologies
- Java Persistence API (JPA) avec EclipseLink comme implémentation
- Jackson pour la sérialisation et la désérialisation des données
- Servlets pour la gestion des requêtes et réponses HTTP
- Modèle DAO pour organiser les interactions avec la base de données

## Utilisation
1. Pour enregistrer un utilisateur, envoyez une requête POST à `/addUser` avec les détails de l'utilisateur.
2. Pour afficher la liste de tous les documents disponibles, envoyez une requête GET à `/listDocuments`.
3. Pour afficher la liste des utilisateurs, envoyez une requête GET à `/users`.
4. Pour emprunter un document, envoyez une requête POST à `/borrow` avec les informations nécessaires concernant le document et l'utilisateur.  
