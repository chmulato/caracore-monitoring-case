<template>
  <div class="card">
    <h2>Configuração</h2>
    <p>IP teste: {{ cfg.ipTesteInternet }}</p>
    <p>Periodicidade Internet: {{ cfg.periodicidadeInternet }}s</p>
    <p>Periodicidade Disco: {{ cfg.periodicidadeDisco }}s</p>
    <p>Periodicidade Câmera: {{ cfg.periodicidadeCamera }}s</p>
  </div>
</template>

<script>
import api from "../services/api";

export default {
  data() {
    return { cfg: {} };
  },
  mounted() {
    api.get("/configuracao").then(res => {
      this.cfg = res.data;
    });
  }
};
</script>
