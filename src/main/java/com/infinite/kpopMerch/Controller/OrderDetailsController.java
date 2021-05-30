package com.infinite.kpopMerch.Controller;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.kpopMerch.Models.Orders;
import com.infinite.kpopMerch.Service.OrderDetailsService;
import com.infinite.kpopMerch.Utils.Config;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;

	@PostMapping(path = "/saveOrderDetails", consumes = "application/json", produces = "application/json")
	public String saveOrderDetails(InputStream inputStream) throws IOException {
		Config config = new Config();
		JSONObject obj = config.covertInputStream(inputStream);
		Orders orderDetails = new Orders();
		orderDetails.setCustomerName(obj.get("customerName").toString());
		orderDetails.setCustomerPhone(obj.get("customerPhone").toString());
		orderDetails.setCutomerCity(obj.get("cutomerCity").toString());
		orderDetails.setCustomerPin(obj.get("customerPin").toString());
		orderDetails.setCustomerAddress(obj.get("customerAddress").toString());
		orderDetails.setCustomerState(obj.get("customerState").toString());
		orderDetails.setCustomerAddType(obj.get("customerRadio").toString());
		orderDetails.setUserId(obj.get("userId").toString());
		orderDetails.setAlbumId(obj.get("albumId").toString());
		String output = orderDetailsService.saveOrderDetails(orderDetails);
		return output;
	}

	@PostMapping(path = "/orders", consumes = "application/json", produces = "application/json")
	public String findOrderID(InputStream inputStream) throws IOException, RazorpayException {
		JSONObject finalJSON = new JSONObject();

		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_58VLPUUblenqlA", "YBrd2FSyRifnrKIIzzQgnPHJ");
		JSONObject options = new JSONObject();
		options.put("amount", 165000);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order.get("id").toString());
//		Config config = new Config();
//		JSONObject obj = config.covertInputStream(inputStream);
//		String userID = obj.get("userId").toString();
//		String albumID = obj.get("albumId").toString();
//		String result = orderDetailsService.findOrderId(userID, albumID);

		finalJSON.put("id", order.get("id").toString());

		return finalJSON.toString();
	}

}
