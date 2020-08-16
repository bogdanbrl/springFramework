/*	
 *  created by bogdan brl
 */
package com.bogdan.springdemo.domain.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bogdan.springdemo.domain.product.ConsumerProduct;
import com.bogdan.springdemo.domain.product.IndustrialProduct;


@Component("myfair")
public class TradeFair {
	private IndustrialProduct industrialProduct;
	private ConsumerProduct consumerProduct;
	
	
	
	
	@Autowired
public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
		this.industrialProduct = industrialProduct;
		this.consumerProduct = consumerProduct;
	}

//	@Autowired
//	public void setIndustrialProduct(IndustrialProduct industrialProduct) {
//		this.industrialProduct = industrialProduct;
//	}
//	@Autowired
//	public void setConsumerProduct(ConsumerProduct consumerProduct) {
//		this.consumerProduct = consumerProduct;
//	}

	public int declareIndustrialProductPrize(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}
	
	public int declareconsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}
	
	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product is priced at $ "+declareIndustrialProductPrize(industrialProduct)+" and " +
						   "Consumer Product is priced at $ "+declareconsumerProductPrice(consumerProduct);
		return priceInfo;
	}
}
