package org.tc.osgi.bundle.fwmetamodel.core.instance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.InstanceIterator;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;

/*
 * Entity.java.
 * 
 * @author thomas collonvillé
 * 
 * @version 0.0.1
 */
public class Entity extends AbstractInstance<MetaEntity> {

	/*
	 * List<Attribute> attribute.
	 */
	private List<Attribute> attribute = null;

	/*
	 * addAttribute.
	 * 
	 * @param attribute Attribute
	 * 
	 * @return boolean
	 */
	public boolean addAttribute(final Attribute attribute) {
		final Iterator it = getType().getMetaAttributeIterator();
		boolean isFind = false;
		while (it.hasNext()) {
			if (((MetaAttribute) it.next()).equals(attribute.getType())) {
				getAttribute().add(attribute);
				isFind = true;
			}

		}
		return isFind;
	}

	/*
	 * getAttribute.
	 * 
	 * @return List<Attribute>
	 */
	public List<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new ArrayList<Attribute>();
		}
		return attribute;
	}

	/*
	 * getAttributeIterator.
	 * 
	 * @return InstanceIterator<Attribute>
	 */
	public InstanceIterator<Attribute> getAttributeIterator() {
		return new InstanceIterator<Attribute>(getAttribute());
	}

	/*
	 * @return String
	 * 
	 * @see
	 * org.tc.osgi.bundle.fwmetamodel.core.instance.AbstractInstance#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer();
		buff.append(super.toString());
		buff.append("{attributes:");
		final Iterator it = getAttributeIterator();
		while (it.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((Attribute) it.next()).toString());
		}
		buff.append("}");
		return buff.toString();
	}

	/*
	 * @return String
	 * 
	 * @see
	 * org.tc.osgi.bundle.fwmetamodel.core.instance.AbstractInstance#toXML()
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
		final Iterator it = getAttributeIterator();
		while (it.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((Attribute) it.next()).toXML());
		}
		buff.append("\r\t</");
		buff.append(getType().getName());
		buff.append(">");
		return buff.toString();
	}
}
