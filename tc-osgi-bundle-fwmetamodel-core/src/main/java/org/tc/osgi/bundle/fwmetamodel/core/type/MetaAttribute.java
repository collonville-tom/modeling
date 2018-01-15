package org.tc.osgi.bundle.fwmetamodel.core.type;

import org.tc.osgi.bundle.fwmetamodel.core.instance.Attribute;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;

/**
 * MetaAttribute.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaAttribute<T> extends AbstractType<Attribute> implements IMetaAttribute {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = -4599843314696422271L;
	/**
	 * String defaultValue.
	 */
	private T defaultValue;

	/**
	 * MetaAttribute constructor.
	 * @param name String
	 * @param defaultValue String
	 */
	public MetaAttribute(final String name, final T defaultValue) {
		super(name);
		setDefaultValue(defaultValue);
		LoggerServiceProxy.getInstance().getLogger(MetaAttribute.class).info("Creation MA " + getName() + " with " + getDefaultValue());
	}

	/**
	 * @param name String
	 * @return Attribute
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#create(java.lang.String)
	 */
	@Override
	public Attribute create(final String name) {
		final Attribute attribute = new Attribute();
		attribute.setName(name);
		attribute.setType(this);
		attribute.setId(getInstanceCounter());
		attribute.setValue(getDefaultValue());
		getInstanceIterator().add(attribute);
		LoggerServiceProxy.getInstance().getLogger(MetaAttribute.class).info("Creation A " + attribute.getName());
		AbstractType.incGlobalCounter();
		return attribute;

	}

	/**
	 * getDefaultValue.
	 * @return String
	 */
	final public T getDefaultValue() {
		return defaultValue;
	}

	/**
	 * setDefaultValue.
	 * @param defaultValue String
	 */
	final public void setDefaultValue(final T defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer();
		buff.append("[");
		buff.append(super.toString());
		buff.append(":");
		buff.append(defaultValue);
		buff.append("]");
		return buff.toString();
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#toXML()
	 */
	@Override
	@Deprecated
	public String toXML() {
		final StringBuffer buff = new StringBuffer();
		buff.append("<MetaAttribute name='");
		buff.append(getName());
		buff.append("'>");
		buff.append(defaultValue);
		buff.append("</MetaAttribute>");
		return buff.toString();
	}

}
