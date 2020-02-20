# Exemplo simples de uma API Rest Com Spring Boot 


Este projeto é um simples estudo sobre apis Restful utilizando **SpringBoot + H2 + JPA** 

## Abaixo segue uma descrição da API

## GET /app/users

Exibe a lista de usuários cadastrados no sistema

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

##GET /app/user/{id}

Recupera um usuário através do seu ID

```
{
    "id": 1,
    "name": "chrisluccas1",
    "document": "12312312323",
    "emailAddress": "chrisluccas2@gmail.com",
    "registerDate": 1582186391564
}
```

##POST /app/user/save

Insere um usuário na base de dados da aplicação

```
{
	"name": "chrisluccas3"
	,"document": "12312312323"
	,"emailAddress": "chrisluccas2@gmail.com"
	,"registerDate":1582186391564
}
```