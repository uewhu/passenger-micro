package com.passenger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PassengersDto {
    @NotEmpty(message = "Passenger name required")
    private String passengerName;
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="Mobile number is invalid")
    private String phoneNo;
    @NotNull(message = "Age required")
    private Integer age;
    @NotEmpty(message = "Gender required")
    private String gender;
    @NotNull
    private Integer trainNo;

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
