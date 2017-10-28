/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import raumschachmodell.modell.RaumschachModellPackage;

import raumschachmodell.modell.impl.RaumschachModellPackageImpl;

import spielfeld.ColoredSelectable;
import spielfeld.EntityWithPosition;
import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Jump;
import spielfeld.Koordinate;
import spielfeld.SelectablePosition;
import spielfeld.SpielfeldFactory;
import spielfeld.SpielfeldPackage;
import spielfeld.StraightLine;
import spielfeld.Zug;
import spielfeld.Zugset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpielfeldPackageImpl extends EPackageImpl implements SpielfeldPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass figurEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass koordinateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass zugsetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass straightLineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass zugEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityWithPositionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jumpEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass selectablePositionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass coloredSelectableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum farbeEEnum = null;

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
     * @see spielfeld.SpielfeldPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SpielfeldPackageImpl() {
        super(eNS_URI, SpielfeldFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link SpielfeldPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SpielfeldPackage init() {
        if (isInited) return (SpielfeldPackage)EPackage.Registry.INSTANCE.getEPackage(SpielfeldPackage.eNS_URI);

        // Obtain or create and register package
        SpielfeldPackageImpl theSpielfeldPackage = (SpielfeldPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SpielfeldPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SpielfeldPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSpielfeldPackage.createPackageContents();

        // Initialize created meta-data
        theSpielfeldPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSpielfeldPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SpielfeldPackage.eNS_URI, theSpielfeldPackage);
        return theSpielfeldPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFigur() {
        return figurEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigur_Name() {
        return (EAttribute)figurEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigur_Id() {
        return (EAttribute)figurEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFigur_ZugsetNormal() {
        return (EReference)figurEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFigur_ZugsetAngriff() {
        return (EReference)figurEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigur_Active() {
        return (EAttribute)figurEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKoordinate() {
        return koordinateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKoordinate_Ebene() {
        return (EAttribute)koordinateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKoordinate_Buchstabe() {
        return (EAttribute)koordinateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKoordinate_Zahl() {
        return (EAttribute)koordinateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getZugset() {
        return zugsetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getZugset_StraightLine() {
        return (EReference)zugsetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getZugset_Jumps() {
        return (EReference)zugsetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStraightLine() {
        return straightLineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStraightLine_MaxDist() {
        return (EAttribute)straightLineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getZug() {
        return zugEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getZug_Figur() {
        return (EReference)zugEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getZug_StartPosition() {
        return (EReference)zugEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getZug_EndPosition() {
        return (EReference)zugEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getField() {
        return fieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getField_Attackable() {
        return (EAttribute)fieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getField_Possible() {
        return (EAttribute)fieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntityWithPosition() {
        return entityWithPositionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntityWithPosition_Position() {
        return (EReference)entityWithPositionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJump() {
        return jumpEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSelectablePosition() {
        return selectablePositionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSelectablePosition_Selected() {
        return (EAttribute)selectablePositionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColoredSelectable() {
        return coloredSelectableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColoredSelectable_Farbe() {
        return (EAttribute)coloredSelectableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getFarbe() {
        return farbeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpielfeldFactory getSpielfeldFactory() {
        return (SpielfeldFactory)getEFactoryInstance();
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
        figurEClass = createEClass(FIGUR);
        createEAttribute(figurEClass, FIGUR__NAME);
        createEAttribute(figurEClass, FIGUR__ID);
        createEReference(figurEClass, FIGUR__ZUGSET_NORMAL);
        createEReference(figurEClass, FIGUR__ZUGSET_ANGRIFF);
        createEAttribute(figurEClass, FIGUR__ACTIVE);

        koordinateEClass = createEClass(KOORDINATE);
        createEAttribute(koordinateEClass, KOORDINATE__EBENE);
        createEAttribute(koordinateEClass, KOORDINATE__BUCHSTABE);
        createEAttribute(koordinateEClass, KOORDINATE__ZAHL);

        zugsetEClass = createEClass(ZUGSET);
        createEReference(zugsetEClass, ZUGSET__STRAIGHT_LINE);
        createEReference(zugsetEClass, ZUGSET__JUMPS);

        straightLineEClass = createEClass(STRAIGHT_LINE);
        createEAttribute(straightLineEClass, STRAIGHT_LINE__MAX_DIST);

        zugEClass = createEClass(ZUG);
        createEReference(zugEClass, ZUG__FIGUR);
        createEReference(zugEClass, ZUG__START_POSITION);
        createEReference(zugEClass, ZUG__END_POSITION);

        fieldEClass = createEClass(FIELD);
        createEAttribute(fieldEClass, FIELD__ATTACKABLE);
        createEAttribute(fieldEClass, FIELD__POSSIBLE);

        entityWithPositionEClass = createEClass(ENTITY_WITH_POSITION);
        createEReference(entityWithPositionEClass, ENTITY_WITH_POSITION__POSITION);

        jumpEClass = createEClass(JUMP);

        selectablePositionEClass = createEClass(SELECTABLE_POSITION);
        createEAttribute(selectablePositionEClass, SELECTABLE_POSITION__SELECTED);

        coloredSelectableEClass = createEClass(COLORED_SELECTABLE);
        createEAttribute(coloredSelectableEClass, COLORED_SELECTABLE__FARBE);

        // Create enums
        farbeEEnum = createEEnum(FARBE);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        figurEClass.getESuperTypes().add(this.getColoredSelectable());
        straightLineEClass.getESuperTypes().add(this.getEntityWithPosition());
        fieldEClass.getESuperTypes().add(this.getColoredSelectable());
        jumpEClass.getESuperTypes().add(this.getEntityWithPosition());
        selectablePositionEClass.getESuperTypes().add(this.getEntityWithPosition());
        coloredSelectableEClass.getESuperTypes().add(this.getSelectablePosition());

        // Initialize classes and features; add operations and parameters
        initEClass(figurEClass, Figur.class, "Figur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFigur_Name(), ecorePackage.getEString(), "name", null, 0, 1, Figur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFigur_Id(), ecorePackage.getEString(), "id", null, 1, 1, Figur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFigur_ZugsetNormal(), this.getZugset(), null, "zugsetNormal", null, 1, 1, Figur.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFigur_ZugsetAngriff(), this.getZugset(), null, "zugsetAngriff", null, 1, 1, Figur.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFigur_Active(), ecorePackage.getEBoolean(), "active", "true", 1, 1, Figur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(figurEClass, null, "bewegen", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getKoordinate(), "zug", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(koordinateEClass, Koordinate.class, "Koordinate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKoordinate_Ebene(), ecorePackage.getEInt(), "ebene", "0", 0, 1, Koordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKoordinate_Buchstabe(), ecorePackage.getEInt(), "buchstabe", "0", 0, 1, Koordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKoordinate_Zahl(), ecorePackage.getEInt(), "zahl", "0", 0, 1, Koordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(zugsetEClass, Zugset.class, "Zugset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getZugset_StraightLine(), this.getStraightLine(), null, "straightLine", null, 0, -1, Zugset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getZugset_Jumps(), this.getJump(), null, "jumps", null, 0, -1, Zugset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(straightLineEClass, StraightLine.class, "StraightLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStraightLine_MaxDist(), ecorePackage.getEInt(), "maxDist", null, 1, 1, StraightLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(zugEClass, Zug.class, "Zug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getZug_Figur(), this.getFigur(), null, "figur", null, 1, 1, Zug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getZug_StartPosition(), this.getKoordinate(), null, "startPosition", null, 1, 1, Zug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getZug_EndPosition(), this.getKoordinate(), null, "endPosition", null, 1, 1, Zug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getField_Attackable(), ecorePackage.getEBoolean(), "attackable", null, 1, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getField_Possible(), ecorePackage.getEBoolean(), "possible", null, 1, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityWithPositionEClass, EntityWithPosition.class, "EntityWithPosition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEntityWithPosition_Position(), this.getKoordinate(), null, "position", null, 1, 1, EntityWithPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(jumpEClass, Jump.class, "Jump", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(selectablePositionEClass, SelectablePosition.class, "SelectablePosition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSelectablePosition_Selected(), ecorePackage.getEBoolean(), "selected", null, 1, 1, SelectablePosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(coloredSelectableEClass, ColoredSelectable.class, "ColoredSelectable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getColoredSelectable_Farbe(), this.getFarbe(), "farbe", null, 1, 1, ColoredSelectable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(farbeEEnum, Farbe.class, "Farbe");
        addEEnumLiteral(farbeEEnum, Farbe.ORANGE);
        addEEnumLiteral(farbeEEnum, Farbe.GRAU);
        addEEnumLiteral(farbeEEnum, Farbe.BEIDE);
        addEEnumLiteral(farbeEEnum, Farbe.UNSET);

        // Create resource
        createResource(eNS_URI);
    }

} //SpielfeldPackageImpl
