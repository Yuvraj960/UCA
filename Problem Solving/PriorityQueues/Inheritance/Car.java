/**
 * Car class represents a car with a size and color.
*/
public class Car {
  private int size;
  private int color;

  /**
   * Constructor to initialize the car's size and color.
   */
  Car(int size, int color) {
    this.size = size;
    this.color = color;
  }

  /**
   * Getter for the car's size.
   */
  public int getSize() {
    return size;
  }

  /**
   * Getter for the car's color.
   */
  public int getColor() {
    return color;
  }

  /**
   * Setter for the car's size.
   *
   * @param size the new size of the car
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Setter for the car's color.
   *
   * @param color the new color of the car
   */
  public void setColor(int color) {
    this.color = color;
  }

  /**
   * Custom equals method to compare two Car objects.
   *
   * @param o the object to compare with
   */
  public boolean equals(Object o) {
    Car c = (Car) o;
    if (this.size == c.getSize() && this.color == c.getColor()) {
      return true;
    }
    return false;
  }

  /**
   * Main method to test the Car class.
   */
  public static void main(String[] args) {
    Car c1 = new Car(5, 1);
    Car c2 = new Car(5, 1);
    Car c3 = new Car(3, 2);


    // Outputs before defining the custom equals method
    System.out.println(c1 == c2); // false
    System.out.println(c1.equals(c2)); // false

    // Outputs after defining the custom equals method
    System.out.println(c1.equals(c2)); // true
    System.out.println(c1.equals(c3)); // false
  }
}

// NOTES
// Every Class in Java inherits from the Object Class
// Object Class -> equals, hashcode

