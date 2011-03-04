package com.ffrevol.gui.client.activity;

import java.util.List;
import java.util.logging.Logger;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.model.Service;
import com.ffrevol.gui.client.model.ServiceType;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.EditService;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.ffrevol.gui.client.ui.ServiceTable;
import com.ffrevol.gui.tools.Function;
import com.ffrevol.gui.tools.Lists;
import com.ffrevol.gui.tools.ServiceToNameFunction;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Panel;

public class ProvisioningActivity extends ServiceBaseActivity implements
		ProvisioningView.Presenter {
	private Logger logger = Logger.getLogger(ProvisioningActivity.class
			.getName());

	public ProvisioningActivity(ServiceBasePlace place,
			ClientFactory clientFactory) {
		super(place, clientFactory);
	}

	@Override
	public void load() {
		AsyncCallback<String> callback = new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				logger.severe("provisioning get succeed");
				getClientFactory().getProvisioningView()
						.setProvisioning(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				logger.severe("provisioning get failed");
				getClientFactory().getProvisioningView().setProvisioning(
						caught.getLocalizedMessage());

			}
		};
		getClientFactory().getProvisioningService().getProvisioning(callback);
	}

	@Override
	public void save(String data) {
		AsyncCallback<String> callback = new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				logger.severe("provisioning set succeed");
			}

			@Override
			public void onFailure(Throwable caught) {
				logger.severe("provisioning set failed");
			}
		};
		getClientFactory().getProvisioningService().saveProvisioning(data,
				callback);

	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		ProvisioningView provView = getClientFactory().getProvisioningView();
		serviceType(getName());
		provView.setPresenter(this);
		containerWidget.setWidget(provView.asWidget());

	}

	@Override
	public void serviceType(String name) {
		getClientFactory().getProvisioningView().setContext(name);
		ServiceType serviceType = getClientFactory().getProvisioningModel()
				.getServiceType(name);
		List<Service> listService = serviceType.getService();
		setServiceList(listService);
		setGrid(listService);
		setEdit(listService);
	}

	private void setEdit(List<Service> listService) {
		Service first = listService.get(0);
		Panel edit = new EditService(first);
		getClientFactory().getProvisioningView().setEditPanel(edit );
	}

	private void setGrid(List<Service> listService) {
		ServiceTable table = new ServiceTable(listService);		
		getClientFactory().getProvisioningView().setGrid(table);
	}

	private void setServiceList(List<Service> listService) {
		Function<Service, String> serviceToName = new ServiceToNameFunction();
		getClientFactory().getProvisioningView().setServiceList(
				Lists.transform(listService, serviceToName));
	}
}
