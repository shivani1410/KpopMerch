package com.infinite.kpopMerch.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infinite.kpopMerch.Models.Orders;

@Repository
public interface OrdersRepo extends CrudRepository<Orders, String> {
	Orders save(Orders order);

	@Query(value = "select order_id from orders where userid=:userId and album_id=:albumId", nativeQuery = true)
	public String findorderIdUsingNativeQuery(@Param("userId") String userId, @Param("albumId") String albumId);

	@Query(value = "SELECT album_id,COUNT(album_id) FROM orders GROUP BY album_id ORDER BY COUNT(album_id) DESC LIMIT 5", nativeQuery = true)
	public List<String> findMaxALbumsUsingNativeQuery();

}
