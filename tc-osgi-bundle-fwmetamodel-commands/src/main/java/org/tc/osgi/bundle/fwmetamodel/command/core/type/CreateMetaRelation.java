package org.tc.osgi.bundle.fwmetamodel.command.core.type;

import org.tc.osgi.bundle.fwmetamodel.command.module.service.FwMetaModelCoreProxy;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

/**
 * CreateMetaRelation.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateMetaRelation extends AbstractTypeCreatingCommand {

	/**
	 * CreateMetaRelation constructor.
	 * @param name String
	 */
	public CreateMetaRelation(final String name) {

		super(name);

	}

	/**
	 *
	 * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
	 */
	@Override
	public void exec() {
		final IType meta = FwMetaModelCoreProxy.getInstance().getMetaRelation(getName());
		setType(meta);

	}

}
