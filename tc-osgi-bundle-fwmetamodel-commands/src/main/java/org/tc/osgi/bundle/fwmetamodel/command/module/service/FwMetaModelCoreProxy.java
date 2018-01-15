package org.tc.osgi.bundle.fwmetamodel.command.module.service;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.module.service.IFwMetaModelCoreService;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

public class FwMetaModelCoreProxy implements IFwMetaModelCoreService {

	/**
	 * UtilsServiceProxy instance.
	 */
	private static FwMetaModelCoreProxy instance = null;

	/**
	 * getInstance.
	 * @return UtilsServiceProxy
	 */
	public static FwMetaModelCoreProxy getInstance() {
		if (FwMetaModelCoreProxy.instance == null) {
			FwMetaModelCoreProxy.instance = new FwMetaModelCoreProxy();
		}
		return FwMetaModelCoreProxy.instance;
	}

	/**
	 * IUtilsService service.
	 */
	private IFwMetaModelCoreService service = null;

	/**
	 * UtilsServiceProxy constructor.
	 */
	private FwMetaModelCoreProxy() {

	}

	public IFwMetaModelCoreService getService() {
		return service;
	}

	public void setService(IFwMetaModelCoreService service) {
		this.service = service;
	}

	@Override
	public IMetaModel getMetaModel(String typeName) {
		return this.service.getMetaModel(typeName);
	}

	@Override
	public IMetaEntity getMetaEntity(String typeName) {
		return this.service.getMetaEntity(typeName);
	}

	@Override
	public IMetaRelation getMetaRelation(String typeName) {
		return this.service.getMetaRelation(typeName);
	}

	@Override
	public <T> IMetaAttribute getMetaAttribute(String typeName, T defaultValue) {
		return this.service.getMetaAttribute(typeName, defaultValue);
	}

}
