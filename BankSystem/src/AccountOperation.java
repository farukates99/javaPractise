public class AccountOperation {

    int paraMiktari;
    AccountOperation(){

    }
    int paraGonder(int paraMiktari,int bakiye){
        bakiye=bakiye-paraMiktari;
        return bakiye;
    }
    int paraCekme(int paraMiktari,int bakiye){
        bakiye=bakiye-paraMiktari;
        return bakiye;

    }
    int paraYatır(int paraMiktari,int bakiye){
        bakiye=bakiye+paraMiktari;
        return bakiye;

    }
    int bakiyeSorgula(int bakiye){

        return bakiye;

    }
}
