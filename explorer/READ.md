# Teste de Programa��o Elo7

Como parte do processo seletivo do Elo7, gostar�amos que voc� fizesse uma 
pequena tarefa. Conforme seu resultado daremos continuidade ao processo te 
convidando para uma sess�o de pair-programming.
 
Durante o desenvolvimento d� prefer�ncia para implementa��o em Java.
 
O objetivo dessa tarefa � avaliar como voc� vai desenvolver o c�digo em termos 
de estilo, efici�ncia e qualidade. 
 
Crie um projeto no seu Github para que vejamos os passos feitos atrav�s dos commits para resolver a tarefa.

Sinta-se � vontade para criar em cima do problema abaixo. Caso algo n�o esteja claro, pode assumir o que seja mais claro para voc� e indique suas suposi��es em documenta��o. A especifica��o � bem b�sica e, portanto, caso deseje evoluir a ideia seguindo essa base, fique � vontade: por exemplo, adaptar as entradas e sa�das para ser um servi�o web, criar uma interface gr�fica, etc.

Qualquer d�vida maior pode nos perguntar, mas no geral, divirta-se!

# Explorando Marte

Um conjunto de sondas foi enviado pela NASA � Marte e ir� pousar num planalto.
Esse planalto, que curiosamente � retangular, deve ser explorado pelas sondas para que suas c�mera embutidas consigam ter uma vis�o completa da �rea e enviar as imagens de volta para a Terra.

A posi��o e dire��o de uma sonda s�o representadas por uma combina��o de coordenadas x-y e uma letra representando a dire��o cardinal para qual a sonda aponta, seguindo a rosa dos ventos em ingl�s.

![rosa dos ventos](http://i.imgur.com/li8Ae5L.png "Rosa dos Ventos")

O planalto � divido numa malha para simplificar a navega��o. Um exemplo de posi��o seria (0, 0, N), que indica que a sonda est� no canto inferior esquerdo e apontando para o Norte.

Para controlar as sondas, a NASA envia uma simples sequ�ncia de letras. As letras poss�veis s�o "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda  ou direita, respectivamente, sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma dire��o.

Nesta malha o ponto ao norte de (x,y) � sempre (x, y+1).

Voc� deve fazer um programa que processe uma s�rie de instru��es enviadas para as sondas que est�o explorando este planalto.
O formato da entrada e sa�da deste programa segue abaixo.

A forma de entrada e sa�da dos dados fica � sua escolha.


## ENTRADA

A primeira linha da entrada de dados � a coordenada do ponto superior-direito da malha do planalto. Lembrando que a inferior esquerda sempre ser� (0,0).

O resto da entrada ser� informa��o das sondas que foram implantadas. Cada sonda � representada por duas linhas. A primeira indica sua posi��o inicial e a segunda uma s�rie de instru��es indicando para a sonda como ela dever� explorar o planalto.

A posi��o � representada por dois inteiros e uma letra separados por espa�os, correpondendo � coordenada X-Y e � dire��o da sonda.
Cada sonda ser� controlada sequencialmente, o que quer dizer que a segunda sonda s� ir� se movimentar ap�s que a primeira tenha terminado suas instru��es.

## SA�DA

A sa�da dever� contar uma linha para cada sonda, na mesma ordem de entrada, indicando sua coordenada final e dire��o.

### Exemplos de Entrada e Sa�da:

####Entrada de Teste:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

#### Sa�da esperada:
```
1 3 N
5 1 E
```

