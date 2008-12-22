package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParentNode;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLElements;

/**
 * class supporting bondArray.
 *  * autogenerated from schema use
 *  bondArray manages the bonds in the parent molecule.
 *  it always indexes them by atom hash (from atomRefs2) and
 *  will also index by id if present.
 *
 */
public class CMLBondArray extends AbstractBondArray {
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(CMLBondArray.class);
	
    /** namespaced element name.*/
    public final static String NS = C_E+TAG;

    /** messages.*/
    public enum Message {
        /** no parent for bondArray*/
        NULL_BONDARRAY_PARENT("null bondArray parent"),
        ;
        /** value.*/
        public String value;
        private Message(String s) {
            value = s;
        }
    }

    /** map of bond ids to bonds.*/
    Map<String, CMLBond> bondIdMap;
    /** map of atomRefs2 to bonds.*/
    Map<String, CMLBond> bondMap;

//    static int count = 0;
    /**
     * constructor.
     */
    public CMLBondArray() {
        super();
        init();
    }

    private void init() {
        bondMap = new HashMap<String, CMLBond>();
        bondIdMap = new HashMap<String, CMLBond>();
    }

    /**
     * copy constructor.
     * NOTE: this will NOT index the bonds. This is dealt with in
     * the Molecule copy costructor
     * @param old
     */
    public CMLBondArray(CMLBondArray old) {
        super((AbstractBondArray) old);
        init();
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLBondArray(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLBond
     */
    public CMLBondArray makeElementInContext(Element parent) {
        CMLBondArray bondArray = new CMLBondArray();
        return bondArray;
    }

    /** finish making element.
     *
     * @param parent
     *            element
     */
    public void finishMakingElement(Element parent) {
        super.finishMakingElement(parent);
        // this is here because the parser doesn't route through the
        // addBond
        indexBonds();
    }

    /** adds a bond.
     * reroutes to addBond(bond)
     * @param bond to add
     * @return added bond or null
     * @throws RuntimeException if already child or duplicate hash
     */
    public CMLBond appendChild(CMLBond bond) {
        CMLBond bond0 = this.addBond(bond);
        return bond0;
    }

    /** get number of child bonds.
     *
     * @return count
     */
    public int size() {
        return this.getBondElements().size();
    }

    /** adds a bond.
     *
     * cannot add bond unless bondArray already is child of molecule.
     * otherwise it doesn't know how to reference atoms
     * @param bond to add
     * @return added bond or null
     * @throws RuntimeException if already child or duplicate hash or not part of molecule
     */
    public CMLBond addBond(CMLBond bond) {
        int count = this.getChildCount();
        return this.insertBond(bond, count);
    }

    /**
     * adds a bond.
     * will fail if bondArray is not child of molecule
     * @param bond to add
     * @param pos position (see insertChild)
     * @return added bond or null
     * @throws RuntimeException if already child or duplicate hash
     */
    public CMLBond insertBond(CMLBond bond, int pos) {
        ParentNode parent = bond.getParent();
        CMLBond addedBond = null;
        if (parent != null) {
            if (parent.equals(this)) {
                throw new RuntimeException("bond already added "+bond.getString());
            }
        } else {
            if (this.getMolecule() == null) {
                throw new RuntimeException("bondArray parent must be molecule");
            }
        }
        this.insertChild(bond, pos);
        addedBond = indexBondAndLigands(bond);
        indexBondId(bond);
        return addedBond;
    }

    private CMLBond indexBondAndLigands(CMLBond bond) {
        CMLBond addedBond = null;
        String hash = CMLBond.atomHash(bond);
        if (hash != null) {
            if (bondMap.containsKey(hash)) {
                String molId = (bond.getMolecule() == null) ? null : bond.getMolecule().getId();
                throw new RuntimeException("bond already in array "+bond.getId()+S_SLASH+hash+S_SLASH+molId);
            }
            bondMap.put(hash, bond);
            addedBond = bond;
            bond.updateLigands();
        }
        return addedBond;
    }

    private void indexBondId(CMLBond bond) {
        String id = bond.getId();
        if (id != null && !"".equals(id.trim())) {
            if (bondIdMap.containsKey(id)) {
                throw new RuntimeException("bond already in id map "+bond.getId()+S_SLASH+bond.getMolecule().getId());
            }
            bondIdMap.put(id, bond);
        }
    }

    /** index all the bonds by atom hash.
     * and by bond id
     */
    public void indexBonds() {
        CMLMolecule molecule = this.getMolecule();
        if (molecule == null) {
            throw new RuntimeException("Cannot index bonds without molecule");
        }
        CMLAtomArray atomArray = molecule.getAtomArray();
        if (atomArray == null) {
            throw new RuntimeException("Cannot index bonds without atoms");
        }
        atomArray.clearLigandInfo();
        List<CMLBond> bonds = this.getBonds();
        bondMap.clear();
        bondIdMap.clear();
        for (CMLBond bond : bonds) {
//        	try {
        		indexBondAndLigands(bond);
        		indexBondId(bond);
//        	} catch (RuntimeException e) {
//        		LOG.warn("SKIPPED BOND (maybe coincident)");
//        	}
        }
    }

    /** get parent molecule.
     *
     * @return null if no parent or parent is not molecule
     */
    public CMLMolecule getMolecule() {
        CMLMolecule molecule = null;
        ParentNode parent = this.getParent();
        if (parent != null && parent instanceof CMLMolecule) {
            molecule = (CMLMolecule) parent;
        }
        return molecule;
    }

    @SuppressWarnings("unused")
    private CMLAtomArray getAtomArray() {
        CMLMolecule molecule = this.getMolecule();
        return (molecule == null) ? null : molecule.getAtomArray();
    }

    /** adds bond info as ligands to atoms.
     *
     * @param bond
     */
    void updateLigands() {
        List<CMLBond> bondList = this.getBonds();
        for (CMLBond bond : bondList) {
            bond.updateLigands();
        }
    }


    /** removes a bond.
     * reroutes to removeBond(bond)
     * @param bond to remove
     * @return removed bond or null
     * @throws RuntimeException
     */
    public CMLBond removeChild(CMLBond bond) {
        return this.removeBond(bond);
    }

    /**
     * removes a bond.
     *
     * @param bond
     * @return deleted bond or null
     */
    public CMLBond removeBond(CMLBond bond) {
        CMLBond deletedBond = null;
        if (bond != null && this.equals(bond.getParent())) {
            List<CMLAtom> atoms = bond.getAtoms();
            if (atoms != null) {
                int err = 0;
                if (atoms.size() == 2) {
                    try {
                        atoms.get(0).clearLigandInfo(bond, atoms.get(1));
                    } catch (RuntimeException e) {
                        err++;
                    }
                    try {
                        atoms.get(1).clearLigandInfo(bond, atoms.get(0));
                    } catch (RuntimeException e) {
                        err++;
                    }
                    if (err > 0) {
                        System.err.println("trouble removing ligands of "+bond.getString());
                    }
                } else {
                    ;// when we have failed to add bond
                }
            } else {
                ; // is this an error?
            }
            super.removeChild(bond);
            this.getBondMap().remove(CMLBond.atomHash(bond));
            this.getBondIdMap().remove(bond.getId());
        }
        return deletedBond;
    }

    /** get map of bond hash to bonds.
     *
     * @return map
     */
    public Map<String, CMLBond> getBondMap() {
        if (bondMap == null) {
            bondMap = new HashMap<String, CMLBond>();
        }
        return bondMap;
    }

    /** get map of bond id to bonds.
     *
     * @return map
     */
    public Map<String, CMLBond> getBondIdMap() {
        if (bondIdMap == null) {
            bondIdMap = new HashMap<String, CMLBond>();
        }
        return bondIdMap;
    }

    /** get list of bonds in order.
     *
     * @return bonds
     */
    public List<CMLBond> getBonds() {
        List<CMLBond> bondList = new ArrayList<CMLBond>();
        CMLElements<CMLBond> bonds = this.getBondElements();
        for (CMLBond bond : bonds) {
            bondList.add(bond);
        }
        return bondList;
    }

    /** get bond by hash.
     *
     * @param hash
     * @return bond or null
     */
    public CMLBond getBondByHash(String hash) {
        return bondMap.get(hash);
    }

    /** get bond by atomRefs2.
     *
     * @param atomRefs2
     * @return bond or null
     */
    public CMLBond getBondByAtomRefs2(String[] atomRefs2) {
        return bondMap.get(CMLBond.atomHash(atomRefs2));
    }

    /** get bond by id.
     *
     * @param id
     * @return bond or null
     */
    public CMLBond getBondById(String id) {
        return (bondIdMap == null) ? null : bondIdMap.get(id);
    }

    /** reroute to molecule.removeBondArray().
     *
     */
    public void detach() {
        ParentNode parent = this.getParent();
        if (parent != null && parent instanceof CMLMolecule) {
            CMLMolecule molecule = (CMLMolecule) parent;
            molecule.removeBondArray();
        }
    }
}
