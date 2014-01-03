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
		System.out.println("Post Called json"+item);
		BusinessEntity be = new BusinessEntity();
		be.setEntityCode("mk");
		item.setBusinessEntity(be);
		super.create(item);
		return "Success";
		//return convertToJSON(super.findAll());
	}
} 
