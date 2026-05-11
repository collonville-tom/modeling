package org.tc.osgi.bundle.fwmetamodel.core.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.instance.AbstractInstance;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.instance.IInstance;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.InstanceIterator;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

/*
 * Type.java.
 * 
 * @author thomas collonvillé
 * 
 * @version 0.0.1
 */
public abstract class AbstractType<T extends AbstractInstance> implements Serializable, IType {

	/*
	 * int globalCounter.
	 */
	@Deprecated
	private static int globalCounter = 0;
	/*
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 9036179301927772066L;

	/*
	 * decGlobalCounter.
	 */
	@Deprecated
	protected static void decGlobalCounter() {
		AbstractType.globalCounter--;
	}

	/*
	 * getGlobalCounter.
	 * 
	 * @return int
	 */
	@Deprecated
	public static int getGlobalCounter() {
		return AbstractType.globalCounter;
	}

	/*
	 * incGlobalCounter.
	 */
	@Deprecated
	protected static void incGlobalCounter() {
		AbstractType.globalCounter++;
	}

	/*
	 * List<T> instances.
	 */
	private List<T> instances = null;

	/*
	 * String name.
	 */
	private String name;

	/**
	 * AbstractType constructor.
	 * @param name String
	 */
	public AbstractType(final String name) {
		this.setName(name);
	}

	/*
	 * create.
	 * 
	 * @param name
	 * 
	 * @return T
	 */
	public abstract T create(String name);

	/*
	 * @param name String
	 * 
	 * @throws TypeException
	 * 
	 * @see
	 * org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#delete(java.lang
	 * .String)
	 */
	public void delete(final String name) {
		T t = null;
		for (final T type : this.getInstances()) {
			if (type.getName().equals(name)) {
				t = type;
			}

		}
		this.getInstanceIterator().remove(t);
		AbstractType.decGlobalCounter();

	}

	/*
	 * getInstanceCounter.
	 * 
	 * @return int
	 */
	public int getInstanceCounter() {
		return this.getInstances().size();
	}

	/*
	 * getInstanceIterator.
	 * 
	 * @return InstanceIterator
	 */
	public InstanceIterator<T> getInstanceIterator() {
		return new InstanceIterator<T>(this.getInstances());
	}

	/*
	 * getInstances.
	 * 
	 * @return List<T>
	 */
	public List<T> getInstances() {
		if (this.instances == null) {
			this.instances = new ArrayList<T>();
		}
		return this.instances;
	}

	/*
	 * getName.
	 * 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * setName.
	 * 
	 * @param name String
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/*
	 * @return String
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer();
		buff.append("(Name:").append(this.name).append(",nbrInst:").append(this.getInstanceCounter()).append("/").append(AbstractType.globalCounter)
			.append(")");
		final InstanceIterator it = this.getInstanceIterator();
		for (; it.hasNext();) {
			final IInstance instance = it.next();
			buff.append(instance.getName()).append(",");
		}
		return buff.toString();
	}

	/*
	 * toXML.
	 * 
	 * @return String
	 */
	@Deprecated
	public abstract String toXML();

}
