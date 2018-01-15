package org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

public interface IMetaRelated<T extends IType> {

	public void addMetaRelation(final T meta);

}
