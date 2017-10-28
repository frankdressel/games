/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see raumschachmodell.modell.RaumschachModellPackage#getState()
 * @model
 * @generated
 */
public enum State implements Enumerator {
    /**
     * The '<em><b>Schach</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SCHACH_VALUE
     * @generated
     * @ordered
     */
    SCHACH(0, "schach", "schach"),

    /**
     * The '<em><b>Matt</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MATT_VALUE
     * @generated
     * @ordered
     */
    MATT(1, "matt", "matt"),

    /**
     * The '<em><b>Remis</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REMIS_VALUE
     * @generated
     * @ordered
     */
    REMIS(2, "remis", "remis"),

    /**
     * The '<em><b>Ok</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OK_VALUE
     * @generated
     * @ordered
     */
    OK(3, "ok", "ok");

    /**
     * The '<em><b>Schach</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Schach</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SCHACH
     * @model name="schach"
     * @generated
     * @ordered
     */
    public static final int SCHACH_VALUE = 0;

    /**
     * The '<em><b>Matt</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Matt</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MATT
     * @model name="matt"
     * @generated
     * @ordered
     */
    public static final int MATT_VALUE = 1;

    /**
     * The '<em><b>Remis</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Remis</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REMIS
     * @model name="remis"
     * @generated
     * @ordered
     */
    public static final int REMIS_VALUE = 2;

    /**
     * The '<em><b>Ok</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Ok</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OK
     * @model name="ok"
     * @generated
     * @ordered
     */
    public static final int OK_VALUE = 3;

    /**
     * An array of all the '<em><b>State</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final State[] VALUES_ARRAY =
        new State[] {
            SCHACH,
            MATT,
            REMIS,
            OK,
        };

    /**
     * A public read-only list of all the '<em><b>State</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<State> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>State</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static State get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            State result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>State</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static State getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            State result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>State</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static State get(int value) {
        switch (value) {
            case SCHACH_VALUE: return SCHACH;
            case MATT_VALUE: return MATT;
            case REMIS_VALUE: return REMIS;
            case OK_VALUE: return OK;
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
    private State(int value, String name, String literal) {
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
    
} //State
