/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zugset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.Zugset#getStraightLine <em>Straight Line</em>}</li>
 *   <li>{@link spielfeld.Zugset#getJumps <em>Jumps</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getZugset()
 * @model
 * @generated
 */
public interface Zugset extends EObject {
    /**
     * Returns the value of the '<em><b>Straight Line</b></em>' containment reference list.
     * The list contents are of type {@link spielfeld.StraightLine}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Straight Line</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Straight Line</em>' containment reference list.
     * @see spielfeld.SpielfeldPackage#getZugset_StraightLine()
     * @model containment="true"
     * @generated
     */
    EList<StraightLine> getStraightLine();

    /**
     * Returns the value of the '<em><b>Jumps</b></em>' containment reference list.
     * The list contents are of type {@link spielfeld.Jump}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jumps</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jumps</em>' containment reference list.
     * @see spielfeld.SpielfeldPackage#getZugset_Jumps()
     * @model containment="true"
     * @generated
     */
    EList<Jump> getJumps();

} // Zugset
