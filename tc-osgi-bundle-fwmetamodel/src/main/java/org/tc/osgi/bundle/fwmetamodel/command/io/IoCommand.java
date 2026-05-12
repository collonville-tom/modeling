package org.tc.osgi.bundle.fwmetamodel.command.io;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

public abstract class IoCommand  extends AbstractCommand {
	private final String cible;
	private FwMetaModelCommandImpl fwcmd;

	public FwMetaModelCommandImpl getFwcmd() {
		return fwcmd;
	}

	public IoCommand(final String name,final String cible, FwMetaModelCommandImpl fwcmd) {
		super(name);
		this.cible = cible;
		this.fwcmd=fwcmd;
	}

	protected abstract AbstractCommand findCommand() throws ClassNotFoundException;

	public String getCible() {
		return this.cible;
	}
}
