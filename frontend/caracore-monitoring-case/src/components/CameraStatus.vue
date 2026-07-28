<template>
  <div class="card">
    <h2>Câmeras</h2>
    <ul>
      <li v-for="cam in cameras" :key="cam.id">
        {{ cam.nome }} — {{ cam.status }}
      </li>
    </ul>
  </div>
</template>

<script>
import api from "../services/api";

export default {
  data() {
    return { cameras: [] };
  },
  mounted() {
    api.get("/camera/status").then(res => {
      this.cameras = res.data;
    });
  }
};
</script>
