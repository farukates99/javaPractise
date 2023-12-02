import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
public class Screen {
    Scanner input= new Scanner(System.in);
    int islem=0;
    int miktar=0;
    User newUser=  new User();
    AccountOperation whichOperation=new AccountOperation();
    Screen(){
        System.out.println("Bankamıza Hoşgeldiniz");
    }
    void startScreen(){
        while(islem!=3){
        System.out.println("1. Yeni Hesap Oluşturun");
        System.out.println("2. Giriş Yapınız");
        System.out.println("3. Çıkış Yapınız");
        System.out.println("Yapacağınız İşlemi Seçin");
        islem= input.nextInt();
        while(!(islem == 1 || islem == 2 || islem==3)){
            System.out.println("Yanlış rakam girdiniz tekrar deneyin");
            System.out.println("1. Yeni Hesap Oluşturun");
            System.out.println("2. Giriş Yapınız");
            System.out.println("3. Çıkış Yapınız");
            System.out.println("Yapacağınız İşlemi Seçin");
            islem= input.nextInt();
        }
        if(islem==1){
            System.out.println("Kayıt olunuz");
            System.out.println("Adınızı Giriniz: ");
            this.newUser.name= input.next();
            System.out.println("Tel No Giriniz: ");
            this.newUser.telNo= input.next();
            System.out.println("Kimlik No Giriniz: ");
            this.newUser.ID= input.next();
            System.out.println("Şifrenizi Giriniz: ");
            this.newUser.password= input.next();
            System.out.println("Kaydınız Başarıyla Tamamlandı");
        }
        else if(islem==2){
            System.out.println("Bilgilerinizi Giriniz");
            System.out.println("Kimlik No Giriniz: ");
            String kullanici= input.next();
            if(kullanici.equals(this.newUser.ID)){
                System.out.println("Şifrenizi Giriniz: ");
                String sifre= input.next();
                while(!(sifre.equals(this.newUser.password))) {
                    System.out.println("Şifre yanlış tekrar deneyin:");
                    sifre= input.next();
                }
                if (sifre.equals(this.newUser.password)) {
                        giris();
                        break;
                }


            }
            System.out.println("Böyle bir kullanıcı yok");
        }else{
            System.out.println("Güle Güle");
        }
    }
    }
    void giris(){
        System.out.println("1. Para Gönder");
        System.out.println("2. Para Çek");
        System.out.println("3. Para Yatır");
        System.out.println("4. Bakiye Sorgula");
        System.out.println("5. Çıkış");
        System.out.print("Yapacağınız işlemi seçin: ");
        islem= input.nextInt();
        if(islem==1){
            System.out.println("Miktarı Giriniz:");
            miktar= input.nextInt();
            newUser.bakiye=whichOperation.paraGonder(miktar, newUser.bakiye);
            giris();
        } else if (islem==2) {
            System.out.println("Miktarı Giriniz:");
            miktar= input.nextInt();
            newUser.bakiye=whichOperation.paraCekme(miktar, newUser.bakiye);
            giris();
        } else if (islem==3) {
            System.out.println("Miktarı Giriniz:");
            miktar= input.nextInt();
            newUser.bakiye=whichOperation.paraYatır(miktar, newUser.bakiye);
            giris();
        } else if (islem==4) {
            System.out.println("Bakiyeniz: "+newUser.bakiye);
            giris();
        } else if (islem==5) {
            System.out.println("Güle Güle");
            startScreen();
        }else {
            System.out.println("Yanlış numara girdiniz ana ekrana yönlendiriliyorsunuz.");
            giris();
        }
    }
}
