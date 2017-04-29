package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.POManage;
import models.Address;
import models.Carrier;
import models.Country;
import models.DesignatedMode;
import models.Incoterms;
import models.PurchaseOrder;
import models.SellerVendor;
import models.State;
import models.TransResp;

@WebServlet("/purchaseorder")
public class POServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		POManage poManage = new POManage();
		RequestDispatcher rd;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Byte shipTogether = (request.getParameter("shiptogether") == null
				|| request.getParameter("shiptogether").equals("null")) ? (byte) 0 : (byte) 1;
		System.out.println("check: " + shipTogether);
		
		String status = request.getParameter("status");
		String priority = request.getParameter("priority");
		Integer seller = Integer.parseInt(request.getParameter("seller"));
		String billTo = request.getParameter("billto");
		Integer carrier = Integer.parseInt(request.getParameter("carrier"));

		String shipFrom = request.getParameter("shipfrom");
		String shipTo = request.getParameter("shipto");
		String originAddress = request.getParameter("originstreet");
		String destinationAddress = request.getParameter("destinationstreat");
		String originCity = request.getParameter("origincity");
		String destinationCity = request.getParameter("destinationcity");
		String poNumber = request.getParameter("ponumber");
		System.out.println("transresp : " + request.getParameter("transresp"));
		Integer transResp = Integer.parseInt(request.getParameter("transresp"));
		Integer incoTerms = Integer.parseInt(request.getParameter("incoterms"));
		Integer designatedMode = Integer.parseInt(request.getParameter("designatedmode"));
		Integer originState = Integer.parseInt(request.getParameter("originstate"));
		Integer destinationState = Integer.parseInt(request.getParameter("destinationstate"));
		Integer originCountry = Integer.parseInt(request.getParameter("origincountry"));
		Integer destinationCountry = Integer.parseInt(request.getParameter("destinationcountry"));
		Date issueDate = null;
		Date dueDate = null;
		Date pickupStart = null;
		Date deliveryStart = null;
		Date pickupEnd = null;
		Date deliveryEnd = null;

		try {
			issueDate = dateFormat.parse(request.getParameter("poissuedate"));
			System.out.println(" inside try" + request.getParameter("duedate"));
			dueDate = dateFormat.parse(request.getParameter("duedate"));
			pickupStart = dateFormat.parse(request.getParameter("pickupstart"));
			pickupEnd = dateFormat.parse(request.getParameter("pickupend"));
			deliveryStart = dateFormat.parse(request.getParameter("deliverystart"));
			System.out.println("From servlet" + request.getParameter("deliveryend"));
			deliveryEnd = dateFormat.parse(request.getParameter("deliveryend"));
			System.out.println("end date " + deliveryEnd);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dueDate == null) {
			rd = request.getRequestDispatcher("purshase_order.jsp");
			rd.include(request, response);
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
			originAddressObj.setAddress(originAddress);
			originAddressObj.setCity(originCity);
			originAddressObj.setState(originStateObj);
			originAddressObj.setCountry(originCountryObj);
			originAddressObj.setRefererName(shipFrom);
			originAddressObj.setStartDate(pickupStart);
			originAddressObj.setEndDate(pickupEnd);

			Address destinationAddressObj = new Address();
			destinationAddressObj.setAddress(destinationAddress);
			destinationAddressObj.setCity(destinationCity);
			destinationAddressObj.setState(destinationStateObj);
			destinationAddressObj.setCountry(destinationCountryObj);
			destinationAddressObj.setRefererName(shipTo);
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

			poManage.createPurchaseOrder(purchaseOrder);
			
			rd = request.getRequestDispatcher("orderlist");
			rd.forward(request, response);
		}
	}
}
