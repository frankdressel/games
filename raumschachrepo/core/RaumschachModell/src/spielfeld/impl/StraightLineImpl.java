/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;
import spielfeld.StraightLine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Straight Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.StraightLineImpl#getMaxDist <em>Max Dist</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StraightLineImpl extends EntityWithPositionImpl implements StraightLine {
    /**
     * The default value of the '{@link #getMaxDist() <em>Max Dist</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxDist()
     * @generated
     * @ordered
     */
    protected static final int MAX_DIST_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxDist() <em>Max Dist</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxDist()
     * @generated
     * @ordered
     */
    protected int maxDist = MAX_DIST_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StraightLineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.STRAIGHT_LINE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMaxDist() {
        return maxDist;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaxDist(int newMaxDist) {
        int oldMaxDist = maxDist;
        maxDist = newMaxDist;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.STRAIGHT_LINE__MAX_DIST, oldMaxDist, maxDist));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.STRAIGHT_LINE__MAX_DIST:
                return getMaxDist();
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
            case SpielfeldPackage.STRAIGHT_LINE__MAX_DIST:
                setMaxDist((Integer)newValue);
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
            case SpielfeldPackage.STRAIGHT_LINE__MAX_DIST:
                setMaxDist(MAX_DIST_EDEFAULT);
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
            case SpielfeldPackage.STRAIGHT_LINE__MAX_DIST:
                return maxDist != MAX_DIST_EDEFAULT;
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
        result.append(" (maxDist: ");
        result.append(maxDist);
        result.append(')');
        return result.toString();
    }

} //StraightLineImpl
