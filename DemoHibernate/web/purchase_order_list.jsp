<jsp:include page="header.jsp"/>
<%@ page import="java.util.List" %>


<%--<%@ page import="com.grailsbrains.action.POListAction"%>--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.grailsbrains.forms.PurchaseOrderForm" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.grailsbrains.persistence.PurchaseOrder" %>

<div class="container-fluid">
		<div class="row bg-grey">
			<div class="para">
				<p>PURCHASE ORDER LIST</p>
			</div>
		</div>
		<div >
			<table class="nav nav-pills nav-justified table-condensed table-striped">
				<tr class="textcolour" style="background-color:#0080ff;">
					<td><input type="checkbox" name="selectall" id="selectall" ></td>
					<td>P.O. Number</td>
					<td>Supplier</td>
					<td>Due Date</td>
					<td>P.O. Status</td>
					<td>Priority</td>
					<td>Items(s)</td>
					<td>Ship From</td>
					<td>Ship To</td>
					<td>Trans. Resp.</td>
				</tr>
			
				<%

					ArrayList arrList = (ArrayList) request.getAttribute("orderList");
					List<PurchaseOrder> p1 = arrList.get;
					if(arrList!=null){

						for(int i=0 ; i<arrList.size();i++){
							PurchaseOrder purchaseOrderForm = (PurchaseOrder) arrList.get(i);

					%>
				<tr>
					<td><input type="checkbox" class="checkbox" name="check[]" ></td>
					<td><%= purchaseOrderForm.getPoNumber() %></td>
					<td><%= purchaseOrderForm.getSeller_vendor() %></td>
					<td><%= purchaseOrderForm.getDueDate() %></td>
					<td><%= purchaseOrderForm.getStatus() %></td>
					<td><%= purchaseOrderForm.getPriority() %></td>
					<td></td>
					<td><%= purchaseOrderForm.getOriginAddresses()%></td>
					<td><%= purchaseOrderForm.getDestinationAddresses()%></td>
					<td><%= purchaseOrderForm.getTransResp()%></td>
				</tr>
				<% }
				}%>
			</table>
		</div>
		<br><br>
		<div class="row" style="text-align: left;">
				<div class="col-lg-offset-7 col-md-offset-7 col-sm-offset-6 col-xs-offset-4 col-lg-1 col-md-1 col-sm-2 col-xs-3">
					
						<div class="col-md-6 ">
							<button class="btn btn-primary" name="edit" id="edit">Edit</button>
						</div>
					
				</div>
				<div class="col-lg-1 col-md-1 col-sm-2 col-xs-3">
					
						<div class="col-md-6 ">
							<button class="btn btn-primary" name="delete" id="delete">Delete</button>
						</div>
					
				</div>	
			</div>
	
	</div>
	<script  type="text/javascript">
	var select_all = document.getElementById("select_all"); //select all checkbox
	var checkboxes = document.getElementsByClassName("checkbox"); //checkbox items

	//select all checkboxes
	select_all.addEventListener("change", function(e){
	    for (i = 0; i < checkboxes.length; i++) { 
	        checkboxes[i].checked = select_all.checked;
	    }
	});


	for (var i = 0; i < checkboxes.length; i++) {
	    checkboxes[i].addEventListener('change', function(e){ //".checkbox" change 
	        //uncheck "select all", if one of the listed checkbox item is unchecked
	        if(this.checked == false){
	            select_all.checked = false;
	        }
	        //check "select all" if all checkbox items are checked
	        if(document.querySelectorAll('.checkbox:checked').length == checkboxes.length){
	            select_all.checked = true;
	        }
	    });
	}
	</script>
</body>
</html>