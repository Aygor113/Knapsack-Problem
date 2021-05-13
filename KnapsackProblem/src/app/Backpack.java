package app;
import java.util.ArrayList;
import java.util.List;
public class Backpack 
{
	 int Capacity;
	 public int Load_value = 0;
     public int Actual_load = 0;
     public int Load_weights = 0;
     
	  public Backpack(int capacity)
      {
          Capacity = capacity;
      }
	  
      public void Load(List<Integer> index, List<Integer> values, List<Integer> weights)    
      {                                                                           
          for(int x:index)
          {

              if ((Actual_load += weights.get(x)) <= Capacity)
              {
                  Load_value += values.get(x);

                  //System.out.print("\t");

                  //System.out.print("\n");
              }
              else
              {
                  Actual_load -= weights.get(x);
              }
          }
          Load_weights = Actual_load;
      }
}
