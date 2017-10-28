/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell;

import org.eclipse.emf.ecore.EObject;

import spielfeld.Farbe;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spieler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link raumschachmodell.modell.Spieler#getFarbe <em>Farbe</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spieler#getId <em>Id</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spieler#getName <em>Name</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spieler#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see raumschachmodell.modell.RaumschachModellPackage#getSpieler()
 * @model
 * @generated
 */
public interface Spieler extends EObject {
    /**
     * Returns the value of the '<em><b>Farbe</b></em>' attribute.
     * The literals are from the enumeration {@link spielfeld.Farbe}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Farbe</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Farbe</em>' attribute.
     * @see spielfeld.Farbe
     * @see #setFarbe(Farbe)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpieler_Farbe()
     * @model required="true"
     * @generated
     */
    Farbe getFarbe();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spieler#getFarbe <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Farbe</em>' attribute.
     * @see spielfeld.Farbe
     * @see #getFarbe()
     * @generated
     */
    void setFarbe(Farbe value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpieler_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spieler#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

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
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpieler_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spieler#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>State</b></em>' attribute.
     * The literals are from the enumeration {@link raumschachmodell.modell.State}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>State</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>State</em>' attribute.
     * @see raumschachmodell.modell.State
     * @see #setState(State)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpieler_State()
     * @model required="true"
     * @generated
     */
    State getState();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spieler#getState <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>State</em>' attribute.
     * @see raumschachmodell.modell.State
     * @see #getState()
     * @generated
     */
    void setState(State value);

} // Spieler
