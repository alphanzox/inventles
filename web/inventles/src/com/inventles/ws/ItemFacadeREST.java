package com.inventles.ws;

import javax.ws.rs.Path;

import com.inventles.data.pojo.Item;

@Path("/item")
public class ItemFacadeREST extends AbstractREST<Item> {

  public ItemFacadeREST() {
		super(Item.class);
	}
} 
