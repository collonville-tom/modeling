package org.tc.osgi.bundle.fwmetamodel.command.config.instance;

import org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.AbstractInstanceCreatingCommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * AbstractInstanceCreatingCommand.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractInstanceConfigAssociation<T extends AbstractInstanceCreatingCommand> extends AbstractConfigAssociation {

	/**
	 * AbstractInstanceCreatingCommand constructor.
	 * @param name String
	 */
	public AbstractInstanceConfigAssociation(final String name) {
		super(name);

	}

	/**
	 * findMetaCreatingCommand.
	 * @return T
	 * @throws ClassNotFoundException
	 */
	protected abstract T findInstanceCreatingCommand() throws CommandNotFoundException;

}
