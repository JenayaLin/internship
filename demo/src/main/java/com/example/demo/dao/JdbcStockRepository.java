package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Stock;

@Repository("JdbcStock")
public class JdbcStockRepository implements StockRepository{
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Stock stock) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "insert into stock (item, stockQuantity) values(?,?)",
                stock.getItem(), stock.getStockQuantity());
	}
	
	@Override
	public int updateStockQuantityByItemId(int newStockQuantity, String item) {
		return jdbcTemplate.update(
                "UPDATE stock SET stockQuantity = ? where item = ?", 
                newStockQuantity, item);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Stock findById(String sId) {
		// TODO Auto-generated method stub
		String innerID= sId;
		 return jdbcTemplate.queryForObject(
	                "select item, stockQuantity from stock where item = ?",
	                new Object[]{innerID},
	                new RowMapper<Stock>() {
						@Override
						public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Stock stock = new Stock();
							
							String item = rs.getString(1);
							int stockQuantity = rs.getInt(2);
							
							stock.setItem(item);
							stock.setStockQuantity(stockQuantity);
							
							return stock;
						}
	                	
	                }
	          
	                 
				);
	}


}
