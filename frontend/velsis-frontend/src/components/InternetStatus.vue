<template>
  <div class="card">
    <h2>Internet</h2>
    <p>Status: {{ status }}</p>
  </div>
</template>

<script>
import api from "../services/api";

export default {
  data() {
    return { status: "Carregando..." };
  },
  mounted() {
    api.get("/internet/status").then(res => {
      this.status = res.data.status;
    });
  }
};
</script>
