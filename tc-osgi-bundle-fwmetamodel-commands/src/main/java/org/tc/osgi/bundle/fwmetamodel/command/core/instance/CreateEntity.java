/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.core.instance;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * CreateEntity.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class CreateEntity extends AbstractInstanceCreatingCommand<CreateMetaEntity> {

    /**
     * String type.
     */
    private final String type;

    /**
     * CreateEntity constructor.
     * @param type String
     * @param name String
     */
    public CreateEntity(final String type, final String name) {
        super(name);
        this.type = type;

    }

    /**
     * @throws ClassNotFoundException
     * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
     */
    @Override
    public void exec() throws CommandExecutionException {
        final CreateMetaEntity cmdCible = findMetaCreatingCommand();
        final MetaEntity md = ((MetaEntity) cmdCible.getType());
        md.create(getName());
        setType(md);
    }

    /**
     * findCommand.
     * @return Command
     * @throws ClassNotFoundException
     */
    @Override
    protected CreateMetaEntity findMetaCreatingCommand() throws CommandNotFoundException {
        final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();

        while (itInstruction.hasNext()) {
            final ICommand cmdCible = itInstruction.next();
            if (cmdCible instanceof CreateMetaEntity) {
                if (type.equals(((CreateMetaEntity) cmdCible).getName())) {
                    return (CreateMetaEntity) cmdCible;
                }
            }
        }
        throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaEntity. Cette classe n'existe pas."));
    }
}
