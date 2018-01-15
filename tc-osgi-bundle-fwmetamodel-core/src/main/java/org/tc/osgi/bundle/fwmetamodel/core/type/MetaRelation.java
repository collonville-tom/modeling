package org.tc.osgi.bundle.fwmetamodel.core.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.instance.Relation;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.MetaIterator;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaEntited;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaRelated;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;

/**
 * MetaRelation.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaRelation extends AbstractType<Relation> implements IMetaRelation<MetaAttribute, MetaEntity> {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = -1584323500479704753L;
	/**
	 * ArrayList<MetaAttribute> metaAttributes.
	 */
	private List<MetaAttribute> metaAttributes = null;
	/**
	 * ArrayList<MetaEntity> metaEntity.
	 */
	private List<MetaEntity> metaEntity = null;

	/**
	 * MetaRelation constructor.
	 * @param name String
	 */
	public MetaRelation(final String name) {
		super(name);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Creation MR " + getName());
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
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Ajout MA " + meta.getName());
	}

	/**
	 * addMetaEntity.
	 * @param meta MetaEntity
	 */
	public void addMetaEntity(final MetaEntity meta) {
		if (metaEntity == null) {
			metaEntity = new ArrayList<MetaEntity>();
		}
		metaEntity.add(meta);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Ajout ME " + meta.getName());
	}

	/**
	 * @param name String
	 * @return Relation<MetaRelation>
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#create(java.lang.String)
	 */
	@Override
	public Relation create(final String name) {
		final Relation relation = new Relation();
		relation.setName(name);
		relation.setType(this);
		relation.setId(getInstanceCounter());

		getInstanceIterator().add(relation);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Creation R " + relation.getName());
		AbstractType.incGlobalCounter();
		return relation;
	}

	/**
	 * getMetaAttributeIterator.
	 * @return MetaAttributeIterator
	 */
	public Iterator<MetaAttribute> getMetaAttributeIterator() {
		return new MetaIterator<MetaAttribute>(getMetaAttributes());
	}

	/**
	 * getMetaAttributes .
	 * @return List<MetaAttribute>
	 */
	public List<MetaAttribute> getMetaAttributes() {
		if (metaAttributes == null) {
			metaAttributes = new ArrayList<MetaAttribute>();
		}
		return metaAttributes;
	}

	/**
	 * getMetaEntity.
	 * @return List<MetaEntity>
	 */
	public List<MetaEntity> getMetaEntity() {
		if (metaEntity == null) {
			metaEntity = new ArrayList<MetaEntity>();
		}
		return metaEntity;
	}

	/**
	 * getMetaEntityIterator.
	 * @return Iterator<MetaEntity>
	 */
	public Iterator<MetaEntity> getMetaEntityIterator() {
		return new MetaIterator<MetaEntity>(getMetaEntity());
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
		final Iterator itEntity = getMetaEntityIterator();
		while (itEntity.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((MetaEntity) itEntity.next()).getName());
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
		buff.append("<MetaRelation name='");
		buff.append(getName());
		buff.append("'>");
		final Iterator itAttribute = getMetaAttributeIterator();
		while (itAttribute.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((MetaAttribute) itAttribute.next()).toXML());
		}
		final Iterator itEntity = getMetaEntityIterator();
		while (itEntity.hasNext()) {
			buff.append("\r\t\t");
			buff.append("<Link>");
			buff.append(((MetaEntity) itEntity.next()).getName());
			buff.append("</Link>");
		}
		buff.append("\r\t</MetaRelation>");
		return buff.toString();
	}
}
