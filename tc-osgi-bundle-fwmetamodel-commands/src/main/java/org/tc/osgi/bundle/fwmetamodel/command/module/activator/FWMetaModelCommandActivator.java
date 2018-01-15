package org.tc.osgi.bundle.fwmetamodel.command.module.activator;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.fwmetamodel.command.interfaces.module.service.IFwMetaModelCommandService;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.CommandRunnerUtilsProxy;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.FwMetaModelCoreProxy;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.impl.FwMetaModelCommandImpl;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.module.service.IFwMetaModelCoreService;
import org.tc.osgi.bundle.utils.interf.module.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.ICommandRunnerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.utils.AbstractTcOsgiActivator;
import org.tc.osgi.bundle.utils.interf.module.utils.TcOsgiProxy;

/**
 * Activator.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class FWMetaModelCommandActivator extends AbstractTcOsgiActivator {

	private TcOsgiProxy<ILoggerUtilsService> iLoggerUtilsService;
	private TcOsgiProxy<IFwMetaModelCoreService> iFwMetaModelCoreService;
	private TcOsgiProxy<ICommandRunnerUtilsService> iCommandRunnerUtilsService;

	@Override
	protected void checkInitBundleUtilsService(BundleContext context) throws TcOsgiException {
		throw new TcOsgiException("checkInitBundleUtilsService not implemented");

	}

	@Override
	protected void initProxys(BundleContext context) throws TcOsgiException {
		this.iLoggerUtilsService = new TcOsgiProxy<ILoggerUtilsService>(context, ILoggerUtilsService.class);
		LoggerServiceProxy.getInstance().setService(this.iLoggerUtilsService.getInstance());
		this.iFwMetaModelCoreService = new TcOsgiProxy<IFwMetaModelCoreService>(context, IFwMetaModelCoreService.class);
		FwMetaModelCoreProxy.getInstance().setService(this.iFwMetaModelCoreService.getInstance());
		this.iCommandRunnerUtilsService = new TcOsgiProxy<ICommandRunnerUtilsService>(context, ICommandRunnerUtilsService.class);
		CommandRunnerUtilsProxy.getInstance().setService(this.iCommandRunnerUtilsService.getInstance());

	}

	@Override
	protected void initServices(BundleContext context) throws TcOsgiException {

		this.getIBundleUtilsService().getInstance().registerService(IFwMetaModelCommandService.class, new FwMetaModelCommandImpl(), context, this);

	}

	@Override
	protected void detachProxys(BundleContext context) throws TcOsgiException {

		this.iFwMetaModelCoreService.close();
		this.iCommandRunnerUtilsService.close();
		this.iLoggerUtilsService.close();

	}

	@Override
	protected void detachServices(BundleContext context) throws TcOsgiException {
		this.getIBundleUtilsService().getInstance().unregister(IFwMetaModelCommandService.class, this);

	}

	@Override
	protected void beforeStart(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeStop(BundleContext context) throws TcOsgiException {

	}

	@Override
	protected void afterStart(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void afterStop(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

}
