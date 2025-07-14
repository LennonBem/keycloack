
# Spring Boot e o protocolo de autorização OAuth2.0

    Este é um projeto para fins didáticos, nele abordo os principais conceitos presentes no protocolo de autorização OAuth2.0. 
    Nele simulo diferentes atores que estão presentes no processo de acesso a recursos protegidos e o fluxo que segue a interação entre eles. 
    


Por que utilizar utilizar esse protocolo? Quais problemas ele resolve ?

    O app de terceiros precisa guardar a senha do usuário, geralmente em texto simples (inseguro).

    Os servidores precisam aceitar senhas, mesmo sabendo que isso tem falhas de segurança.

    O app de terceiros tem acesso total, sem controle do que pode ou não acessar ou por quanto tempo.

    O dono dos dados não consegue revogar o acesso de um app específico. Se quiser bloquear um app, precisa trocar a senha e, com isso, desloga tudo (inclusive outros apps confiáveis).]



OAuth2.0 aborda esses problemas introduzindo uma camada de autorização e separando o papel do cliente (Client) e do proprietario do recurso(Resource Owner).

    No OAuth 2.0, o cliente (aplicativo) quer acessar recursos do proprietário do recurso (usuário), mas não usa a senha do usuário.

Em vez disso:

    O cliente recebe um token de acesso, que é uma chave temporária com permissões específicas (escopo, tempo de validade, etc.).

    Esse token é gerado por um servidor de autorização, com a permissão do usuário.

    O cliente usa esse token para acessar os dados no servidor de recursos, sem precisar da senha do usuário.



    
     +--------+                               +---------------+
     |        |--(A)- Authorization Request ->|   Resource    |
     |        |                               |     Owner     |
     |        |<-(B)-- Authorization Grant ---|               |
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(C)-- Authorization Grant -->| Authorization |
     | Client |                               |     Server    |
     |        |<-(D)----- Access Token -------|   (KEYCLOACK) |
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(E)----- Access Token ------>|    Resource   |
     |        |                               |     Server    |
     |        |<-(F)--- Protected Resource ---|               |
     +--------+                               +---------------+


Neste projeto criei duas API's:

resource-server-api: API que contem os recursos a serem solicitados pelos clientes.
## Stack utilizada

**Front-end:** Nuxt, Vue, TypeScript

**Back-end:** Java, Spring Boot


## Referência

 - [Documentação do protocolo OAuth2.0](https://datatracker.ietf.org/doc/html/rfc6749#section-1.2)
 - [Documentação SpringBoot OAuth2.0](https://docs.spring.io/spring-security/reference/servlet/oauth2/index.html)


