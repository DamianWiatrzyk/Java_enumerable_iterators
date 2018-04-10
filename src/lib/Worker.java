package lib;

public class Worker extends Person {
    public enum Position {
        MANAGER(1, "Manager"),
        EXECUTIVE(2, "Executive"),
        LEADER(3, "Leader"),
        SECRETARY(5, "Secretary"),
        CLEANER(6, "Cleaner"),
        PROGRAMMER(4, "Golden-collar worker");
        
        final int level;
        final String describe;

        private Position(int level, String describe) {
            this.level = level;
            this.describe = describe;
        }

        @Override
        public String toString() {
            return super.toString() + "(" + describe + ")"; //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }
    Position position;
    private int salary;

    public Worker(String name, String surname, Position position, int salary) {
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " position: " + position + " salary: " + salary;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public int getSalary() {
        return salary;
    }
}
