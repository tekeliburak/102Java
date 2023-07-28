public class Inventory {
   private Weapon weapon;
   private Armor armor;
   private String[] award = new String[3];





    public Inventory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor = new Armor(-1,"Paçavra",0,0);
        this.award[0] = "boş";
        this.award[1] = "boş";
        this.award[2] = "boş";






    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String[] getAward() {
        return award;
    }

    public void setAward(String award) {
        if (this.award[0].equals("boş")){
            this.award[0] = award;
        } else if (this.award[1].equals("boş")) {
            this.award[1] = award;
        }
        else{
            this.award[2] = award;
        }

    }
}
