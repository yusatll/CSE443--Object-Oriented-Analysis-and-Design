package midterm_part1;

public class Camera {
    private int front;
    private int rear;
    private int zoom;

    /**
     * create a new Camera object
     * @param front feature 1
     * @param rear feature 2
     */
    public Camera(int front, int rear)
    {
        this.front = front;
        this.rear = rear;
    }

    /**
     * Specific Camera object.
     * @param zoom feature 3
     */
    public Camera(int zoom)
    {
        this.zoom = zoom;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String toString()
    {
        String name = "Camera: " + getFront() + " MP Front, " + getRear() + " MP Rear, " + getZoom() + "x Opt. Zoom.\n";
        return name;
    }

}
