package lib;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Company implements Iterable {
    private Set<Worker> workers;
    
    public Company() {
        workers = new HashSet<Worker>();
    }
    
    //Is worker exists
    public boolean isExists(Worker p) {
        return workers.equals(p);
    }
    
    //add new worker
    public void add(Worker p) throws IllegalStateException {
        if (isExists(p))
            throw new IllegalStateException("Istnieje już taki pracownik!!!");
        
        workers.add(p);
    }
    
    //current sum of workers
    public int howManyWorkers() {
        return workers.size();
    }
    
    //delete worker
    public void deleteWorker(String name, String surname) {
        workers.removeIf(p -> (p.getName() == name && p.getSurname() == surname));
    }
    
    public void printWorkers(){
        for(Worker p : workers) {
            System.out.println(p.toString());
        }
    }

    @Override
    public IteratorCompany iterator() {
        return new IteratorCompany(workers.iterator());
    }
    
    public IteratorCompany iterator(Worker.Position s) {
        return new IteratorCompany(workers.iterator(), s);
    }
    
    public int salarySum() {
        int sum = 0;
        for (IteratorCompany it = this.iterator(); it.hasNext();) {
            Worker p = it.next();
            sum += p.getSalary();
        }
        
        return sum;
    }
    
    public int salarySum(Worker.Position s) {
        int suma = 0;
        for (IteratorCompany it = this.iterator(s); it.hasNext();) {
            Worker p = it.next();
            suma += p.getSalary();
        }
        
        return suma;
    }
    
    //
    public class IteratorCompany implements Iterator<Worker> {
        private Iterator<Worker> temp;
        private Worker p = null;
        private Worker.Position position;
        
        public IteratorCompany(Iterator<Worker> it) {
            this.temp = it;
            this.position = null;
        }
        
        public IteratorCompany(Iterator<Worker> it, Worker.Position s) {
            this.temp = it;
            this.position = s;
        }

        @Override
        public boolean hasNext() {
            if(position == null)
                return temp.hasNext();
            
            Iterator<Worker> temp2 = temp;
            while(temp2.hasNext()) {
                p = temp2.next();
                if(p.getPosition() == position)
                    return true;
            }
            return false;
        }

        @Override
        public Worker next() {
            if(position == null)
                return temp.next();
                       
            return p;
        }
    }
}
