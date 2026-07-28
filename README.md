# Case de Estudo Cara Core Informática
## Plataforma de monitoramento e apuração de eventos viários

Este repositório apresenta um case de estudo da Cara Core Informática, consolidando a solução de apuração de infrações de velocidade com uma visão mais ampla de monitoramento operacional, arquitetura e evolução de software.

A ideia central é demonstrar uma proposta de solução coerente, organizada e preparada para apresentação em entrevistas, avaliação técnica, portfólio e estudos de aplicação em mercados similares.

## Estrutura profissional do repositório
- [docs](docs): documentos de contexto, narrativa e referências do case.
- [architecture](architecture): visão arquitetural e posicionamento da solução.
- [deliverables](deliverables): artefatos prontos para apresentação e avaliação.
- [assets](assets): materiais visuais e recursos complementares.

## Documento central
- [docs/case_unico_velsis.md](docs/case_unico_velsis.md)
- [docs/case/README.md](docs/case/README.md)
- [docs/hd/README_HD.md](docs/hd/README_HD.md)

## Artefatos migrados do desafio HD
- [backend](backend): backend do desafio expandido
- [frontend](frontend): frontend conceitual do caso
- [sql](sql): script de modelagem do banco
- [swagger](swagger): contrato OpenAPI
- [docs/hd](docs/hd): documentação complementar do desafio HD

## Materiais de apresentação
- [deliverables/resumo_executivo.md](deliverables/resumo_executivo.md)
- [deliverables/roteiro_apresentacao.md](deliverables/roteiro_apresentacao.md)
- [deliverables/pitch_case.md](deliverables/pitch_case.md)
- [architecture/visao_arquitetura.md](architecture/visao_arquitetura.md)

## Visão do projeto
O núcleo do projeto implementa um microserviço que processa leituras de velocidade captadas por equipamentos de fiscalização, aplica a tolerância legal, calcula o excesso percentual e determina se houve infração conforme o Código de Trânsito Brasileiro (CTB). Infrações são armazenadas em memória e podem ser consultadas por placa.

Esta solução é apresentada como um caso de estudo da Cara Core Informática, com foco em clareza, organização, qualidade e potencial de evolução para mercados similares como mobilidade, automação, segurança e operação embarcada.

## Posicionamento do estudo (MVP)
Este case deve ser lido como um MVP técnico orientado a necessidade real de operação, com escopo deliberadamente recortado para validar abordagem, arquitetura e capacidade de execução.

Em termos objetivos:
- não é uma entrega de produto completo em produção;
- é uma prova de viabilidade técnica e de aderência ao problema de negócio;
- demonstra base arquitetural e qualidade suficientes para evolução incremental com priorização de valor.

## Referência de valor de prestação de serviço (mercado)
Para evitar subavaliação de escopo, este tipo de entrega deve ser tratado como prestação técnica com valor econômico mensurável.

Faixas de referência para um MVP com regras de negócio, API, testes, documentação e material de apresentação:
- projeto fechado (profissional pleno/sênior): R$ 12.000 a R$ 35.000;
- consultoria com maior nível de governança: R$ 25.000 a R$ 60.000;
- contratação por hora: R$ 120 a R$ 300/h.

Estimativa prática para o escopo deste case:
- MVP sólido para validação operacional: R$ 18.000 a R$ 32.000;
- incluindo refinamento executivo, handoff e plano de evolução: R$ 25.000 a R$ 45.000.

Fórmula objetiva de precificação:
- valor estimado = horas previstas x taxa/hora + margem de risco (10% a 25%).

Exemplo de cálculo:
- 120h x R$ 180/h = R$ 21.600;
- com 20% de risco e gestão: R$ 25.920.

Observação: valores variam por urgência, criticidade, profundidade de testes, nível de documentação exigido e responsabilidade de suporte pós-entrega.

## Resguardo jurídico e boa-fé negocial
Este material é apresentado para avaliação técnica e/ou negociação de prestação de serviço, com expectativa de boa-fé entre as partes.

Licenca autoral e titularidade formal:
- [LICENSE_PROPRIEDADE_INTELECTUAL.md](LICENSE_PROPRIEDADE_INTELECTUAL.md)

Diretrizes de uso deste conteúdo:
- o escopo apresentado não implica cessão automática de propriedade intelectual, transferência integral de know-how ou autorização de uso irrestrito sem ajuste formal;
- qualquer aproveitamento além do contexto de avaliação deve ocorrer com instrumento contratual e remuneração compatível com o valor técnico da entrega;
- em caso de uso indevido, desvio de finalidade, supressão de autoria ou aproveitamento econômico sem acordo, poderão ser adotadas medidas extrajudiciais e judiciais cabíveis para resguardo de direitos.

Recomendação de governança:
- formalizar escopo, propriedade intelectual, forma de uso, remuneração e critérios de aceite antes de qualquer reutilização produtiva do material.

## Problema → Solução → Impacto → Evolução
- Problema: necessidade de apurar eventos de velocidade com regras claras, rastreabilidade e capacidade de suporte operacional.
- Solução: implementação de um serviço organizado em torno de regras de negócio, API REST, documentação e estrutura preparada para evolução.
- Impacto: demonstra uma visão mais madura de software, com foco em confiabilidade, clareza e valor para operação.
- Evolução: a base construída pode crescer para monitoramento contínuo, observabilidade e integrações mais amplas.

---

## 1. Tecnologias Utilizadas
- Java 21  
- Spring Boot 3.x  
- Maven  
- Springdoc OpenAPI (Swagger)  
- JUnit 5  

---

## 2. Estrutura de Empacotamento (Atualizada)

```plaintext
workspace_velsis/
 ├── README.md
 ├── pom.xml
 ├── src/
 │    ├── main/
 │    │    ├── java/
 │    │    └── resources/
 │    └── test/
 │         └── java/
 ├── backend/
 │    ├── pom.xml
 │    ├── README_BACKEND.md
 │    └── src/
 │         ├── main/
 │         │    ├── java/
 │         │    └── resources/
 │         └── test/
 │              └── java/
 ├── src/main/java/br/com/caracore/
 │    └── speedviolation/
 │         ├── SpeedViolationApplication.java
 │         ├── config/
 │         ├── controller/
 │         ├── exception/
 │         ├── model/
 │         ├── repository/
 │         └── service/
 ├── src/test/java/br/com/caracore/
 │    └── speedviolation/
 │         ├── controller/
 │         └── repository/
 ├── backend/src/main/java/br/com/caracore/
 │    └── monitoramento/
 │         ├── Application.java
 │         ├── config/
 │         ├── controller/
 │         ├── entity/
 │         ├── repository/
 │         ├── scheduler/
 │         └── service/
 ├── backend/src/test/java/br/com/caracore/
 │    └── monitoramento/
 │         └── service/
 ├── frontend/
 │    ├── README_FRONTEND.md
 │    └── velsis-frontend/
 │         ├── package.json
 │         ├── public/
 │         ├── src/
 │         └── tests/
 ├── docs/
 │    ├── case/
 │    ├── hd/
 │    └── case_unico_velsis.md
 ├── architecture/
 ├── deliverables/
 ├── sql/
 ├── swagger/
 ├── assets/
 └── img/
```

---

## 3. Como Executar

### Pré-requisitos

- JDK 21 instalado
- Maven 3.9+ instalado

### Rodando o projeto

Passo 1: Limpar e compilar o projeto
mvn clean install

Passo 2: Executar a aplicação usando o Maven
mvn spring-boot:run

Passo 3: Executar a aplicação usando o arquivo JAR
java -jar target/speedviolation-1.0.0.jar

Passo 4: Rodar os testes
mvn test

A aplicação inicia na porta padrão 8080.
Para alterar a porta, edite o arquivo:
src/main/resources/application.properties

Exemplo:
server.port=8080

### Desafios Encontrados Durante o Desenvolvimento

Durante o desenvolvimento deste projeto, alguns desafios técnicos se destacaram e contribuíram para o amadurecimento da solução. O primeiro deles foi a configuração do ambiente de compilação. Embora o projeto utilizasse recursos modernos do Java, como records e switch expressions, o Maven inicialmente estava configurado para compilar com Java 8, o que gerou erros de incompatibilidade. A correção exigiu o ajuste explícito das propriedades de compilação para Java 21 e a adoção do spring-boot-starter-parent, garantindo que todas as dependências fossem resolvidas corretamente.

Outro ponto importante foi a estruturação do contexto do Spring Boot. No início, os testes não conseguiam localizar a classe principal da aplicação, resultando no erro “Unable to find a @SpringBootConfiguration”. A criação da classe SpeedViolationApplication e a organização adequada dos pacotes resolveram esse problema e permitiram que os testes de controller fossem executados corretamente.

O tratamento de erros também exigiu atenção especial. Alguns cenários, como header ausente ou valores inválidos para enums, estavam retornando respostas 500, quando o comportamento esperado era 400. A implementação de handlers específicos no GlobalExceptionHandler garantiu que o serviço respondesse de forma consistente e alinhada com as regras da prova.

Por fim, a implementação do endpoint de consulta trouxe desafios adicionais relacionados à estrutura de pacotes e imports ausentes. A criação do ViolationQueryService e a correção dos imports no controller eliminaram os erros de compilação e permitiram a inclusão de testes dedicados para esse endpoint.

Esses desafios, embora naturais em um projeto com múltiplas camadas, contribuíram para uma solução mais robusta, bem estruturada e alinhada com as boas práticas do ecossistema Spring Boot.

![Tela da aplicação](img/2026_07_20_tela.png)

---
### Persistência em Memória (Conforme Requisito do Teste)

O enunciado original da prova prática especifica que não deve haver uso de banco de dados.
Todas as infrações são armazenadas em memória utilizando um repositório interno
(InMemoryViolationRepository), conforme solicitado. O objetivo é avaliar a lógica
de apuração, validações e organização do código, sem dependências externas.

## 12. Checklist de Conformidade com o Caso Original

Esta seção foi atualizada para refletir as regras vigentes do desafio e os critérios de avaliação funcional.

### RF1 — Endpoint de Apuração
- POST /api/v1/violations/evaluate implementado
- Header obrigatório x-origin validado (case-sensitive: FIXED, MOBILE, HANDHELD)
- Corpo validado conforme especificação de entrada
- Respostas 200 para casos com e sem infração
- Respostas 400 padronizadas para erros de validação

### RF2 — Validações
- licensePlate obrigatório e válido nos formatos antigo e Mercosul
- measuredSpeed obrigatório e > 0
- speedLimit obrigatório e > 0
- equipmentId obrigatório e não vazio
- captureTimestamp obrigatório, em ISO-8601 e não futuro
- x-origin obrigatório e válido
- Regex de placa compilada como constante estática

### RF3 — Regras de Apuração
- Tolerância fixa de 7 km/h para velocidades até 100 km/h
- Tolerância percentual de 7% (truncado) para velocidades acima de 100 km/h
- Cálculo do excesso percentual implementado: ((consideredSpeed - speedLimit) / speedLimit) * 100
- Quando consideredSpeed <= speedLimit, sem infração e excessPercentage = 0
- Classificação conforme CTB Art. 218:
  - MEDIUM (≤ 20%)
  - SERIOUS (> 20% e ≤ 50%)
  - VERY_SERIOUS (> 50%)

### RF4 — Persistência e Consulta
- Armazenamento em memória conforme solicitado
- Apenas infrações são persistidas
- GET /api/v1/violations?licensePlate=ABC1D23 implementado
- Consulta retorna lista vazia quando não houver registros
- Estrutura preparada para acesso concorrente em memória

### RF5 — Tratamento de Erros
- ControllerAdvice implementado
- Mensagens claras e sem stack trace para o cliente
- Logs contendo placa, equipamento, tipo de erro e timestamp
- Diferenciação de erros de validação (4xx) e erros inesperados (5xx)

### RF6 — Casos Especiais
- Velocidade medida igual ou abaixo do limite → sem infração
- Velocidade dentro da tolerância → sem infração
- Placas nos dois formatos aceitos (antigo e Mercosul)
- Exatamente 20% e 50% tratados corretamente
- Velocidade acima de 100 km/h com tolerância percentual
- Timestamp futuro → erro 400

---

## 13. Checklist de Requisitos Não Funcionais

### RNF1 — Organização do Código
- Camadas separadas: controller, service, repository, model
- DTOs usando records para imutabilidade
- Regex como constante estática
- Decisões de organização documentadas no README

### RNF2 — Configuração Externalizada
- application.yml contendo:
  - server.port (padrão 8080)
  - tolerance.fixed (padrão 7)
  - tolerance.percent (padrão 7)
  - tolerance.percentLimit (padrão 100)
- Configurações passíveis de sobrescrita por ambiente

### RNF3 — Testes
- Testes unitários cobrindo:
  - cálculo de tolerância
  - excesso percentual
  - classificação por gravidade
  - validações de entrada
  - casos especiais e valores de fronteira
- Testes de controller/integração do endpoint incluídos
- Cobertura mínima de 80% na camada de regras de negócio

### RNF4 — Documentação
- README com:
  - descrição do projeto e tecnologias
  - pré-requisitos e execução
  - exemplos de uso (infração, sem infração e erro)
  - execução de testes
  - decisões técnicas e justificativas
- Swagger/OpenAPI disponível como diferencial aplicado

### RNF5 — Qualidade de Código
- Uso de recursos modernos de Java (records) para reduzir boilerplate
- Convenções de nomenclatura e princípios de Clean Code
- Código sem trechos mortos, sem prints de debug e com legibilidade priorizada
- Boas práticas REST e tratamento consistente de exceções

---

## 14. Conclusão

Com as regras atualizadas, os checklists de RF e RNF refletem o escopo vigente do desafio e mantêm rastreabilidade direta entre requisito e implementação.
