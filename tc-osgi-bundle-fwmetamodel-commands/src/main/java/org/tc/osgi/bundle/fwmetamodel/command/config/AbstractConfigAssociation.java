package org.tc.osgi.bundle.fwmetamodel.command.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.utils.interf.pattern.command.ICommand;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;

/**
 * AbstractConfigAssociation.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractConfigAssociation implements ICommand {

	/**
	 * String cible.
	 */
	private final String cible;

	/**
	 * ArrayList elements.
	 */
	private final List<String> elements = new ArrayList<String>();

	/**
	 * AbstractConfigAssociation constructor.
	 * @param cible String
	 */
	public AbstractConfigAssociation(final String cible) {
		super();
		this.cible = cible;
	}

	/**
	 * add.
	 * @param string String
	 */
	public void add(final String string) {
		elements.add(string);
	}

	/**
	 * configExec.
	 * @throws ClassNotFoundException
	 * @throws InstanceIteratorException
	 */
	protected abstract void configExec() throws InstanceIteratorException;

	/**
	 * @throws CommandExecutionException
	 * @see org.tc.osgi.bundle.utils.pattern.command.ICommand#exec()
	 */
	@Override
	public void exec() throws CommandExecutionException {
		try {
			configExec();
		} catch (final InstanceIteratorException e) {
			throw new CommandExecutionException("Une erreur est survenue", e);
		}
	}

	/**
	 * getCible.
	 * @return String
	 */
	public String getCible() {
		return cible;
	}

	/**
	 * getElementsIterator.
	 * @return Iterator
	 */
	public Iterator<String> getElementsIterator() {
		return elements.iterator();
	}

}
