/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Farbe</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see spielfeld.SpielfeldPackage#getFarbe()
 * @model
 * @generated
 */
public enum Farbe implements Enumerator {
    /**
     * The '<em><b>Orange</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ORANGE_VALUE
     * @generated
     * @ordered
     */
    ORANGE(0, "orange", "orange"),

    /**
     * The '<em><b>Grau</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #GRAU_VALUE
     * @generated
     * @ordered
     */
    GRAU(1, "grau", "grau"),

    /**
     * The '<em><b>Beide</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BEIDE_VALUE
     * @generated
     * @ordered
     */
    BEIDE(2, "beide", "beide"), /**
     * The '<em><b>Unset</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNSET_VALUE
     * @generated
     * @ordered
     */
    UNSET(3, "unset", "unset");

    /**
     * The '<em><b>Orange</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Orange</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ORANGE
     * @model name="orange"
     * @generated
     * @ordered
     */
    public static final int ORANGE_VALUE = 0;

    /**
     * The '<em><b>Grau</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Grau</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #GRAU
     * @model name="grau"
     * @generated
     * @ordered
     */
    public static final int GRAU_VALUE = 1;

    /**
     * The '<em><b>Beide</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Beide</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BEIDE
     * @model name="beide"
     * @generated
     * @ordered
     */
    public static final int BEIDE_VALUE = 2;

    /**
     * The '<em><b>Unset</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Unset</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNSET
     * @model name="unset"
     * @generated
     * @ordered
     */
    public static final int UNSET_VALUE = 3;

    /**
     * An array of all the '<em><b>Farbe</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final Farbe[] VALUES_ARRAY =
        new Farbe[] {
            ORANGE,
            GRAU,
            BEIDE,
            UNSET,
        };

    /**
     * A public read-only list of all the '<em><b>Farbe</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<Farbe> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Farbe</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Farbe get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Farbe result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Farbe</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Farbe getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Farbe result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Farbe</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Farbe get(int value) {
        switch (value) {
            case ORANGE_VALUE: return ORANGE;
            case GRAU_VALUE: return GRAU;
            case BEIDE_VALUE: return BEIDE;
            case UNSET_VALUE: return UNSET;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private Farbe(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //Farbe
