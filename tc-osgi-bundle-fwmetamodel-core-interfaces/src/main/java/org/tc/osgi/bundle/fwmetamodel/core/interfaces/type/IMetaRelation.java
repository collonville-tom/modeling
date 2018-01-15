package org.tc.osgi.bundle.fwmetamodel.core.interfaces.type;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaEntited;

public interface IMetaRelation<T extends IType, NT extends IType> extends IType, IMetaAttributed<T>, IMetaEntited<NT> {

}
