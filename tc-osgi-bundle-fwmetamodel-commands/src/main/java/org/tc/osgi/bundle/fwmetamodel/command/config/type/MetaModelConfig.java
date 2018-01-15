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
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.CommandRunnerUtilsProxy;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * MetaModelConfig.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaModelConfig extends AbstractMetaConfigAssociation<CreateMetaModel> {

	/**
	 * MetaModelConfig constructor.
	 * @param cible String
	 */
	public MetaModelConfig(final String cible) {
		super(cible);

	}

	/**
	 * @throws ClassNotFoundException
	 * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#configExec()
	 */
	@Override
	protected void configExec() throws CommandNotFoundException {

		final CreateMetaModel cmdCible = findMetaCreatingCommand();
		final MetaModel md = ((MetaModel) cmdCible.getType());
		final Iterator<ICommand> itCommands = CommandRunnerUtilsProxy.getInstance().getRepository().getCommandsIterator();

		while (itCommands.hasNext()) {
			final ICommand cmd = itCommands.next();
			if (cmd instanceof CreateMetaEntity) {
				final Iterator<String> itElements = getElementsIterator();
				while (itElements.hasNext()) {
					if (itElements.next().equals(((CreateMetaEntity) cmd).getName())) {
						md.addMetaEntity((MetaEntity) ((CreateMetaEntity) cmd).getType());
					}
				}
			}
			if (cmd instanceof CreateMetaRelation) {
				final Iterator<String> itElements = getElementsIterator();
				while (itElements.hasNext()) {
					if (itElements.next().equals(((CreateMetaRelation) cmd).getName())) {
						md.addMetaRelation((MetaRelation) ((CreateMetaRelation) cmd).getType());
					}
				}
			}
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
	 * @return CreateMetaModel
	 * @throws ClassNotFoundException
	 * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#findInstanceCreatingCommand()
	 */
	@Override
	protected CreateMetaModel findMetaCreatingCommand() throws CommandNotFoundException {
		final Iterator<ICommand> itInstruction = CommandRunnerUtilsProxy.getInstance().getRepository().getCommandsIterator();
		while (itInstruction.hasNext()) {

			final ICommand cmdCible = itInstruction.next();
			if (cmdCible instanceof CreateMetaModel) {
				if (getCible().equals(((CreateMetaModel) cmdCible).getName())) {
					return (CreateMetaModel) cmdCible;
				}
			}
		}
		throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaModel. Cette classe n'existe pas."));
	}
}
