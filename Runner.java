package ds_lab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Runner
{    
    public static void main(String[] args)
    {       
        //String filePath = args[0];
        String filePath = "PathsGraphInput.txt";
        try
        {
            BufferedReader inFile = new BufferedReader(new FileReader(filePath));
            BufferedWriter outFile = new BufferedWriter(new FileWriter("outFile.txt"));
          
            //Read & Parse 1 line at a time
            String line = inFile.readLine();
            
            while(line != null)
            {
                String[] Size = line.split("\\s+");
                int size = Integer.parseInt(Size[0]);
                
                System.out.println(size);
                              
                NodeVertex[] vertexList = new NodeVertex[size];
                //create node and store in array
                for(int i=0; i<size; i++)
                {
                    NodeVertex newNode = new NodeVertex(i);
                    vertexList[i] = newNode;
                }
  
                //System.out.println(size);
                //keeping track of current vertex
                int VertexCount = 0;
   
                while(VertexCount < size) 
                {
                    line = inFile.readLine();
                    LinkedListNorm neighbors = new LinkedListNorm();
                    String[] neighbor  = line.split("\\s+");
                    
                    for(int i = 0; i<size; i++)
                    {
                        if (neighbor[i] == "1")
                        {
                            neighbors.append(vertexList[i]);
                        }
                        else if (neighbor[i] != "1" && neighbor[i] != "0")
                        {
                            //error, matrix can only have 1 or 0
                        }
                                              
                    }
                    //System.out.println(neighbors);                    
                    
                    vertexList[VertexCount].neighbors = neighbors;                    
                    VertexCount += 1;                   
                }
                
                Graph graph = new Graph(size, outFile);
                for(int i=0; i<size; i++)
                {
                    graph.append(vertexList[i]);
                }
                
                System.out.println(graph.toString());
                graph.findPath();
     
                
                line = inFile.readLine();      
                //Problem: Invalid matrix 


            }
            //System.out.println("End of file");
            inFile.close();
            outFile.close();

        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {       
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {           
            e.printStackTrace();
            
        }
    }
}
