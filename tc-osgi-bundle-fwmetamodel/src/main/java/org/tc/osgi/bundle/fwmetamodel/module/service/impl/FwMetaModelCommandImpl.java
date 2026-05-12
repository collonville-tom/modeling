package org.tc.osgi.bundle.fwmetamodel.module.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaEntityConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaModelConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaRelationConfig;
import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.command.interfaces.module.service.IFwMetaModelCommandService;

public class FwMetaModelCommandImpl implements IFwMetaModelCommandService {

	private Map<String, AbstractCommand> cmdRepository = new HashMap<String, AbstractCommand>();
	private Map<String, AbstractConfigAssociation> configRepository = new HashMap<String, AbstractConfigAssociation>();

	public FwMetaModelCommandImpl() {}
	
	public Iterator<Entry<String,AbstractCommand>> getCommandsIterator()
	{
		return this.cmdRepository.entrySet().iterator();
	}
	
	
	public void createMetaModel(String mm) {
		cmdRepository.put(mm, new CreateMetaModel(mm));
	}

	public void createMetaRelation(String mm) {
		cmdRepository.put(mm, new CreateMetaRelation(mm));
	}

	public void createMetaEntity(String mm) {
		cmdRepository.put(mm, new CreateMetaEntity(mm));
	}

	public <T> void createMetaAttribute(String mm, T defaultValue) {
		cmdRepository.put(mm, new CreateMetaAttribute<T>(mm, defaultValue));
	}

	public void configMetaModel(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaModelConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
		configRepository.put(mm, cListA);
	}

	public void configMetaEntity(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaEntityConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
		configRepository.put(mm, cListA);
	}

	public void configMetaRelation(String mm, String... values) {
		AbstractConfigAssociation cListA = new MetaRelationConfig(mm);
		for (String value : values) {
			cListA.add(value);
		}
		configRepository.put(mm, cListA);
	}

}
