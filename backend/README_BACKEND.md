CARA CORE BACKEND - SISTEMA DE MONITORAMENTO
=========================================

Este módulo contém a API REST e os agendadores (Schedulers) desenvolvidos em Java 17 e Spring Boot 3 para o case de estudo da Cara Core Informática.

TECNOLOGIAS E PADRÕES
---------------------

- Java 17 e Spring Boot 3.x
- Spring Data JPA com banco de dados H2 (para testes rápidos em memória)
- Documentação da API: Swagger/OpenAPI
- Testes Unitários: JUnit 5 + Mockito

DECISÕES DE ARQUITETURA (FOCO NA AVALIAÇÃO)
-------------------------------------------

Como a aplicação visa avaliação e estudo de arquitetura, priorizamos padrões de projeto e código limpo ao invés de acoplar ferramentas de peso (que exigem setup complexo do avaliador).

1. Schedulers e SOLID (Mock RTSP): As rotinas de monitoramento utilizam agendamentos automáticos. Para a captura RTSP (que por padrão usaria bibliotecas nativas como OpenCV), aplicamos Inversão de Dependência (DIP). O serviço depende de uma interface, sendo injetado um Mock que responde os testes e gera o histórico da câmera conceitualmente. Em um ambiente de produção real, bastaria injetar a implementação concreta via FFmpeg/OpenCV.

2. Ping Multi-plataforma: A aplicação detecta o OS do hospedeiro e executa o ping corretamente (ping -c 1 para Linux, ping -n 1 para Windows), assegurando estabilidade em diferentes plataformas.

3. Massa de Dados Automática: Um DataLoader insere configurações padrão e câmeras de teste assim que a API sobe. Dessa forma, você só precisa ligar a aplicação para ver o dashboard preenchido.

COMO RODAR
----------

Acesse a raiz da pasta backend pelo terminal:

1. Compile o projeto: mvn clean install
2. Inicie o servidor: mvn spring-boot:run
3. Swagger: Acesse http://localhost:8080/swagger-ui.html para testar as rotas da API REST.
4. Banco H2: Acesse http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:monitoramento)

TESTES
------

A aplicação foca nas regras de negócio através de testes isolados de serviços. Para rodar a bateria de testes unitários:

mvn test
