import java.util.Scanner;

public class Game extends Inventory{

    private Scanner input = new Scanner(System.in);
    public void start(){
        boolean a = true;
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.next();
        Player player1 = new Player(playerName);
        System.out.println("Sayın " + player1.getName() + " bu karanlık ve sisli adaya hoşgeldiniz!");
        System.out.println("Burada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz!");
        player1.selectChar();

        Location location = null;
        while(a){
            player1.printInfo();
            System.out.println();
            System.out.println("##########Bölgeler##########");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yok.");
            System.out.println("2 - Mağaza --> Silah veya Zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara --> Ödül <Yemek>, dikkatli ol zombi çıkabilir!");
            System.out.println("4 - Orman --> Ödül <Odun>, dikkatli ol vampir çıkabilir!");
            System.out.println("5 - Nehir --> Ödül <Su>, dikkatli ol ayı çıkabilir!");
            System.out.println("6 - Maden --> Ödül <eşya kazanma ihtimali>, dikkatli ol yılan çıkabilir.");
            System.out.println("0 - Çıkış Yap. --> Oyunu Sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    if (!player1.getInventory().getAward()[0].equals("boş") && !player1.getInventory().getAward()[1].equals("boş") && !player1.getInventory().getAward()[2].equals("boş")){
                        System.out.println("Tebrikler oyunu bitirdiniz.");
                        a = false;
                        break;
                    }
                    location = new SafeHouse(player1);
                    break;
                case 2:
                    location = new ToolStore(player1);
                    break;
                case 3:
                    location = new Cave(player1);
                    break;
                case 4:
                    location = new Forest(player1);
                    break;
                case 5:
                    location = new River(player1);
                    break;
                case 6:
                    location = new Mine(player1);
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız.");
                    continue;
            }
            if (location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin.");
               break;
            }
           if (!location.onLocation()){
               System.out.println("GAME OVER!");
               break;
           }
        }




    }
}
