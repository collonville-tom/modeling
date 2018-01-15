package org.tc.osgi.bundle.fwmetamodel.command.module.service;

import org.tc.osgi.bundle.utils.interf.module.service.ICommandRunnerUtilsService;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommandRepository;

public class CommandRunnerUtilsProxy implements ICommandRunnerUtilsService {

	private static CommandRunnerUtilsProxy instance = null;

	/**
	 * getInstance.
	 * @return UtilsServiceProxy
	 */
	public static CommandRunnerUtilsProxy getInstance() {
		if (CommandRunnerUtilsProxy.instance == null) {
			CommandRunnerUtilsProxy.instance = new CommandRunnerUtilsProxy();
		}
		return CommandRunnerUtilsProxy.instance;
	}

	/**
	 * IUtilsService service.
	 */
	private ICommandRunnerUtilsService service = null;

	/**
	 * UtilsServiceProxy constructor.
	 */
	private CommandRunnerUtilsProxy() {

	}

	@Override
	public ICommandRepository getRepository() {
		return this.service.getRepository();
	}

	@Override
	public ICommand getRunner() {
		return this.service.getRunner();
	}

	public ICommandRunnerUtilsService getService() {
		return service;
	}

	public void setService(ICommandRunnerUtilsService service) {
		this.service = service;
	}

}
