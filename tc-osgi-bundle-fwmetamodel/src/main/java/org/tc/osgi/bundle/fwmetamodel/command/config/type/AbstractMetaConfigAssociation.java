package org.tc.osgi.bundle.fwmetamodel.command.config.type;

import org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.AbstractTypeCreatingCommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * AbstractInstanceCreatingCommand.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractMetaConfigAssociation<T extends AbstractTypeCreatingCommand> extends AbstractConfigAssociation {

	/**
	 * AbstractInstanceCreatingCommand constructor.
	 * @param name String
	 */
	public AbstractMetaConfigAssociation(final String name) {
		super(name);

	}

	/**
	 * findMetaCreatingCommand.
	 * @return T
	 * @throws ClassNotFoundException
	 */
	protected abstract T findMetaCreatingCommand() throws CommandNotFoundException;

}
