package org.tc.osgi.bundle.fwmetamodel.command.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map.Entry;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

public class PrintMetaModelOnFile extends IoCommand {

	private final String path;

	public PrintMetaModelOnFile(final String name,final String cible, final String path, FwMetaModelCommandImpl fwcmd) {
		super(name,cible,fwcmd);

		final StringBuffer buff = new StringBuffer(path);
		buff.append("MetaModel");
		buff.append(this.getCible());
		buff.append(".xml");
		this.path = buff.toString();
		
	}

	@Override
	public void exec(){
		PrintStream ps;
		try {
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(this.path)));
			final StringBuffer buff = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
			buff.append("");// mettre ici le namespace du fichier xml + \r
			final CreateMetaModel cmd = (CreateMetaModel) this.findCommand();
			buff.append(((MetaModel) cmd.getType()).toXML());
			ps.println(buff.toString());
			ps.close();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected AbstractCommand findCommand() throws ClassNotFoundException {
		final Iterator<Entry<String,AbstractCommand>> itInstruction = this.getFwcmd().getCommandsIterator();
		while (itInstruction.hasNext()) {
			Entry<String,AbstractCommand> cmdCible =  itInstruction.next();
			if (cmdCible.getValue().getClass().equals(CreateMetaModel.class.getCanonicalName())) {
				if (this.getCible().equals(((AbstractCommand) cmdCible).getName())) {
					return cmdCible.getValue();
				}
			}
		}
		throw (new ClassNotFoundException(
				"Class: fwMetamodel.command.core.type.CreateMetaModel. Cette classe n'existe pas."));
	}

}
