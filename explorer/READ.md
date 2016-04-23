# Explorer API

## Mapa (Planalto)

Permite criar e consultar mapas Cadastrados

### Criar um Mapa - /api/v1/atlas POST

Exemplo payload:

```
{
	"x": 5,
	"y": 5
}
```

### Consultando um Mapa - /api/v1/atlas/{id} GET

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

### Enviar equipamento - /api/v1/equipamentos POST

Exemplo payload:

```
{
	"mapa": 1,
	"posicao": "0 0 N"
}
```

### Consultar Equipamento - /api/v1/equipamentos/{id} GET

Exemplo Saida para a URL /api/v1/equipamentos/1:

```
{
	"id": 1,
	"posicaoAtual": "0 0 N",
	"mapa": {
		"id": 1,
		"criadoEm": "2016-01-01T00:00:00.000Z",
		"x": 5,
		"y": 5
	}
}
```

### Comandar Equipamento - /api/v1/equipamentos/{id}/comandos POST

Exemplo payload:

```
{
	"comando": "MMRMR"
}
```

### Consulta apos a execucao do Comando

Consulta ao equipamento logo apos executar o comando no passo anterior


/api/v1/equipamentos/1 GET

```
{
	"id": 1,
	"posicaoAtual": "1 2 S",
	"mapa": {
		"id": 1,
		"criadoEm": "2016-01-01T00:00:00.000Z",
		"x": 5,
		"y": 5
	},
	ultimosComandos: [
		{"data": "2016-01-01T00:00:00.000Z", "comando": "MMRMR"}
	]
}

```






