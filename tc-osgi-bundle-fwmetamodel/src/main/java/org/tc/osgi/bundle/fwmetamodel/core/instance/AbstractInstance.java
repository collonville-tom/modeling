package org.tc.osgi.bundle.fwmetamodel.core.instance;

import java.io.Serializable;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.instance.IInstance;
import org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType;

/**
 * Instance.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public abstract class AbstractInstance<T extends AbstractType> implements Serializable, IInstance {

	/**
	 * int id.
	 */
	private int id;
	/**
	 * String name.
	 */
	private String name;
	/**
	 * T type.
	 */
	private T type;

	/**
	 * getId.
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * getName.
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getType.
	 * @return T
	 */
	public T getType() {
		return this.type;
	}

	/**
	 * setId.
	 * @param cnt int
	 */
	public void setId(final int cnt) {
		this.id = cnt;
	}

	/**
	 * setName.
	 * @param name String
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * setType.
	 * @param type T
	 */
	public void setType(final T type) {
		this.type = type;
	}

	/**
	 * @return String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer("(");
		buff.append(this.name).append(",");
		buff.append(this.id).append(",");
		buff.append(this.type.getName()).append(")");
		return buff.toString();
	}

	/**
	 * toXML.
	 * @return String
	 */
	@Deprecated
	public abstract String toXML();
}
