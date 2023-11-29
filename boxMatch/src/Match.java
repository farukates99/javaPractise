public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1=f1;
        this.f2=f2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
    }
    boolean isCheck(){
        return ((f1.weight>=minWeight && f1.weight<=maxWeight) && (f2.weight>=minWeight && f2.weight<= maxWeight));
    }
    void run(){
        double whoIsFirst= Math.random()*100;

        if(isCheck()){
            if(whoIsFirst>50) {
            while(this.f1.health>0 && this.f2.health>0){

                this.f2.health = this.f1.hit(this.f2);
                System.out.println("Health "+this.f2.name +" :"+ this.f2.health);
                if(isWin()){
                    break;
                }
                this.f1.health=this.f2.hit(this.f1);
                System.out.println("Health "+this.f1.name +" :"+ this.f1.health);
                if(isWin()){
                    break;
                }

            }
        }else{
                while(this.f1.health>0 && this.f2.health>0){

                this.f1.health = this.f2.hit(this.f1);
                System.out.println("Health "+this.f1.name +" :"+ this.f1.health);
                if(isWin()){
                    break;
                }
                this.f2.health=this.f1.hit(this.f2);
                System.out.println("Health "+this.f2.name +" :"+ this.f2.health);
                if(isWin()){
                    break;
                }

            }

            }
        }else{System.out.println("the match is not suitable.");}
    }
    boolean isWin(){
        if(f2.health<=0){
            System.out.println(this.f1.name+" kazandı");
            return true;
        } else if (f1.health<=0){

            System.out.println(this.f2.name+" kazandı");
            return true;
        }
            return false;
    }

}
