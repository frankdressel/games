/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see raumschachmodell.modell.RaumschachModellFactory
 * @model kind="package"
 * @generated
 */
public interface RaumschachModellPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "raumschachmodell";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://raumschachmodell.modell/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "raumschachmodell.modell";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RaumschachModellPackage eINSTANCE = raumschachmodell.modell.impl.RaumschachModellPackageImpl.init();

    /**
     * The meta object id for the '{@link raumschachmodell.modell.impl.SpielImpl <em>Spiel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see raumschachmodell.modell.impl.SpielImpl
     * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getSpiel()
     * @generated
     */
    int SPIEL = 0;

    /**
     * The feature id for the '<em><b>Beschreibung</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__BESCHREIBUNG = 0;

    /**
     * The feature id for the '<em><b>Spieler</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__SPIELER = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__ID = 2;

    /**
     * The feature id for the '<em><b>Zuege</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__ZUEGE = 3;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__ACTIVE = 4;

    /**
     * The feature id for the '<em><b>Figures</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__FIGURES = 5;

    /**
     * The feature id for the '<em><b>Fields</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL__FIELDS = 6;

    /**
     * The number of structural features of the '<em>Spiel</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIEL_FEATURE_COUNT = 7;

    /**
     * The meta object id for the '{@link raumschachmodell.modell.impl.SpielerImpl <em>Spieler</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see raumschachmodell.modell.impl.SpielerImpl
     * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getSpieler()
     * @generated
     */
    int SPIELER = 1;

    /**
     * The feature id for the '<em><b>Farbe</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIELER__FARBE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIELER__ID = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIELER__NAME = 2;

    /**
     * The feature id for the '<em><b>State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIELER__STATE = 3;

    /**
     * The number of structural features of the '<em>Spieler</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPIELER_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link raumschachmodell.modell.State <em>State</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see raumschachmodell.modell.State
     * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getState()
     * @generated
     */
    int STATE = 2;

    /**
     * The meta object id for the '<em>EKoordinate</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.Koordinate
     * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getEKoordinate()
     * @generated
     */
    int EKOORDINATE = 3;


    /**
     * Returns the meta object for class '{@link raumschachmodell.modell.Spiel <em>Spiel</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spiel</em>'.
     * @see raumschachmodell.modell.Spiel
     * @generated
     */
    EClass getSpiel();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spiel#getBeschreibung <em>Beschreibung</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Beschreibung</em>'.
     * @see raumschachmodell.modell.Spiel#getBeschreibung()
     * @see #getSpiel()
     * @generated
     */
    EAttribute getSpiel_Beschreibung();

    /**
     * Returns the meta object for the reference list '{@link raumschachmodell.modell.Spiel#getSpieler <em>Spieler</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Spieler</em>'.
     * @see raumschachmodell.modell.Spiel#getSpieler()
     * @see #getSpiel()
     * @generated
     */
    EReference getSpiel_Spieler();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spiel#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see raumschachmodell.modell.Spiel#getId()
     * @see #getSpiel()
     * @generated
     */
    EAttribute getSpiel_Id();

    /**
     * Returns the meta object for the reference list '{@link raumschachmodell.modell.Spiel#getFigures <em>Figures</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Figures</em>'.
     * @see raumschachmodell.modell.Spiel#getFigures()
     * @see #getSpiel()
     * @generated
     */
    EReference getSpiel_Figures();

    /**
     * Returns the meta object for the reference list '{@link raumschachmodell.modell.Spiel#getZuege <em>Zuege</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Zuege</em>'.
     * @see raumschachmodell.modell.Spiel#getZuege()
     * @see #getSpiel()
     * @generated
     */
    EReference getSpiel_Zuege();

    /**
     * Returns the meta object for the reference list '{@link raumschachmodell.modell.Spiel#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Fields</em>'.
     * @see raumschachmodell.modell.Spiel#getFields()
     * @see #getSpiel()
     * @generated
     */
    EReference getSpiel_Fields();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spiel#getActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see raumschachmodell.modell.Spiel#getActive()
     * @see #getSpiel()
     * @generated
     */
    EAttribute getSpiel_Active();

    /**
     * Returns the meta object for class '{@link raumschachmodell.modell.Spieler <em>Spieler</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spieler</em>'.
     * @see raumschachmodell.modell.Spieler
     * @generated
     */
    EClass getSpieler();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spieler#getFarbe <em>Farbe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Farbe</em>'.
     * @see raumschachmodell.modell.Spieler#getFarbe()
     * @see #getSpieler()
     * @generated
     */
    EAttribute getSpieler_Farbe();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spieler#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see raumschachmodell.modell.Spieler#getId()
     * @see #getSpieler()
     * @generated
     */
    EAttribute getSpieler_Id();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spieler#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see raumschachmodell.modell.Spieler#getName()
     * @see #getSpieler()
     * @generated
     */
    EAttribute getSpieler_Name();

    /**
     * Returns the meta object for the attribute '{@link raumschachmodell.modell.Spieler#getState <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>State</em>'.
     * @see raumschachmodell.modell.Spieler#getState()
     * @see #getSpieler()
     * @generated
     */
    EAttribute getSpieler_State();

    /**
     * Returns the meta object for enum '{@link raumschachmodell.modell.State <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>State</em>'.
     * @see raumschachmodell.modell.State
     * @generated
     */
    EEnum getState();

    /**
     * Returns the meta object for data type '{@link spielfeld.Koordinate <em>EKoordinate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>EKoordinate</em>'.
     * @see spielfeld.Koordinate
     * @model instanceClass="spielfeld.Koordinate"
     * @generated
     */
    EDataType getEKoordinate();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RaumschachModellFactory getRaumschachModellFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link raumschachmodell.modell.impl.SpielImpl <em>Spiel</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see raumschachmodell.modell.impl.SpielImpl
         * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getSpiel()
         * @generated
         */
        EClass SPIEL = eINSTANCE.getSpiel();

        /**
         * The meta object literal for the '<em><b>Beschreibung</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIEL__BESCHREIBUNG = eINSTANCE.getSpiel_Beschreibung();

        /**
         * The meta object literal for the '<em><b>Spieler</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPIEL__SPIELER = eINSTANCE.getSpiel_Spieler();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIEL__ID = eINSTANCE.getSpiel_Id();

        /**
         * The meta object literal for the '<em><b>Figures</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPIEL__FIGURES = eINSTANCE.getSpiel_Figures();

        /**
         * The meta object literal for the '<em><b>Zuege</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPIEL__ZUEGE = eINSTANCE.getSpiel_Zuege();

        /**
         * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPIEL__FIELDS = eINSTANCE.getSpiel_Fields();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIEL__ACTIVE = eINSTANCE.getSpiel_Active();

        /**
         * The meta object literal for the '{@link raumschachmodell.modell.impl.SpielerImpl <em>Spieler</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see raumschachmodell.modell.impl.SpielerImpl
         * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getSpieler()
         * @generated
         */
        EClass SPIELER = eINSTANCE.getSpieler();

        /**
         * The meta object literal for the '<em><b>Farbe</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIELER__FARBE = eINSTANCE.getSpieler_Farbe();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIELER__ID = eINSTANCE.getSpieler_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIELER__NAME = eINSTANCE.getSpieler_Name();

        /**
         * The meta object literal for the '<em><b>State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPIELER__STATE = eINSTANCE.getSpieler_State();

        /**
         * The meta object literal for the '{@link raumschachmodell.modell.State <em>State</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see raumschachmodell.modell.State
         * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getState()
         * @generated
         */
        EEnum STATE = eINSTANCE.getState();

        /**
         * The meta object literal for the '<em>EKoordinate</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.Koordinate
         * @see raumschachmodell.modell.impl.RaumschachModellPackageImpl#getEKoordinate()
         * @generated
         */
        EDataType EKOORDINATE = eINSTANCE.getEKoordinate();

    }

} //RaumschachModellPackage
