VELSIS - DESAFIO TÉCNICO (ENGENHARIA JÚNIOR)
============================================

Este repositório contém a solução conceitual e avaliativa para o desafio de monitoramento de recursos embarcados e periféricos. O projeto foi desenhado focando em arquitetura limpa, testabilidade e princípios SOLID, garantindo que as principais competências de engenharia de software sejam demonstradas de forma clara e objetiva.

ABORDAGEM DO PROJETO (CONCEITUAL E AVALIATIVA)
----------------------------------------------

Para alinhar com as expectativas de uma vaga Júnior e as orientações do próprio case ("Mais importante do que implementar todas as funcionalidades é demonstrar capacidade de projetar um software organizado..."), algumas decisões arquiteturais foram tomadas:

1. Mock Inteligente de Stream RTSP (Backend): Em vez de embarcar dependências nativas pesadas (como OpenCV/FFmpeg) que poderiam dificultar a compilação no ambiente do avaliador, o acesso RTSP foi abstraído usando Inversão de Dependência (DIP). Uma interface define a captura, e a implementação atual simula o retorno com sucesso/falha demonstrando o fluxo arquitetural sem acoplar complexidade.

2. Componente Visual de Stream Conceitual (Frontend): O Vue.js demonstra o roteamento e a tela para visualização de câmera exibindo um placeholder de "Conectando ao Stream". Isso valida a arquitetura e fluxos de UI do frontend sem a sobrecarga desnecessária de um player WebRTC/HLS num ambiente de teste.

3. Comando de Ping Multiplataforma: O scheduler responsável pelo ping foi projetado para detectar automaticamente o sistema operacional (Linux ou Windows) e disparar o comando correto (-c 1 vs -n 1), garantindo que a aplicação seja 100% portátil para o avaliador.

4. Foco Total em Qualidade e Testes: O projeto brilha nos testes unitários bem estruturados e com validação de cenários de mock (cobertura total dos componentes principais e serviços de negócio).

ESTRUTURA GERAL
---------------

O projeto possui a seguinte estrutura e entregáveis:

- Backend (Spring Boot 3 + Java 17): API RESTful, agendadores de monitoramento (Schedulers) e banco de dados H2/PostgreSQL. Documentação detalhada em: [backend/README_BACKEND.md](./backend/README_BACKEND.md)
- Frontend (Vue 3 + Vite): Interface rica, reativa e totalmente testada via Vitest. Documentação detalhada em: [frontend/README_FRONTEND.md](./frontend/README_FRONTEND.md)
- Banco de Dados (PostgreSQL): O arquivo de modelo físico (DDL) encontra-se disponível no diretório: [sql/schema.sql](./sql/schema.sql)
- Documentação da API (Swagger): O contrato OpenAPI 3.0 está disponível estaticamente no diretório: [swagger/openapi.yaml](./swagger/openapi.yaml)

COMO EXECUTAR
-------------

Leia as instruções detalhadas em cada módulo clicando nos links abaixo:

- Instruções do Backend: [Acessar README do Backend](./backend/README_BACKEND.md)
- Instruções do Frontend: [Acessar README do Frontend](./frontend/README_FRONTEND.md)

NOTAS DE AVALIAÇÃO TÉCNICA (FAQ)
--------------------------------

Para facilitar a correção, antecipamos algumas escolhas arquiteturais com base no escopo:

- Banco de Dados (PostgreSQL vs H2): O projeto está preparado para PostgreSQL (dependência e script DDL inclusos), mas o H2 em memória foi configurado como padrão para garantir uma excelente experiência de teste (basta compilar e rodar, sem depender de banco local).
- Captura de Frame (RTSP): Conforme a margem para decisão técnica do edital, evitamos o acoplamento de bibliotecas C++ pesadas (OpenCV) que dificultam a portabilidade. Utilizamos o Princípio da Inversão de Dependência (SOLID) para injetar um serviço "Mock", provando a testabilidade e isolamento da regra de negócio.
- Segurança (Login): O Spring Security está mapeado nas dependências, mas como o módulo de login era opcional, as rotas não exigem token no momento para facilitar a correção direta das APIs via Swagger.

Desenvolvido por Christian Vladimir Uhdre Mulato
