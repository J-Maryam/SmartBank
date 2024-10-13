# Application JEE pour la Simulation des Crédits

## Description
Cette application web permet aux clients de SmartBank de simuler et de calculer la mensualité de leurs crédits à travers une interface utilisateur intuitive. Les utilisateurs peuvent soumettre leurs demandes de crédit, qui sont ensuite traitées et suivies par le personnel de la banque.

L'application permet :
- La simulation des crédits par les clients.
- Le calcul de la mensualité sur la base d'une formule spécifique.
- La validation et l'envoi des demandes de crédit.
- Le suivi des demandes de crédit avec des filtres par date et par état.
- La gestion de l'historique des modifications des états de chaque demande.
- La consultation des détails complets d'une demande de crédit.

## Contexte
SmartBank souhaite offrir une interface de simulation de crédits à ses clients pour leur permettre de calculer les mensualités de leurs prêts et soumettre des demandes de crédit pour traitement.

## Fonctionnalités principales
1. **Simulation de crédit** : Le client peut simuler un crédit et obtenir une estimation des mensualités.
2. **Calcul de la mensualité** : Le calcul se base sur une formule fournie (pièce jointe).
3. **Soumission de la demande** : Après simulation, le client peut soumettre la demande de crédit pour traitement.
4. **Suivi des demandes** : L'application permet de consulter une liste de demandes avec la possibilité de filtrer par date et état.
5. **Gestion des états** : L'état d'une demande peut être modifié, et chaque modification est enregistrée avec un historique des changements.
6. **Détails des demandes** : Les détails complets d'une demande et son historique peuvent être affichés.

## Technologies utilisées
- **Maven** : Pour la gestion des dépendances.
- **JPA (Java Persistence API)** et **Hibernate** : Pour l'ORM (Mapping Objet-Relationnel) et la gestion des entités.
- **Servlets** : Pour la gestion des requêtes HTTP.
- **JSP (JavaServer Pages)** et **JSTL (JavaServer Pages Standard Tag Library)** : Pour les vues (interfaces utilisateur).
- **JUnit** et **Mockito** : Pour les tests unitaires et les tests de simulation.
- **Tomcat** (ou autre serveur comme Jetty, Netty, Glassfish) : Serveur d'application.
- **HTTP** : Pour la communication entre le frontend et le backend.
  
## Architecture
L'application est structurée en couches séparées :
1. **Couche de présentation (UI)** : Utilise JSP pour afficher les interfaces utilisateur.
2. **Couche des services** : Contient la logique métier, notamment le calcul de la mensualité.
3. **Couche de persistance** : Gère l'interaction avec la base de données à l'aide de JPA et Hibernate.
4. **Couche des tests** : Inclut des tests unitaires avec JUnit et des mocks avec Mockito.

### Calcul des mensualités
Le calcul de la mensualité est réalisé à l'aide d'une formule spécifique. Ce calcul est fait à la fois en frontend pour la simulation immédiate et validé en backend pour garantir l'exactitude avant l'insertion en base.

### Gestion des demandes
Chaque demande de crédit est caractérisée par :
- Numéro de demande
- Date de création
- Montant demandé
- Durée du crédit
- État de la demande (en cours, accepté, refusé)
- Remarques
- Historique des modifications d'état

## Installation et exécution

### Prérequis
- JDK 8 ou supérieur
- Maven
- Serveur Tomcat
- Base de données (PostgreSQL)

### Étapes d'installation
1. **Cloner le projet GitHub** :
   ```bash
   https://github.com/J-Maryam/SmartBank.git
   ```

2. **Configurer la base de données** :
   - Modifier le fichier `persistence.xml` pour y ajouter les informations de connexion à la base de données.

3. **Compiler le projet** :
   ```bash
   mvn clean install
   ```

4. **Déployer sur Tomcat** :
   - Copier le fichier WAR généré dans le répertoire `webapps` de Tomcat.

5. **Démarrer Tomcat** :
   - Accéder à l'application via `http://localhost:8080/SmartBank_war/`.

### Utilisation
- Accéder à l'application depuis un navigateur.
- Simuler un crédit, soumettre une demande et consulter les demandes existantes.

## Auteur
Développé par Jammar Maryam

## Licence
Ce projet est sous licence MIT.

