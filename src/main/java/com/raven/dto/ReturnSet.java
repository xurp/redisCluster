package com.raven.dto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.raven.entity.User;

public class ReturnSet {

	
	private int totals;
	
	
	private List<User> rows;
	
	public ReturnSet() {
		System.err.println("  method: Construct");	
	}

	@PostConstruct
	public void init() {
		System.err.println("  method:   PostConstruct");
	}
	
	@PreDestroy
	public void destory() {
		System.err.println("   method:  PreDestory");
	}

	public int getTotals() {
		return totals;
	}


	public void setTotals(int totals) {
		this.totals = totals;
	}


	public List<User> getRows() {
		return rows;
	}


	public void setRows(List<User> rows) {
		this.rows = rows;
	}

	
	
	
	
}
