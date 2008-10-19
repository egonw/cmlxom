package org.xmlcml.cml.element.main;

import java.util.List;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.Transform3;
import org.xmlcml.euclid.Util;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.euclid.Axis.Axis3;
import org.xmlcml.euclid.Transform3.Type;

/**
 * user-modifiable class supporting transform3. * autogenerated from schema use
 * as a shell which can be edited
 * 
 */
public class CMLTransform3 extends AbstractTransform3 {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;
	
    /**
     * transformation matrix size
     */
    public final static int SIZE = 16;

    /**
     * unit matrix
     */
    public final static double[] UNIT44 = { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
            0, 0, 0, 1 };

    /**
     * default constructor. does NOT create unit matrix.
     * do not use, except for reflection
     */
    public CMLTransform3() {
    }

    /**
     * contructor.
     * 
     * @param old
     */
    public CMLTransform3(CMLTransform3 old) {
        super((AbstractTransform3) old);

    }

    /**
     * copy node .
     * 
     * @return Node
     */
    public Node copy() {
        return new CMLTransform3(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     * 
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLTransform3
     */
    public CMLTransform3 makeElementInContext(Element parent) {
        return new CMLTransform3();

    }

    /**
     * check transform has right shape. cannot easily check values here
     * 
     * @param parent
     *            element
     * @throws RuntimeException
     *             parsing error
     */
    public void finishMakingElement(Element parent) throws RuntimeException {
        double[] array = this.getXMLContent();
        if (array == null) {
            throw new RuntimeException("line must not be empty");
        } else if (array.length != SIZE) {
            throw new RuntimeException("line must have 16 double components");
        }
        setMatrix(array);
    }

    // =========================== additional constructors
    // ========================

    /** create from primitive components.
     * 
     * @param transform3
     *            the components (4x4)
     */
    public CMLTransform3(Transform3 transform3) {
        this.setMatrix(transform3.getMatrixAsArray());
    }

    /** create from primitive components.
     * 
     * @param array
     *            the components (4x4)
     * @throws RuntimeException
     *             must be 16 elements
     */
    public CMLTransform3(double[] array) throws RuntimeException {
        this.setMatrix(array);
    }

    /**
     * This gives a default unit matrix of type t.
     * 
     * @param t
     *            type
     */
    public CMLTransform3(Type t) {
        Transform3 teucl3 = new Transform3(t);
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * identity matrix with translation component. T = I|vector
     * 
     * @param v
     *            translation vector
     */
    public CMLTransform3(CMLVector3 v) {
        Transform3 teucl3 = new Transform3(v.getEuclidVector3());
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * from rotation about an axis. (use (Choice3.X), etc
     * 
     * @param axis
     *            1=X, etc
     * @param angle
     *            radians to rotate by
     */
    public CMLTransform3(int axis, double angle) {
        Angle rot = new Angle(angle);
        Axis3 ax = null;
        if (axis == 1) {
            ax = Axis3.X;
        } else if (axis == 2) {
            ax = Axis3.Y;
        } else if (axis == 3) {
            ax = Axis3.Z;
        }
        Transform3 teucl3 = new Transform3(ax, rot);
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * from rotation about the three orthogonal axes. rotX then rotY then rotZ
     * 
     * @param xrot
     *            radians
     * @param yrot
     *            radians
     * @param zrot
     *            radians
     */
    public CMLTransform3(double xrot, double yrot, double zrot) {
        double[] matrix = UNIT44;
        // there is a bug in Transform3 - if all 3 angles are 0
        if (xrot != 0. || yrot != 0. || zrot != 0.0) {
            Transform3 teucl3 = new Transform3(new Angle(xrot),
                    new Angle(yrot), new Angle(zrot));
            matrix = teucl3.getMatrixAsArray();
        }
        this.setMatrix(matrix);
    }

    /**
     * from rotation about a point.
     * 
     * @param t
     *            rotation matrix
     * @param p
     *            point to rotate about
     */
    public CMLTransform3(CMLTransform3 t, CMLPoint3 p) {
        Transform3 teucl3 = new Transform3(t.getEuclidTransform3(), p
                .getEuclidPoint3());
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * from rotation about a vector.
     * 
     * @param v
     *            vector to rotate about
     * @param a
     *            angle to rotate by
     */
    public CMLTransform3(CMLVector3 v, double a) {
        Transform3 teucl3 = new Transform3(v.getEuclidVector3(), new Angle(a));
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * Rotation about a line. chooses any point on line as centre of rotation
     * 
     * @param l
     *            line to rotate about
     * @param a
     *            angle to rotate by in radians
     */
    public CMLTransform3(CMLLine3 l, double a) {
        Transform3 teucl3 = new Transform3(l.getEuclidLine3(), new Angle(a));
        double[] array = teucl3.getMatrixAsArray();
        this.setMatrix(array);
    }

    /**
     * rotation of one vector onto another. this documentation has not been
     * checked
     * 
     * @param v1
     *            vector to rotate
     * @param v2
     *            vector to rotate v1 onto
     * @exception CMLException
     *                <TT>v1</TT> or <TT>v2</TT> is zero length
     */
    public CMLTransform3(CMLVector3 v1, CMLVector3 v2) {
        Transform3 teucl3 = new Transform3(v1.getEuclidVector3(), v2
                .getEuclidVector3());
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * from 3 vector components. NOT checked fills rows of T with v1, v2, v3
     * 
     * @param v1
     *            first row of T
     * @param v2
     *            second row of T
     * @param v3
     *            third row of T
     */
    public CMLTransform3(CMLVector3 v1, CMLVector3 v2, CMLVector3 v3) {
        Transform3 teucl3 = new Transform3(v1.getEuclidVector3(), v2
                .getEuclidVector3(), v3.getEuclidVector3());
        this.setMatrix(teucl3.getMatrixAsArray());
    }

    /**
     * from a crystallographic operator.
     * 
     * @param opString
     *            for example 1/2-x,1/2+y,-z
     */
    public CMLTransform3(String opString) {
        Transform3 teucl3 = new Transform3(opString);
        double[] array = teucl3.getMatrixAsArray();
        // fix bug
        array[15] = 1.0;
        this.setMatrix(array);
    }

    // ====================== housekeeping methods =====================

    /**
     * create new CMLTransform3 from Transform3.
     * 
     * @param tool
     *            to provide document context
     * @param t
     *            Transform3 to create from
     */
    /*--
     static CMLTransform3 createCMLTransform3(Transform3 t) {
     CMLTransform3 tnew = null;
     tnew = new CMLTransform3();
     tnew.setXMLContent(t.getMatrixAsArray());
     return tnew;
     }
     --*/

    // assumes Transform3 != null
    /**
     * gets euclid transform. this may be useful for low level calculations
     * 
     * @return the transform
     */
    public Transform3 getEuclidTransform3() {
        return new Transform3(this.getXMLContent());
    }

    // ====================== main accessors =====================

    /**
     * sets components.
     * 
     * @param matrixAsArray
     *            16 components
     * @throws RuntimeException
     *             matrix must be of length 16
     */
    public void setMatrix(double[] matrixAsArray) throws RuntimeException {
        if (matrixAsArray.length != SIZE) {
            throw new RuntimeException("xyz3 must be of length " + SIZE);
        }
        this.setXMLContent(matrixAsArray);
    }

    /**
     * gets component matrix.
     * 
     * @return 16-component array
     */
    public double[] getMatrixAsArray() {
        Transform3 teucl3 = this.getEuclidTransform3();
        return teucl3.getMatrixAsArray();
    }

    // ====================== functionality =====================

    /**
     * equality of two transforms. based on equality of RealSquareMatrix
     * 
     * @param m
     *            transform to compare
     * @return true if equal within Real.isEqual()
     */
    public boolean isEqualTo(CMLTransform3 m) {
        Transform3 teucl3 = this.getEuclidTransform3();
        return teucl3.isEqualTo(m.getEuclidTransform3());
    }

    /**
     * concatenate. (I think this is right...) result = this * m2 i.e. if x' =
     * m2 * x and x'' = this * x'' then x'' = result * x;
     * 
     * @param m2
     *            transform to be concatenated
     * @return result of applying this to m2
     */
    public CMLTransform3 concatenate(CMLTransform3 m2) {
        Transform3 teucl3 = this.getEuclidTransform3();
        Transform3 t = teucl3.concatenate(m2.getEuclidTransform3());
        CMLTransform3 tt =  new CMLTransform3(t.getMatrixAsArray());
        return tt;
    }

    /**
     * set transformation type.
     * 
     * @param option
     *            the type
     * @return 0 if ok else 1
     */
    public int setTransformationType(Type option) {
        Transform3 teucl3 = this.getEuclidTransform3();
        return teucl3.setTransformationType(option);
    }

    /**
     * get transformation type.
     * 
     * @return the type
     */
    public Type getTransformationType() {
        Transform3 teucl3 = this.getEuclidTransform3();
        return teucl3.getTransformationType();
    }

    /**
     * interpret current matrix as rotation about general axis.
     * 
     * @return double[4] 3 vector components and one angle (radian)
     */
    public double[] getAxisAndAngle() {
        Transform3 teucl3 = this.getEuclidTransform3();
        Vector3 v = new Vector3();
        Angle ang = new Angle();
        teucl3.getAxisAndAngle(v, ang);
        double[] d = new double[4];
        System.arraycopy(v.getArray(), 0, d, 0, 3);
        d[3] = ang.getRadian();
        return d;
    }

    /**
     * get translation component.
     * 
     * @return the translation
     */
    public CMLVector3 getTranslation() {
        Transform3 teucl3 = this.getEuclidTransform3();
        Vector3 v = teucl3.getTranslation();
        return CMLVector3.createCMLVector3(v);
    }

    /**
     * get centre of rotation. if R is rotation and t is translation compute p =
     * ~(I - R) . t
     * 
     * @return the centre
     */
    public CMLPoint3 getCentreOfRotation() {
        Transform3 teucl3 = this.getEuclidTransform3();
        Point3 p = teucl3.getCentreOfRotation();
        return new CMLPoint3(p);
    }

    /**
     * get scales.
     * 
     * @return 3-element RealArray)
     */
    public double[] getScales() {
        Transform3 teucl3 = this.getEuclidTransform3();
        RealArray ra = teucl3.getScales();
        return ra.getArray();
    }

    /**
     * get contents as 3*4 CMLMatrix.
     * 
     * @return the matrix
     */
    public CMLMatrix getMatrix() {
        double[] array = new double[12];
        System.arraycopy(this.getMatrixAsArray(), 0, array, 0, 12);
        return new CMLMatrix(3, 4, array);
    }

    /**
     * does operator have a translation component. true if any operator is of
     * form a+xyz where a is non-zero and xyz is x, y, z this should extract
     * screw axis, glide and centering operations. at present probably only
     * useful for orthorhombic and below
     * 
     * @return true if has component.
     */
    public boolean hasNonZeroTranslationComponent() {
        boolean nonZeroTranslation = false;
        double[] matrix = this.getMatrixAsArray();
        for (int i = 0; i < 3; i++) {
            int offset = 4 * i;
            // non-zero translation
            if (Math.abs(matrix[offset + 3]) > 0.001) {
                for (int j = 0; j < 3; j++) {
                    // non inversion
                    if (matrix[offset + j] > 0.001) {
                        nonZeroTranslation = true;
                        break;
                    }
                }
            }
        }
        return nonZeroTranslation;
    }

    /**
     * does operator have only translation components. true if operators are of
     * form a+x, b+y, c+z where at least one of a, b, c is non-zero this should
     * extract centering operations.
     * 
     * @return true if has component.
     */
    public boolean isPureTranslation() {
        boolean hasTranslation = false;
        boolean unit = true;

        double[] matrix = this.getMatrixAsArray();
        for (int i = 0; i < 3; i++) {
            int offset = 4 * i;
            // at least one non-zero translation
            if (Math.abs(matrix[offset + 3]) > 0.001) {
                hasTranslation = true;
            }
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (Math.abs(matrix[offset + j] - 1.0) > 0.001) {
                        unit = false;
                        break;
                    }
                } else {
                    if (Math.abs(matrix[offset + j]) > 0.001) {
                        unit = false;
                        break;
                    }
                }
            }
        }
        return (unit == true && hasTranslation);
    }

    /**
     * true if transform is unit matrix.
     * 
     * @return true if unit matrix
     */
    public boolean isUnit() {
        boolean unit = true;
        double[] matrix = this.getMatrixAsArray();
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    if (!(Math.abs(matrix[count] - 1.0) < 0.00000000001)) {
                        unit = false;
                        break;
                    }
                } else {
                    if (!(Math.abs(matrix[count]) < 0.00000000001)) {
                        unit = false;
                        break;
                    }
                }
                count++;
            }
        }
        return unit;
    }

    /**
     * gets row. rows 0,1,2 of length 4
     * 
     * @param iRow
     *            row
     * @return copy of row of length 4 or null if bad iRow
     */
    public double[] getRow(int iRow) {
        double row[] = null;
        if (iRow >= 0 && iRow <= 2) {
            row = new double[4];
            double[] matrix = this.getMatrixAsArray();
            System.arraycopy(matrix, 4 * iRow, row, 0, 4);
        }
        return row;
    }

    /**
     * are two matrices equal. compare rows columns and array contents
     * 
     * @param tr2
     *            to compare
     * @param eps
     *            max allowed difference
     * @return true if equal
     */
    public boolean isEqualTo(CMLTransform3 tr2, double eps) {
        return (Util.isEqual(this.getXMLContent(), tr2.getXMLContent(), eps));
    }

    /**
     * adjusts translation to be inside unit cell. range is 0 (inclusive) to 1
     * (exclusive)
     * 
     */
    public void normalizeCrystallographically() {
        double[] dd = this.getXMLContent();
        boolean change = false;
        for (int i = 0; i < 3; i++) {
            double t = dd[4 * i + 3];
            while (t < 0) {
                t += 1.0;
                change = true;
            }
            while (t >= 1.0) {
                t -= 1.0;
                change = true;
            }
            if (change) {
                dd[4 * i + 3] = t;
            }
        }
        if (change) {
            this.setXMLContent(dd);
        }
    }

    /**
     * index of transform in list. compares by content
     * 
     * @param trList
     *            the list
     * @param tr
     *            the search transform
     * @param eps
     *            maximum deviation in elements
     * @return the index or -1 not found
     */
    public static int indexOf(List<CMLTransform3> trList, CMLTransform3 tr,
            double eps) {
        int idx = -1;
        for (int i = 0; i < trList.size(); i++) {
            if (tr.isEqualTo(trList.get(i), eps)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    /**
     * get transformed point.
     * 
     * @param point
     * @return point.
     */
    public Point3 transform(Point3 point) {
        Point3 newPoint = null;
        if (point != null) {
            newPoint = point.transform(this.getEuclidTransform3());
        }
        return newPoint;
    }

    /**
     * to string.
     * 
     * @return string
     */
    public String getString() {
        return this.getEuclidTransform3().toString();
    }

    /** is identity matrix.
     * 
     * @return is identity
     */
    public boolean isIdentity() {
    	if (this.getValue().equals("1.0 0.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 0.0 1.0")) {
    		return true;
    	} else {
    		return false;
    	}
    }
}