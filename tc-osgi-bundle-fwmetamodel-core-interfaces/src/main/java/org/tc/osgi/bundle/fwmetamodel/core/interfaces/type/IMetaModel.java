package org.tc.osgi.bundle.fwmetamodel.core.interfaces.type;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaEntited;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaRelated;

public interface IMetaModel<T extends IType, NT extends IType, NNT extends IType> extends IType, IMetaAttributed<T>, IMetaEntited<NT>, IMetaRelated<NNT> {

}
