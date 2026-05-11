package org.tc.osgi.bundle.fwmetamodel.command.io;

public abstract class PrintMetaModelOnConsole extends IoCommand {

    // public PrintMetaModelOnConsole(final String cible) {
    // super(cible);
    // AbstractCommand.getRepository().getInstructions().add(this);
    // }
    //
    // @Override
    // public void exec() throws ClassNotFoundException {
    // final StringBuffer buff = new
    // StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
    // buff.append("");// mettre ici le namespace du fichier xml + \r
    // final CreateMetaModel cmd = (CreateMetaModel) this.findCommand();
    // buff.append(((MetaModel) (cmd).getType()).toXML());
    // System.out.println(buff.toString());
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
    // (cmdCible.getClass().toString().equals("class fwMetamodel.command.core.type.CreateMetaModel"))
    // {
    // if (this.getCible().equals(((AbstractCreatingCommand)
    // cmdCible).getName())) {
    // return cmdCible;
    // }
    // }
    // }
    // throw (new
    // ClassNotFoundException("Class: fwMetamodel.command.core.type.CreateMetaModel. Cette classe n'existe pas."));
    // }
}
