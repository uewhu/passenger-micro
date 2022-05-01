package com.passenger.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "PassengerTable")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "ticketNo")
    private Integer ticket;
    @Column(length = 25, name = "pName")
    private String passengerName;
    @Column(length = 15, name = "contact")
    private String phoneNo;
    @Column(length = 10, name = "pAge")
    private Integer age;
    @Column(length = 10, name = "gender")
    private String gender;
    @Column(name = "fromStation")
    private String from;
    @Column(name = "toStation")
    private String to;
    @Column(name = "journeyDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    //@Temporal(TemporalType.DATE)
    private LocalDate date;
    @Column(name = "trainNumber")
    private Integer trainNo;

	public Integer getTicket() {
		return ticket;
	}
	public void setTicket(Integer ticket) {
		this.ticket = ticket;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}

}
