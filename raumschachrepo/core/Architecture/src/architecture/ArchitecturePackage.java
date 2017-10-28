/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "architecture";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://architecture/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "architecture";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ArchitecturePackage eINSTANCE = architecture.impl.ArchitecturePackageImpl.init();

    /**
     * The meta object id for the '{@link architecture.ISpielProvider <em>ISpiel Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see architecture.ISpielProvider
     * @see architecture.impl.ArchitecturePackageImpl#getISpielProvider()
     * @generated
     */
    int ISPIEL_PROVIDER = 0;

    /**
     * The number of structural features of the '<em>ISpiel Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ISPIEL_PROVIDER_FEATURE_COUNT = 0;


    /**
     * The meta object id for the '{@link architecture.IStateAnalyzer <em>IState Analyzer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see architecture.IStateAnalyzer
     * @see architecture.impl.ArchitecturePackageImpl#getIStateAnalyzer()
     * @generated
     */
    int ISTATE_ANALYZER = 1;

    /**
     * The number of structural features of the '<em>IState Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ISTATE_ANALYZER_FEATURE_COUNT = 0;


    /**
     * The meta object id for the '{@link architecture.IDataBaseWrapper <em>IData Base Wrapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see architecture.IDataBaseWrapper
     * @see architecture.impl.ArchitecturePackageImpl#getIDataBaseWrapper()
     * @generated
     */
    int IDATA_BASE_WRAPPER = 2;

    /**
     * The number of structural features of the '<em>IData Base Wrapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDATA_BASE_WRAPPER_FEATURE_COUNT = 0;


    /**
     * The meta object id for the '{@link architecture.IDisplayProvider <em>IDisplay Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see architecture.IDisplayProvider
     * @see architecture.impl.ArchitecturePackageImpl#getIDisplayProvider()
     * @generated
     */
    int IDISPLAY_PROVIDER = 3;

    /**
     * The number of structural features of the '<em>IDisplay Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDISPLAY_PROVIDER_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '<em>EDisplay</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.widgets.Display
     * @see architecture.impl.ArchitecturePackageImpl#getEDisplay()
     * @generated
     */
    int EDISPLAY = 4;


    /**
     * Returns the meta object for class '{@link architecture.ISpielProvider <em>ISpiel Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>ISpiel Provider</em>'.
     * @see architecture.ISpielProvider
     * @generated
     */
    EClass getISpielProvider();

    /**
     * Returns the meta object for class '{@link architecture.IStateAnalyzer <em>IState Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IState Analyzer</em>'.
     * @see architecture.IStateAnalyzer
     * @generated
     */
    EClass getIStateAnalyzer();

    /**
     * Returns the meta object for class '{@link architecture.IDataBaseWrapper <em>IData Base Wrapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IData Base Wrapper</em>'.
     * @see architecture.IDataBaseWrapper
     * @generated
     */
    EClass getIDataBaseWrapper();

    /**
     * Returns the meta object for class '{@link architecture.IDisplayProvider <em>IDisplay Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IDisplay Provider</em>'.
     * @see architecture.IDisplayProvider
     * @generated
     */
    EClass getIDisplayProvider();

    /**
     * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Display <em>EDisplay</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>EDisplay</em>'.
     * @see org.eclipse.swt.widgets.Display
     * @model instanceClass="org.eclipse.swt.widgets.Display"
     * @generated
     */
    EDataType getEDisplay();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ArchitectureFactory getArchitectureFactory();

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
         * The meta object literal for the '{@link architecture.ISpielProvider <em>ISpiel Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see architecture.ISpielProvider
         * @see architecture.impl.ArchitecturePackageImpl#getISpielProvider()
         * @generated
         */
        EClass ISPIEL_PROVIDER = eINSTANCE.getISpielProvider();
        /**
         * The meta object literal for the '{@link architecture.IStateAnalyzer <em>IState Analyzer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see architecture.IStateAnalyzer
         * @see architecture.impl.ArchitecturePackageImpl#getIStateAnalyzer()
         * @generated
         */
        EClass ISTATE_ANALYZER = eINSTANCE.getIStateAnalyzer();
        /**
         * The meta object literal for the '{@link architecture.IDataBaseWrapper <em>IData Base Wrapper</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see architecture.IDataBaseWrapper
         * @see architecture.impl.ArchitecturePackageImpl#getIDataBaseWrapper()
         * @generated
         */
        EClass IDATA_BASE_WRAPPER = eINSTANCE.getIDataBaseWrapper();
        /**
         * The meta object literal for the '{@link architecture.IDisplayProvider <em>IDisplay Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see architecture.IDisplayProvider
         * @see architecture.impl.ArchitecturePackageImpl#getIDisplayProvider()
         * @generated
         */
        EClass IDISPLAY_PROVIDER = eINSTANCE.getIDisplayProvider();
        /**
         * The meta object literal for the '<em>EDisplay</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.swt.widgets.Display
         * @see architecture.impl.ArchitecturePackageImpl#getEDisplay()
         * @generated
         */
        EDataType EDISPLAY = eINSTANCE.getEDisplay();

    }

} //ArchitecturePackage
