package com.infinite.kpopMerch.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.Orders;

public interface OrderDetailsService {
	public String saveOrderDetails(Orders order) throws JsonProcessingException;

	public String findOrderId(String userId, String albumId);

	public List<String> findMaxCountAlbums();
}
