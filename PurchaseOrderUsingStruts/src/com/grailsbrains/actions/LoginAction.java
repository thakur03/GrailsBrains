package com.grailsbrains.actions;

import com.grailsbrains.forms.Loginfrm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Created by Ajeet on 4/27/2017.
 */
public class LoginAction extends Action {

    private final static String USER = "ajeet";
    private final static String PASS = "12345";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
       Loginfrm actionForm = (Loginfrm) form;

       if (actionForm.getUsername().equals(USER)&& actionForm.getPassword().equals(PASS))
         return  mapping.findForward("purchase_order");
       else
         return   mapping.findForward("fail");

    }
}
