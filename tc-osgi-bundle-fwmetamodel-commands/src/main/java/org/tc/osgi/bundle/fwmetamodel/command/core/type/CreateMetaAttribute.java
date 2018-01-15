package org.tc.osgi.bundle.fwmetamodel.command.core.type;

import org.tc.osgi.bundle.fwmetamodel.command.module.service.FwMetaModelCoreProxy;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;

/**
 * CreateMetaAttribute.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateMetaAttribute<T> extends AbstractTypeCreatingCommand<IType> {

	/**
	 * String value.
	 */
	private final T value;

	/**
	 * CreateMetaAttribute constructor.
	 * @param name String
	 * @param value String
	 */
	public CreateMetaAttribute(final String name, final T value) {

		super(name);
		this.value = value;

	}

	/**
	 *
	 * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
	 */
	@Override
	public void exec() throws CommandExecutionException {
		final IType meta = FwMetaModelCoreProxy.getInstance().getMetaAttribute(getName(), value);
		setType(meta);
	}

}
