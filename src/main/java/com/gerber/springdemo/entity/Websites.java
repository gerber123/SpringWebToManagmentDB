package com.gerber.springdemo.entity;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="websites")
public class Websites
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="author_firstName")
    private String author_firstName;


    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="author_lastName")
    private String author_lastName;

    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="theme")
    private String theme;

    @NotNull(message="is Required!")
    @Size(min=1,message ="is Required!")
    @Column(name="website_url")
    private String website_url;


    @Column(name="vote_points")
    private int vote_points;


    public Websites() {
    }

    public Websites(@NotNull String author_firstName, @NotNull String author_lastName, @NotNull String theme) {
        this.author_firstName = author_firstName;
        this.author_lastName = author_lastName;
        this.theme = theme;
    }


    public int getId() {
        return id;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_firstName() {
        return author_firstName;
    }

    public void setAuthor_firstName(String author_firstName) {
        this.author_firstName = author_firstName;
    }

    public String getAuthor_lastName() {
        return author_lastName;
    }

    public void setAuthor_lastName(String author_lastName) {
        this.author_lastName = author_lastName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getVote_points() {
        return vote_points;
    }

    public void setVote_points(int vote_points) {
        this.vote_points = vote_points;
    }
}
