
package org.mule.modules.marta.generated.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/marta</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-07-15T06:33:40-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class MartaNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(MartaNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [marta] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [marta] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new MARTAConnectorConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-bus", new GetAllBusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-bus", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-bus-by-route", new GetBusByRouteDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-bus-by-route", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-realtime-arrivals", new GetRealtimeArrivalsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-realtime-arrivals", "@Processor", ex);
        }
    }

}
