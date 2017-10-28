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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Koordinate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.KoordinateImpl#getEbene <em>Ebene</em>}</li>
 *   <li>{@link spielfeld.impl.KoordinateImpl#getBuchstabe <em>Buchstabe</em>}</li>
 *   <li>{@link spielfeld.impl.KoordinateImpl#getZahl <em>Zahl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KoordinateImpl extends EObjectImpl implements Koordinate {
    /**
     * The default value of the '{@link #getEbene() <em>Ebene</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEbene()
     * @generated
     * @ordered
     */
    protected static final int EBENE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getEbene() <em>Ebene</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEbene()
     * @generated
     * @ordered
     */
    protected int ebene = EBENE_EDEFAULT;

    /**
     * The default value of the '{@link #getBuchstabe() <em>Buchstabe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuchstabe()
     * @generated
     * @ordered
     */
    protected static final int BUCHSTABE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getBuchstabe() <em>Buchstabe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuchstabe()
     * @generated
     * @ordered
     */
    protected int buchstabe = BUCHSTABE_EDEFAULT;

    /**
     * The default value of the '{@link #getZahl() <em>Zahl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZahl()
     * @generated
     * @ordered
     */
    protected static final int ZAHL_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getZahl() <em>Zahl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZahl()
     * @generated
     * @ordered
     */
    protected int zahl = ZAHL_EDEFAULT;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected KoordinateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.KOORDINATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getEbene() {
        return ebene;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEbene(int newEbene) {
        int oldEbene = ebene;
        ebene = newEbene;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.KOORDINATE__EBENE, oldEbene, ebene));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getBuchstabe() {
        return buchstabe;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBuchstabe(int newBuchstabe) {
        int oldBuchstabe = buchstabe;
        buchstabe = newBuchstabe;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.KOORDINATE__BUCHSTABE, oldBuchstabe, buchstabe));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getZahl() {
        return zahl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setZahl(int newZahl) {
        int oldZahl = zahl;
        zahl = newZahl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.KOORDINATE__ZAHL, oldZahl, zahl));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.KOORDINATE__EBENE:
                return getEbene();
            case SpielfeldPackage.KOORDINATE__BUCHSTABE:
                return getBuchstabe();
            case SpielfeldPackage.KOORDINATE__ZAHL:
                return getZahl();
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
            case SpielfeldPackage.KOORDINATE__EBENE:
                setEbene((Integer)newValue);
                return;
            case SpielfeldPackage.KOORDINATE__BUCHSTABE:
                setBuchstabe((Integer)newValue);
                return;
            case SpielfeldPackage.KOORDINATE__ZAHL:
                setZahl((Integer)newValue);
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
            case SpielfeldPackage.KOORDINATE__EBENE:
                setEbene(EBENE_EDEFAULT);
                return;
            case SpielfeldPackage.KOORDINATE__BUCHSTABE:
                setBuchstabe(BUCHSTABE_EDEFAULT);
                return;
            case SpielfeldPackage.KOORDINATE__ZAHL:
                setZahl(ZAHL_EDEFAULT);
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
            case SpielfeldPackage.KOORDINATE__EBENE:
                return ebene != EBENE_EDEFAULT;
            case SpielfeldPackage.KOORDINATE__BUCHSTABE:
                return buchstabe != BUCHSTABE_EDEFAULT;
            case SpielfeldPackage.KOORDINATE__ZAHL:
                return zahl != ZAHL_EDEFAULT;
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
        result.append(" (ebene: ");
        result.append(ebene);
        result.append(", buchstabe: ");
        result.append(buchstabe);
        result.append(", zahl: ");
        result.append(zahl);
        result.append(')');
        return result.toString();
    }
    /**
     * Two {@link Koordinate}s are equal, if the coordinates are equal (numerically).
     */
    @Override
    public boolean equals(Object obj) {
        //Check for a Koorinate.
        if(!(obj instanceof Koordinate)){
            return false;
        }
        //Convert.
        final Koordinate objKoord=(Koordinate)obj;
        return objKoord.getEbene()==ebene&&objKoord.getBuchstabe()==buchstabe&&objKoord.getZahl()==zahl;
    }

    /**
     * The hashcode is the sum of the three coordinates.
     */
    @Override
    public int hashCode() {
        return ebene*25+buchstabe*5+zahl;
    }
} //KoordinateImpl
