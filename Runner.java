package ds_lab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Runner class, reads and parses file into a linked list
 * translates adjacency matrix and size value to outFile
 * calls Graph.java
 * @author Bryan Cheung
 *
 */
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
                outFile.write(Integer.toString(size));
                outFile.newLine();
                              
                //NodeVertex[] vertexList = new NodeVertex[size];
                LinkedListNorm vertexList = new LinkedListNorm();
                //create node and store in array
                for(int i=0; i<size; i++)
                {
                    NodeVertex newNode = new NodeVertex(i);
                    newNode.setData(i);
                    vertexList.append(newNode);
                }

  
                //System.out.println(size);
                //keeping track of current vertex
                int VertexCount = 0;
   
                while(VertexCount < size) 
                {
                    line = inFile.readLine();
                    //new linked list called neighbors
                    LinkedListNorm neighbors = new LinkedListNorm();
                    String[] neighbor  = line.split("\\s+");
                    
                    String adjMatBuff ="";
                    for(int z=0; z<size;z++)
                    {
                        adjMatBuff += neighbor[z] + " ";       
                    }
                    outFile.write(adjMatBuff);
                    outFile.newLine();
                    
                    for(int i = 0; i<size; i++)
                    {                    
                        if (neighbor[i].equals("1"))
                        //if (neighbor[i] == "1")
                        {
                            neighbors.append(vertexList.search(i));                            
                        }       
                        
                        else if (!neighbor[i].equals("1") && !neighbor[i].equals("0") && neighbor.length != size)
                        {
                            outFile.write("Invalid Matrix");
                            //error, matrix can only have 1 or 0
                        }
                                              
                    }
                    //System.out.println(neighbors);                    
                    
                    //all nodes have same neighbor for some reason not good..
                    vertexList.search(VertexCount).setNeighbors(neighbors);
                    
                    //vertexList[VertexCount].setNeighbors(neighbors);                    
                    VertexCount += 1;                   
                }

                
                Graph graph = new Graph(size, outFile, vertexList);
                /*for(int i=0; i<size; i++)
                {
                    graph.append(vertexList[i]);
                }*/
                
                
                System.out.println(graph.toString());
                graph.findPath();
                  
                line = inFile.readLine();      
  


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


