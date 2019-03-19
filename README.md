# Un Petit logiciel que corrige les photos

un logiciel qui corrige les couleurs sur une photo. Le logiciel va construire deux images résultantes
pour chaque photo. Ainsi, deux algorithmes différents vont être comparés.

## Algorithme 1


## Algorithme 2


## Description

Lorsque l’image est chargée, il doit analyser. Une image est une matrice de point. Chaque point est une couleur.
Dans notre cas, les couleurs seront représentées par 4 valeurs (composantes alpha, rouge, verte et bleu). Notre 
correction n’utilisera pas la composante alpha. Une composante est représentée par une valeur entre 0 et 255.

Le logiciel doit premièrement construire un histogramme pour chaque composante. C’est-à-dire, il doit calculer
combien de points ont la composante rouge à 0, combien ont la composante rouge à 1, combien ont la composante 
rouge à 2, et ainsi de suite pour les valeurs de 0 à 255 et pour les trois composantes.

Lorsque les trois histogrammes sont construits, nous sommes prêts à corriger l’image. le logiciel va construire
2 images résultantes à partir de l’image de base.
