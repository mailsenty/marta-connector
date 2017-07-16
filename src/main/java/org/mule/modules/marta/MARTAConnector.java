package org.mule.modules.marta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.marta.config.ConnectorConfig;

@Connector(name="marta", friendlyName="MARTA")
public class MARTAConnector {

    @Config
    ConnectorConfig config;
    
	private final String APIKEY = "78d104cb-d7a5-41ad-88fd-717dfc338cd1";
	private final String GETALLTRAINS = "http://developer.itsmarta.com/RealtimeTrain/RestServiceNextTrain/GetRealtimeArrivals?apikey="+APIKEY;
	private final String GETALLBUS  = "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetAllBus";
	private final String GETBUSBYROUTE  = "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetBusByRoute/";
	
	private  URL GETALLTRAINS_URL;
	private  URL GETALLBUS_URL;
	private  URL GETBUSBYROUTE_URL  ;

	HttpURLConnection con ;
	
	

    

    @Processor
    public String getAllBus() {
        String response;
    	try {
			GETALLBUS_URL  = new URL(GETALLBUS);
			response=processConnection(GETALLBUS_URL);
		} catch (MalformedURLException e) {
			response="Error connecting to endpoint Please retry";
			e.printStackTrace();
		}
    	catch (Exception e) {
    		response="Error connecting to endpoint Please retry" ;  				
			e.printStackTrace();
		}
    	return response;
  

    }
    @Processor
    public String getBusByRoute(String route) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    		
			  String response;
		    	try {
		    		GETBUSBYROUTE_URL  = new URL(GETBUSBYROUTE+route);
					response=processConnection(GETBUSBYROUTE_URL);
				} catch (MalformedURLException e) {
					response="Error connecting to endpoint Please retry";
					e.printStackTrace();
				}
		    	catch (Exception e) {
		    		response="Error connecting to endpoint Please retry" ;  				
					e.printStackTrace();
				}
		    	return response;
    }
    
    
    
    @Processor
    public String getRealtimeArrivals() {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	
    		  String response;
    	    	try {
    	    		GETALLTRAINS_URL = new URL(GETALLTRAINS);
    				response=processConnection(GETALLTRAINS_URL);
    			} catch (MalformedURLException e) {
    				response="Error connecting to endpoint Please retry";
    				e.printStackTrace();
    			}
    	    	catch (Exception e) {
    	    		response="Error connecting to endpoint Please retry" ;  				
    				e.printStackTrace();
    			}
    	    	return response;
    }

    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
    private String processConnection(URL url){
    	
    	StringBuffer response = new StringBuffer();
    	
    	try {
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");

			// add request header
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}  catch (Exception e) {
			response=new StringBuffer("Error getting Yoda Speak");
			e.printStackTrace();
		}

		// print result
		return response.toString();
    }

}