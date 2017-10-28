/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture.impl;

import architecture.ArchitectureFactory;
import architecture.ArchitecturePackage;
import architecture.IDataBaseWrapper;
import architecture.IDisplayProvider;
import architecture.ISpielProvider;

import architecture.IStateAnalyzer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.swt.widgets.Display;
import raumschachmodell.modell.RaumschachModellPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitecturePackageImpl extends EPackageImpl implements ArchitecturePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iSpielProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iStateAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iDataBaseWrapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iDisplayProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType eDisplayEDataType = null;

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
     * @see architecture.ArchitecturePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ArchitecturePackageImpl() {
        super(eNS_URI, ArchitectureFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ArchitecturePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ArchitecturePackage init() {
        if (isInited) return (ArchitecturePackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);

        // Obtain or create and register package
        ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ArchitecturePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ArchitecturePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        RaumschachModellPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theArchitecturePackage.createPackageContents();

        // Initialize created meta-data
        theArchitecturePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theArchitecturePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ArchitecturePackage.eNS_URI, theArchitecturePackage);
        return theArchitecturePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getISpielProvider() {
        return iSpielProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIStateAnalyzer() {
        return iStateAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIDataBaseWrapper() {
        return iDataBaseWrapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIDisplayProvider() {
        return iDisplayProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getEDisplay() {
        return eDisplayEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArchitectureFactory getArchitectureFactory() {
        return (ArchitectureFactory)getEFactoryInstance();
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
        iSpielProviderEClass = createEClass(ISPIEL_PROVIDER);

        iStateAnalyzerEClass = createEClass(ISTATE_ANALYZER);

        iDataBaseWrapperEClass = createEClass(IDATA_BASE_WRAPPER);

        iDisplayProviderEClass = createEClass(IDISPLAY_PROVIDER);

        // Create data types
        eDisplayEDataType = createEDataType(EDISPLAY);
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
        RaumschachModellPackage theRaumschachModellPackage = (RaumschachModellPackage)EPackage.Registry.INSTANCE.getEPackage(RaumschachModellPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(iSpielProviderEClass, ISpielProvider.class, "ISpielProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(iSpielProviderEClass, theRaumschachModellPackage.getSpiel(), "getSpiel", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(iStateAnalyzerEClass, IStateAnalyzer.class, "IStateAnalyzer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(iStateAnalyzerEClass, ecorePackage.getEMap(), "analyzeStrength", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(iDataBaseWrapperEClass, IDataBaseWrapper.class, "IDataBaseWrapper", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(iDataBaseWrapperEClass, ecorePackage.getEString(), "getNameForActualPlayer", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(iDisplayProviderEClass, IDisplayProvider.class, "IDisplayProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(iDisplayProviderEClass, this.getEDisplay(), "getAllDisplays", 0, -1, IS_UNIQUE, IS_ORDERED);

        EOperation op = addEOperation(iDisplayProviderEClass, this.getEDisplay(), "getDisplay", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(iDisplayProviderEClass, null, "addDisplay", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEDisplay(), "display", 0, 1, IS_UNIQUE, IS_ORDERED);

        // Initialize data types
        initEDataType(eDisplayEDataType, Display.class, "EDisplay", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //ArchitecturePackageImpl
