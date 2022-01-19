
public class User{
    private String firstName;
    private String surName;
    private String userName;
    private String password;
    private boolean membership;
    private Cart cart;
    private double totalSpent;

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    private int purchases;

    public User(String firstName, String surName, String userName, String password, boolean membership, Cart cart) {
        this.firstName = firstName;
        this.surName = surName;
        this.userName = userName;
        this.password = password;
        this.membership = membership;
        this.cart=cart;
        this.purchases=0;
        this.totalSpent=0;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getMembership(){
        return this.membership;
    }

    public void setMembership(boolean membership){
        this.membership =  membership;
    }
    void validName(){
        for (int k=0; k<10; k++){
            for (int i=0; i<getFirstName().length(); i++){
                if (getFirstName().charAt(i)==k){
                    System.out.println("invalid first name");
                    break;
                }
            }
            for (int j=0; j<getSurName().length(); j++){
                if (getSurName().charAt(j)==k){
                    System.out.println("invalid sur name");
                    break;
                }
            }
        }
    }
    void validPassword(){
        if (this.password.length()<6){
            System.out.println("invalid password");
        }
    }

    public void fullName() {
        System.out.println("hello "+ getFirstName() + " " + getSurName());
    }

    @Override
    public String toString() {
        return "User: " +
                "firstName='" + firstName + '\n' +
                ", surName='" + surName + '\n' +
                ", userName='" + userName + '\n' +
                ", password='" + password + '\n' +
                ", membership='" + membership + '\n' +",cart="+cart+ '\n'+" ,purchases= "+purchases;
    }

    public boolean isMembership() {
        return membership;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent() {
        this.totalSpent = getTotalSpent()+getCart().getTotal();
    }
}
