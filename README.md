# Exemplo simples de uma API Rest Com Spring Boot 


Este projeto é um simples estudo sobre apis Restful utilizando **SpringBoot + H2 + JPA** 

## Abaixo segue uma descrição da API para manipular dados de usuário

## GET /app/users

Exibe a lista de usuários cadastrados no sistema - **Response 200**

```
[
    {
        "id": 1,
        "name": "chrisluccas1",
        "document": "12312312323",
        "emailAddress": "chrisluccas2@gmail.com",
        "registerDate": 1582186391564
    },
    {
        "id": 2,
        "name": "chrisluccas2",
        "document": "12312312323",
        "emailAddress": "chrisluccas2@gmail.com",
        "registerDate": 1582186391564
    },
    {
        "id": 3,
        "name": "chrisluccas3",
        "document": "12312312323",
        "emailAddress": "chrisluccas2@gmail.com",
        "registerDate": 1582186391564
    }
]
```

## GET /app/user/{id}

Recupera um usuário através do seu ID - **Response 200**

```
{
    "id": 1,
    "name": "chrisluccas1",
    "document": "12312312323",
    "emailAddress": "chrisluccas2@gmail.com",
    "registerDate": 1582186391564
}
```

## POST /app/user/save

Insere um usuário na base de dados da aplicação - **Response 200**

**ResponseBody**
```
{
	"name": "chrisluccas3"
	,"document": "12312312323"
	,"emailAddress": "chrisluccas2@gmail.com"
	,"registerDate":1582186391564
}
```

## DELETE /app/user/delete/{id}

Remove um usuário da base através do seu ID - **Response 200**

## PUT /app/user/update/{id}

Atualiza dados de um usuário através do seu ID - **Response 200**

**ResponseBody**
```
{
	"name": "jamesstewart"
	,"document": "111111111"
	,"emailAddress": "jamesstewart1010@gmail.com"
	,"registerDate":1582186391564
}
```

## Apis para acessar o ponto eletrônico de um usuário

## GET /app/checkpoints

Recupera as marcações de ponto eletrônico da base


## GET /app/checkpoints/{id}

Recupera as marcações de ponto eletrônico de um determinado usuário através do seu ID

```
[
    {
        "id": 1,
        "userId": 1,
        "date": 1582194701090,
        "entrance": false
    },
    {
        "id": 2,
        "userId": 1,
        "date": 1582194701090,
        "entrance": true
    },
    {
        "id": 3,
        "userId": 1,
        "date": 1582194701092,
        "entrance": false
    }
]
```

## POST /app/checkpoint/save

Guarda um registro de marcação de ponto de um usuário

**ResponseBody**

```
{
	
	"userId": 1
	,"date": 1582194701092
	,"entrance":false
	
}
```