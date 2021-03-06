package com.treyzania.api.games;

/**
 * This class might actually be considered a ray, but I'm calling it a vector because of reasons.
 * 
 * @author Treyzania
 *
 */
public class Vector3F {

	public final Point3F base;
	
	public final float pitch; // Rotation around Z, in degrees
	public final float roll; // Rotation around X, in degrees
	public final float yaw; // Rotation around Y, in degrees
	
	public Vector3F(Point3F base, float pitch, float roll, float yaw) {
		
		this.base = base;
		
		this.pitch = pitch;
		this.roll = roll;
		this.yaw = yaw;
		
	}
	
	public Vector3F(Point3F base, float pitch, float yaw) {
		this(base, pitch, 0F, yaw);
	}
	
	public Vector3F(Vector3F from) {
		this(from.base, from.pitch, from.roll, from.yaw);
	}
	
	/**
	 * Gets the point along the vector at the specified length.  Currently
	 * doesn't work properly.
	 * 
	 * @param length
	 * @return
	 */
	public Point3F pointAt(double length) {
		
		double nx, ny, nz;
		
		// TODO Finish this.
		
		nx = 0D;
		ny = 0D;
		nz = 0D;
		
		return new Point3F((float) (base.x + nx), (float) (base.y + ny), (float) (base.z + nz));
		
	}
	
	public float getPitch_rads() {
		return (float) Math.toRadians(this.pitch);
	}
	
	public float getRoll_rads() {
		return (float) Math.toRadians(this.roll);
	}
	
	public float getYaw_rads() {
		return (float) Math.toRadians(this.yaw);
	}
	
	public float getPitch_degs() {
		return this.pitch;
	}
	
	public float getRoll_degs() {
		return this.roll;
	}
	
	public float getYaw_degs() {
		return this.yaw;
	}
	
}
