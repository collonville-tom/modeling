package org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator;

import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.instance.IInstance;

/**
 * InstanceIterator.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class InstanceIterator<T extends IInstance> implements Iterator<T> {

	/**
	 * List<T> instances.
	 */
	private List<T> instances = null;

	/**
	 * Iterator<T> iterator.
	 */
	private Iterator<T> iterator = null;

	/**
	 * InstanceIterator constructor.
	 * @param instances List<T>
	 */
	public InstanceIterator(final List<T> instances) {
		super();
		this.iterator = instances.iterator();
		this.instances = instances;

	}

	/**
	 * add.
	 * @param instance T
	 */
	public void add(final T instance) {
		this.instances.add(instance);

	}

	/**
	 * getInstanceAt.
	 * @param cible String
	 * @return T
	 * @throws InstanceIteratorException
	 */
	public T getInstanceAt(final String cible) throws InstanceIteratorException {
		return this.instances.get(this.getRelationPosition(cible));
	}

	/**
	 * getIterator.
	 * @return Iterator<T>
	 */
	private Iterator<T> getIterator() {
		return this.iterator;
	}

	/**
	 * getRelationPosition.
	 * @param name String
	 * @return int
	 * @throws InstanceIteratorException
	 */
	public int getRelationPosition(final String name) throws InstanceIteratorException {
		int index = -1;
		while (this.hasNext()) {
			index = index + 1;
			if (this.next().getName().compareTo(name) == 0) {
				return index;
			}
		}
		throw (new InstanceIteratorException("String: " + name + ". Cet element n'existe pas."));
	}

	/**
	 * @return boolean
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {

		return this.getIterator().hasNext();
	}

	/**
	 * @return  T
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
		return this.getIterator().next();

	}

	/**
	 *
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		this.getIterator().remove();

	}

	/**
	 * remove.
	 * @param instance T
	 */
	public void remove(final T instance) {
		this.instances.remove(instance);

	}

}
