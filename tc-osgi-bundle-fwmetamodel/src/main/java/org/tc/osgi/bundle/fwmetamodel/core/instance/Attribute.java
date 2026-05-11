package org.tc.osgi.bundle.fwmetamodel.core.instance;

import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;

/**
 * Attribute.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class Attribute<T> extends AbstractInstance<MetaAttribute<T>> {

	/**
	 * String value.
	 */
	private T value;

	/**
	 * getValue.
	 * @return String
	 */
	public T getValue() {
		return value;
	}

	/**
	 * setValue.
	 * @param value String
	 */
	public void setValue(final T value) {
		this.value = value;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.fwmetamodel.core.instance.AbstractInstance#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer();
		buff.append(super.toString());
		buff.append("{value:");
		buff.append(value);
		buff.append("}");
		return buff.toString();
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.fwmetamodel.core.instance.AbstractInstance#toXML()
	 */
	@Override
	@Deprecated
	public String toXML() {
		final StringBuffer buff = new StringBuffer();
		buff.append("<");
		buff.append(getType().getName());
		buff.append(" id='");
		buff.append(getId());
		buff.append("' name='");
		buff.append(getName());
		buff.append("'>");
		buff.append(value);
		buff.append("</");
		buff.append(getType().getName());
		buff.append(">");
		return buff.toString();
	}

}
