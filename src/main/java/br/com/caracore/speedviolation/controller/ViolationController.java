package br.com.caracore.speedviolation.controller;

import br.com.caracore.speedviolation.model.enums.Origin;
import br.com.caracore.speedviolation.model.request.ViolationRequest;
import br.com.caracore.speedviolation.model.response.ViolationResponse;
import br.com.caracore.speedviolation.service.ViolationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/violations")
public class ViolationController {

    private final ViolationService service;

    public ViolationController(ViolationService service) {
        this.service = service;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<ViolationResponse> evaluate(
            @RequestHeader("x-origin") Origin origin,
            @Valid @RequestBody ViolationRequest request
    ) {
        return ResponseEntity.ok(service.evaluate(origin, request));
    }
}
