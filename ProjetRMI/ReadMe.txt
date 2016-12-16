PARTIE 1 : 
---------

Implementation d'un registre : MyRegistre dans lequel on crée GlobalRegistre cf image 1 
Le client interroge MyRegistry pour recupérer un stub. 
MyRegistry le récupère dans GlobalRegistry (grâce à la map)

GlobalRegistry : 
bind() cest comme un setter Si le service_name n'a pas encore était renseigné dans la map on créé une nouvelle list 
Sinon on ajoute notre objet remote à la liste

lookup() c'est comme un setter on recupère notre objet remote. On fait return map.get(name).get(0) : le 0 c'est parce qu'on est sur qu'il sera toujours présentet c'est suffisant pour la partie 1