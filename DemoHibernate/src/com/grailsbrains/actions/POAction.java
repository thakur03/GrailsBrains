package com.grailsbrains.actions;

import com.grailsbrains.forms.PurchaseOrderForm;
import com.grailsbrains.manage.POManage;
import com.grailsbrains.persistence.DestinationAddress;
import com.grailsbrains.persistence.OriginAddress;
import com.grailsbrains.persistence.PurchaseOrder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class POAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        PurchaseOrderForm poForm = (PurchaseOrderForm)form;
        POManage poManage = new POManage();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<OriginAddress> originAddresses = new ArrayList<>();
        OriginAddress originAddress = new OriginAddress();
        originAddress.setRefererName(poForm.getShipfrom());
        originAddress.setAddress(poForm.getOriginstreet());
        originAddress.setCity(poForm.getOrigincity());
        originAddress.setState(poForm.getOriginstate());
        originAddress.setCountry(poForm.getOrigincountry());
        originAddress.setPickupStart(dateFormat.parse(poForm.getPickupstart()));
        originAddress.setPickupEnd(dateFormat.parse(poForm.getPickupend()));
        originAddresses.add(originAddress);

        List<DestinationAddress> destinationAddresses = new ArrayList<>();
        DestinationAddress destinationAddress = new DestinationAddress();
        destinationAddress.setRefererName(poForm.getShipto());
        destinationAddress.setAddress(poForm.getDestinationstreat());
        destinationAddress.setCity(poForm.getDestinationcity());
        destinationAddress.setState(poForm.getDestinationstate());
        destinationAddress.setCountry(poForm.getDestinationcountry());
        destinationAddress.setDeliveryStart(dateFormat.parse(poForm.getDeliverystart()));
        destinationAddress.setDeliveryEnd(dateFormat.parse(poForm.getDeliveryend()));
        destinationAddresses.add(destinationAddress);


        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setPoNumber(Integer.parseInt(poForm.getPonumber()));
        purchaseOrder.setStatus(poForm.getStatus());
        purchaseOrder.setPriority(poForm.getPriority());
        purchaseOrder.setIssueDate(dateFormat.parse(poForm.getPoissuedate()));
        purchaseOrder.setDueDate(dateFormat.parse(poForm.getDuedate()));
        purchaseOrder.setSeller_vendor(poForm.getSeller());
        purchaseOrder.setTransResp(poForm.getTransresp());
        purchaseOrder.setIncoTerms(poForm.getIncoterms());
        purchaseOrder.setBillTo(poForm.getBillto());
        purchaseOrder.setDesignatedMode(poForm.getDesignatedmode());
        purchaseOrder.setCarrier(poForm.getCarrier());
        purchaseOrder.setShipTogether(Boolean.parseBoolean(poForm.getShiptogether()));
        purchaseOrder.setOriginAddresses(originAddresses);
        purchaseOrder.setDestinationAddresses(destinationAddresses);
        System.out.println(purchaseOrder.toString());
        System.out.println("before calling createPurchaseOrder");
        poManage.createPurchaseOrder(purchaseOrder);
        List<PurchaseOrder> orderList = poManage.viewOrders();
        System.out.println("after calling createPurchaseOrder");

        request.setAttribute("orderList", orderList);
        return mapping.findForward("success");
    }
}