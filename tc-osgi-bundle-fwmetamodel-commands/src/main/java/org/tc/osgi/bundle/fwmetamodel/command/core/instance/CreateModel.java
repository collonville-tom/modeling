/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.core.instance;

import java.util.Iterator;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * CreateModel.java.
 * @author thomas collonvillé
 * @version
 */
public class CreateModel extends AbstractInstanceCreatingCommand<CreateMetaModel> {

    /**
     * String type.
     */
    private final String type;

    /**
     * CreateModel constructor.
     * @param type String
     * @param name String
     */
    public CreateModel(final String type, final String name) {
        super(name);
        this.type = type;

    }

    /**
     * @throws ClassNotFoundException
     * @see org.tc.osgi.bundle.utils.pattern.command.AbstractCommand#exec()
     */
    @Override
    public void exec() throws CommandExecutionException {
        final CreateMetaModel cmdCible = findMetaCreatingCommand();
        final MetaModel md = ((MetaModel) cmdCible.getType());
        md.create(getName());
        setType(md);
    }

    /**
     * findCommand.
     * @return CreateMetaModel
     * @throws ClassNotFoundException
     */
    @Override
    protected CreateMetaModel findMetaCreatingCommand() throws CommandNotFoundException {
        final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();
        while (itInstruction.hasNext()) {
            final ICommand cmdCible = itInstruction.next();
            if (cmdCible instanceof CreateMetaModel) {
                if (type.equals(((CreateMetaModel) cmdCible).getName())) {
                    return (CreateMetaModel) cmdCible;
                }
            }
        }
        throw (new CommandNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaModel. Cette classe n'existe pas."));
    }
}
