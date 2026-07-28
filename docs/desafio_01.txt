# Prova Prática: Desenvolvedor(a) Backend Java 
**Desafio original de mobilidade e fiscalização eletrônica**  
**Vaga:** Desenvolvedor(a) FullStack Java | Curitiba/PR 
   
## Informações Gerais 
* **Entrega:** Link de repositório Git público (GitHub/GitLab) 
* **Linguagem:** Java 21 
* **Framework:** Spring Boot 3.x 
* **Prazo:** Até 3 dias corridos a partir do recebimento 
* **Diferencial:** Aplicação hospedada e rodando para demonstração 
  
> **Nota:** Esta prova foca exclusivamente em backend. Não é necessário desenvolver interface/frontend. 
  
## Objetivo 
Desenvolver um microserviço REST que processa leituras de velocidade captadas por equipamentos de fiscalização de trânsito e determina se houve infração por excesso de velocidade, classificando-a por gravidade conforme o Código de Trânsito Brasileiro (CTB).  

O tema reflete o domínio de mobilidade viária / fiscalização eletrônica, mas todas as regras necessárias estão descritas neste documento; não é preciso conhecimento prévio de legislação de trânsito.
  
## Descrição do Problema 
Você deve criar um microserviço chamado `speed-violation-service` que:  
1. Recebe, via HTTP, uma leitura de velocidade registrada por um equipamento. 
2. Valida os dados de entrada. 
3. Aplica a margem de tolerância legal sobre a velocidade medida para obter a velocidade considerada. 
4. Calcula o percentual de excesso sobre a velocidade regulamentada. 
5. Determina se houve infração e a classifica por gravidade (média, grave ou gravíssima). 
6. Armazena as infrações apuradas e permite consultá-las por placa. 
7. Trata erros adequadamente, sem expor detalhes internos ao cliente.  
  
## Requisitos Funcionais 

### RF1: Endpoint de Apuração 
Criar o endpoint `POST /api/v1/violations/evaluate`. 
  
**Header obrigatório:**  
* `x-origin`: origem da captura. Valores aceitos (case-sensitive): `FIXED`, `MOBILE`, `HANDHELD`. 
  
**Corpo da requisição:**  
```json
{     
  "licensePlate": "ABC1D23",     
  "measuredSpeed": 92,     
  "speedLimit": 60,     
  "equipmentId": "RAD-CWB-001",     
  "captureTimestamp": "2026-06-08T14:30:00Z"     
}     
```
  
**Resposta de sucesso: com infração (200):**  
```json
{     
  "licensePlate": "ABC1D23",     
  "equipmentId": "RAD-CWB-001",     
  "measuredSpeed": 92,     
  "consideredSpeed": 85,     
  "speedLimit": 60,     
  "excessPercentage": 41.67,     
  "hasViolation": true,     
  "violation": {     
    "severity": "SERIOUS",     
    "ctbCode": "218-II"     
  },     
  "processedAt": "2026-06-08T14:30:05Z"     
}     
```
  
**Resposta de sucesso: sem infração (200):**  
```json
{     
  "licensePlate": "ABC1D23",     
  "equipmentId": "RAD-CWB-001",     
  "measuredSpeed": 64,     
  "consideredSpeed": 57,     
  "speedLimit": 60,     
  "excessPercentage": 0.0,     
  "hasViolation": false,     
  "violation": null,     
  "processedAt": "2026-06-08T14:30:05Z"     
}     
```
  
**Resposta de erro (400):**  
```json
{     
  "error": "INVALID_LICENSE_PLATE",     
  "message": "Invalid license plate format",     
  "timestamp": "2026-06-08T14:30:05Z"     
}     
```
   
### RF2: Validação de Entrada 
Validar e retornar erro 400 com mensagem clara quando:  
* `licensePlate`: ausente ou fora dos formatos aceitos: 
    * Formato antigo: 3 letras + 4 números (ex.: `ABC1234`) 
    * Formato Mercosul: 3 letras + 1 número + 1 letra + 2 números (ex.: `ABC1D23`)
* `measuredSpeed`: ausente ou menor/igual a zero. 
* `speedLimit`: ausente ou menor/igual a zero. 
* `equipmentId`: ausente ou em branco. 
* `captureTimestamp`: ausente, em formato inválido (não ISO-8601) ou no futuro. 
* Header `x-origin`: ausente ou diferente de `FIXED`, `MOBILE`, `HANDHELD`.  

A validação de placa deve usar expressões regulares compiladas como constantes estáticas (atenção à performance). 
   
### RF3: Regras de Apuração 
A apuração ocorre em três etapas:  

**1. Velocidade considerada (aplicação da tolerância do medidor)**  
A velocidade medida nunca é usada diretamente; aplica-se uma margem de tolerância:  

| Velocidade Regulamentada | Velocidade Considerada (`consideredSpeed`) |
|--------------------------|--------------------------------------------|
| até 100 km/h             | velocidade medida − 7 km/h                 |
| acima de 100 km/h        | velocidade medida − 7% (truncar para inteiro)|

**2. Percentual de excesso**  
```
excessPercentage = ((consideredSpeed − speedLimit) / speedLimit) × 100     
```
Se `consideredSpeed <= speedLimit`, não há infração (`excessPercentage = 0`). 
  
**3. Classificação por gravidade (Art. 218 do CTB)**  

| Excesso (velocidade considerada sobre a regulamentada) | Gravidade (`severity`) | `ctbCode` |
|--------------------------------------------------------|------------------------|-----------|
| até 20%                                                | `MEDIUM`               | 218-I     |
| acima de 20% até 50%                                   | `SERIOUS`              | 218-II    |
| acima de 50%                                           | `VERY_SERIOUS`         | 218-III   |

### RF4: Persistência e Consulta 
* Armazenar em memória todas as infrações apuradas (apenas quando `hasViolation = true`). 
* Criar o endpoint `GET /api/v1/violations?licensePlate={licensePlate}` que retorna a lista de infrações registradas para a placa informada (lista vazia caso não haja). 
* Não é necessário banco de dados; uma estrutura em memória é suficiente. Considere o acesso concorrente.  
  
### RF5: Tratamento de Erros 
* Implementar tratamento centralizado de exceções com respostas padronizadas. 
* Não expor stack traces ou detalhes internos ao cliente. 
* Registrar logs com contexto adequado (placa, equipamento, tipo de erro, timestamp). 
* Diferenciar nos logs erros de validação de erros inesperados (5xx).  
  
### RF6: Casos Especiais (edge cases) 
O serviço deve tratar corretamente:  
* Velocidade medida igual ou abaixo do limite → sem infração. 
* Velocidade que cai dentro da margem de tolerância → sem infração. 
* Placas em ambos os formatos (antigo e Mercosul) → válidas. 
* Valores de fronteira entre faixas de gravidade (exatamente 20% e exatamente 50%). 
* Vias com limite acima de 100 km/h → tolerância percentual. 
* `captureTimestamp` no futuro → erro 400.  
  
## Requisitos Não Funcionais 

### RNF1: Organização do Código 
Organize o projeto da forma que considerar mais adequada. A arquitetura é uma decisão sua, queremos avaliar como você estrutura e separa responsabilidades, e a justificativa por trás das suas escolhas (documente no README). 
  
### RNF2: Configuração Externalizada 
Usar `application.yml` ou `application.properties`. Devem ser externalizáveis, no mínimo:  
* Porta do servidor (padrão: 8080) 
* Margem de tolerância em km/h (padrão: 7) 
* Margem de tolerância percentual (padrão: 7) 
* Limite que define o uso da tolerância percentual (padrão: 100) 
  
### RNF3: Testes 
**Obrigatório:**  
* Testes unitários da lógica de apuração (cálculo de tolerância, percentual e classificação por gravidade). 
* Testes de validação (placa nos dois formatos, velocidades e datas inválidas). 
* Testes dos casos especiais e valores de fronteira do RF6. 
* Cobertura mínima de 80% da camada de regras de negócio. 
  
**Diferencial:**  
* Testes de integração do endpoint (ex.: `@SpringBootTest` / `MockMvc` / `WebTestClient`). 
* Testes das expressões regulares de validação de placa. 
  
### RNF4: Documentação 
`README.md` contendo:  
* Descrição do projeto e tecnologias utilizadas. 
* Pré-requisitos e instruções de execução. 
* Exemplos de uso com curl (incluindo casos de infração, sem infração e erro). 
* Como executar os testes. 
* Decisões técnicas e justificativas (especialmente sobre a organização do código, ver RNF1).  

Documentação da API via Swagger/OpenAPI é um diferencial. 
  
### RNF5: Qualidade de Código 
* Usar Records (Java 21) e/ou Lombok para reduzir boilerplate. 
* Seguir as convenções de nomenclatura Java e princípios de Clean Code. 
* Código limpo e legível; comentários apenas onde necessário. 
* Sem código comentado, prints de debug ou trechos mortos. 
* Expressões regulares compiladas como constantes estáticas. 
  
## Estrutura de Entrega 

**Obrigatório**  
* Código-fonte do serviço. 
* Testes unitários. 
* Arquivo de configuração (`application.yml` ou `.properties`). 
* `README.md` completo. 
* `.gitignore` configurado. 
* Build tool (Maven). 
  
**Diferencial**  
* Aplicação hospedada e rodando (Railway, Render, Fly.io, AWS, etc.) com URL pública para testes. 
* Dockerfile. 
* Collection do Postman/Insomnia com exemplos de leituras. 
* Pipeline de CI (ex.: GitHub Actions). 
* Documentação OpenAPI/Swagger. 
   
## Instruções de Entrega 
1. **Repositório Git:** público no GitHub/GitLab, nome sugerido `speed-violation-service`. 
2. **Commits:** incrementais e com mensagens descritivas (ex.: `feat: add speed violation rules`, `test: add boundary cases`). Evite um único commit. 
3. **Enviar:** 
    * Link do repositório público. 
    * (Diferencial) URL da aplicação hospedada. 
    * Instruções especiais e suposições assumidas, se houver. 
   
## O que Valorizamos 
Estamos avaliando não apenas se funciona, mas como você resolve o problema:  
* Organização do código e clareza das decisões de arquitetura 
* Código legível e manutenível 
* Testes bem escritos, cobrindo regras e edge cases 
* Tratamento adequado de erros e validações 
* Documentação clara e decisões técnicas justificadas 
* Aplicação hospedada e funcionando (grande diferencial!) 
  
**Dicas finais:**  
* Qualidade > Quantidade. 
* Teste tudo antes de entregar. 
* Documente suas decisões e qualquer suposição no README. 
  
Boa sorte!
