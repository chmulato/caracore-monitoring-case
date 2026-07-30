import { mount } from "@vue/test-utils";
import { vi } from "vitest";
import Dashboard from "../../src/views/Dashboard.vue";

// Mocking API to prevent real requests during component mount
vi.mock("../../src/services/api", () => {
  return {
    default: {
      get: vi.fn().mockResolvedValue({ data: {} })
    }
  };
});

describe("Dashboard.vue", () => {

  it("renderiza o dashboard sem erros", () => {
    const wrapper = mount(Dashboard);
    expect(wrapper.exists()).toBe(true);
  });

});
