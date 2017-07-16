package org.mule.modules.marta;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

public class MARTAConnectorTest {
	MARTAConnector mARTAConnector= new MARTAConnector();
	
	

	
	@Test
	public void testGetAllBus() {
		Assert.assertNotNull(mARTAConnector.getAllBus());
		//System.out.println(mARTAConnector.getAllBus());
	}

	@Test
	public void testGetBusByRoute() {
		Assert.assertNotNull(mARTAConnector.getBusByRoute("8"));
		//System.out.println(mARTAConnector.getBusByRoute("8"));
	}

	@Test
	public void testGetRealtimeArrivals() {
		Assert.assertNotNull(mARTAConnector.getRealtimeArrivals());
		//mARTAConnector.getRealtimeArrivals();
	}

}
