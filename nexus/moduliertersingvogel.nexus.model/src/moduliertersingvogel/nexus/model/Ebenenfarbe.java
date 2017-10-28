package moduliertersingvogel.nexus.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A representation of the literals of the enumeration '
 * <em><b>ebenenfarbe</b></em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public enum Ebenenfarbe {

	/**
	 * The enum: ORANGE <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ORANGE(0, "orange", "orange") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isOrange() {
			return true;
		}
	},
	/**
	 * The enum: ROT <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ROT(1, "rot", "rot") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isRot() {
			return true;
		}
	},
	/**
	 * The enum: GRUEN <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	GRUEN(2, "gruen", "gruen") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isGruen() {
			return true;
		}
	};

	/**
	 * An array of all the '<em><b>ebenenfarbe</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Ebenenfarbe[] VALUES_ARRAY = new Ebenenfarbe[] {
			ORANGE, ROT, GRUEN };

	/**
	 * A public read-only list of all the '<em><b>ebenenfarbe</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<Ebenenfarbe> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ebenenfarbe</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Ebenenfarbe get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Ebenenfarbe result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ebenenfarbe</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Ebenenfarbe getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Ebenenfarbe result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ebenenfarbe</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Ebenenfarbe get(int value) {
		for (Ebenenfarbe enumInstance : VALUES_ARRAY) {
			if (enumInstance.getValue() == value) {
				return enumInstance;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private Ebenenfarbe(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isOrange() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isRot() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isGruen() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the literal value of the enumerator, which is its string
	 *         representation.
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
