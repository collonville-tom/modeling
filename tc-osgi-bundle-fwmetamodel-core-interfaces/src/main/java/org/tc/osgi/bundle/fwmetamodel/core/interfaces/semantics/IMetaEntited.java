package org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

public interface IMetaEntited<T extends IType> {

	public void addMetaEntity(final T meta);
}
