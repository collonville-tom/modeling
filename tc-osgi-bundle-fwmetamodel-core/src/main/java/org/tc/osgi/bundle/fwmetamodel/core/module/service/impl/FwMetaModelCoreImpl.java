package org.tc.osgi.bundle.fwmetamodel.core.module.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.module.service.IFwMetaModelCoreService;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaRelation;

public class FwMetaModelCoreImpl implements IFwMetaModelCoreService {

	private Map<String, IMetaModel> mmRepository = new HashMap<String, IMetaModel>();
	private Map<String, IMetaEntity> meRepository = new HashMap<String, IMetaEntity>();
	private Map<String, IMetaRelation> mrRepository = new HashMap<String, IMetaRelation>();
	private Map<String, IMetaAttribute> maRepository = new HashMap<String, IMetaAttribute>();

	public IMetaModel getMetaModel(String typeName) {
		if (mmRepository.containsKey(typeName)) {
			return mmRepository.get(typeName);
		}
		IMetaModel mm = new MetaModel(typeName);
		this.mmRepository.put(typeName, mm);
		return mm;
	}

	public IMetaEntity getMetaEntity(String typeName) {
		if (meRepository.containsKey(typeName)) {
			return meRepository.get(typeName);
		}
		IMetaEntity mm = new MetaEntity(typeName);
		this.meRepository.put(typeName, mm);
		return mm;
	}

	public IMetaRelation getMetaRelation(String typeName) {
		if (mrRepository.containsKey(typeName)) {
			return mrRepository.get(typeName);
		}
		IMetaRelation mm = new MetaRelation(typeName);
		this.mrRepository.put(typeName, mm);
		return mm;
	}

	public <T> IMetaAttribute getMetaAttribute(String typeName, T defaultValue) {
		if (maRepository.containsKey(typeName)) {
			return maRepository.get(typeName);
		}
		IMetaAttribute mm = new MetaAttribute<T>(typeName, defaultValue);
		this.maRepository.put(typeName, mm);
		return mm;
	}

}
