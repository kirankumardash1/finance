package com.budget.app.dto;
import lombok.NonNull;
import lombok.Value;

@Value
public class DateTimeNormalizeRequest {
    @NonNull
    String input;

    @NonNull
    String tagetZone;

}
