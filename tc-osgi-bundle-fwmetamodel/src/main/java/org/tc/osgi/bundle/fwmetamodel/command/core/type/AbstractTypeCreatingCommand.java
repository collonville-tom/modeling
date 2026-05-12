package org.tc.osgi.bundle.fwmetamodel.command.core.type;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

/**
 * AbstractTypeCreatingCommand.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractTypeCreatingCommand<T extends IType> extends AbstractCommand<T> {

	/**
	 * AbstractTypeCreatingCommand constructor.
	 * @param name String
	 */
	public AbstractTypeCreatingCommand(final String name) {
		super(name);
	}

}
