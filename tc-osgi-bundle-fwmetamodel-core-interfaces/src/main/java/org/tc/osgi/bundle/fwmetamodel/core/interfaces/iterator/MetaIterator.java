package org.tc.osgi.bundle.fwmetamodel.core.interfaces.iterator;

import java.util.Iterator;
import java.util.List;

import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.MetaIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.type.IType;

/**
 * MetaIterator.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaIterator<T extends IType> implements Iterator<T> {

	/**
	 * Iterator<T> iterator.
	 */
	private final Iterator<T> iterator;

	/**
	 * MetaIterator constructor.
	 * @param list ArrayList<T>
	 * @param type  Type<? extends Instance>
	 */
	public MetaIterator(final List<T> list) {
		super();
		this.iterator = list.iterator();

	}

	/**
	 * getIterator.
	 * @return Iterator<T>
	 */
	public Iterator<T> getIterator() {
		return this.iterator;
	}

	/**
	 * getPosition.
	 * @param name String
	 * @return int
	 * @throws MetaIteratorException
	 */
	public int getPosition(final String name) throws MetaIteratorException {
		int index = -1;
		while (this.hasNext()) {
			index = index + 1;
			if (this.next().getName().compareTo(name) == 0) {
				return index;
			}
		}
		throw new MetaIteratorException("String: " + name + ". Cet element n'existe pas.");
	}

	/**
	 * @return boolean
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	/**
	 * @return T
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
		return this.iterator.next();
	}

	/**
	 *
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		this.iterator.remove();
	}
}
