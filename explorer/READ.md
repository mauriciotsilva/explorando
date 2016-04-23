# Explorando API

## Atlas

Permite criar e consultar mapas Cadastrados

### Criar um Mapa (URL: /api/v1/atlas POST)

Exemplo payload:

```
{
	"x": 5,
	"y": 5
}
```

### Consultando um Mapa (URL: /api/v1/atlas/{id} GET)

Exemplo Saida:

```
{
	"id":1,
	"criadoEm":"2016-01-01T00:00:00.000Z",
	"x":5,
	"y":5
}
```

## Equipamento

### Enviar equipamento

## Comandar Equipamento

### Comando Remoto