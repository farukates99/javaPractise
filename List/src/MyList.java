public class MyList<T>{
    private Object[] value;
    private int capacity;
    private int size;
    public MyList(int capacity) {
        this.capacity = capacity;
        this.value=new Object[capacity];
        this.size=0;
    }
    public MyList() {
        this.value=new Object[10];
        this.size=0;
        this.capacity=10;
        this.value=new Object[this.capacity];
    }
    public void printSize(){
        int i=0;
        for(i=0;;i++) {
            if (this.value[i] == null) {
                System.out.println("Size: "+i);
                return ;
            }
        }
    }
    public int size(){
        int i=0;
        for(i=0;;i++) {
            if (this.value[i] == null) {
                return i;
            }
        }
    }
    public void printCapacity(){
        System.out.println("Capacity: "+this.value.length);
        return;
    }
    public int getCapacity(){
        return this.value.length;
    }
    public void add(Object newData){
        if(this.size()==this.getCapacity()-1){
            this.capacity=this.capacity*2;
            Object[] newValue;
            newValue=this.value;
            int size=this.size();
            this.value=new Object[this.capacity];
            for(int i=0;i<size;i++){
                this.value[i]=newValue[i];
            }
            this.value[this.size()] = newData;
            return;
        }
        else{
            this.value[this.size()] = newData;
            return;
        }
    }
    public void printArray(){
        for(int i=0;i<this.size();i++){
            System.out.println(i+". value: "+this.value[i]);
        }
    }
    public Object get(int index){
        if(index>size()){
            return null;
        }
        return this.value[index];
    }
    public void remove(int index){
        int i=0;
        if(index>size()){
            System.out.println("Wrong index");
            return;
        }
        Object[] newValue;
        newValue=this.value;
        for(i=0;i<size();i++){
            if(i==index){
                break;
            }
        }
        for(;i<size()-1;i++){
            this.value[i]=newValue[i+1];
        }
        this.value[i]=null;
        printArray();
    }
   public void set(int index,T data){
       if(index>size()){
           System.out.println("Wrong index");
           return;
       }
       this.value[index]=data;
       System.out.println("The data successfully changed");
   }
   public int indexOf(T data){
       for(int i=0;i<size();i++){
           if(this.value[i]==data){
               return i;
           }
       }
       return -1;
   }
   public int lastIndexOf(T data){
       for(int i=size();i>-1;i--){
           if(this.value[i]==data){
               return i;
           }
       }
       return -1;
   }
   public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        return false;
   }
   public void clear(){
       for(int i=0;i<size();i++){
           this.value[i]=null;
       }
       return;
   }
   public void toArray(){
        Object[] newArray;
        newArray= new Object[this.size()];
       for(int i=0;i<this.size();i++){
           newArray[i]=this.value[i];
       }
       this.value=newArray;

   }
   public boolean contains(T data){
        if(this.indexOf(data)==-1){
            return false;
        }
        return true;
   }
    public Object[] sublist(int start,int finish){
        Object[] newArray;
        newArray= new Object[this.size()];
        for(int i=start;i<this.size()|| i<finish+1;i++){
            newArray[i]=this.value[i];
        }
        return newArray;
    }
}
