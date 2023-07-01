package HowitzerSimulator;
/**
 * ProjectileMotion class
 *
 */
public class ProjectileMotion {
    private int[] position;
    private double velocity;
    private double mass;
    
    public ProjectileMotion(int[] position, int velocity, int mass) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
    }
    
    /**
     * Gets the Position of the Projectile 
     * @return int[] position
     */
    public int[] getPosition() {
        return position;
    }
    
    /**
     * Sets the Position of the Projectile
     *      * @return int[] position 
     */
    public void setPosition(int[] position) {
        this.position = position;
    }
    
    /**
     * Gets the velocity of the Projectile 
     * @return double velocity
     */
    public double getVelocity() {
        return velocity;
    }
    /**
     * Sets the velocity of the Projectile 
     * @param double velocity
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Gets the mass of the Projectile 
     * @return double mass
     */
    public double getMass() {
        return mass;
    }
    
    /**
     * Sets the mass of the Projectile 
     * @param double mass
     */
    public void setMass(double mass) {
        this.mass = mass;
    }
}