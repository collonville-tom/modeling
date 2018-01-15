package org.tc.osgi.bundle.fwmetamodel.command.core;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.INamed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;

/**
* CreatingCommand.java.
* @author thomas collonvillé
* @version 0.0.1
*/
public abstract class AbstractCreatingCommand<T extends IType> implements ICommand, INamed {

	/**
	 * String name.
	 */
	private String name;
	/**
	 * Type type.
	 */
	private T type;

	/**
	 * CreatingCommand constructor.
	 * @param name String
	 */
	public AbstractCreatingCommand(final String name) {
		setName(name);
	}

	/**
	 * getName.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * getType.
	 * @return Type
	 */
	public T getType() {
		return type;
	}

	/**
	 * setName.
	 * @param name String
	 */
	final public void setName(final String name) {
		this.name = name;
	}

	/**
	 * setType.
	 * @param type Type
	 */
	public void setType(final T type) {
		this.type = type;
	}
}
