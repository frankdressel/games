/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Straight Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The move is a straight line, which means it is a multiply of vector and a number. A stright line move stops, if one of the fields in the line is blocked.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.StraightLine#getMaxDist <em>Max Dist</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getStraightLine()
 * @model
 * @generated
 */
public interface StraightLine extends EntityWithPosition {
    /**
     * Returns the value of the '<em><b>Max Dist</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The maximum number, with which the inkrement vector is multiplied.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Max Dist</em>' attribute.
     * @see #setMaxDist(int)
     * @see spielfeld.SpielfeldPackage#getStraightLine_MaxDist()
     * @model required="true"
     * @generated
     */
    int getMaxDist();

    /**
     * Sets the value of the '{@link spielfeld.StraightLine#getMaxDist <em>Max Dist</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Dist</em>' attribute.
     * @see #getMaxDist()
     * @generated
     */
    void setMaxDist(int value);

} // StraightLine
