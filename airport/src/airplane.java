public class airplane {
    private String call_sign;
    private int bearing;
    private double distance;
    private int altitude;

    /**
     * 
     */
    public airplane() {
        this.call_sign = "AAA01";
        this.bearing = 0;
        this.distance = 1;
        this.altitude = 0;

    }
    /**
     * @param call_sign
     * @param bearing
     * @param distance
     */
    public airplane(String call_sign, double distance, int bearing, int altitude) {
        this.call_sign = call_sign;
        setBearing(bearing);
        setDistance(distance);
        this.altitude = altitude;
    }

    public void move(double distance, int dir){
        setDistance(distance);
        setBearing(dir);

    }

    public double distTo(airplane other){
        //Distance between two points in 3d space is:
        //  dist = sqrt[(x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2]
        //Calcualate this.x and this.y and this.z
        // convert all distance values to miles

        double x1 = this.distance*Math.cos(Math.toRadians(this.bearing));
        double y1 = this.distance*Math.sin(Math.toRadians(this.bearing));
        double z1 = this.altitude / 5280;
        z1  = 0; //the example is only calculating in 2d

        //System.out.println("x1:" + x1 + " y1:" + y1);

        //Calcualate other.x and other.y and other.z
        double x2 = other.distance*Math.cos(Math.toRadians(other.bearing));
        double y2 = other.distance*Math.sin(Math.toRadians(other.bearing));
        double z2 = other.altitude / 5280;
        z2 = 0;//the example is only calculating in 2d

        //System.out.println("x2:" + x2 + " y2:" + y2);

        double dist = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1),2)
                        + Math.pow((z2-z1),2));

        //System.out.println("x1 to x2:" + dist);

        return Math.round(dist*100)/100D;//rounds to 2 decimal places

    }
    
    /**
     * @param bearing the bearing to set
     */
    public void setBearing(int bearing) {

        if (bearing < 0) {//only handles upto -360
            this.bearing = 360 + bearing;
            
        }else if (bearing > 360) {
            this.bearing = bearing % 360;
            
        }else{
           this.bearing = bearing;
        }
    }
    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return the altitude
     */
    public int getAlt() {
        return altitude;
    }

    /**
     * increase altitude by 1000ft for each call
     */
    public int gainAlt() {
        return this.altitude = this.altitude + 1000;
    }

    /**
     * decrease altitude by 1000ft for each call
     */
    public int loseAlt() {
        this.altitude = this.altitude - 1000;
        if (this.altitude < 0) {
            this.altitude =  0;
        }
        return this.altitude;
    }
    @Override
    public String toString() {
        return call_sign + " - " + distance + " miles away at bearing " 
                + bearing + "\u00B0, altitude " + altitude + " feet"; 
    }
    
}
