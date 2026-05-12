package org.tc.osgi.bundle.fwmetamodel.command.core.instance;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.AbstractTypeCreatingCommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * AbstractInstanceCreatingCommand.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractInstanceCreatingCommand<T extends AbstractTypeCreatingCommand> extends AbstractCommand {

    /**
     * AbstractInstanceCreatingCommand constructor.
     * @param name String
     */
    public AbstractInstanceCreatingCommand(final String name) {
        super(name);

    }

    /**
     * findMetaCreatingCommand.
     * @return T
     * @throws ClassNotFoundException
     */
    protected abstract T findMetaCreatingCommand() throws CommandNotFoundException;

}
