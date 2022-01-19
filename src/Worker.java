import java.util.Arrays;

public class Worker extends User{
    private User[] users;
    private int administration;

    public Worker(String firstName, String surName, String userName, String password, int administration ,Cart cart) {
        super(firstName, surName, userName, password, false, cart);
        this.administration = administration;
    }

    public int getAdministration() {
            if(this.administration==1){
                System.out.println("regular worker");
            }
            if(this.administration==2){
                System.out.println("CEO");
            }
            if (this.administration==3){
                System.out.println("administration member");
            }

        return administration;
    }

    public void setAdministration(int administration) {
        this.administration = administration;
    }

    public void fullName(){
        super.fullName();
        System.out.println(getAdministration());
    }
    public void printAllCostumers(){
        System.out.println(Arrays.toString(users));
    }
    public void printAllMembership(){
        for (int i=0; i< users.length; i++){
            if (users[i].getMembership()){
                System.out.println(users[i]);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()+ "Worker:" +
                "administration=" + administration ;
    }
}
