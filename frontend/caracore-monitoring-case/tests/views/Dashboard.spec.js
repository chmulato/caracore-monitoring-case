import { mount } from "@vue/test-utils";
import Dashboard from "../../src/views/Dashboard.vue";

describe("Dashboard.vue", () => {

  it("renderiza o dashboard sem erros", () => {
    const wrapper = mount(Dashboard);
    expect(wrapper.exists()).toBe(true);
  });

});
