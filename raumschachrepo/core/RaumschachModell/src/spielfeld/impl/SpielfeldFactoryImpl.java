/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import spielfeld.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpielfeldFactoryImpl extends EFactoryImpl implements SpielfeldFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SpielfeldFactory init() {
        try {
            SpielfeldFactory theSpielfeldFactory = (SpielfeldFactory)EPackage.Registry.INSTANCE.getEFactory("http://spielfeld/1.0"); 
            if (theSpielfeldFactory != null) {
                return theSpielfeldFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SpielfeldFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpielfeldFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SpielfeldPackage.FIGUR: return createFigur();
            case SpielfeldPackage.KOORDINATE: return createKoordinate();
            case SpielfeldPackage.ZUGSET: return createZugset();
            case SpielfeldPackage.STRAIGHT_LINE: return createStraightLine();
            case SpielfeldPackage.ZUG: return createZug();
            case SpielfeldPackage.FIELD: return createField();
            case SpielfeldPackage.JUMP: return createJump();
            case SpielfeldPackage.SELECTABLE_POSITION: return createSelectablePosition();
            case SpielfeldPackage.COLORED_SELECTABLE: return createColoredSelectable();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case SpielfeldPackage.FARBE:
                return createFarbeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case SpielfeldPackage.FARBE:
                return convertFarbeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Figur createFigur() {
        FigurImpl figur = new FigurImpl();
        return figur;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate createKoordinate() {
        KoordinateImpl koordinate = new KoordinateImpl();
        return koordinate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zugset createZugset() {
        ZugsetImpl zugset = new ZugsetImpl();
        return zugset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StraightLine createStraightLine() {
        StraightLineImpl straightLine = new StraightLineImpl();
        return straightLine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zug createZug() {
        ZugImpl zug = new ZugImpl();
        return zug;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Field createField() {
        FieldImpl field = new FieldImpl();
        return field;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Jump createJump() {
        JumpImpl jump = new JumpImpl();
        return jump;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SelectablePosition createSelectablePosition() {
        SelectablePositionImpl selectablePosition = new SelectablePositionImpl();
        return selectablePosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColoredSelectable createColoredSelectable() {
        ColoredSelectableImpl coloredSelectable = new ColoredSelectableImpl();
        return coloredSelectable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Farbe createFarbeFromString(EDataType eDataType, String initialValue) {
        Farbe result = Farbe.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertFarbeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpielfeldPackage getSpielfeldPackage() {
        return (SpielfeldPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SpielfeldPackage getPackage() {
        return SpielfeldPackage.eINSTANCE;
    }

} //SpielfeldFactoryImpl
