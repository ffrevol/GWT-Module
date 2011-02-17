package com.ffrevol.gui.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface ProvisioningServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ffrevol.gui.client.ProvisioningService
     */
    void getProvisioning( AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ffrevol.gui.client.ProvisioningService
     */
    void saveProvisioning( java.lang.String data, AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ProvisioningServiceAsync instance;

        public static final ProvisioningServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ProvisioningServiceAsync) GWT.create( ProvisioningService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "provisioning" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
