/*
 * Created on 23 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.config.instance;

import java.util.Iterator;

import javax.management.relation.Relation;

import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateEntity;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateRelation;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandNotFoundException;

/**
 * ModelConfig.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class ModelConfig extends AbstractInstanceConfigAssociation<CreateModel> {

    /**
     * ModelConfig constructor.
     * @param cible String
     */
    public ModelConfig(final String cible) {
        super(cible);

    }

    /**
     * @throws ClassNotFoundException
     * @throws InstanceIteratorException
     * @see org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation#configExec()
     */
    @Override
    protected void configExec() throws CommandNotFoundException, InstanceIteratorException {

        final CreateModel cmdCible = findInstanceCreatingCommand();
        final MetaModel md = ((MetaModel) cmdCible.getType());
        final Iterator<ICommand> itCommands = DefaultRepository.getInstance().getCommandsIterator();

        while (itCommands.hasNext()) {

            final ICommand cmd = itCommands.next();
            if (cmd instanceof CreateEntity) {

                final Iterator<String> itElements = getElementsIterator();
                while (itElements.hasNext()) {
                    if (itElements.next().equals(((CreateEntity) cmd).getName())) {
                        final String entityName = ((CreateEntity) cmd).getName();
                        final Entity entity = ((MetaEntity) ((CreateEntity) cmd).getType()).getInstanceIterator().getInstanceAt(entityName);
                        md.getInstanceIterator().getInstanceAt(getCible()).addEntity(entity);
                    }
                }
            }
            if (cmd instanceof CreateRelation) {
                final Iterator<String> itElements = getElementsIterator();
                while (itElements.hasNext()) {
                    if (itElements.next().equals(((CreateRelation) cmd).getName())) {
                        final String relationName = ((CreateRelation) cmd).getName();
                        final Relation relation = ((MetaRelation) ((CreateRelation) cmd).getType()).getInstanceIterator().getInstanceAt(relationName);
                        md.getInstanceIterator().getInstanceAt(getCible()).addRelation(relation);
                    }
                }
            }
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
    protected CreateModel findInstanceCreatingCommand() throws CommandNotFoundException {
        final Iterator<ICommand> itInstruction = DefaultRepository.getInstance().getCommandsIterator();
        while (itInstruction.hasNext()) {

            final ICommand cmdCible = itInstruction.next();
            if (cmdCible instanceof CreateModel) {
                if (getCible().equals(((CreateModel) cmdCible).getName())) {
                    return (CreateModel) cmdCible;
                }
            }
        }
        throw (new CommandNotFoundException("Class: fwMetamodel.command.core.instance.CreateModel. Cette classe n'existe pas."));
    }

}
