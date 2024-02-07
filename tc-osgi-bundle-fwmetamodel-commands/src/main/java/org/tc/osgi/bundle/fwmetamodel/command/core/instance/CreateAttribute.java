/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.core.instance;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaAttribute;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * CreateAttribute.java.
 * 
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateAttribute extends AbstractInstanceCreatingCommand<CreateMetaAttribute> {

	/**
	 * String type.
	 */
	private final String type;

	/**
	 * CreateAttribute constructor.
	 * 
	 * @param type String
	 * @param name String
	 */
	public CreateAttribute(final String type, final String name) {
		super(name);
		this.type = type;

	}

	/**
	 * @throws ClassNotFoundException
	 * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
	 */
	@Override
	public void exec() throws CommandExecutionException {
		final CreateMetaAttribute cmdCible = findMetaCreatingCommand();
		final IMetaAttribute md = ((IMetaAttribute) cmdCible.getType());
		md.create(getName());
		setType(md);
	}

	/**
	 * findCommand.
	 * 
	 * @return CreateMetaAttribute
	 * @throws ClassNotFoundException
	 */
	@Override
	protected CreateMetaAttribute findMetaCreatingCommand() throws CommandNotFoundException {
		final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();
		while (itInstruction.hasNext()) {
			final ICommand cmdCible = itInstruction.next();
			if (cmdCible instanceof CreateMetaAttribute) {
				if (type.equals(((CreateMetaAttribute) cmdCible).getName())) {
					return (CreateMetaAttribute) cmdCible;
				}
			}
		}
		throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaAttribute. Cette classe n'existe pas."));
	}
}
