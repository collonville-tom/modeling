package org.tc.osgi.bundle.fwmetamodel.core.interfaces.module.service;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

public interface IFwMetaModelCoreService {

	public IMetaModel getMetaModel(String typeName);

	public IMetaEntity getMetaEntity(String typeName);

	public IMetaRelation getMetaRelation(String typeName);

	public <T> IMetaAttribute getMetaAttribute(String typeName, T defaultValue);

}
