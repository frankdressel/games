/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import spielfeld.ColoredSelectable;
import spielfeld.Farbe;
import spielfeld.SpielfeldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colored Selectable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.ColoredSelectableImpl#getFarbe <em>Farbe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColoredSelectableImpl extends SelectablePositionImpl implements ColoredSelectable {
    /**
     * The default value of the '{@link #getFarbe() <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFarbe()
     * @generated
     * @ordered
     */
    protected static final Farbe FARBE_EDEFAULT = Farbe.ORANGE;

    /**
     * The cached value of the '{@link #getFarbe() <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFarbe()
     * @generated
     * @ordered
     */
    protected Farbe farbe = FARBE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColoredSelectableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.COLORED_SELECTABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Farbe getFarbe() {
        return farbe;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFarbe(Farbe newFarbe) {
        Farbe oldFarbe = farbe;
        farbe = newFarbe == null ? FARBE_EDEFAULT : newFarbe;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.COLORED_SELECTABLE__FARBE, oldFarbe, farbe));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.COLORED_SELECTABLE__FARBE:
                return getFarbe();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SpielfeldPackage.COLORED_SELECTABLE__FARBE:
                setFarbe((Farbe)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SpielfeldPackage.COLORED_SELECTABLE__FARBE:
                setFarbe(FARBE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SpielfeldPackage.COLORED_SELECTABLE__FARBE:
                return farbe != FARBE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (farbe: ");
        result.append(farbe);
        result.append(')');
        return result.toString();
    }

} //ColoredSelectableImpl
