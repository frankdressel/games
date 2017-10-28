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
 * A representation of the model object '<em><b>Figur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.Figur#getName <em>Name</em>}</li>
 *   <li>{@link spielfeld.Figur#getId <em>Id</em>}</li>
 *   <li>{@link spielfeld.Figur#getZugsetNormal <em>Zugset Normal</em>}</li>
 *   <li>{@link spielfeld.Figur#getZugsetAngriff <em>Zugset Angriff</em>}</li>
 *   <li>{@link spielfeld.Figur#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getFigur()
 * @model
 * @generated
 */
public interface Figur extends ColoredSelectable {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see spielfeld.SpielfeldPackage#getFigur_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link spielfeld.Figur#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A unique id for the figure.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see spielfeld.SpielfeldPackage#getFigur_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link spielfeld.Figur#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Zugset Normal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zugset Normal</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zugset Normal</em>' reference.
     * @see #setZugsetNormal(Zugset)
     * @see spielfeld.SpielfeldPackage#getFigur_ZugsetNormal()
     * @model required="true" transient="true"
     * @generated
     */
    Zugset getZugsetNormal();

    /**
     * Sets the value of the '{@link spielfeld.Figur#getZugsetNormal <em>Zugset Normal</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zugset Normal</em>' reference.
     * @see #getZugsetNormal()
     * @generated
     */
    void setZugsetNormal(Zugset value);

    /**
     * Returns the value of the '<em><b>Zugset Angriff</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zugset Angriff</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zugset Angriff</em>' reference.
     * @see #setZugsetAngriff(Zugset)
     * @see spielfeld.SpielfeldPackage#getFigur_ZugsetAngriff()
     * @model required="true" transient="true"
     * @generated
     */
    Zugset getZugsetAngriff();

    /**
     * Sets the value of the '{@link spielfeld.Figur#getZugsetAngriff <em>Zugset Angriff</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zugset Angriff</em>' reference.
     * @see #getZugsetAngriff()
     * @generated
     */
    void setZugsetAngriff(Zugset value);

    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * True, if the Figure is still in the game (and not taken out already).
     * <!-- end-model-doc -->
     * @return the value of the '<em>Active</em>' attribute.
     * @see #setActive(boolean)
     * @see spielfeld.SpielfeldPackage#getFigur_Active()
     * @model default="true" required="true"
     * @generated
     */
    boolean isActive();

    /**
     * Sets the value of the '{@link spielfeld.Figur#isActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive(boolean value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void bewegen(Koordinate zug);

} // Figur
