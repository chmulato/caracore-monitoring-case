import api from "../../src/services/api";

describe("api.js", () => {

  it("usa a baseURL correta", () => {
    expect(api.defaults.baseURL).toBe("http://localhost:8080");
  });

});
