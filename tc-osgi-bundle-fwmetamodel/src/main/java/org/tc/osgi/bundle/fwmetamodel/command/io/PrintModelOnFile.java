package org.tc.osgi.bundle.fwmetamodel.command.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map.Entry;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateModel;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

/**
 * PrintModelOnFile.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class PrintModelOnFile extends IoCommand {

	/**
	 * String path.
	 */
	private final String path;

	/**
	 * PrintModelOnFile constructor.
	 * 
	 * @param cible String
	 * @param path  String
	 */
	public PrintModelOnFile(final String name,final String cible, final String path, FwMetaModelCommandImpl fwcmd) {
		super(name,cible, fwcmd);
		final StringBuffer buff = new StringBuffer(path);
		buff.append("Model");
		buff.append(this.getCible());
		buff.append(".xml");
		this.path = buff.toString();
		
	}

	@Override
	public void exec()  {
		PrintStream ps;
		try {
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(this.path)));
			final StringBuffer buff = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
			buff.append("");// mettre ici le namespace du fichier xml + \r
			final CreateModel cmd = (CreateModel) this.findCommand();
			final MetaModel md = ((MetaModel) cmd.getType());
			buff.append(md.getInstanceIterator().getInstanceAt(this.getCible()).toXML());
			ps.println(buff.toString());
			ps.close();
			
		} catch (FileNotFoundException | ClassNotFoundException | InstanceIteratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	@Override
	protected AbstractCommand findCommand() throws ClassNotFoundException {
		final Iterator<Entry<String,AbstractCommand>> itInstruction = this.getFwcmd().getCommandsIterator();
		Entry<String,AbstractCommand> cmdCible = null;
		while (itInstruction.hasNext()) {

			cmdCible = itInstruction.next();
			if (cmdCible.getValue().getClass().equals(CreateModel.class.getCanonicalName())) {
				if (this.getCible().equals(((AbstractCommand) cmdCible).getName())) {
					return cmdCible.getValue();
				}
			}
		}
		throw (new ClassNotFoundException(
				"Class: fwMetamodel.command.core.instance.CreateModel. Cette classe n'existe pas."));
	}

}
