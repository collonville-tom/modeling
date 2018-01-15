package org.tc.osgi.bundle.fwmetamodel.command.config.instance;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateEntity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * EntityConfig.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class EntityConfig extends AbstractInstanceConfigAssociation<CreateEntity> {

	/**
	 * EntityConfig constructor.
	 * @param cible String
	 */
	public EntityConfig(final String cible) {
		super(cible);

	}

	/**
	 * @throws ClassNotFoundException
	 * @throws InstanceIteratorException
	 * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#configExec()
	 */
	@Override
	protected void configExec() throws CommandNotFoundException, InstanceIteratorException {

		final CreateEntity cmdCible = findInstanceCreatingCommand();
		final MetaEntity md = ((MetaEntity) cmdCible.getType());
		final Iterator<ICommand> itCommands = DefaultRepository.getInstance().getCommandsIterator();

		while (itCommands.hasNext()) {
			final ICommand cmd = itCommands.next();
			if (cmd instanceof CreateAttribute) {
				final Iterator<String> itElements = getElementsIterator();
				while (itElements.hasNext()) {
					if (itElements.next().equals(((CreateAttribute) cmd).getName())) {
						final String attributeName = ((CreateAttribute) cmd).getName();
						final Attribute attribute = ((MetaAttribute) ((CreateAttribute) cmd).getType()).getInstanceIterator().getInstanceAt(attributeName);
						md.getInstanceIterator().getInstanceAt(getCible()).addAttribute(attribute);
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
	protected CreateEntity findInstanceCreatingCommand() throws CommandNotFoundException {
		final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();

		while (itInstruction.hasNext()) {

			final ICommand cmdCible = itInstruction.next();
			if (cmdCible instanceof CreateEntity) {
				if (getCible().equals(((CreateEntity) cmdCible).getName())) {
					return (CreateEntity) cmdCible;
				}
			}
		}
		throw (new CommandNotFoundException("Class: fwMetamodel.command.core.instance.CreateEntity. Cette classe n'existe pas."));
	}

}
