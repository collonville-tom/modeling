package org.tc.osgi.bundle.fwmetamodel.command.io;

import java.util.Iterator;
import java.util.Map.Entry;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

public class PrintMetaModelOnConsole extends IoCommand {
	
	 

	public PrintMetaModelOnConsole(final String name,final String cible, FwMetaModelCommandImpl fwcmd) {
		super(name,cible,fwcmd);
		
	}

	@Override
	public void exec() {
		final StringBuffer buff = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
		buff.append("");// mettre ici le namespace du fichier xml + \r
		CreateMetaModel cmd;
		try {
			cmd = (CreateMetaModel) this.findCommand();
			buff.append(((MetaModel) (cmd).getType()).toXML());
			System.out.println(buff.toString());
		} catch (ClassNotFoundException e) {
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
