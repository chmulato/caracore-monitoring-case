Se este teste for um trabalho de prova de conceito com desvio de finalidade eu posso processar a empresa e cobrar pelo projeto MVP prestado?

Resposta curta: Sim, legalmente você pode processar e cobrar, mas na prática isso exige demonstrar que o "teste" ultrapassou os limites do razoável e se tornou prestação de serviço útil/trabalho gratuito (enriquecimento sem causa da empresa).

Como funciona no Direito do Trabalho e Civil Brasileiro
No Brasil, a Justiça do Trabalho entende que testes técnicos em processos seletivos são legítimos apenas quando servem exclusivamente para aferir o conhecimento do candidato. Quando a empresa exige um trabalho complexo que gera um produto/solução reaproveitável ou comercializável, caracteriza-se o desvio de finalidade.

Principais pontos que respaldam essa cobrança:

Enriquecimento sem causa (Art. 884 do Código Civil): Se a empresa utilizar o seu código (o MVP ou Prova de Conceito) em produção ou para resolver um problema real de um cliente/negócio sem te remunerar, ela está se beneficiando do seu trabalho gratuitamente.

Trabalho Análogo a Prestação de Serviços / Vínculo: Se o teste demandou muitas horas/dias de trabalho com escopo de projeto real, a Justiça pode entender que houve prestação de serviço autônomo (consultoria/desenvolvimento) ou até vínculo empregatício pelo período do projeto, exigindo o pagamento das horas trabalhadas ou valor de mercado da solução entregue.

Direitos Autorais (Lei nº 9.609/1998 - Lei do Software): Em testes técnicos, os direitos autorais e patrimoniais do código permanecem com o autor (você), exceto se houver um contrato assinado de cessão de direitos ou contratação formal. Se a empresa copiar, modificar ou rodar seu repositório comercialmente sem autorização, cabe inclusive ação por violação de propriedade intelectual.

O que você precisa para comprovar a cobrança?
Se decidir notificar a empresa ou ingressar com ação, o sucesso depende do conjunto probatório:

Escopo e Complexidade Exagerada: Provar que a especificação solicitada não era um exercício genérico (como um CRUD simples ou desafio público), mas sim um problema de negócio real, específico e pronto para uso comercial.

Uso Efetivo: Evidências de que a empresa efetivamente usou, incorporou ou se apropriou da sua solução (commits, logs, endpoints ativos, validação com clientes dela, etc.).

Proporcionalidade de Tempo: Documentar o número desproporcional de horas exigidas para a conclusão da tarefa em relação a um teste de recrutamento padrão.

Recomendações Práticas
Proteja seu repositório: Mantendo o repositório sob uma licença estrita (ou removendo o acesso público/alterando para privado) e registrando a autoria do código.

Notificação Extrajudicial: Antes de acionar a justiça, advogados costumam enviar uma notificação formal apontando a apropriação indevida do projeto e solicitando o pagamento proporcional ao desenvolvimento do MVP.

Consultoria Jurídica: Para avaliar os riscos, custos e a viabilidade da cobrança frente ao valor do projeto, o recomendado é consultar um advogado trabalhista ou especialista em direito digital.

Sim mas hoje em dia as IAs fazem tudo rápido se tem os sêniores fazendo a gestão?

Aqui está o ponto central: a IA acelera a codificação, mas não muda a natureza jurídica da apropriação do seu trabalho.

Mesmo que o uso de IAs reduza o tempo de desenvolvimento sob a gestão de um desenvolvedor sênior, a tese legal não se baseia apenas em "quantas horas levou", mas no valor do entregável e na finalidade da solicitação.

1. O valor do entregável (Direito Autoral e Propriedade Intelectual)
A Lei do Software (Lei nº 9.609/1998) protege a propriedade intelectual do código-fonte criado por você.

Se a empresa pediu uma Prova de Conceito (PoC) para resolver um problema real do negócio dela e ela passa a usar essa solução (seja para validação interna, demonstração para clientes ou integração no sistema dela), ela está se apropriando de um ativo de software.

Pouco importa se você usou IA, um framework pronto ou escreveu tudo à mão: a autoria do projeto/arquitetura entregue no repositório ainda é sua. Se ela usou para fins comerciais sem te contratar ou pagar pela licença/serviço, há enriquecimento sem causa (Art. 884 do Código Civil).

2. O desvio de finalidade do teste
O objetivo de um teste técnico em um processo seletivo é aferir capacidade técnica (arquitetura, padrões de projeto, SOLID, qualidade de código).

Se o teste exige a construção de um MVP funcional sob medida para uma demanda específica da empresa, o teste deixa de ser uma avaliação de perfil e vira uma consultoria/prestação de serviço não remunerada ("trabalho spec"). O fato de um sênior orientar com IA não anula o fato de que a empresa recebeu um produto final de graça.

3. O impacto prático da IA na tese judicial
Onde a IA muda o cenário é na valoração financeira (quanto cobrar):

Antes da IA: A cobrança em ações/notificações baseava-se em "horas de desenvolvimento sênior x valor da hora no mercado".

Com IA: A defesa da empresa tentará argumentar que o esforço foi mínimo e que o código gerado é genérico. Por isso, a cobrança se desloca do "tempo gasto" para o valor de mercado da solução entregue (MVP) e para o uso indevido da propriedade intelectual.

O que realmente importa para a cobrança:
Evidência de uso: A empresa pegou o repositório e colocou em produção, usou como base do produto dela ou apresentou para investidores/clientes? Isso é a prova cabal da utilização do trabalho.

Propriedade: O código do repositório público/privado é seu. Sem um contrato de cessão assinado (como o que existe no contrato de trabalho formal), a empresa não detém os direitos patrimoniais do software.

A IA agiliza a execução, mas não concede à empresa o direito de se apropriar de um MVP funcional feito durante um processo seletivo sem a devida contraprestação financeira.

Este é que nível?

Aqui está uma análise técnica objetiva deste desafio:

Trata-se de um teste de nível Pleno Avançado a Sênior (Full Stack / Embarcados), embora no mercado muitas empresas tentem rotulá-lo apenas como "Pleno".

Abaixo estão os motivos que justificam esse nível:

1. Complexidade de Integração e Domínio (Embarcados + Java/C++)
Processamento de Mídia em Tempo Real: Capturar um fluxo RTSP (geralmente via JNI/OpenCV ou FFmpeg) no back-end Java, decodificar/converter em frames ou HLS/WebRTC e fazer o streaming pro Vue.js no front-end não é uma tarefa trivial de CRUD web. Isso exige conhecimentos de infraestrutura de mídia e integração nativa.

Comunicação com SO e Periféricos: Interagir diretamente com o sistema operacional Linux para checar métricas de disco, executar pings e gerenciar threads de polling/agendamento contínuo em background.

2. Escopo Full Stack Extenso
O candidato precisa dominar o ecossistema completo:

Back-end: Java (8/17), Spring Boot, Spring Data JPA, Spring Security, BCrypt, agendamento de tarefas (@Scheduled), documentação Swagger/OpenAPI.

Front-end: Vue.js, Axios, Vue Router, gerenciamento de estado e reprodução de mídia em tempo real.

Banco de Dados: PostgreSQL com modelagem relacional de pelo menos 6 entidades, relacionamentos e persistência de histórico de métricas.

3. Exigência de Qualidade de Código de Nível Sênior
O documento deixa explicito na seção 22 que a avaliação focará na arquitetura e não apenas no funcionamento. É exigido:

Arquitetura em camadas sólida e Clean Code.

Aplicação prática dos princípios SOLID e Padrões de Projeto.

Cobertura de testes unitários e de integração (JUnit 5 + Mockito).

Javadoc em métodos públicos e documentação arquitetural no README.

4. Prazo vs. Volume de Entregáveis
Pedir essa quantidade de módulos (back-end, front-end, persistência, processamento RTSP, testes e documentação) para ser entregue em 3 a 5 dias corridos ultrapassa a carga horária razoável de um teste de recrutamento para níveis Pleno/Júnior. É um escopo que se aproxima do desenvolvimento de um MVP funcional completo.

Tem cara de teste de má fé?

Analisando o documento sob a ótica de mercado e jurídica, a resposta é sim: tem todos os traços de um teste abusivo ou de má fé.

No mercado de tecnologia, esse tipo de desafio é conhecido como "Work Spec" ou "Trabalho Gratuito Disfarçado de Teste".

Aqui estão os motivos claros pelos quais este teste acende múltiplos sinais de alerta:

1. Escopo de MVP Comercial Pronto para Uso
O desafio não pede para você demonstrar lógica com algoritmos genéricos. Ele pede um sistema completo de telemetria e monitoramento de equipamentos embarcados — que é exatamente o core business de empresas de tecnologia de trânsito, segurança ou automação.
PDF

Sistema de monitoramento de disco/internet  
PDF

Módulo de cadastro e verificação de câmeras IP  
PDF

Decodificação de stream RTSP  
PDF

Painel e API REST completa  
PDF

Pedir a solução inteira ponta a ponta (front + back + banco + testes + infra) com regras de negócio reais da empresa é o indicador mais forte de reutilização de código.

2. Prazo Irrealista (3 a 5 Dias)
O documento estabelece um prazo de 3 a 5 dias corridos para a entrega de um sistema funcional com testes unitários, Swagger, documentação arquitetural e processamento de mídia em tempo real.  
PDF

Se for feito do zero com qualidade sênior (SOLID, Clean Architecture, JUnit), isso exige facilmente de 30 a 50 horas de trabalho focado.  
PDF

Exigir esse volume de horas sem remuneração em um processo seletivo ultrapassa qualquer limite de razoabilidade para aferição de conhecimento.

3. A Pegadinha dos "Módulos Não Obrigatórios"
O documento marca vários itens como "(Não obrigatório)", mas nas seções de Qualidade de Código, Critérios de Avaliação e Diferenciais, ele deixa claro que o candidato será julgado pela completude e arquitetura. Essa é uma tática comum para tentar juridicamente descaracterizar o abuso ("nós não obrigamos a fazer tudo"), enquanto na prática desclassificam quem não entrega o projeto completo.  
PDF
+ 1

4. Especificidade Excessiva de Requisitos
Testes legítimos avaliam como você pensa (ex: "crie um serviço simples que consuma uma API e exiba métricas"). Este teste especifica até como contornar limitações do navegador usando OpenCV no Java para ler RTSP. Isso soa como resolução de um problema técnico real que a própria equipe da empresa encontrou no dia a dia.  
PDF

O que você pode fazer para se proteger se decidir entregar:
Licença de Código Fechada: Adicione um arquivo LICENSE no repositório com uma licença proprietária/restritiva (ex: All Rights Reserved / "Proibido qualquer uso comercial ou cópia sem autorização expressa do autor").

Não entregue o binário executável no ar: Suba o código no seu GitHub e forneça apenas prints/vídeos de demonstração (ou limite o acesso ao repositório).

Ofuscamento ou Mock de Regras Chave: Se houver um algoritmo ou integração muito específica do negócio deles, suba com dados mockados ou abstraídos.

Guarde todos os registros: Mantenha os e-mails, o PDF do enunciado, o histórico de commits do Git com timestamps e a troca de mensagens com os recrutadores.

O que escrevo para o Matheus do RH para por eles na parede?

Para dar uma resposta firme, elegante e estrategicamente segura, você deve focar em proteger sua propriedade intelectual e impor limites sem parecer reativo. O objetivo não é "brigar", mas sim mostrar que você é um profissional sênior que percebeu o tamanho desproporcional do escopo e não aceita fornecer trabalho consultivo de graça sob a roupagem de teste técnico.

Aqui estão duas opções de mensagens que você pode ajustar conforme o tom que deseja adotar:

Opção 1: Direta, firme e elegante (Recomendada)
Esta opção estabelece que o projeto é um MVP com valor de mercado, resguarda seus direitos autorais e coloca a bola de volta do lado deles.

Assunto: Esclarecimento sobre o escopo do Desafio Técnico – [Seu Nome]

Olá, Matheus, tudo bem?

Analisei detalhadamente a especificação do case técnico. Trata-se de uma solução full-stack completa de telemetria e monitoramento de periféricos (processamento de mídia RTSP em tempo real, integração com SO e arquitetura completa).

Pelo nível de especificidade e complexidade das regras de negócio, o material solicitado ultrapassa os padrões de aferição técnica de um processo seletivo e se configura como um MVP (Produto Mínimo Viável) funcional para uso real.

Como profissional sênior, priorizo a transparência e o respeito mútuo. Sendo assim, informo que a solução que desenvolvi permanece sob minha propriedade intelectual exclusiva (direitos autorais resguardados), sendo o repositório disponibilizado estritamente para avaliação do meu nível arquitetural nesta vaga.

Caso a empresa deseje utilizar, evoluir ou incorporar esta solução/código em seus ambientes ou produtos, estou aberto a formalizar um contrato de prestação de serviços ou cessão de direitos patrimoniais do software.

Fico no aguardo do feedback técnico da equipe quanto à qualidade do meu código e aos critérios do processo.

Um abraço,

[Seu Nome]

Opção 2: Postura de Consultor / Teto de Horas (Mais incisiva)
Esta opção pontua o desvio de finalidade focando no volume desproporcional de horas solicitadas para um teste não remunerado.

Assunto: Considerações sobre a entrega do Case Técnico – [Seu Nome]

Olá, Matheus, tudo bem?

Conforme solicitado, realizei a entrega do desafio técnico. Gostaria de fazer uma observação pontual quanto ao formato do teste:

O projeto exigido abrange o desenvolvimento completo de um sistema embarcado comercial (módulo de mídia RTSP, monitoramento de SO Linux, persistência, APIs e painel em Vue.js). A entrega de um escopo desse porte em 3 a 5 dias exige entre 30 a 50 horas de arquitetura e desenvolvimento sênior, o que caracteriza uma prestação de serviço/POC e não um mero teste seletivo.

Fiz a entrega para demonstrar meu padrão de arquitetura e Clean Code, porém ressalto que todo o código-fonte disponibilizado no repositório é de minha propriedade intelectual e está protegido contra qualquer reprodução, cópia ou uso comercial por parte da empresa sem prévio acordo comercial e contratação formal.

Gostaria de confirmar o recebimento e entender quais são os próximos passos da etapa final do processo seletivo.

Atenciosamente,

[Seu Nome]

Dicas de Proteção Antes de Enviar:
Licença no GitHub: Certifique-se de que o repositório no GitHub tenha um arquivo LICENSE restritivo (ou simplesmente um README com o aviso: "Todos os direitos reservados. Código desenvolvido estritamente para fins de avaliação técnica individual. Proibida a cópia, modificação ou uso comercial sem autorização por escrito do autor.").

Guarde os Registros: Mantenha salvos o PDF do teste, os logs de commits do repositório (que provam a data e autoria) e a troca de e-mails com a empresa.

Mando a merda e uso o caso para o meu portfólio como prestador de serviço para eles e faço propaganda do trabalho?

Aqui está o meu parecer sincero: não mande a merda, mas use o projeto como um case de portfólio incrível (rebranding total dele para a sua própria marca).

Mandar o recrutador a merda na emoção gera um "print" e pode queimar pontes em redes profissionais locais ou em grupos de RH. A melhor resposta para uma empresa que tenta explorar seu trabalho de graça não é o xingamento, é a elegância implacável combinada com o uso comercial do que você construiu a seu favor.

1. Como reaproveitar o projeto como Portfólio (A Sacada Comercial)
Você acabou de construir um sistema completo e robusto de monitoramento de equipamentos embarcados e streaming RTSP em tempo real. Isso tem um valor comercial gigante para empresas de logística, rastreamento, segurança eletrônica, agronegócio e automação industrial.

Para transformar esse desafio em um produto do seu portfólio de consultoria:

Faça o Rebranding Completo:

Altere o nome do repositório no GitHub para algo genérico/comercial seu (ex: caracore-embedded-telemetry ou edge-stream-monitor).

Remova qualquer menção ao nome da empresa, ao nome do recrutador ou ao PDF do teste.

Transforme o Readme num Showcase Comercial:

Escreva o README focado em problemas que o sistema resolve: "Solução Edge Computing para monitoramento de saúde de ativos embarcados Linux, telemetria de rede/disco e ingestão de vídeo RTSP com baixa latência."

Adicione GIFs, diagramas de arquitetura (C4 Model), métricas de performance e badges de cobertura de testes.

Mostre Autoridade e Padrão Sênior:

Destaque decisões arquiteturais: uso de OpenCV/FFmpeg, estratégia de mitigação de latência no streaming, arquitetura em camadas e desacoplamento com SOLID.

2. A Resposta Fria e Elegante para o RH (Sem "mandar a merda", mas deixando claro)
Em vez de xingar, envie uma mensagem ultra-profissional que encerra a conversa e impõe o seu valor como consultor/desenvolvedor sênior.

Assunto: Encerramento da participação no processo seletivo – [Seu Nome]

Olá, Matheus.

Após analisar detalhadamente o escopo exigido no case técnico (que abrange desde o monitoramento de SO Linux até o processamento e streaming de mídia RTSP em tempo real com regras de negócio completas), identifico que a demanda se trata de um MVP funcional de telemetria e segurança embarcada, e não de um mero teste de aferição de conhecimento técnico.

Pelo meu nível de senioridade e pela complexidade do software, não realizo desenvolvimento de soluções sob medida ou provas de conceito produtivas sem a devida contratação formal/remuneração.

Diante disso, estou retirando minha candidatura deste processo seletivo.

O código desenvolvido durante a análise do requisito foi incorporado ao meu portfólio privado e permanece sob minha propriedade intelectual restrita. Caso a empresa tenha interesse futuro em licenciar a arquitetura ou contratar meus serviços de consultoria para este projeto, fico à disposição.

Desejo sucesso na busca pelo profissional.

Atenciosamente,

[Seu Nome]

Por que essa abordagem é superior?
Você mantém a superioridade moral e profissional: O RH não terá nenhum argumento para te rotular como "não profissional".

Você protege seu ativo: O código vira seu produto e sua vitrine, em vez de ser um trabalho gratuito jogado fora.

A mensagem é um tapa de luva: Ela explicita exatamente o que eles tentaram fazer (pedir um MVP de graça), mostra que você percebeu e estabelece que o seu tempo e conhecimento sênior custam dinheiro.

E posso criar uma série de artigos de 4 episódios dentro do LinkedIn e meu blog para vender a ideia para outras aplicações práticas da solução?

Pode e deve. Essa é exatamente a jogada de mestre de quem atua com perfil de arquitetura e consultoria sênior: pegar um código que tentaram extrair de graça e transformar em autoridade, inbound marketing e ativo de vendas.

Como o código é de sua autoria e você não assinou nenhum NDA (acordo de confidencialidade) nem contrato de trabalho, você tem total liberdade para ensinar a arquitetura e demonstrar a solução.

A única regra de ouro é a desvinculação institucional: remova do código, das imagens e dos textos qualquer menção ao nome da empresa, ao recrutador ou ao enunciado original. Apresente o projeto como um case autoral desenvolvido por você para resolver um problema clássico de Edge Computing e monitoramento industrial.

Estrutura Sugerida para a Série (4 Episódios)
Abaixo está um roteiro pronto para estruturar seus artigos no LinkedIn e no blog, posicionando a solução para o mercado de automação, transporte, segurança e agronegócio:

Episódio 1: O Desafio de Telemetria e Monitoramento no Edge (Visão Geral)
Foco: O problema de mercado e a visão de arquitetura.

Conteúdo: Por que monitorar recursos de hardware e câmeras no ambiente embarcado (Linux) é crítico para disponibilidade de sistemas no campo. Diferença entre arquitetura em nuvem contínua vs. processamento local (local-first/edge).

CTA (Chamada para ação): "Você já teve problemas com perda de sinal ou travamento de periféricos em aplicações embarcadas?"

Episódio 2: Captura e Transmissão de Vídeo RTSP em Tempo Real com Java e OpenCV
Foco: A solução técnica para o principal gargalo (vídeo).

Conteúdo: Como contornar a limitação de navegadores que não rodam RTSP nativo. Explicar a estratégia de captura de frames/streaming no back-end Java, controle de concorrência e baixo consumo de CPU/memória no Linux.

CTA: "Como você costuma resolver o pipeline de vídeo em aplicações Java no ecossistema embarcado?"

Episódio 3: Arquitetura de Software Resiliente: Polling, Alertas e Persistência Local
Foco: Engenharia de software, SOLID e resiliência.

Conteúdo: Modelagem do banco de dados, gestão de threads para checagem contínua de disco e conectividade, geração de alertas em tempo real e isolamento de camadas.

CTA: "Compartilho o diagrama de classes e o padrão de persistência que utilizei para garantir tolerância a falhas."

Episódio 4: Do Protótipo ao Produto: Casos de Uso Reais e Aplicações Industriais
Foco: Vendas e aplicações comerciais (O fechamento).

Conteúdo: Apresentar como esse core de telemetria se aplica a frotas de transporte, monitoramento de biomassas/usinas, segurança patrimonial periférica ou totens de atendimento.

CTA: "Precisa de uma arquitetura embarcada sob medida ou de uma consultoria para viabilizar um MVP industrial? Vamos conversar."

Benefícios dessa estratégia:
Geração de Leads: Em vez de trabalhar de graça para uma única empresa, você expõe a solução para centenas de potenciais clientes ou contratantes no LinkedIn.

Inversão de Posição: Você deixa de ser o "candidato submetido a um teste" e passa a ser o especialista que ensina como se constrói uma solução sênior de ponta a ponta.

Indexação no Blog: Os artigos técnicos no seu blog geram autoridade orgânica e constroem um acervo permanente do seu conhecimento técnico e capacidade de entrega.

Essa é a melhor forma de virar a mesa: transformar a tentativa de exploração em vitrine de negócios.