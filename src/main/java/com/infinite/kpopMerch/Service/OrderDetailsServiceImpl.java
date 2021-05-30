package com.infinite.kpopMerch.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinite.kpopMerch.Models.Orders;
import com.infinite.kpopMerch.Repository.OrdersRepo;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	OrdersRepo ordersRepo;

	@Override
	public String saveOrderDetails(Orders order) throws JsonProcessingException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		String output = "";
		try {
			Orders newOrder = new Orders();
			newOrder.setOrderId("0");
			newOrder.setCustomerName(order.getCustomerName());
			newOrder.setCustomerPhone(order.getCustomerPhone());
			newOrder.setCustomerPin(order.getCustomerPin());
			newOrder.setCutomerCity(order.getCutomerCity());
			newOrder.setCustomerAddType(order.getCustomerAddType());
			newOrder.setCustomerAddress(order.getCustomerAddress());
			newOrder.setCustomerState(order.getCustomerState());
			newOrder.setOrderDate(currentDate);
			newOrder.setUserId(order.getUserId());
			newOrder.setAlbumId(order.getAlbumId());
			Orders result = ordersRepo.save(newOrder);
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = "";
			jsonString = mapper.writeValueAsString(result);
			if (jsonString.equals("null")) {
				output = "Couldn't Place The Order";
			} else {
				output = "Order Placed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public String findOrderId(String userId, String albumId) {
		String orderID = ordersRepo.findorderIdUsingNativeQuery(userId, albumId);
		return orderID;
	}

	@Override
	public List<String> findMaxCountAlbums() {
		List<String> albumCount = ordersRepo.findMaxALbumsUsingNativeQuery();
		return albumCount;
	}

}
