package com.example.demo.dao;

import com.example.demo.model.Stock;

public interface StockRepository {
	
	int save(Stock stock);
	
	Stock findById(String sId);
	
	int updateStockQuantityByItemId(int newStockQuantity, String item);


}
