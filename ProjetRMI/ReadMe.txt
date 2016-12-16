PARTIE 1 : 
---------

Implementation d'un registre : MyRegistre dans lequel on crée GlobalRegistre cf image 1 
Le client interroge MyRegistry pour recupérer un stub. 
MyRegistry le récupère dans GlobalRegistry (grâce à la map)

GlobalRegistry : 
bind() cest comme un setter Si le service_name n'a pas encore était renseigné dans la map on créé une nouvelle list 
Sinon on ajoute notre objet remote à la liste

lookup() c'est comme un setter on recupère notre objet remote. On fait return map.get(name).get(0) : le 0 c'est parce qu'on est sur qu'il sera toujours présentet c'est suffisant pour la partie 1

PARTIE 2 : 
----------

On veut faire un round robin pour distribuer les stub aux clients
Il y a un iterateurs pour chaque list à chaque Service name
on créé donc une map (key, value) associant un iterateur à un service_name

Pour le bind() ne pas oublier d'initialiser l'iterateur a 0
Pour le look up faire une boucle telle que lorsque l'on arrive a la fin de la liste des stubs on revient au debut