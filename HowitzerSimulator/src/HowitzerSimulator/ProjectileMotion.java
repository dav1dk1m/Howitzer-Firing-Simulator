package HowitzerSimulator;

public class ProjectileMotion {
    private int[] position;
    private int velocity;
    private int mass;
    
    public ProjectileMotion(int[] position, int velocity, int mass) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
    }
    
    public int[] getPosition() {
        return position;
    }
    
    public void setPosition(int[] position) {
        this.position = position;
    }
    
    public int getVelocity() {
        return velocity;
    }
    
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    
    public int getMass() {
        return mass;
    }
    
    public void setMass(int mass) {
        this.mass = mass;
    }
}