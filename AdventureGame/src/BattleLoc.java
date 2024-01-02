import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String locName, Obstacle obstacle, String award, int maxObstacle) {
        super(player, locName);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }
    @Override
    boolean onLocation() {
        int obsNumber = this.randomObstacle();
        System.out.println("This is the "+ this.getLocName());
        System.out.println("Be Careful! there are "+obsNumber +" "+this.getObstacle().getName()+"s around");
        System.out.println("Fight or Run");
        String selectCase= input.nextLine();
        selectCase=selectCase.toUpperCase();
        while ( !selectCase.equals("F") && !selectCase.equals("R")){
            System.out.println("Wrong case, try again");
            selectCase= input.nextLine();
            selectCase=selectCase.toUpperCase();
        }
        if(selectCase.equals("F")){
            System.out.println("Let the war begin!");
            boolean gameOver=combat(obsNumber);
            if(gameOver==false){
                return false;
            }
        }
        return true;
    }


    public boolean combat(int obsNumber){
        for(int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerInfo();
            obstacleInfo();
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("Hit or Run");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("R")){
                    System.out.println("Coward!!!");
                    return true;
                }

                if(selectCombat.equals("H")){
                        Random random= new Random();
                        int whofirst=random.nextInt(101);
                        if(whofirst>50){
                         playerAttack();
                            if(this.getObstacle().getHealth()>0){
                         enemyAttack();
                            }
                        } else{
                            enemyAttack();
                            if(this.getPlayer().getHealth()>0){
                            playerAttack();
                            }
                        }
                }
            }
            System.out.println("--------------------");
            if(this.getPlayer().getHealth()<=0){
                return false;
            }
            System.out.println(this.getObstacle().getName()+" is dead");
            System.out.println(this.getObstacle().getName()+" number is "+(obsNumber-i));
            this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getMoney());
            System.out.println("--------------------");
        }

        System.out.println("####################");
        System.out.println("All enemies in the around is dead");
        switch (this.getAward()) {
            case "firewood" -> this.getPlayer().inventory.setFirewood(true);
            case "fisch" -> this.getPlayer().inventory.setFisch(true);
            case "food" -> this.getPlayer().inventory.setFood(true);
        }
        this.setFinish(true);
        this.getPlayer().setMoney(this.getObstacle().getMoney()+this.getPlayer().getMoney());
        if(this.getObstacle().getName()=="Snake"){
            int selectArmor = 3;
            Armor selectedArmor = Armor.getArmorObj(selectArmor);
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("Free Armor, You find: "+ this.getPlayer().getInventory().getArmor().getName());
        }
        return true;
    }

    public void playerAttack(){
        System.out.println("Now,"+this.getPlayer().getCharName()+" is hitting:");
        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getDamage());
        afterHit();
    }
    public void enemyAttack(){
        System.out.println("Now,"+this.getObstacle().getName()+" is hitting:");

            System.out.println("------------------");
            System.out.println("Monster is attacking you");
            int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().inventory.getArmor().getProtect();
            if(obstacleDamage<0){
                obstacleDamage=0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
            afterHit();
    }

    public void afterHit(){
        System.out.println("-------------------------");
        System.out.println("Health:"+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Health:"+ this.getObstacle().getHealth());
        System.out.println("-------------------------");

    }
    public void playerInfo(){
        System.out.println("Player Info:");
        System.out.println("Health:"+this.getPlayer().getHealth());
        System.out.println("Damage:"+this.getPlayer().getDamage());
        System.out.println("Block:"+this.getPlayer().inventory.getArmor().getProtect());
        System.out.println("-----------------------");
        System.out.println();
    }
    public void obstacleInfo(){
        System.out.println("-----------------------");
        System.out.println(this.getObstacle().getName()+"Info:");
        System.out.println("Health: "+this.getObstacle().getHealth());
        System.out.println("Damage: "+this.getObstacle().getDamage());
        System.out.println("Money: "+this.getObstacle().getMoney());
        System.out.println();


    }
    public int randomObstacle(){
        Random r=new Random();
        if(this.getObstacle().getName()=="Snake"){
            return r.nextInt(4)+4;
        }
        return r.nextInt(3)+1;

    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
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


}
