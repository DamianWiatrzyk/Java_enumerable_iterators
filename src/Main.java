import lib.Worker;
import lib.Company;

public class Main {

    public static void main(String[] args) {
        Company f = new Company();
        
        f.add(new Worker("Jan", "Kowalski", Worker.Position.EXECUTIVE, 40000));
        f.add(new Worker("Zbigniew", "Kowalewski", Worker.Position.MANAGER, 20000));
        f.add(new Worker("Przemysław", "Nowak", Worker.Position.LEADER, 10000));
        f.add(new Worker("Dobromir", "Miły", Worker.Position.CLEANER, 5000));
        f.add(new Worker("Grażyna", "Walewska", Worker.Position.SECRETARY, 5000));
        f.add(new Worker("Wojtek", "Czekalski", Worker.Position.PROGRAMMER, 5000));
        f.add(new Worker("Wojciech", "Fonczewski", Worker.Position.PROGRAMMER, 5000));
        
        f.printWorkers();
        System.out.println("-------------------------------");
        
        f.deleteWorker("Zbigniew", "Kowalewski");
        f.printWorkers();
        System.out.println("-------------------------------");
        
        System.out.println("There is " + f.howManyWorkers() + " workers.");
        System.out.println("-------------------------------");
        
        for(Company.IteratorCompany it = f.iterator(Worker.Position.PROGRAMMER); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println("-------------------------------");
        
        System.out.println("Salaries in total " + f.salarySum());
        System.out.println("-------------------------------");
        
        System.out.println("Programmers salary " + f.salarySum(Worker.Position.PROGRAMMER));
        System.out.println("-------------------------------");
    }
    
}
