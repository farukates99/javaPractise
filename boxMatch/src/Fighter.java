public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int blockChance;
    Fighter(String name, int damage, int health, int weight,int blockChance){
        this.name=name;
        this.damage=damage;
        this.health=health;
        this.weight=weight;
        if(blockChance>100 || blockChance<0){
            this.blockChance=0;
        }else this.blockChance=blockChance;
    }

    int hit(Fighter enemy){
        if(isBlock()){
            System.out.println(enemy.name+" blockladı");
            return enemy.health;
        }
        enemy.health=enemy.health-this.damage;
        System.out.println(this.name+" "+enemy.name+"'ye "+ this.damage+"hasar verdi.");
        if(enemy.health<0){
            return 0;
        }
        return enemy.health;
    }
    boolean isBlock(){
        double randomnumber= Math.random() * 100;
        return randomnumber >= blockChance;
    }
}
