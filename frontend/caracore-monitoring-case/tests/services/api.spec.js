import api from "../../src/services/api";

describe("api.js", () => {

  it("usa a baseURL correta", () => {
    const expectedBaseUrl = import.meta.env?.VITE_API_URL || "http://localhost:8080";
    expect(api.defaults.baseURL).toBe(expectedBaseUrl);
  });

});
