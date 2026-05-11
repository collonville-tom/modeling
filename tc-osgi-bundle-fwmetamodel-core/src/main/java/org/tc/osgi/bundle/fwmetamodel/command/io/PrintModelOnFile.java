package org.tc.osgi.bundle.fwmetamodel.command.io;

/**
 * PrintModelOnFile.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class PrintModelOnFile extends IoCommand {

    // /**
    // * String path.
    // */
    // private final String path;
    //
    // /**
    // * PrintModelOnFile constructor.
    // * @param cible String
    // * @param path String
    // */
    // public PrintModelOnFile(final String cible, final String path) {
    // super(cible);
    // final StringBuffer buff = new StringBuffer(path);
    // buff.append("Model");
    // buff.append(this.getCible());
    // buff.append(".xml");
    // this.path = buff.toString();
    // AbstractCommand.getRepository().getInstructions().add(this);
    // }
    //
    // @Override
    // public void exec() throws FileNotFoundException, ClassNotFoundException,
    // InstanceIteratorException {
    // final PrintStream ps = new PrintStream(new BufferedOutputStream(new
    // FileOutputStream(this.path)));
    // final StringBuffer buff = new
    // StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
    // buff.append("");// mettre ici le namespace du fichier xml + \r
    // final CreateModel cmd = (CreateModel) this.findCommand();
    // final MetaModel md = ((MetaModel) cmd.getType());
    // buff.append(md.getInstanceIterator().getInstanceAt(this.getCible()).toXML());
    // ps.println(buff.toString());
    // ps.close();
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
