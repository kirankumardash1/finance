package com.budget.app.controller;

import com.budget.app.dto.DateTimeNormalizeRequest;
import com.budget.app.dto.DateTimeNormalizeResponse;
import com.budget.app.service.DateTimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dateTime")
public class DateTimeController {
    private final DateTimeService dateTimeService;
     public DateTimeController(DateTimeService dateTimeService) {
         this.dateTimeService = dateTimeService;
     }

     @PostMapping
    public DateTimeNormalizeResponse normalize(@RequestBody DateTimeNormalizeRequest dateTimeNormalizeRequest){
         return dateTimeService.normalize(dateTimeNormalizeRequest);
     }
}
