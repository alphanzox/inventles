package com.inventles.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.inventles.data.pojo.BusinessEntity;
import com.inventles.data.pojo.Item;

@Path("/item")
public class ItemFacadeREST extends AbstractREST<Item> {

  public ItemFacadeREST() {
		super(Item.class);
	}
  
  	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddItem(Item item) {
	  item.setBusinessEntity((BusinessEntity)getBusinessEntity());
	  super.upsert(item);
	  return "Success";
	}
} 
