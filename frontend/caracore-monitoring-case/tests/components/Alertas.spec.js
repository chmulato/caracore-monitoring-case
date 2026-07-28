import { mount, flushPromises } from "@vue/test-utils";
import Alertas from "../../src/components/Alertas.vue";
import api from "../../src/services/api";

vi.mock("../../src/services/api");

describe("Alertas.vue", () => {

  it("lista alertas", async () => {
    api.get.mockResolvedValue({
      data: [
        { id: 1, tipo: "INTERNET", mensagem: "Internet offline" }
      ]
    });

    const wrapper = mount(Alertas);
    await flushPromises();

    expect(wrapper.text()).toContain("Internet offline");
  });

});
