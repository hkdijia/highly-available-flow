package com.gotkx.priceserver.mapper;


import com.gotkx.priceserver.model.ProductPrice;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductPriceMapper {
	
	@Insert("INSERT INTO product_price(value,product_id) VALUES(#{value},#{productId})")
	public void add(ProductPrice productPrice);
	
	@Update("UPDATE product_price SET value=#{value},product_id=#{productId} WHERE id=#{id}")
	public void update(ProductPrice productPrice);
	
	@Delete("DELETE FROM product_price WHERE id=#{id}")
	public void delete(Long id);
	
	@Select("SELECT * FROM product_price WHERE id=#{id}")
	public ProductPrice findById(Long id);
	
}
