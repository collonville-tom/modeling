package org.tc.osgi.bundle.fwmetamodel.core.instance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator.InstanceIterator;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaRelation;

/*
 * Model.java.
 * 
 * @author thomas collonvillé
 * 
 * @version 0.0.1
 */
public class Model extends AbstractInstance<MetaModel> {

	/*
	 * List<Attribute> attribute.
	 */
	private List<Attribute> attribute = null;
	/*
	 * List<Entity> entity.
	 */
	private List<Entity> entity = null;
	/*
	 * List<Relation> relation.
	 */
	private List<Relation> relation = null;

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
	 * addEntity.
	 * 
	 * @param entity Entity
	 * 
	 * @return boolean
	 */
	public boolean addEntity(final Entity entity) {
		final Iterator it = getType().getMetaEntityIterator();
		boolean isFind = false;
		while (it.hasNext()) {
			if (((MetaEntity) it.next()).equals(entity.getType())) {
				getEntity().add(entity);
				isFind = true;
			}

		}
		return isFind;

	}

	/*
	 * addRelation.
	 * 
	 * @param relation Relation
	 * 
	 * @return boolean
	 */
	public boolean addRelation(final Relation relation) {
		final Iterator it = getType().getMetaRelationIterator();
		boolean isFind = false;
		while (it.hasNext()) {
			if (((MetaRelation) it.next()).equals(relation.getType())) {
				getRelation().add(relation);
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
	 * getEntity.
	 * 
	 * @return List<Entity>
	 */
	public List<Entity> getEntity() {
		if (entity == null) {
			entity = new ArrayList<Entity>();
		}
		return entity;
	}

	/*
	 * getEntityIterator.
	 * 
	 * @return InstanceIterator<Entity>
	 */
	public InstanceIterator<Entity> getEntityIterator() {
		return new InstanceIterator<Entity>(getEntity());
	}

	/*
	 * getRelation.
	 * 
	 * @return List<Relation>
	 */
	public List<Relation> getRelation() {
		if (relation == null) {
			relation = new ArrayList<Relation>();
		}
		return relation;
	}

	/*
	 * getRelationIterator.
	 * 
	 * @return InstanceIterator<Relation>
	 */
	public InstanceIterator<Relation> getRelationIterator() {
		return new InstanceIterator<Relation>(getRelation());
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
		buff.append("|entity:");
		final Iterator itEntity = getEntityIterator();
		while (itEntity.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((Entity) itEntity.next()).getName());
		}
		buff.append("{attributes:");
		final Iterator it = getAttributeIterator();
		while (it.hasNext()) {
			buff.append("\r\t\t");
			buff.append(((Attribute) it.next()).toString());
		}
		final Iterator itRelation = getRelationIterator();
		while (itRelation.hasNext()) {
			buff.append("\r\t");
			buff.append(((Relation) itRelation.next()).toString());
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
		final Iterator itAttribute = getAttributeIterator();
		while (itAttribute.hasNext()) {
			buff.append("\r\t");
			buff.append(((Attribute) itAttribute.next()).toXML());
		}
		final Iterator itEntity = getEntityIterator();
		while (itEntity.hasNext()) {
			buff.append("\r\t");
			buff.append(((Entity) itEntity.next()).toXML());
		}
		final Iterator itRelation = getRelationIterator();
		while (itRelation.hasNext()) {
			buff.append("\r\t");
			buff.append(((Relation) itRelation.next()).toXML());
		}
		buff.append("\r</");
		buff.append(getType().getName());
		buff.append(">");
		return buff.toString();
	}
}
