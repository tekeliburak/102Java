import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    public  Player(String name){

        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Karakterler:");
        System.out.println("------------------------------------------------------------------------");
        for (GameChar gameChar: charList){
            System.out.println("ID: " + gameChar.getId() +"\t Karakter: " + gameChar.getName() + gameChar.getSpace()+ "\t Hasar: " + gameChar.getDamage() + "\t Sağlık: " + gameChar.getHealth() + "\t Para: " + gameChar.getMoney());

        }
        System.out.println("------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter giriniz: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Geçerli Sayı Giriniz.");

        }
        //System.out.println("Karakter: " + this.getCharName() + ", Hasar: " + this.getDamage() + ", Sağlık: " + this.getHealth() + ", Para: " + this.getMoney());

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println(
                "Silah: " + this.getInventory().getWeapon().getName() +
                        ", Zırh: " + this.getInventory().getArmor().getName() +
                        ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                ", Hasar: " + this.getTotalDamage() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney());
    }
    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        if (health<0){
            health = 0;
        }
        this.health = health;
    }
    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCharName(){
        return this.charName;
    }
    public void setCharName(String charName){
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
