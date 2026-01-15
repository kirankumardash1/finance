package com.budget.app.service;

import com.budget.app.dto.DateTimeNormalizeRequest;
import com.budget.app.dto.DateTimeNormalizeResponse;
import com.budget.app.exception.InvalidDateTimeException;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class DateTimeService {


    public DateTimeNormalizeResponse normalize(DateTimeNormalizeRequest dateTimeNormalizeRequest) {
        try {
            Instant instant = OffsetDateTime.parse(dateTimeNormalizeRequest.getInput()).toInstant();
            ZoneId targetZone = ZoneId.of(dateTimeNormalizeRequest.getTagetZone());

            ZonedDateTime normalized = instant.atZone(targetZone);

            return new DateTimeNormalizeResponse(
                    dateTimeNormalizeRequest.getInput(),
                    normalized.toInstant().toString(),
                    normalized.toEpochSecond());
        }catch (DateTimeException ex) {
            throw new InvalidDateTimeException("Invalid datetime or timezone",ex);
        }
    }
}
