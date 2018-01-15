/*
 * Created on 23 janv. 2005
 * 
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.config.type;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.CommandRunnerUtilsProxy;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.FwMetaModelCoreProxy;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * MetaEntityConfig.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaEntityConfig extends AbstractMetaConfigAssociation<CreateMetaEntity> {

	/**
	 * MetaEntityConfig constructor.
	 * @param cible String
	 */
	public MetaEntityConfig(final String cible) {
		super(cible);

	}

	/**
	 * @throws ClassNotFoundException
	 * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#configExec()
	 */
	@Override
	protected void configExec() throws CommandNotFoundException {

		final CreateMetaEntity cmdCible = findMetaCreatingCommand();
		final IMetaAttributed<IType> md = cmdCible.getType();
		final Iterator<ICommand> itCommands = CommandRunnerUtilsProxy.getInstance().getRepository().getCommandsIterator();
		while (itCommands.hasNext()) {
			final ICommand cmd = itCommands.next();
			if (cmd instanceof CreateMetaAttribute) {
				final Iterator<String> itElements = getElementsIterator();
				while (itElements.hasNext()) {
					if (itElements.next().equals(((CreateMetaAttribute) cmd).getName())) {
						md.addMetaAttribute((MetaAttribute) ((CreateMetaAttribute) cmd).getType());
					}
				}
			}

		}
	}

	/**
	 * @return AbstractCommand
	 * @throws ClassNotFoundException
	 * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#findInstanceCreatingCommand()
	 */
	@Override
	protected CreateMetaEntity findMetaCreatingCommand() throws CommandNotFoundException {
		final Iterator<ICommand> itInstruction = CommandRunnerUtilsProxy.getInstance().getRepository().getCommandsIterator();
		while (itInstruction.hasNext()) {
			final ICommand cmdCible = itInstruction.next();
			if (cmdCible instanceof CreateMetaEntity) {
				if (getCible().equals(((CreateMetaEntity) cmdCible).getName())) {
					return (CreateMetaEntity) cmdCible;
				}
			}
		}
		throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaEntity. Cette classe n'existe pas."));
	}
}
