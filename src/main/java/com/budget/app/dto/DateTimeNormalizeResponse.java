package com.budget.app.dto;

public record DateTimeNormalizeResponse(
        String original,
        String normalizedIso,
        long epochSeconds
) {


}
