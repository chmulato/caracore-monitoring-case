import { mount, flushPromises } from "@vue/test-utils";
import InternetStatus from "../../src/components/InternetStatus.vue";
import api from "../../src/services/api";

vi.mock("../../src/services/api");

describe("InternetStatus.vue", () => {
  beforeEach(() => {
    vi.clearAllMocks();
    api.get.mockResolvedValue({ data: {} });
  });

  it("exibe 'Carregando...' inicialmente", () => {
    const wrapper = mount(InternetStatus);
    expect(wrapper.text()).toContain("Carregando");
  });

  it("exibe status retornado pela API", async () => {
    api.get.mockResolvedValue({ data: { status: "ONLINE" } });

    const wrapper = mount(InternetStatus);
    await flushPromises();

    expect(wrapper.text()).toContain("ONLINE");
  });

});
