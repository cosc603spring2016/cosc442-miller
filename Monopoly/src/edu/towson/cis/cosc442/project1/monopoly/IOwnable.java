package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Interface IOwnable.
 */
public interface IOwnable {

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public abstract Player getOwner();

	/**
	 * Play action.
	 */
	public abstract void playAction();

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public abstract void setOwner(Player owner);

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public abstract String toString();

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public abstract boolean isAvailable();

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public abstract void setAvailable(boolean available);

}