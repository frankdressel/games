/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import spielfeld.Farbe;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;
import spielfeld.Zugset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Figur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.FigurImpl#getName <em>Name</em>}</li>
 *   <li>{@link spielfeld.impl.FigurImpl#getId <em>Id</em>}</li>
 *   <li>{@link spielfeld.impl.FigurImpl#getZugsetNormal <em>Zugset Normal</em>}</li>
 *   <li>{@link spielfeld.impl.FigurImpl#getZugsetAngriff <em>Zugset Angriff</em>}</li>
 *   <li>{@link spielfeld.impl.FigurImpl#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FigurImpl extends ColoredSelectableImpl implements Figur {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;
    
    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getZugsetNormal() <em>Zugset Normal</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZugsetNormal()
     * @generated
     * @ordered
     */
    protected Zugset zugsetNormal;

    /**
     * The cached value of the '{@link #getZugsetAngriff() <em>Zugset Angriff</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZugsetAngriff()
     * @generated
     * @ordered
     */
    protected Zugset zugsetAngriff;

    /**
     * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected static final boolean ACTIVE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected boolean active = ACTIVE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FigurImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.FIGUR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIGUR__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIGUR__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zugset getZugsetNormal() {
        if (zugsetNormal != null && zugsetNormal.eIsProxy()) {
            InternalEObject oldZugsetNormal = (InternalEObject)zugsetNormal;
            zugsetNormal = (Zugset)eResolveProxy(oldZugsetNormal);
            if (zugsetNormal != oldZugsetNormal) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.FIGUR__ZUGSET_NORMAL, oldZugsetNormal, zugsetNormal));
            }
        }
        return zugsetNormal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zugset basicGetZugsetNormal() {
        return zugsetNormal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setZugsetNormal(Zugset newZugsetNormal) {
        Zugset oldZugsetNormal = zugsetNormal;
        zugsetNormal = newZugsetNormal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIGUR__ZUGSET_NORMAL, oldZugsetNormal, zugsetNormal));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zugset getZugsetAngriff() {
        if (zugsetAngriff != null && zugsetAngriff.eIsProxy()) {
            InternalEObject oldZugsetAngriff = (InternalEObject)zugsetAngriff;
            zugsetAngriff = (Zugset)eResolveProxy(oldZugsetAngriff);
            if (zugsetAngriff != oldZugsetAngriff) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF, oldZugsetAngriff, zugsetAngriff));
            }
        }
        return zugsetAngriff;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Zugset basicGetZugsetAngriff() {
        return zugsetAngriff;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setZugsetAngriff(Zugset newZugsetAngriff) {
        Zugset oldZugsetAngriff = zugsetAngriff;
        zugsetAngriff = newZugsetAngriff;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF, oldZugsetAngriff, zugsetAngriff));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isActive() {
        return active;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActive(boolean newActive) {
        boolean oldActive = active;
        active = newActive;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.FIGUR__ACTIVE, oldActive, active));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void bewegen(Koordinate zug) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.FIGUR__NAME:
                return getName();
            case SpielfeldPackage.FIGUR__ID:
                return getId();
            case SpielfeldPackage.FIGUR__ZUGSET_NORMAL:
                if (resolve) return getZugsetNormal();
                return basicGetZugsetNormal();
            case SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF:
                if (resolve) return getZugsetAngriff();
                return basicGetZugsetAngriff();
            case SpielfeldPackage.FIGUR__ACTIVE:
                return isActive();
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
            case SpielfeldPackage.FIGUR__NAME:
                setName((String)newValue);
                return;
            case SpielfeldPackage.FIGUR__ID:
                setId((String)newValue);
                return;
            case SpielfeldPackage.FIGUR__ZUGSET_NORMAL:
                setZugsetNormal((Zugset)newValue);
                return;
            case SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF:
                setZugsetAngriff((Zugset)newValue);
                return;
            case SpielfeldPackage.FIGUR__ACTIVE:
                setActive((Boolean)newValue);
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
            case SpielfeldPackage.FIGUR__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SpielfeldPackage.FIGUR__ID:
                setId(ID_EDEFAULT);
                return;
            case SpielfeldPackage.FIGUR__ZUGSET_NORMAL:
                setZugsetNormal((Zugset)null);
                return;
            case SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF:
                setZugsetAngriff((Zugset)null);
                return;
            case SpielfeldPackage.FIGUR__ACTIVE:
                setActive(ACTIVE_EDEFAULT);
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
            case SpielfeldPackage.FIGUR__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SpielfeldPackage.FIGUR__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case SpielfeldPackage.FIGUR__ZUGSET_NORMAL:
                return zugsetNormal != null;
            case SpielfeldPackage.FIGUR__ZUGSET_ANGRIFF:
                return zugsetAngriff != null;
            case SpielfeldPackage.FIGUR__ACTIVE:
                return active != ACTIVE_EDEFAULT;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", id: ");
        result.append(id);
        result.append(", active: ");
        result.append(active);
        result.append(')');
        return result.toString();
    }

    @Override
    public boolean equals(Object arg0) {
        if(!(arg0 instanceof Figur)){
            return false;
        }
        return this.hashCode()==arg0.hashCode();
    }

    @Override
    public int hashCode() {
        return (name+id).hashCode();
    }

} //FigurImpl
