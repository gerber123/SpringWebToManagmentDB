package com.gerber.springdemo.entity;




import com.gerber.springdemo.Validation.VipCode;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name="playerfortheexp")
public class PlayerForTheExp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="first_name")
    private String firstName;


    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="last_name")
    private String lastName;


    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Email
    @Column(name="email")
    private String email;

    @Column(name="status")
    private String status;

    @Column(name="joinDate")
    private Date date;

    public PlayerForTheExp() {
    }

    public PlayerForTheExp(@NotNull String firstName, @NotNull String lastName, @NotNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
