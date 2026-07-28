import { mount, flushPromises } from "@vue/test-utils";
import CameraStatus from "../../src/components/CameraStatus.vue";
import api from "../../src/services/api";

vi.mock("../../src/services/api");

describe("CameraStatus.vue", () => {

  it("lista câmeras corretamente", async () => {
    api.get.mockResolvedValue({
      data: [
        { id: 1, nome: "Cam 1", status: "ONLINE" },
        { id: 2, nome: "Cam 2", status: "OFFLINE" }
      ]
    });

    const wrapper = mount(CameraStatus);
    await flushPromises();

    expect(wrapper.text()).toContain("Cam 1");
    expect(wrapper.text()).toContain("Cam 2");
  });

});
