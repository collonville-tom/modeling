/*
 * Created on 11 d�c. 2004
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io;

import java.util.Iterator;
import java.util.Map.Entry;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateModel;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

public class PrintModelOnConsole extends IoCommand {

	public PrintModelOnConsole(final String name,final String cible, FwMetaModelCommandImpl fwcmd) {
		super(name,cible,fwcmd);
	
	}

	@Override
	public void exec() {

		final StringBuffer buff = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>\r");
		buff.append("");// mettre ici le namespace du fichier xml + \r
		CreateModel cmd;
		try {
			cmd = (CreateModel) this.findCommand();
			final MetaModel md = ((MetaModel) cmd.getType());
			buff.append(md.getInstanceIterator().getInstanceAt(this.getCible()).toXML());
			System.out.println(buff.toString());
		} catch (ClassNotFoundException | InstanceIteratorException e) {
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
