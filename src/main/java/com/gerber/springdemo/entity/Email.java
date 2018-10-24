package com.gerber.springdemo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Email
{
    @NotNull(message = "is required")
    @Size(min=1,message ="is Required!")
    private String authorName;
    @NotNull(message = "is required")
    @Size(min=1,message ="is Required!")
    private String reciverEmail;
    @NotNull(message = "is required")
    @Size(min=1,message ="is Required!")
    private String textEmail;
    @NotNull(message = "is required")
    @Size(min=1,message ="is Required!")
    private String themeEmail;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReciverEmail() {
        return reciverEmail;
    }

    public void setReciverEmail(String reciverEmail) {
        this.reciverEmail = reciverEmail;
    }

    public String getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(String textEmail) {
        this.textEmail = textEmail;
    }

    public String getThemeEmail() {
        return themeEmail;
    }

    public void setThemeEmail(String themeEmail) {
        this.themeEmail = themeEmail;
    }
}
