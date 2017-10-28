/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import raumschachmodell.modell.*;

import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Koordinate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RaumschachModellFactoryImpl extends EFactoryImpl implements RaumschachModellFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RaumschachModellFactory init() {
        try {
            RaumschachModellFactory theRaumschachModellFactory = (RaumschachModellFactory)EPackage.Registry.INSTANCE.getEFactory("http://raumschachmodell.modell/1.0"); 
            if (theRaumschachModellFactory != null) {
                return theRaumschachModellFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RaumschachModellFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RaumschachModellFactoryImpl() {
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
            case RaumschachModellPackage.SPIEL: return createSpiel();
            case RaumschachModellPackage.SPIELER: return createSpieler();
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
            case RaumschachModellPackage.STATE:
                return createStateFromString(eDataType, initialValue);
            case RaumschachModellPackage.EKOORDINATE:
                return createEKoordinateFromString(eDataType, initialValue);
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
            case RaumschachModellPackage.STATE:
                return convertStateToString(eDataType, instanceValue);
            case RaumschachModellPackage.EKOORDINATE:
                return convertEKoordinateToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Spiel createSpiel() {
        SpielImpl spiel = new SpielImpl();
        return spiel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Spieler createSpieler() {
        SpielerImpl spieler = new SpielerImpl();
        return spieler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public State createStateFromString(EDataType eDataType, String initialValue) {
        State result = State.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertStateToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate createEKoordinateFromString(EDataType eDataType, String initialValue) {
        return (Koordinate)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEKoordinateToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RaumschachModellPackage getRaumschachModellPackage() {
        return (RaumschachModellPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RaumschachModellPackage getPackage() {
        return RaumschachModellPackage.eINSTANCE;
    }

} //RaumschachModellFactoryImpl
