Cara Core Frontend - Dashboard de Monitoramento
============================================

O front-end do projeto foi construído com ferramentas modernas para garantir alta performance, fácil manutenção e testes robustos, servindo como demonstração visual para o case de estudo da Cara Core Informática.

TECNOLOGIAS UTILIZADAS
----------------------

- Vue.js 3
- Vite (Bundler e Dev Server ultra rápido)
- Vitest e Vue Test Utils (Testes unitários)
- Axios (Integração com a API)

DECISÕES DE DESENVOLVIMENTO (FOCO AVALIATIVO)
---------------------------------------------

1. Componentização Semântica: Cada card do Dashboard (Internet, Disco, Alertas, Câmeras) é um componente isolado que consome seu próprio endpoint. Isso obedece ao princípio de responsabilidade única e facilita os testes.

2. Cobertura de Testes (Vitest): Todos os componentes principais possuem testes unitários rigorosos. A lógica lida corretamente com promessas de API usando funções de espera para garantir que os estados (como "Carregando" vs "Online") sejam renderizados corretamente de acordo com os dados recebidos nas asserções.

3. Visualização de Stream Conceitual: De acordo com a premissa de um projeto para avaliação Júnior, a tela de Stream de Vídeo foi abordada conceitualmente. Ela exibe o layout, consumo de dados básicos e navegação de rotas no Vue.js, servindo como placeholder que demonstra o fluxo de desenvolvimento de UI sem onerar a aplicação com processamento de vídeo (WebRTC ou HLS pesados).

COMO RODAR
----------

Navegue até a pasta frontend/caracore-monitoring-case no seu terminal:

1. Instale as dependências:
npm install

2. Inicie o servidor de desenvolvimento:
npm run dev

3. A aplicação estará disponível em http://localhost:5173. (Certifique-se de que o Backend está rodando em paralelo para que a API funcione perfeitamente).

TESTES UNITÁRIOS E COBERTURA
----------------------------

Para validar a integridade dos componentes, rode a suíte do Vitest:

npm run test -- --coverage

O comando executará todos os arquivos de especificação, processando as chamadas de API e validando a renderização de templates, retornando no final uma tabela de cobertura dos arquivos do sistema.
