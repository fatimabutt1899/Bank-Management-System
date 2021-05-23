package bankmanagementsystem;
    
public class Savings extends Accounts{
    
    float IntRate= 0.02f;
     @Override
     public float balCal(float bal)
     {
         float cal = super.balCal(bal);
         return (cal*IntRate)+cal;
     }
}
