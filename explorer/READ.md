# Explorer API

## Mapa (Planalto)

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

Exemplo Saida para a url /api/v1/atlas/1:

```
{
	"id": 1,
	"criadoEm": "2016-01-01T00:00:00.000Z",
	"x": 5,
	"y": 5
}
```

## Equipamento (Sonda)

Permite criar, executar comandos remotos e consultar um equipamento enviado a Marte

### Enviar equipamento (URL: /api/v1/equipamentos POST)

```
{
	"mapa": 1,
	"posicao": "0 0 N"
}
```

## Comandar Equipamento

### Comando Remoto