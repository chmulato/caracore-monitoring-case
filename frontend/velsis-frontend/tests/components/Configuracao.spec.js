import { mount, flushPromises } from "@vue/test-utils";
import Configuracao from "../../src/components/Configuracao.vue";
import api from "../../src/services/api";

vi.mock("../../src/services/api");

describe("Configuracao.vue", () => {

  it("exibe configuração corretamente", async () => {
    api.get.mockResolvedValue({
      data: {
        ipTesteInternet: "8.8.8.8",
        periodicidadeInternet: 10,
        periodicidadeDisco: 20,
        periodicidadeCamera: 30
      }
    });

    const wrapper = mount(Configuracao);
    await flushPromises();

    expect(wrapper.text()).toContain("8.8.8.8");
    expect(wrapper.text()).toContain("10s");
    expect(wrapper.text()).toContain("20s");
    expect(wrapper.text()).toContain("30s");
  });

});
