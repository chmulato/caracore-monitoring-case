<template>
  <div class="dashboard">
    <h1>Monitoramento HD</h1>

    <InternetStatus />
    <DiscoStatus />
    <CameraStatus />
    <Alertas />
    <Configuracao />
  </div>
</template>

<script>
import InternetStatus from "../components/InternetStatus.vue";
import DiscoStatus from "../components/DiscoStatus.vue";
import CameraStatus from "../components/CameraStatus.vue";
import Alertas from "../components/Alertas.vue";
import Configuracao from "../components/Configuracao.vue";

export default {
  components: {
    InternetStatus,
    DiscoStatus,
    CameraStatus,
    Alertas,
    Configuracao
  }
};
</script>
