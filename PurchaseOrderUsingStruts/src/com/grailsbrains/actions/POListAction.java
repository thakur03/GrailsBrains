package com.grailsbrains.actions;

import com.grailsbrains.connection.POManage;
import com.grailsbrains.forms.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ajeet on 4/28/2017.
 */
public class POListAction extends Action {
private static String SUCCESS="success";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PurchaseOrderForm poForm = (PurchaseOrderForm) form;

        POManage poManage = new POManage();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Byte shipTogether = (request.getParameter("shiptogether") == null
                || request.getParameter("shiptogether").equals("null")) ? (byte) 0 : (byte) 1;
        System.out.println("check: " + shipTogether);
        System.out.println("check: " + poForm.getPonumber() );

        String poNumber= poForm.getPonumber();
        String status = poForm.getStatus();
        String priority = poForm.getPriority();
        Integer seller = Integer.parseInt(poForm.getSeller());
        String billTo = poForm.getBillto();
        Integer carrier = Integer.parseInt(poForm.getCarrier());

        String shipFrom = poForm.getShipfrom();
        String shipTo = poForm.getShipto();
        String originAddress = poForm.getOriginstreet();
        String destinationAddress = poForm.getDestinationstreat();
        String originCity = poForm.getOrigincity();
        String destinationCity = poForm.getDestinationcity();

        //System.out.println("transresp : " + request.getParameter("transresp"));
        Integer transResp = Integer.parseInt(poForm.getTransresp());
        Integer incoTerms = Integer.parseInt(poForm.getIncoterms());
        Integer designatedMode = Integer.parseInt(poForm.getDesignatedmode());
        Integer originState = Integer.parseInt(poForm.getOriginstate());
        Integer destinationState = Integer.parseInt(poForm.getDestinationstate());
        Integer originCountry = Integer.parseInt(poForm.getOrigincountry());
        Integer destinationCountry = Integer.parseInt(poForm.getDestinationcountry());
        Date issueDate = null;
        Date dueDate = null;
        Date pickupStart = null;
        Date deliveryStart = null;
        Date pickupEnd = null;
        Date deliveryEnd = null;


            issueDate = dateFormat.parse(poForm.getPoissuedate());
            System.out.println(" inside try" + dateFormat.parse(poForm.getPoissuedate()));
            dueDate = dateFormat.parse(poForm.getDuedate());
            pickupStart = dateFormat.parse(poForm.getPickupstart());
            pickupEnd = dateFormat.parse(poForm.getPickupend());
            deliveryStart = dateFormat.parse(poForm.getDeliverystart());

            deliveryEnd = dateFormat.parse(poForm.getDeliveryend());
            System.out.println("end date " + deliveryEnd);
            System.out.print("po number :" + poNumber);

        if (poNumber == null) {
            return   mapping.findForward("fail");
        } else {

            State originStateObj = new State();
            originStateObj.setId(originState);

            State destinationStateObj = new State();
            destinationStateObj.setId(destinationState);

            Country originCountryObj = new Country();
            originCountryObj.setId(originCountry);

            Country destinationCountryObj = new Country();
            destinationCountryObj.setId(destinationCountry);

            Carrier carrierObj = new Carrier();
            carrierObj.setId(carrier);

            DesignatedMode mode = new DesignatedMode();
            mode.setId(designatedMode);

            Incoterms incotermsObj = new Incoterms();
            incotermsObj.setId(incoTerms);

            SellerVendor sellerVendorObj = new SellerVendor();
            sellerVendorObj.setId(seller);

            TransResp transRespObj = new TransResp();
            transRespObj.setId(transResp);

            Address originAddressObj = new Address();
            originAddressObj.setRefererName(shipFrom);
            originAddressObj.setAddress(originAddress);
            originAddressObj.setCity(originCity);
            originAddressObj.setState(originStateObj);
            originAddressObj.setCountry(originCountryObj);
            originAddressObj.setStartDate(pickupStart);
            originAddressObj.setEndDate(pickupEnd);

            Address destinationAddressObj = new Address();
            destinationAddressObj.setRefererName(shipTo);
            destinationAddressObj.setAddress(destinationAddress);
            destinationAddressObj.setCity(destinationCity);
            destinationAddressObj.setState(destinationStateObj);
            destinationAddressObj.setCountry(destinationCountryObj);
            destinationAddressObj.setStartDate(deliveryStart);
            destinationAddressObj.setEndDate(deliveryEnd);

            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setPoNumber(poNumber);
            purchaseOrder.setStatus(status);
            purchaseOrder.setPriority(priority);
            purchaseOrder.setIssueDate(issueDate);
            purchaseOrder.setDueDate(dueDate);
            purchaseOrder.setBillTo(billTo);
            purchaseOrder.setToShipTogether(shipTogether);
            purchaseOrder.setAddressFrom(originAddressObj);
            purchaseOrder.setAddressTo(destinationAddressObj);
            purchaseOrder.setSellerVendor(sellerVendorObj);
            purchaseOrder.setTransResp(transRespObj);
            purchaseOrder.setIncoterms(incotermsObj);
            purchaseOrder.setDesignatedMode(mode);
            purchaseOrder.setCarrier(carrierObj);

            System.out.println("********"+purchaseOrder.toString());
            poManage.createPurchaseOrder(purchaseOrder);
            System.out.print("order is created");
            
            List<PurchaseOrderForm> orderList = poManage.viewPurchaseOrder();
            System.out.println("view order");


            request.setAttribute("orderList", orderList);
            System.out.println("session created");

            return  mapping.findForward(SUCCESS);


        }

    }
}
