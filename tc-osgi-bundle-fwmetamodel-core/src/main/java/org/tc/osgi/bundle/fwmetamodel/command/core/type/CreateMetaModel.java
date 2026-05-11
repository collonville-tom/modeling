package org.tc.osgi.bundle.fwmetamodel.command.core.type;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.fwmetamodel.module.service.FwMetaModelCoreProxy;

/**
 * CreateMetaModel.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateMetaModel extends AbstractTypeCreatingCommand {

	/**
	 * CreateMetaModel constructor.
	 * @param name String
	 */
	public CreateMetaModel(final String name) {
		super(name);
	}

	/**
	 *
	 * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
	 */
	@Override
	public void exec() {
		final IType meta = FwMetaModelCoreProxy.getInstance().getMetaModel(getName());
		setType(meta);
	}

}
