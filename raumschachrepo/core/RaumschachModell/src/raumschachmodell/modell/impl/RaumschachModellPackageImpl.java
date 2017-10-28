/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import raumschachmodell.modell.RaumschachModellFactory;
import raumschachmodell.modell.RaumschachModellPackage;
import raumschachmodell.modell.Spiel;
import raumschachmodell.modell.Spieler;
import raumschachmodell.modell.State;

import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RaumschachModellPackageImpl extends EPackageImpl implements RaumschachModellPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass spielEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass spielerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum stateEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType eKoordinateEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see raumschachmodell.modell.RaumschachModellPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RaumschachModellPackageImpl() {
        super(eNS_URI, RaumschachModellFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link RaumschachModellPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RaumschachModellPackage init() {
        if (isInited) return (RaumschachModellPackage)EPackage.Registry.INSTANCE.getEPackage(RaumschachModellPackage.eNS_URI);

        // Obtain or create and register package
        RaumschachModellPackageImpl theRaumschachModellPackage = (RaumschachModellPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RaumschachModellPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RaumschachModellPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        SpielfeldPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theRaumschachModellPackage.createPackageContents();

        // Initialize created meta-data
        theRaumschachModellPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRaumschachModellPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RaumschachModellPackage.eNS_URI, theRaumschachModellPackage);
        return theRaumschachModellPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSpiel() {
        return spielEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpiel_Beschreibung() {
        return (EAttribute)spielEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSpiel_Spieler() {
        return (EReference)spielEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpiel_Id() {
        return (EAttribute)spielEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSpiel_Figures() {
        return (EReference)spielEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSpiel_Zuege() {
        return (EReference)spielEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSpiel_Fields() {
        return (EReference)spielEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpiel_Active() {
        return (EAttribute)spielEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSpieler() {
        return spielerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpieler_Farbe() {
        return (EAttribute)spielerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpieler_Id() {
        return (EAttribute)spielerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpieler_Name() {
        return (EAttribute)spielerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSpieler_State() {
        return (EAttribute)spielerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getState() {
        return stateEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getEKoordinate() {
        return eKoordinateEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RaumschachModellFactory getRaumschachModellFactory() {
        return (RaumschachModellFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        spielEClass = createEClass(SPIEL);
        createEAttribute(spielEClass, SPIEL__BESCHREIBUNG);
        createEReference(spielEClass, SPIEL__SPIELER);
        createEAttribute(spielEClass, SPIEL__ID);
        createEReference(spielEClass, SPIEL__ZUEGE);
        createEAttribute(spielEClass, SPIEL__ACTIVE);
        createEReference(spielEClass, SPIEL__FIGURES);
        createEReference(spielEClass, SPIEL__FIELDS);

        spielerEClass = createEClass(SPIELER);
        createEAttribute(spielerEClass, SPIELER__FARBE);
        createEAttribute(spielerEClass, SPIELER__ID);
        createEAttribute(spielerEClass, SPIELER__NAME);
        createEAttribute(spielerEClass, SPIELER__STATE);

        // Create enums
        stateEEnum = createEEnum(STATE);

        // Create data types
        eKoordinateEDataType = createEDataType(EKOORDINATE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        SpielfeldPackage theSpielfeldPackage = (SpielfeldPackage)EPackage.Registry.INSTANCE.getEPackage(SpielfeldPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(spielEClass, Spiel.class, "Spiel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSpiel_Beschreibung(), ecorePackage.getEString(), "beschreibung", null, 0, 1, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSpiel_Spieler(), this.getSpieler(), null, "spieler", null, 0, -1, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSpiel_Id(), ecorePackage.getELong(), "id", null, 1, 1, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSpiel_Zuege(), theSpielfeldPackage.getZug(), null, "zuege", null, 0, -1, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSpiel_Active(), theSpielfeldPackage.getFarbe(), "active", null, 1, 1, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSpiel_Figures(), theSpielfeldPackage.getFigur(), null, "figures", null, 40, 40, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSpiel_Fields(), theSpielfeldPackage.getField(), null, "fields", null, 125, 125, Spiel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(spielEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(spielEClass, ecorePackage.getEEList(), "createCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(spielerEClass, Spieler.class, "Spieler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSpieler_Farbe(), theSpielfeldPackage.getFarbe(), "farbe", null, 1, 1, Spieler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSpieler_Id(), ecorePackage.getEString(), "id", null, 0, 1, Spieler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSpieler_Name(), ecorePackage.getEString(), "name", null, 0, 1, Spieler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSpieler_State(), this.getState(), "state", null, 1, 1, Spieler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(stateEEnum, State.class, "State");
        addEEnumLiteral(stateEEnum, State.SCHACH);
        addEEnumLiteral(stateEEnum, State.MATT);
        addEEnumLiteral(stateEEnum, State.REMIS);
        addEEnumLiteral(stateEEnum, State.OK);

        // Initialize data types
        initEDataType(eKoordinateEDataType, Koordinate.class, "EKoordinate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //RaumschachModellPackageImpl
