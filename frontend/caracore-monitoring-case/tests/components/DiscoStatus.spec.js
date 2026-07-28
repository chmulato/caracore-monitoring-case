import { mount, flushPromises } from "@vue/test-utils";
import DiscoStatus from "../../src/components/DiscoStatus.vue";
import api from "../../src/services/api";

vi.mock("../../src/services/api");

describe("DiscoStatus.vue", () => {

  it("renderiza percentual de uso", async () => {
    api.get.mockResolvedValue({ data: { percentual: 75 } });

    const wrapper = mount(DiscoStatus);
    await flushPromises();

    expect(wrapper.text()).toContain("75%");
  });

});
