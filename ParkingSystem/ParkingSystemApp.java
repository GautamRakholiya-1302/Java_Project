import java.util.Scanner;

class Car {
    private String carNumber;
    private String ownerName;

    public Car(String carNumber, String ownerName) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}

class ParkingLot {
    private Car[] spots;
    private int availableSpots;

    public ParkingLot(int totalSpots) {
        spots = new Car[totalSpots];
        availableSpots = totalSpots;
    }

    public boolean parkCar(Car car) {
        if (availableSpots > 0) {
            for (int i = 0; i < spots.length; i++) {
                if (spots[i] == null) {
                    spots[i] = car;
                    availableSpots--;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean unparkCar(String carNumber) {
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] != null && spots[i].getCarNumber().equals(carNumber)) {
                spots[i] = null;
                availableSpots++;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}

public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10); // Initialize with 10 parking spots
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCar Parking Management System");
            System.out.println("1. Park a car");
            System.out.println("2. Unpark a car");
            System.out.println("3. Available parking spots");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter car number: ");
                    String carNumber = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    Car car = new Car(carNumber, ownerName);

                    if (parkingLot.parkCar(car)) {
                        System.out.println("Car parked successfully.");
                    } else {
                        System.out.println("Parking lot is full. Car cannot be parked.");
                    }
                    break;
                case 2:
                    System.out.print("Enter car number to unpark: ");
                    carNumber = scanner.nextLine();
                    if (parkingLot.unparkCar(carNumber)) {
                        System.out.println("Car unparked successfully.");
                    } else {
                        System.out.println("Car not found in the parking lot.");
                    }
                    break;
                case 3:
                    int availableSpots = parkingLot.getAvailableSpots();
                    System.out.println("Available parking spots: " + availableSpots);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

