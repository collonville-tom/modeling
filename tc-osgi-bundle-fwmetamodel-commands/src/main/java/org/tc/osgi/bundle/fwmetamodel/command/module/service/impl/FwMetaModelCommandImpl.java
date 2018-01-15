package org.tc.osgi.bundle.fwmetamodel.command.module.service.impl;

import org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaEntityConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaModelConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaRelationConfig;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.command.interfaces.module.service.IFwMetaModelCommandService;

public class FwMetaModelCommandImpl implements IFwMetaModelCommandService {

	public void createMetaModel(String mm) {
		new CreateMetaModel(mm);
	}

	public void createMetaRelation(String mm) {
		new CreateMetaRelation(mm);
	}

	public void createMetaEntity(String mm) {
		new CreateMetaEntity(mm);
	}

	public <T> void createMetaAttribute(String mm, T defaultValue) {
		new CreateMetaAttribute<T>(mm, defaultValue);
	}

	public void configMetaModel(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaModelConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
	}

	public void configMetaEntity(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaEntityConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
	}

	public void configMetaRelation(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaRelationConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
	}

}
