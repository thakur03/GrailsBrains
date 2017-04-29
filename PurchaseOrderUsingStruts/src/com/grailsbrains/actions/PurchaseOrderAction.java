package com.grailsbrains.actions;

import com.grailsbrains.connection.POManage;
import com.grailsbrains.forms.PurchaseOrder;
import com.grailsbrains.forms.PurchaseOrderForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Created by Ajeet on 4/28/2017.
 */
public class PurchaseOrderAction extends Action {
    private static final String SUCCESS = "success";
    private Connection con;
    private PreparedStatement pst;
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PurchaseOrderForm purchaseOrderForm = (PurchaseOrderForm) form;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        POManage manage = new POManage();
       int n = manage.createPurchaseOrder(purchaseOrder);
        return  mapping.findForward("purchase_order_list");
    }
}
