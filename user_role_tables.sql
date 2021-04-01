
--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mxreaibdd57kib96h1is2qfkt` (`libelle`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `libelle`) VALUES
(2, 'ROLE_EMPLOYE'),
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `username` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jreodf78a7pl5qidfh43axdfb` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `password`, `prenom`, `username`) VALUES
(1, 'user', '$2a$10$OqfX4bk002LaoS72IaTY7u6N5HW7bgC6Lx3h8lNXuTL63/rfrc4CW', 'user', 'user'),
(2, 'employe', '$2a$10$eGdgUJfIRDOMgmiIXAOivurZOSy2niN1.u99ms6c7OsLgQsWYN/Nm', 'employe', 'livreur');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `users_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`users_id`,`roles_id`),
  KEY `FKc6dfc5scokvhdj4by38b9ghvj` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`users_id`, `roles_id`) VALUES
(1, 1),
(2, 1),
(2, 2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKc6dfc5scokvhdj4by38b9ghvj` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKl8tkm649pdk9iid3u1nmw0ky0` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`);
