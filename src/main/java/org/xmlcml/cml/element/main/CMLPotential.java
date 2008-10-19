package org.xmlcml.cml.element.main;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting potential. * autogenerated from schema use
 * as a shell which can be edited
 *
 */
public class CMLPotential extends AbstractPotential {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLPotential() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLPotential(CMLPotential old) {
        super((AbstractPotential) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLPotential(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLPotential
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLPotential();

    }
}