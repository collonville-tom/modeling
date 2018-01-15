/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.core.instance;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * CreateRelation.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateRelation extends AbstractInstanceCreatingCommand<CreateMetaRelation> {

    /**
     * String type.
     */
    private final String type;

    /**
     * CreateRelation constructor.
     * @param type String
     * @param name String
     */
    public CreateRelation(final String type, final String name) {
        super(name);
        this.type = type;

    }

    /**
     * @throws ClassNotFoundException
     * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
     */
    @Override
    public void exec() throws CommandExecutionException {
        final CreateMetaRelation cmdCible = findMetaCreatingCommand();
        final MetaRelation md = ((MetaRelation) cmdCible.getType());
        md.create(getName());
        setType(md);
    }

    /**
     * findCommand.
     * @return CreateMetaRelation
     * @throws ClassNotFoundException
     */
    @Override
    protected CreateMetaRelation findMetaCreatingCommand() throws CommandNotFoundException {
        final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();
        while (itInstruction.hasNext()) {
            final ICommand cmdCible = itInstruction.next();
            if (cmdCible instanceof CreateMetaRelation) {
                if (type.equals(((CreateMetaRelation) cmdCible).getName())) {
                    return (CreateMetaRelation) cmdCible;
                }
            }
        }
        throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaRelation. Cette classe n'existe pas."));
    }
}
