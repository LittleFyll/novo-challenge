# Livrables manquant
* Mise à jour périodique des signes vitaux (actuellement mocké a la création du patient & jamais modifié)
* Envoie de message au patient

# À implémenter Frontend
* Envoie de messages au patient
    * Un patient devrait avoir une manière de contacter obligatoire & différentes alternatives(différents personnes/texto, mail, appel)
    * Le contact n'est pas nécessairement patient, pourrait être un parent/proche
    * Système de gestion de l'historique des tentatives de message + réponses
* Système de login pour la sécurité
* Système de gestion d'erreur
* Update des informations d'un patient
* Graph pour les données
* Programmer des notifications automatique si signe vitaux dépasse certain cap
* Système de prise de notes

# À implémenter Backend
* Système de login
* Meilleur système de configuration
    * Le système actuel n'est pas optimal pour la configuration de plusieurs environnement (dev/staging/prod)
    * Force les configs (url/password) à être en clair et accessible dans le code source
    * Devrait être dans des fichiers séparé par environnement
* Système de logging & de suivi du life cycle d'une transaction
    * Ajouter un traceId aux des points d'entrées de l'app (REST dans ce cas) et injecter le logger au fils du cycle de vie de la transaction
    * Système de caching avec une pool query sur la BD pour les datas, réduit le nombre de transaction sur la BD et profite de la RAM (c'mon ça coûte pas cher de nos jour)
* Système de gestion d'erreur & notification automatique (configurable) en cas d'erreur/warning


