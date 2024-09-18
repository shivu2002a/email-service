package com.example.email_demo.Dto;

import java.time.LocalDate;

public class TerminationMailDto {
    public String email;
    public String username, subject;

    public String serviceName, serviceType;
    public Integer serviceValidity;

    public LocalDate startDate, endDate;

    public Integer noOfDaysUsed;
}
