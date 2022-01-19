import java.util.Arrays;
import java.util.Scanner;

public class Store {
    private User user;
    private User[] users;
    private Product[] productsAtStore;
    private Product product;
    private Worker worker;

    public Store(User user, Worker worker) {
        this.user = user;
        this.users = new User[0];
        this.productsAtStore = new Product[0];
        this.worker = worker;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Product[] getProductsAtStore() {
        return productsAtStore;
    }

    public void setProductsAtStore(Product[] productsAtStore) {
        this.productsAtStore = productsAtStore;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void menu(int n){
        Scanner scanner= new Scanner(System.in);
        int i=scanner.nextInt();
        switch (n){
            case 1:{
                addUser(user);
            }
            case 2:{
                LogIn(i);
            }
            case 3:{
                break;
            }
        }

    }

    public void addUser(User user){
        users= new User[users.length+1];
        users[users.length-1]=user;
    }

    public void LogIn(int n){
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        boolean available1=scanner.nextBoolean();
        for (int i=0; i< users.length; i++){
            if (user.getUserName().equals(users[i].getUserName()) && user.getPassword().equals(users[i].getPassword())) {
                if (user instanceof Worker) {
                    switch (n) {
                        case 1: {
                            PrintAllCostumers();
                        }
                        case 2: {
                            PrintAllMembershipCostumers();
                        }
                        case 3: {
                            CostumerWithMoreThan1Purchase();
                        }
                        case 4: {
                            CostumerWhoSpentTheMost();
                        }
                        case 5: {
                            addProductToTheStore(product);
                        }
                        case 6: {
                            availabilityOfProduct(index, available1);
                        }
                        case 7: {
                            WorkerIsBuying(index);
                        }
                        case 8: {
                            int option=scanner.nextInt();
                            menu(option);
                            break;
                        }
                    }
                } else {
                    switch (n) {
                        case 1: {
                            CostumerIsBuying(index);
                        }
                        case 2: {
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("password or user name are wrong");
                break;
            }
        }
    }
    public void PrintAllCostumers(){
        System.out.println(Arrays.toString(users));
    }

    public void PrintAllMembershipCostumers(){
        for (int i=0; i<users.length; i++){
            if (users[i].getMembership()){
                System.out.println(users[i]);
            }
        }
    }

    public void CostumerWithMoreThan1Purchase(){
        for (int i=0; i<users.length; i++){
            if (users[i].getPurchases()>=1){
                System.out.println(users[i]);
            }
        }
    }

    public void CostumerWhoSpentTheMost(){
        double max=0;
        int index=0;
        for (int i=0; i<users.length; i++){
            if (users[i].getTotalSpent()>max){
                max=users[i].getTotalSpent();
                index=i;
            }
        }
        System.out.println(users[index]);
    }

    public void addProductToTheStore(Product product){
        productsAtStore=new Product[getProductsAtStore().length+1];
        productsAtStore[getProductsAtStore().length-1]=product;
    }

    public void availabilityOfProduct(int index ,boolean available1){
        System.out.println(Arrays.toString(productsAtStore));
        if (index< getProductsAtStore().length) {
            productsAtStore[index].setAvailable(available1);
        }
    }

    public void CostumerIsBuying(int index){
        for (int i=0;i< getProductsAtStore().length && index< getProductsAtStore().length; i++){
            if(index==i) {
                addProductToTheStore(getProductsAtStore()[index]);
                if (user.getMembership()) {
                    user.getCart().setTotal(user.getCart().getTotal() * (1 - getProductsAtStore()[index].getDiscount()));
                }
            }
            else {
                if (index == -1) {
                    user.getCart().setTotal(0);
                    user.getCart().setProducts(new Product[0]);
                    user.setPurchases(user.getPurchases() + 1);
                    System.out.println(user.getCart().getDate());
                }
            }
        }
    }

    public void WorkerIsBuying(int index){
       for (int i=0;i< getProductsAtStore().length && index< getProductsAtStore().length; i++){
           if(index==i) {
               addProductToTheStore(getProductsAtStore()[index]);
               switch (getWorker().getAdministration()) {
                   case 1: {
                       worker.getCart().setTotal(worker.getCart().getTotal() * (0.9));
                   }
                   case 2: {
                       worker.getCart().setTotal(worker.getCart().getTotal() * (0.8));
                   }
                   case 3: {
                       worker.getCart().setTotal(worker.getCart().getTotal() * (0.7));
                   }
               }
           }
               else{
                   if (index==-1) {
                       worker.getCart().setTotal(0);
                       worker.getCart().setProducts(new Product[0]);
                       worker.setPurchases(worker.getPurchases() + 1);
                       System.out.println(worker.getCart().getDate());
                   }
               }
       }
    }

    @Override
    public String toString() {
        return "Store{" +
                "user=" + user +
                ", users=" + Arrays.toString(users) +
                ", productsAtStore=" + Arrays.toString(productsAtStore) +
                ", product=" + product +
                ", worker=" + worker +
                '}';
    }
}
