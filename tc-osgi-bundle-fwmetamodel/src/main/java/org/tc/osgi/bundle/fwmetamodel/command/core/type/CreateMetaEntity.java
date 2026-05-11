package org.tc.osgi.bundle.fwmetamodel.command.core.type;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.fwmetamodel.module.service.FwMetaModelCoreProxy;

/**
 * CreateMetaEntity.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateMetaEntity extends AbstractTypeCreatingCommand<IMetaEntity> {

	/**
	 * CreateMetaEntity constructor.
	 * @param name String
	 */
	public CreateMetaEntity(final String name) {

		super(name);

	}

	/**
	 *
	 * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
	 */
	@Override
	public void exec() {
		final IMetaEntity meta = FwMetaModelCoreProxy.getInstance().getMetaEntity(getName());
		setType(meta);
	}

}
