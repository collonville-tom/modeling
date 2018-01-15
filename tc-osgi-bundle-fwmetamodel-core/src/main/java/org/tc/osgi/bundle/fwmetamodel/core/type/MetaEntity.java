package org.tc.osgi.bundle.fwmetamodel.core.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.instance.Entity;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.MetaIterator;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaRelated;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;

/**
 * MetaEntity.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaEntity extends AbstractType<Entity> implements IMetaEntity<MetaAttribute> {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = -3973453228322983386L;
	/**
	 * ArrayList<MetaAttribute> metaAttributes.
	 */
	private List<MetaAttribute> metaAttributes = null;

	/**
	 * MetaEntity constructor.
	 * @param name String
	 */
	public MetaEntity(final String name) {
		super(name);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Creation ME " + getName());
	}

	/**
	 * addMetaAttribute.
	 * @param meta MetaAttribute
	 */
	public void addMetaAttribute(final MetaAttribute meta) {
		if (metaAttributes == null) {
			metaAttributes = new ArrayList<MetaAttribute>();
		}
		metaAttributes.add(meta);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("Ajout MA " + meta.getName());
	}

	/**
	 * @param name String
	 * @return  Entity
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#create(java.lang.String)
	 */
	@Override
	public Entity create(final String name) {
		final Entity entity = new Entity();
		entity.setName(name);
		entity.setType(this);
		entity.setId(getInstanceCounter());

		getInstanceIterator().add(entity);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("Creation E " + entity.getName());
		AbstractType.incGlobalCounter();
		return entity;

	}

	/**
	 * getMetaAttributeIterator.
	 * @return MetaIterator<MetaAttribute>
	 */
	public MetaIterator<MetaAttribute> getMetaAttributeIterator() {
		return new MetaIterator<MetaAttribute>(getMetaAttributes());
	}

	/**
	 * getMetaAttributes.
	 * @return ArrayList<MetaAttribute>
	 */
	public List<MetaAttribute> getMetaAttributes() {
		if (metaAttributes == null) {
			metaAttributes = new ArrayList<MetaAttribute>();
		}
		return metaAttributes;
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
		final Iterator<MetaAttribute> it = getMetaAttributeIterator();
		while (it.hasNext()) {
			buff.append("\r\t\t");
			buff.append(it.next().toString());
		}
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
		buff.append("<MetaEntity name='");
		buff.append(getName());
		buff.append("'>");
		final Iterator<MetaAttribute> it = getMetaAttributeIterator();
		while (it.hasNext()) {
			buff.append("\r\t\t");
			buff.append(it.next().toXML());
		}
		buff.append("\r\t</MetaEntity>");
		return buff.toString();
	}

}
