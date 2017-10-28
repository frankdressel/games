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

import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.FieldImpl#isAttackable <em>Attackable</em>}</li>
 *   <li>{@link spielfeld.impl.FieldImpl#isPossible <em>Possible</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldImpl extends ColoredSelectableImpl implements Field {
    /**
     * The default value of the '{@link #isAttackable() <em>Attackable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAttackable()
     * @generated
     * @ordered
     */
    protected static final boolean ATTACKABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAttackable() <em>Attackable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAttackable()
     * @generated
     * @ordered
     */
    protected boolean attackable = ATTACKABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isPossible() <em>Possible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPossible()
     * @generated
     * @ordered
     */
    protected static final boolean POSSIBLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isPossible() <em>Possible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPossible()
     * @generated
     * @ordered
     */
    protected boolean possible = POSSIBLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAttackable() {
        return attackable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttackable(boolean newAttackable) {
        boolean oldAttackable = attackable;
        attackable = newAttackable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIELD__ATTACKABLE, oldAttackable, attackable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isPossible() {
        return possible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPossible(boolean newPossible) {
        boolean oldPossible = possible;
        possible = newPossible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIELD__POSSIBLE, oldPossible, possible));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.FIELD__ATTACKABLE:
                return isAttackable();
            case SpielfeldPackage.FIELD__POSSIBLE:
                return isPossible();
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
            case SpielfeldPackage.FIELD__ATTACKABLE:
                setAttackable((Boolean)newValue);
                return;
            case SpielfeldPackage.FIELD__POSSIBLE:
                setPossible((Boolean)newValue);
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
            case SpielfeldPackage.FIELD__ATTACKABLE:
                setAttackable(ATTACKABLE_EDEFAULT);
                return;
            case SpielfeldPackage.FIELD__POSSIBLE:
                setPossible(POSSIBLE_EDEFAULT);
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
            case SpielfeldPackage.FIELD__ATTACKABLE:
                return attackable != ATTACKABLE_EDEFAULT;
            case SpielfeldPackage.FIELD__POSSIBLE:
                return possible != POSSIBLE_EDEFAULT;
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
        result.append(" (attackable: ");
        result.append(attackable);
        result.append(", possible: ");
        result.append(possible);
        result.append(')');
        return result.toString();
    }

    /**
     * Two {@link Field}s are equal, if the coordinates are equal (numerically).
     */
    @Override
    public boolean equals(Object obj) {
        //Check for a Field.
        if(!(obj instanceof Field)){
            return false;
        }
        //Convert.
        final Field objField=(Field)obj;
        return objField.getPosition().getEbene()==position.getEbene()&&objField.getPosition().getBuchstabe()==position.getBuchstabe()&&objField.getPosition().getZahl()==position.getZahl();
    }

    /**
     * The hashcode is the sum of the three coordinates.
     */
    @Override
    public int hashCode() {
        return position==null?(int)System.currentTimeMillis():position.getEbene()*25+position.getBuchstabe()*5+position.getZahl();
    }
    
} //FieldImpl
