package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.POManage;
import models.PurchaseOrder;

@WebServlet("/orderlist")
public class PurchaseOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseOrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view;
		POManage poManage = new POManage();
		List<PurchaseOrder> po = poManage.viewPurchaseOrder();
		Iterator<PurchaseOrder> iterator = po.iterator();
		while (iterator.hasNext()) {
			PurchaseOrder p1 = iterator.next();
		    System.out.println(p1.getPoNumber());
		    System.out.println(p1.getSellerVendor().getName());
		    System.out.println(p1.getDueDate());
		    System.out.println(p1.getStatus());
		    System.out.println(p1.getPriority());
		    System.out.println(p1.getAddressFrom().getRefererName());
		    System.out.println(p1.getAddressTo().getRefererName());
		    System.out.println(p1.getTransResp().getName());
		   
		}
		request.setAttribute("purchase", po);
		view = request.getRequestDispatcher("purchase_order_list.jsp");
		view.forward(request, response);
		
	}
}
