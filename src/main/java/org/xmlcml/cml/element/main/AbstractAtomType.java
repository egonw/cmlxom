package org.xmlcml.cml.element.main;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringSTAttribute;
import org.xmlcml.cml.element.lite.AbstractArray;
import org.xmlcml.cml.element.lite.AbstractAtom;
import org.xmlcml.cml.element.lite.AbstractLabel;
import org.xmlcml.cml.element.lite.AbstractMolecule;
import org.xmlcml.cml.element.lite.AbstractProperty;
import org.xmlcml.cml.element.lite.AbstractScalar;
import org.xmlcml.cml.element.lite.CMLArray;
import org.xmlcml.cml.element.lite.CMLAtom;
import org.xmlcml.cml.element.lite.CMLLabel;
import org.xmlcml.cml.element.lite.CMLMolecule;
import org.xmlcml.cml.element.lite.CMLProperty;
import org.xmlcml.cml.element.lite.CMLScalar;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractAtomType extends CMLElement {
    /** local name*/
    public final static String TAG = "atomType";
    /** constructor. */    public AbstractAtomType() {
        super("atomType");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractAtomType(AbstractAtomType old) {
        super((CMLElement) old);
    }
// attribute:   name

    /** cache */
    StringSTAttribute _att_name = null;
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @return CMLAttribute
    */
    public CMLAttribute getNameAttribute() {
        return (CMLAttribute) getAttribute("name");
    }
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @return String
    */
    public String getName() {
        StringSTAttribute att = (StringSTAttribute) this.getNameAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setName(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_name == null) {
            _att_name = (StringSTAttribute) attributeFactory.getAttribute("name", "atomType");
            if (_att_name == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : name probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_name);
        super.addRemove(att, value);
    }
// attribute:   ref

    /** cache */
    RefAttribute _att_ref = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getRefAttribute() {
        return (CMLAttribute) getAttribute("ref");
    }
    /** null
    * @return String
    */
    public String getRef() {
        RefAttribute att = (RefAttribute) this.getRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRef(String value) throws RuntimeException {
        RefAttribute att = null;
        if (_att_ref == null) {
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "atomType");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   atomRef

    /** cache */
    StringSTAttribute _att_atomref = null;
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefAttribute() {
        return (CMLAttribute) getAttribute("atomRef");
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return String
    */
    public String getAtomRef() {
        StringSTAttribute att = (StringSTAttribute) this.getAtomRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_atomref == null) {
            _att_atomref = (StringSTAttribute) attributeFactory.getAttribute("atomRef", "atomType");
            if (_att_atomref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_atomref);
        super.addRemove(att, value);
    }
// attribute:   title

    /** cache */
    StringSTAttribute _att_title = null;
    /** A title on an element.
    * No controlled value.
    * @return CMLAttribute
    */
    public CMLAttribute getTitleAttribute() {
        return (CMLAttribute) getAttribute("title");
    }
    /** A title on an element.
    * No controlled value.
    * @return String
    */
    public String getTitle() {
        StringSTAttribute att = (StringSTAttribute) this.getTitleAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A title on an element.
    * No controlled value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTitle(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_title == null) {
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "atomType");
            if (_att_title == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : title probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_title);
        super.addRemove(att, value);
    }
// attribute:   id

    /** cache */
    IdAttribute _att_id = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getIdAttribute() {
        return (CMLAttribute) getAttribute("id");
    }
    /** null
    * @return String
    */
    public String getId() {
        IdAttribute att = (IdAttribute) this.getIdAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setId(String value) throws RuntimeException {
        IdAttribute att = null;
        if (_att_id == null) {
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "atomType");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
        super.addRemove(att, value);
    }
// attribute:   convention

    /** cache */
    StringSTAttribute _att_convention = null;
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @return CMLAttribute
    */
    public CMLAttribute getConventionAttribute() {
        return (CMLAttribute) getAttribute("convention");
    }
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @return String
    */
    public String getConvention() {
        StringSTAttribute att = (StringSTAttribute) this.getConventionAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConvention(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_convention == null) {
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "atomType");
            if (_att_convention == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : convention probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_convention);
        super.addRemove(att, value);
    }
// attribute:   dictRef

    /** cache */
    DictRefAttribute _att_dictref = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getDictRefAttribute() {
        return (CMLAttribute) getAttribute("dictRef");
    }
    /** null
    * @return String
    */
    public String getDictRef() {
        DictRefAttribute att = (DictRefAttribute) this.getDictRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDictRef(String value) throws RuntimeException {
        DictRefAttribute att = null;
        if (_att_dictref == null) {
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "atomType");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// element:   molecule

    /** null
    * @param molecule child to add
    */
    public void addMolecule(AbstractMolecule molecule) {
        molecule.detach();
        this.appendChild(molecule);
    }
    /** null
    * @return CMLElements<CMLMolecule>
    */
    public CMLElements<CMLMolecule> getMoleculeElements() {
        Elements elements = this.getChildElements("molecule", CML_NS);
        return new CMLElements<CMLMolecule>(elements);
    }
// element:   atom

    /** null
    * @param atom child to add
    */
    public void addAtom(AbstractAtom atom) {
        atom.detach();
        this.appendChild(atom);
    }
    /** null
    * @return CMLElements<CMLAtom>
    */
    public CMLElements<CMLAtom> getAtomElements() {
        Elements elements = this.getChildElements("atom", CML_NS);
        return new CMLElements<CMLAtom>(elements);
    }
// element:   label

    /** null
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** null
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   scalar

    /** null
    * @param scalar child to add
    */
    public void addScalar(AbstractScalar scalar) {
        scalar.detach();
        this.appendChild(scalar);
    }
    /** null
    * @return CMLElements<CMLScalar>
    */
    public CMLElements<CMLScalar> getScalarElements() {
        Elements elements = this.getChildElements("scalar", CML_NS);
        return new CMLElements<CMLScalar>(elements);
    }
// element:   array

    /** null
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** null
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CML_NS);
        return new CMLElements<CMLArray>(elements);
    }
// element:   matrix

    /** null
    * @param matrix child to add
    */
    public void addMatrix(AbstractMatrix matrix) {
        matrix.detach();
        this.appendChild(matrix);
    }
    /** null
    * @return CMLElements<CMLMatrix>
    */
    public CMLElements<CMLMatrix> getMatrixElements() {
        Elements elements = this.getChildElements("matrix", CML_NS);
        return new CMLElements<CMLMatrix>(elements);
    }
// element:   property

    /** null
    * @param property child to add
    */
    public void addProperty(AbstractProperty property) {
        property.detach();
        this.appendChild(property);
    }
    /** null
    * @return CMLElements<CMLProperty>
    */
    public CMLElements<CMLProperty> getPropertyElements() {
        Elements elements = this.getChildElements("property", CML_NS);
        return new CMLElements<CMLProperty>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("name")) {
            setName(value);
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("atomRef")) {
            setAtomRef(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}