<template>
  <div class="card">
    <h2>Disco</h2>
    <p>Uso: {{ uso }}%</p>
  </div>
</template>

<script>
import api from "../services/api";

export default {
  data() {
    return { uso: 0 };
  },
  mounted() {
    api.get("/disco/status").then(res => {
      this.uso = res.data.percentual;
    });
  }
};
</script>
