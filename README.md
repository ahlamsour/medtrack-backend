# 🩺 MedTrack — Application de Suivi Médical à Domicile

## 🧠 Description
**MedTrack** est une application de suivi des traitements médicaux à domicile, développée avec **Spring Boot** et **Kotlin**.  
Elle permet à chaque médecin de gérer ses patients, leurs médicaments, ainsi que le suivi des prises quotidiennes.  
Le but principal est d’aider les médecins à assurer un suivi précis et continu des traitements, en visualisant les prises effectuées ou oubliées.

---

## ⚙️ Technologies utilisées
- Kotlin
- Spring Boot 3
- Spring Data JPA
- MySQL
- Postman
- IntelliJ IDEA
- Architecture : MVC (Model – View – Controller)
- Build Tool : Gradle

---

## 🧱 Architecture
Le projet suit une architecture en couches :
- **Entity** : Représentation des tables de la base de données
- **Repository** : Gestion CRUD
- **Service** : Logique métier
- **Controller** : Endpoints REST

---

## 🧩 Diagramme UML
Le diagramme suivant représente les relations entre les entités principales du projet :

![Diagramme UML](/uml_diagram.jpeg)

> 💡 Relations principales :
> - Un **Médecin** peut avoir plusieurs **Patients**
> - Un **Patient** peut avoir plusieurs **Médicaments**
> - Un **Médicament** est associé à plusieurs **Prises**

---
Le diagramme suivant représente les relations entre les entités principales du projet :

![Diagramme UML](/uml_diagramm.jpeg)

## 🗂️ Structure de la Base de Données

### 🧍‍♂️ Entité : Patient
- Contient les informations personnelles du patient : nom, prénom, âge, maladie.
- Chaque patient est suivi par un seul médecin et peut avoir plusieurs médicaments.

### 🧑‍⚕️ Entité : Médecin
- Contient les informations du médecin : nom, prénom, spécialité.
- Chaque médecin gère plusieurs patients et peut consulter leurs dossiers complets.

### 💊 Entité : Médicament
- Contient les informations sur le médicament : nom, dose, fréquence.
- Chaque médicament est attribué à un seul patient.
- Contient une liste de prises associées.

### ⏰ Entité : Prise
- Contient les informations sur les prises de médicaments : date, heure, état (effectuée ou oubliée).
- Chaque prise est liée à un médicament et un patient.

---

## 🚀 Installation et exécution
### Prérequis :
- JDK 17+
- MySQL
- Gradle
- Postman

---

### Étapes d'installation
1. Clonez le repository :
   ```bash
   git clone https://github.com/Ezzahraa-es/medtrack-backend.git


---

## 📡 Endpoints Disponibles


## 👩‍⚕️ Médecin

- GET /medecins/all → Afficher tous les médecins

- POST /medecins/add → Ajouter un nouveau médecin

- DELETE /medecins/delete/{id} → Supprimer un médecin

- GET /patients/{id}/dossier → Consulter le dossier complet d’un patient

## 🧍 Patient

- GET /patients/all → Afficher tous les patients

- POST /patients/add → Ajouter un patient

- PUT /patients/update → Modifier un patient

- DELETE /patients/delete/{id} → Supprimer un patient

## 💊 Médicament

- POST /medicaments/add → Ajouter un médicament à un patient

- GET /medicaments/all → Voir tous les médicaments

- DELETE /medicaments/delete/{id} → Supprimer un médicament

## ⏰ Prise

- POST /prises/add → Enregistrer une prise (effectuée ou oubliée)

- GET /prises/oubliees/{patientId}/{medicamentId} → Voir les prises oubliées d’un patient pour un médicament donné

---

## 👩‍💻 Auteur
*Ezzahraa Essadiki* et *Ahlam Sour*   — Projet Back-End Kotlin / Spring Boot


---

## 📅 Date
Novembre 2025