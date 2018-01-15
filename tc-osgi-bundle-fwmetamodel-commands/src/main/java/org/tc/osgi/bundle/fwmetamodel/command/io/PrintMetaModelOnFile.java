package org.tc.osgi.bundle.fwmetamodel.command.io;

public abstract class PrintMetaModelOnFile extends IoCommand {

    // private final String path;
    //
    // public PrintMetaModelOnFile(final String cible, final String path) {
    // super(cible);
    // final StringBuffer buff = new StringBuffer(path);
    // buff.append("MetaModel");
    // buff.append(this.getCible());
    // buff.append(".xml");
    // this.path = buff.toString();
    // AbstractCommand.getRepository().getInstructions().add(this);
    // }
    //
    // @Override
    // public void exec() throws FileNotFoundException, ClassNotFoundException {
    // final PrintStream ps = new PrintStream(new BufferedOutputStream(new
    // FileOutputStream(this.path)));
    // final StringBuffer buff = new
    // StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
    // buff.append("");// mettre ici le namespace du fichier xml + \r
    // final CreateMetaModel cmd = (CreateMetaModel) this.findCommand();
    // buff.append(((MetaModel) cmd.getType()).toXML());
    // ps.println(buff.toString());
    // ps.close();
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
