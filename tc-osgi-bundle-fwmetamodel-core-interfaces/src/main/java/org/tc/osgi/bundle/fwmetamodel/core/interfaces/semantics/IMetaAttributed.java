package org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

public interface IMetaAttributed<T extends IType> {

	public void addMetaAttribute(final T meta);

}
