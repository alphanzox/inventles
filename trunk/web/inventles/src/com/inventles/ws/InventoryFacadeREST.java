package com.inventles.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.inventles.data.pojo.ItemTransaction;

@Path("/inventory")
public class InventoryFacadeREST extends AbstractREST<ItemTransaction> {

  public InventoryFacadeREST() {
		super(ItemTransaction.class);
	}
  
  	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddItem(ItemTransaction item) {
	  super.upsert(item);
	  return "Success";
	}
} 
