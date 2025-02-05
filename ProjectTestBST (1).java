import java.io.*;
class ProjectTestBST {
    BufferedReader fileReader;
    BST<String> bst;
    
    public static void main(String [] args){
        
        ProjectTestBST test = new ProjectTestBST("datafile.txt");
        
        test.bst.inorder();
        test.bst.search("java");
        test.bst.search("database");
        
    }
    
    public ProjectTestBST(String filename){
        
        try{
            
            bst = new BST <String>();
            fileReader = new BufferedReader(new FileReader(filename));
            while(readNextRecord()){}
               // readNextRecord();
            
        }
        
        catch (IOException e){
            
            e.printStackTrace();
            
        }
        
    }
    
    public boolean readNextRecord(){
        
        if(fileReader == null){
            
            System.out.println("Error: you must open the file first!");
            return false;
            
        }
        
        else{
            
            try{
                
                String data = fileReader.readLine();
                if(data == null)
                    return false;
                    
                int titleId = Integer.parseInt(data);;
                String title = fileReader.readLine();
                String author = fileReader.readLine();
                int numKeys = Integer.parseInt(fileReader.readLine());
                
                Article article = new Article(titleId, title, author);

                String keyword;
                for(int i = 0; i<numKeys; i++){
                    
                    keyword = fileReader.readLine();
                    bst.insert(keyword, article);
                    
                }
                
                fileReader.readLine();
            }
            
            catch(NumberFormatException e){
                
                System.out.println("Error: number expected!");
                return false;
                
            }
            
            catch(Exception e){
                
                System.out.println("Fatal Error: " + e);
                return false;
                
            }
            
        }
        
        return true;
    }
}