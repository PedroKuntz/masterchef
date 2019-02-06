package com.ello.masterchef;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.model.CatalogItemType;
import com.ello.masterchef.catalog.model.Channel;
import com.ello.masterchef.catalog.model.SalesPrice;
import com.ello.masterchef.catalog.model.SalesRules;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterchefApplicationTests {


	private SalesPrice buildSalesPrice() {
		SalesRules salesRules = new SalesRules();
		salesRules.setRuleId(UUID.randomUUID());
		salesRules.setDateValidation("SEG");

		SalesPrice salesPrice = new SalesPrice();
		salesPrice.setSalesPriceId(UUID.randomUUID());
		salesPrice.setChannel(Channel.FREE);
		salesPrice.setSalesRules(salesRules);
		salesPrice.setPrice(64.9);

		return salesPrice;

	}

	@Test
	public void contextLoads() {

		CatalogItem catalogItem = new CatalogItem();
		catalogItem.setCatalogItemId(UUID.randomUUID());
		catalogItem.setItemId(1L);
		catalogItem.setAmount(1);
		catalogItem.setCatalogItemType(CatalogItemType.FREE); //RODIZIO
		catalogItem.setDescription("Rodizio Japonês Completo - Seg-Quinta");
		catalogItem.setNameItem("Rodizio Japanese Food");
		catalogItem.setSalesPrice(Arrays.asList(buildSalesPrice()));






	}

}

