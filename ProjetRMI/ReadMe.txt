PARTIE 1 : 
---------

Implementation d'un registre : MyRegistre dans lequel on cr�e GlobalRegistre cf image 1 
Le client interroge MyRegistry pour recup�rer un stub. 
MyRegistry le r�cup�re dans GlobalRegistry (gr�ce � la map)

GlobalRegistry : 
bind() cest comme un setter Si le service_name n'a pas encore �tait renseign� dans la map on cr�� une nouvelle list 
Sinon on ajoute notre objet remote � la liste

lookup() c'est comme un setter on recup�re notre objet remote. On fait return map.get(name).get(0) : le 0 c'est parce qu'on est sur qu'il sera toujours pr�sentet c'est suffisant pour la partie 1

PARTIE 2 : 
----------

On veut faire un round robin pour distribuer les stub aux clients
Il y a un iterateurs pour chaque list � chaque Service name
on cr�� donc une map (key, value) associant un iterateur � un service_name

Pour le bind() ne pas oublier d'initialiser l'iterateur a 0
Pour le look up faire une boucle telle que lorsque l'on arrive a la fin de la liste des stubs on revient au debut