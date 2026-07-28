package br.com.caracore.speedviolation.model.response;

import br.com.caracore.speedviolation.model.entity.Violation;
import java.time.Instant;

public record ViolationResponse(

        String licensePlate,
        String equipmentId,
        Integer measuredSpeed,
        Integer consideredSpeed,
        Integer speedLimit,
        Double excessPercentage,
        boolean hasViolation,
        Violation violation,
        Instant processedAt

) {}
