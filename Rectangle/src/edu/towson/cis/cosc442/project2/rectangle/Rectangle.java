package edu.towson.cis.cosc442.project2.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The point2. */
	private Point point1, point2;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param point1 the point1
	 * @param point2 the point2
	 */
	Rectangle(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		return this.getWidth() * this.getHeight();
	}
	
	/**
	 * Gets the width
	 * 
	 * @return the width
	 */
	public Double getWidth(){
		Double width = point2.x - point1.x;
		return Math.abs(width);
	}
	
	/**
	 * Gets the height
	 * 
	 * @return the height
	 */
	public Double getHeight(){
		Double height = point2.y - point1.y;
		return Math.abs(height);
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		return Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2));
	}
}
