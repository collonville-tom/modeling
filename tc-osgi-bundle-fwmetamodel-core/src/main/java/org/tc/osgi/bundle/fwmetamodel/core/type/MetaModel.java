package org.tc.osgi.bundle.fwmetamodel.core.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.instance.Model;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.MetaIterator;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaAttributed;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaEntited;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.semantics.IMetaRelated;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IMetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;

/**
 * MetaModel.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaModel extends AbstractType<Model> implements IMetaModel<MetaAttribute, MetaEntity, MetaRelation> {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 4969835207613134120L;
	/**
	 * List<MetaAttribute> metaAttributes.
	 */
	private List<MetaAttribute> metaAttributes = null;
	/**
	 * List<MetaEntity> metaEntities.
	 */
	private List<MetaEntity> metaEntities = null;
	/**
	 * List<MetaRelation> metaRelations.
	 */
	private List<MetaRelation> metaRelations = null;

	/**
	 * MetaModel constructor.
	 * @param name String
	 */
	public MetaModel(final String name) {
		super(name);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).info("Creation MM " + getName());
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
	 * addMetaEntity.
	 * @param meta MetaEntity
	 */
	public void addMetaEntity(final MetaEntity meta) {
		if (metaEntities == null) {
			metaEntities = new ArrayList<MetaEntity>();
		}
		metaEntities.add(meta);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("Ajout ME " + meta.getName());
	}

	/**
	 * addMetaRelation.
	 * @param meta MetaRelation
	 */
	public void addMetaRelation(final MetaRelation meta) {
		if (metaRelations == null) {
			metaRelations = new ArrayList<MetaRelation>();
		}
		metaRelations.add(meta);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("Ajout MR " + meta.getName());
	}

	/**
	 * @param name String
	 * @return Model
	 * @see org.tc.osgi.bundle.fwmetamodel.core.type.AbstractType#create(java.lang.String)
	 */
	@Override
	public Model create(final String name) {
		final Model model = new Model();
		model.setName(name);
		model.setType(this);
		model.setId(getInstanceCounter());

		getInstanceIterator().add(model);
		LoggerServiceProxy.getInstance().getLogger(this.getClass()).debug("Creation M " + model.getName());
		AbstractType.incGlobalCounter();
		return model;
	}

	/**
	 * getMetaAttributeIterator.
	 * @return MetaAttributeIterator
	 */
	public MetaIterator<MetaAttribute> getMetaAttributeIterator() {
		return new MetaIterator<MetaAttribute>(getMetaAttributes());
	}

	/**
	 * getMetaAttributes.
	 * @return List<MetaAttribute>
	 */
	public List<MetaAttribute> getMetaAttributes() {
		if (metaAttributes == null) {
			metaAttributes = new ArrayList<MetaAttribute>();
		}
		return metaAttributes;
	}

	/**
	 * getMetaEntities.
	 * @return List<MetaEntity>
	 */
	public List<MetaEntity> getMetaEntities() {
		if (metaEntities == null) {
			metaEntities = new ArrayList<MetaEntity>();
		}
		return metaEntities;
	}

	/**
	 * getMetaEntityIterator.
	 * @return MetaEntityIterator
	 */
	public MetaIterator<MetaEntity> getMetaEntityIterator() {
		return new MetaIterator<MetaEntity>(getMetaEntities());
	}

	/**
	 * getMetaRelationIterator.
	 * @return MetaRelationIterator
	 */
	public MetaIterator<MetaRelation> getMetaRelationIterator() {
		return new MetaIterator<MetaRelation>(getMetaRelations());
	}

	/**
	 * getMetaRelations.
	 * @return List<MetaRelation>
	 */
	public List<MetaRelation> getMetaRelations() {
		if (metaRelations == null) {
			metaRelations = new ArrayList<MetaRelation>();
		}
		return metaRelations;
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
		final Iterator itRelation = getMetaRelationIterator();
		while (itRelation.hasNext()) {
			buff.append("\r\t");
			buff.append(((MetaRelation) itRelation.next()).toString());
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
		buff.append("<MetaModel name='");
		buff.append(getName());
		buff.append("'>");
		final Iterator itAttribute = getMetaAttributeIterator();
		while (itAttribute.hasNext()) {
			buff.append("\r\t");
			buff.append(((MetaAttribute) itAttribute.next()).toXML());
		}
		final Iterator itEntity = getMetaEntityIterator();
		while (itEntity.hasNext()) {
			buff.append("\r\t");
			buff.append(((MetaEntity) itEntity.next()).toXML());
		}

		final Iterator itRelation = getMetaRelationIterator();
		while (itRelation.hasNext()) {
			buff.append("\r\t");
			buff.append(((MetaRelation) itRelation.next()).toXML());
		}
		buff.append("\r</MetaModel>");
		return buff.toString();
	}
}
