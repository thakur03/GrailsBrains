package com.grailsbrains.forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class Loginfrm extends org.apache.struts.action.ActionForm {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ActionForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (username == null || username.length() < 4) {
            errors.add("username", new ActionMessage("error.username.required"));
        }
        if (password == null || password.length() < 4) {
            errors.add("password", new ActionMessage("error.password.required"));
        }
        return errors;
    }
}
