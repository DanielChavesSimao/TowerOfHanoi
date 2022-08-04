## Torre de Hanói utilizando busca com AIMA framework
A classe principal é `App.java` e a busca escolhida foi a Breadth First Search(BFS).

Para fins de teste a classe de estados `TOHState.java` pode ser inicializada randomicamente:
```
TOHState estadoRandomico = new TOHState(true);
TOHState estadoRandomico = new TOHState(numDisks, true);
```

O test goal também pode ser personalizado de acordo com a configuração desejada, passando o número de discos e/ou a configuração dos pinos.
