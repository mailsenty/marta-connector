
package org.mule.modules.marta.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.marta.MARTAConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>MARTAConnectorProcessAdapter</code> is a wrapper around {@link MARTAConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-07-15T06:33:40-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class MARTAConnectorProcessAdapter
    extends MARTAConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<MARTAConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, MARTAConnectorCapabilitiesAdapter> getProcessTemplate() {
        final MARTAConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,MARTAConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, MARTAConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, MARTAConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
