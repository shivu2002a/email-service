package com.example.email_demo.Dto;

import java.time.LocalDate;

public class ActivationMailDto {
    public String email;
    public String username, subject;

    
    public String serviceName, serviceType;
    public String serviceBenefits, serviceDescription;
    public Double serviceCost;
    public Integer serviceValidity;

    public LocalDate startDate, endDate;
}
