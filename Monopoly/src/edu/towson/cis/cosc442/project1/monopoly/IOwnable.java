package edu.towson.cis.cosc442.project1.monopoly;

public interface IOwnable {

	public abstract String getName();

	public abstract Player getOwner();

	public abstract Boolean playAction(String msg);

	public abstract void setOwner(Player owner);

	public abstract String toString();

	public abstract boolean isAvailable();

	public abstract void setAvailable(boolean available);

}