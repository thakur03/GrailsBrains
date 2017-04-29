package com.grailsbrains.connection;

import com.grailsbrains.forms.*;

import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajeet on 4/28/2017.
 */
public class POManage {


        private Connection con;
        private PreparedStatement pst;

        public int createPurchaseOrder(PurchaseOrder purchaseOrder) {

            try {

                con = ConnectionManage.getConnection();
                System.out.println("Preparing Statement for ship from");
                pst = (PreparedStatement) con.prepareStatement(
                        "insert into address(id, referer_name, address, city, state_id,"
                                + " country_id, start_date, end_date) values (null, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

                Address shipFrom = purchaseOrder.getAddressFrom();

                pst.setString(1, shipFrom.getRefererName());
                pst.setString(2, shipFrom.getAddress());
                pst.setString(3, shipFrom.getCity());
                pst.setInt(4, shipFrom.getState().getId());
                pst.setInt(5, shipFrom.getCountry().getId());
                System.out.println("(shipFrom.getStartDate()" + shipFrom.getStartDate());
                System.out.println("(shipFrom.getEndDate()" + shipFrom.getEndDate());

                pst.setDate(6, new java.sql.Date(shipFrom.getStartDate().getTime()));
                pst.setDate(7, new java.sql.Date(shipFrom.getEndDate().getTime()));

                System.out.println("Executing Statement ship from");
                pst.executeUpdate();
                System.out.println("Getting Generated Keys of ship from");
                ResultSet resultSet = pst.getGeneratedKeys();
                resultSet.next();
                int shipFromAddressId = resultSet.getInt(1);

                System.out.println("Preparing Statement for ship from");
                pst = (PreparedStatement) con.prepareStatement(
                        "insert into address (id, referer_name, address, city, state_id, country_id,"
                                + " start_date, end_date ) values (null, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

                Address shipTo = purchaseOrder.getAddressTo();
                pst.setString(1, shipTo.getRefererName());
                pst.setString(2, shipTo.getAddress());
                pst.setString(3, shipTo.getCity());
                pst.setInt(4, shipTo.getState().getId());
                pst.setInt(5, shipTo.getCountry().getId());
                pst.setDate(6, new java.sql.Date(shipTo.getStartDate().getTime()));
                pst.setDate(7, new java.sql.Date(shipTo.getEndDate().getTime()));

                System.out.println("Executing Statement ship to");
                pst.executeUpdate();
                System.out.println("Getting Generated Keys of ship to");
                resultSet = pst.getGeneratedKeys();
                resultSet.next();
                int shipToAddressId = resultSet.getInt(1);

                System.out.println("Preparing Statement for purchase order");
                pst = (PreparedStatement) con.prepareStatement(
                        "insert into po_details(id, po_number, status, priority, issue_date, due_date,"
                                + " seller_vendor_id, address_from, address_to, bill_to, trans_resp_id, incoterms_id, to_ship_together,"
                                + " designated_mode_id, carrier_id ) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                System.out.println(pst);
                System.out.println(purchaseOrder.getStatus());
                System.out.println("purchase order issue date" + purchaseOrder.getIssueDate().getTime());
                System.out.println("purchase order seller " + purchaseOrder.getSellerVendor().getName());

                pst.setString(1, purchaseOrder.getPoNumber());
                pst.setString(2, purchaseOrder.getStatus());
                pst.setString(3, purchaseOrder.getPriority());
                pst.setDate(4, new java.sql.Date(purchaseOrder.getIssueDate().getTime()));
                pst.setDate(5, new java.sql.Date(purchaseOrder.getDueDate().getTime()));
                System.out.println(new java.sql.Date(purchaseOrder.getDueDate().getTime()));

                pst.setInt(6, purchaseOrder.getSellerVendor().getId());
                pst.setInt(7, shipFromAddressId);
                pst.setInt(8, shipToAddressId);
                pst.setString(9, purchaseOrder.getBillTo());
                pst.setInt(10, purchaseOrder.getTransResp().getId());
                pst.setInt(11, purchaseOrder.getIncoterms().getId());
                pst.setByte(12, purchaseOrder.getToShipTogether());
                pst.setInt(13, purchaseOrder.getDesignatedMode().getId());
                pst.setInt(14, purchaseOrder.getCarrier().getId());

                System.out.println("address id ship from " + shipFromAddressId + "address id ship to :" + shipToAddressId);

                System.out.println("Executing Statement purchase order");
                int inserted = pst.executeUpdate();
                System.out.println(inserted + " rows updated");

                return inserted;

            } catch (Exception e) {
                System.err.println("Following exception occurred while performing INSERT operations : " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Exception Occurred While Closing Connection.");
                    e.printStackTrace();
                }
            }
            return 0;
        }

        public List<PurchaseOrderForm> viewPurchaseOrder() {
            List<PurchaseOrderForm> poList = new ArrayList<PurchaseOrderForm>();
            ResultSet rs = null;
            try {
                con = ConnectionManage.getConnection();
                pst = con.prepareStatement("select po.po_number, sv.name, po.due_date, po.status, po.priority, af.referer_name, "
                        + "at.referer_name, t.name from purchase_order.po_details po "
                        + "join seller_vendor sv on po.seller_vendor_id = sv.id "
                        + "join address af on po.address_from = af.id "
                        + "join address at on po.address_to = at.id "
                        + "join trans_resp t on po.trans_resp_id = t.id;");
                rs = pst.executeQuery();
                System.out.println("result ser ; "+ rs.toString());
                while (rs.next()) {
                    PurchaseOrderForm purchaseOrderForm = new PurchaseOrderForm();
                    purchaseOrderForm.setPonumber(rs.getString("po_number"));
                    purchaseOrderForm.setDuedate(rs.getString("due_date"));

                    purchaseOrderForm.setStatus(rs.getString("status"));
                    purchaseOrderForm.setPriority(rs.getString("priority"));

                    SellerVendor sellerVendor = new SellerVendor();
                    sellerVendor.setName(rs.getString("name"));

                    Address shipFrom = new Address();
                    Address shipTo = new Address();
                    shipFrom.setRefererName(rs.getString("referer_name"));
                    shipTo.setRefererName(rs.getString("referer_name"));

                    TransResp transResp = new TransResp();
                    transResp.setName(rs.getString("name"));

                    purchaseOrderForm.setSeller(sellerVendor.getName());
                    purchaseOrderForm.setTransresp(transResp.getName());
                    purchaseOrderForm.setShipto(shipFrom.getRefererName());
                    purchaseOrderForm.setShipto(shipTo.getRefererName());

                    poList.add(purchaseOrderForm);
                    System.out.println("view purchase order");
                }

                return poList;
            } catch (Exception e) {
                System.err.println("Following exception occurred while performing SELECT operations : " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Exception Occurred While Closing Connection.");
                    e.printStackTrace();
                }
            }

            return poList;
        }


    }

