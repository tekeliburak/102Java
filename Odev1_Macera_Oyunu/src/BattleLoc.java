import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;




    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle ) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

@Override
    public boolean onLocation(){
        if (!this.getName().equals("Maden")){
            if (this.isThere(this.award)){
                if (!this.getPlayer().getInventory().getAward()[0].equals("boş") && !this.getPlayer().getInventory().getAward()[1].equals("boş") && !this.getPlayer().getInventory().getAward()[2].equals("boş")){
                    return true;
                }
                System.out.println("Daha önce bu ödülü aldınız. Başka bir harita seçiniz.");
                return true;
            }
        }


        int obsNumber = this.randomObstacleNumber();
    System.out.println("Şuan buradasınız: " + this.getName());
    System.out.println("Dikkatl ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
    System.out.print("<S>avaş veya <K>aç: ");
    String selectCase = input.nextLine();
    selectCase = selectCase.toUpperCase();
    if (selectCase.equals("S") && combat(obsNumber)){
        //Savaşma İşlemi
        System.out.println();
            System.out.println(this.getName() + " Tüm Düşmanları Yendiniz.");
            if (this.getObstacle().getName().equals("Yılan")){
                int chanceAward = randomChanceNumber();
                if (chanceAward<15){
                    System.out.println("Silah kazanacaksınız.");
                    chanceAward = randomChanceNumber();
                    if (chanceAward<20){
                        System.out.println("Tüfek kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setWeapon(Weapon.weaponsAward()[2]);
                                break;
                            case 2:
                                System.out.println("Silah envantere eklenmedi.");
                                break;
                        }
                        return true;
                    } else if (chanceAward>=20 && chanceAward<50) {
                        System.out.println("Kılıç kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setWeapon(Weapon.weaponsAward()[1]);
                                break;
                            case 2:
                                System.out.println("Silah envantere eklenmedi.");
                                break;
                        }
                        return true;
                        
                    }
                    else{
                        System.out.println("Tabanca kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setWeapon(Weapon.weaponsAward()[0]);
                                break;
                            case 2:
                                System.out.println("Silah envantere eklenmedi.");
                                break;
                        }
                        return true;
                    }
                }
                else if (chanceAward>=15 && chanceAward<30){
                    System.out.println("Zırh kazanacaksınız.");
                    chanceAward = randomChanceNumber();
                    if (chanceAward<20){
                        System.out.println("Ağır Zırh kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setArmor(Armor.armorsAward()[2]);
                                break;
                            case 2:
                                System.out.println("Zırh envantere eklenmedi.");
                                break;
                        }
                        return true;
                    }
                    else if (chanceAward>=20 && chanceAward<50){
                        System.out.println("Orta zırh kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setArmor(Armor.armorsAward()[1]);
                                break;
                            case 2:
                                System.out.println("Zırh envantere eklenmedi.");
                                break;
                        }
                        return true;
                    }
                    else{
                        System.out.println("Hafif zırh kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().getInventory().setArmor(Armor.armorsAward()[0]);
                                break;
                            case 2:
                                System.out.println("Zırh envantere eklenmedi.");
                                break;
                        }
                        return true;
                    }

                } else if (chanceAward>=30 && chanceAward<55) {
                    System.out.println("Para kazanacaksınız.");
                    chanceAward = randomChanceNumber();
                    if (chanceAward<20){
                        System.out.println("10 para kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                                break;
                            case 2:
                                System.out.println("Para eklenmedi.");
                                break;
                        }
                        return true;
                    } else if (chanceAward>=20 && chanceAward<50) {
                        System.out.println("5 para kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                                break;
                            case 2:
                                System.out.println("Para eklenmedi.");
                                break;
                        }
                        return true;
                    }else {
                        System.out.println("1 para kazanacaksınız. İstiyorsanız 1'e basın, istemiyorsanız 2'ye basın.");
                        int secim = input.nextInt();
                        switch (secim){
                            case 1:
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                                break;
                            case 2:
                                System.out.println("Para eklenmedi.");
                                break;
                        }
                        return true;
                    }

                }
                else{
                    System.out.println("Ödül kazanamadınız.");
                }
                return true;
            }
        System.out.println("Kazanılan ödül: " + this.award);
        this.getPlayer().getInventory().setAward(this.award);
            return true;

    }
    if (this.getPlayer().getHealth() <= 0){
        System.out.println("Öldünüz.");
        return false;
    }

        return true;
    }
    public boolean combat(int obsNumber){
        int chanceNumber = randomChanceNumber();
        int snakeDamage = randomSnakeDamage();
            for (int i=1; i<= obsNumber;i++){
                this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
                if (this.getObstacle().getName().equals("Yılan")){
                    this.getObstacle().setDamage(snakeDamage);
                }
                playerStats();
                obstacleStats(i);
                while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){

                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")){
                        if (chanceNumber<50){
                            if (this.getObstacle().getHealth() > 0){
                                System.out.println();
                                System.out.println("Canavar size vurdu.");
                                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                                if (obstacleDamage <0){
                                    obstacleDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                                afterHit();
                            }
                            if (this.getPlayer().getHealth()<=0){
                                break;
                            }

                            System.out.println("Siz vurdunuz.");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                        else{
                            System.out.println("Siz vurdunuz.");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                            if (this.getObstacle().getHealth() > 0){
                                System.out.println();
                                System.out.println("Canavar size vurdu.");
                                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                                if (obstacleDamage <0){
                                    obstacleDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                                afterHit();
                            }
                        }

                    } else{
                        return false;
                    }

                } // while bitiş
                if (this.getObstacle().getHealth() <this.getPlayer().getHealth()){
                    System.out.println("Düşmanı öldürdünüz.");
                    System.out.println(this.getObstacle().getAward() + " para kazandınız.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel paranız: " + this.getPlayer().getMoney());

                } else{
                    return false;
                }

            }


        return true;
    }

    public boolean isThere(String a){
        int temp = 0;
        for (int i =0; i<getPlayer().getInventory().getAward().length; i++) {
            if (a.equals(this.getPlayer().getInventory().getAward()[i])) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }




    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı: " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri: ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödülü: " + this.getObstacle().getAward());


    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int randomChanceNumber(){
        Random c = new Random();
        return c.nextInt(100);
    }
    public int randomSnakeDamage(){
        Random s = new Random();
        return s.nextInt(3,7);
    }



    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
