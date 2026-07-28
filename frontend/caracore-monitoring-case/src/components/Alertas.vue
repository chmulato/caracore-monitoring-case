<template>
  <div class="card">
    <h2>Alertas</h2>
    <ul>
      <li v-for="a in alertas" :key="a.id">
        {{ a.tipo }} — {{ a.mensagem }}
      </li>
    </ul>
  </div>
</template>

<script>
import api from "../services/api";

export default {
  data() {
    return { alertas: [] };
  },
  mounted() {
    api.get("/alertas").then(res => {
      this.alertas = res.data;
    });
  }
};
</script>
