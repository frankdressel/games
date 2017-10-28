/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.Zug;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spiel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link raumschachmodell.modell.Spiel#getBeschreibung <em>Beschreibung</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getSpieler <em>Spieler</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getId <em>Id</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getZuege <em>Zuege</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getActive <em>Active</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getFigures <em>Figures</em>}</li>
 *   <li>{@link raumschachmodell.modell.Spiel#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel()
 * @model
 * @generated
 */
public interface Spiel extends EObject {
    /**
     * Returns the value of the '<em><b>Beschreibung</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Beschreibung</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Beschreibung</em>' attribute.
     * @see #setBeschreibung(String)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Beschreibung()
     * @model
     * @generated
     */
    String getBeschreibung();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spiel#getBeschreibung <em>Beschreibung</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Beschreibung</em>' attribute.
     * @see #getBeschreibung()
     * @generated
     */
    void setBeschreibung(String value);

    /**
     * Returns the value of the '<em><b>Spieler</b></em>' reference list.
     * The list contents are of type {@link raumschachmodell.modell.Spieler}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Spieler</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Spieler</em>' reference list.
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Spieler()
     * @model
     * @generated
     */
    EList<Spieler> getSpieler();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(long)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Id()
     * @model required="true"
     * @generated
     */
    long getId();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spiel#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(long value);

    /**
     * Returns the value of the '<em><b>Zuege</b></em>' reference list.
     * The list contents are of type {@link spielfeld.Zug}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zuege</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zuege</em>' reference list.
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Zuege()
     * @model
     * @generated
     */
    EList<Zug> getZuege();

    /**
     * Returns the value of the '<em><b>Fields</b></em>' reference list.
     * The list contents are of type {@link spielfeld.Field}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fields</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' reference list.
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Fields()
     * @model lower="125" upper="125"
     * @generated
     */
    EList<Field> getFields();

    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute.
     * The literals are from the enumeration {@link spielfeld.Farbe}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active</em>' attribute.
     * @see spielfeld.Farbe
     * @see #setActive(Farbe)
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Active()
     * @model required="true"
     * @generated
     */
    Farbe getActive();

    /**
     * Sets the value of the '{@link raumschachmodell.modell.Spiel#getActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see spielfeld.Farbe
     * @see #getActive()
     * @generated
     */
    void setActive(Farbe value);

    /**
     * Returns the value of the '<em><b>Figures</b></em>' reference list.
     * The list contents are of type {@link spielfeld.Figur}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Figures</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Figures</em>' reference list.
     * @see raumschachmodell.modell.RaumschachModellPackage#getSpiel_Figures()
     * @model lower="40" upper="40"
     * @generated
     */
    EList<Figur> getFigures();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void reset();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model many="false"
     */
    List<Figur> createCopy();

} // Spiel
