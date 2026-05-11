/*
 * Created on 11 d�c. 2004
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io;

public abstract class PrintModelOnConsole extends IoCommand {

    // public PrintModelOnConsole(final String cible) {
    // super(cible);
    // AbstractCommand.getRepository().getInstructions().add(this);
    // }
    //
    // @Override
    // public void exec() throws ClassNotFoundException,
    // InstanceIteratorException {
    //
    // final StringBuffer buff = new
    // StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
    // buff.append("");// mettre ici le namespace du fichier xml + \r
    // final CreateModel cmd = (CreateModel) this.findCommand();
    // final MetaModel md = ((MetaModel) cmd.getType());
    // buff.append(md.getInstanceIterator().getInstanceAt(this.getCible()).toXML());
    // System.out.println(buff.toString());
    //
    // }
    //
    // @Override
    // protected AbstractCommand findCommand() throws ClassNotFoundException {
    // final Iterator itInstruction =
    // AbstractCommand.getRepository().getCommandsIterator();
    // AbstractCommand cmdCible = null;
    // while (itInstruction.hasNext()) {
    //
    // cmdCible = (AbstractCommand) itInstruction.next();
    // if
    // (cmdCible.getClass().toString().equals("class fwMetamodel.command.core.instance.CreateModel"))
    // {
    // if (this.getCible().equals(((AbstractCreatingCommand)
    // cmdCible).getName())) {
    // return cmdCible;
    // }
    // }
    // }
    // throw (new
    // ClassNotFoundException("Class: fwMetamodel.command.core.instance.CreateModel. Cette classe n'existe pas."));
    // }

}
