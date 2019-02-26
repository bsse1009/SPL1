package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    int n  = 0;
    int m = 0;
    ArrayList<String> states = new ArrayList <String>();	//** state list
    ArrayList<String> emotions = new ArrayList <String>();	//**  emotions list
    double start_p [] = new double [100];				//** store starting probability of state
    double  trans_p[][] = new double [100][100];		//** store transition table
    double  emit_p[][] = new double [100][100];			//** store emition probability table
    String observData ;									//** store users emotion sequence
    int status [] = new int [100];

    
    @FXML private Label header;
    @FXML private Label stateCounter;
    @FXML private Label emoCounter;
    
    @FXML
    private TextField stateName;
    @FXML private TextField emojiName;
    
    
    @FXML
    public void AddState(ActionEvent event) {
    	String state = stateName.getText();
        states.add(state);
        status[n] = n;
        n++;
        stateCounter.setText(String.valueOf(n));
        stateName.setText("");
    }

    public void addEmo (ActionEvent event) {
    	String emo = emojiName.getText();
        emotions.add(emo);
        m++;
        emoCounter.setText(String.valueOf(m));
        emojiName.setText("");
    }

    public void setTrans_p()
    {

    }

    public void setEmit_p()
    {

    }



    public void setObservData()
    {

    }
    
    @FXML
    public void gotoTableview(ActionEvent event) throws IOException
    {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	Scene tableViewScene = new Scene (tableViewParent);
    	
    	Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window1.setScene(tableViewScene);
    	window1.show();
    }
    
    //** obs array store the sequence of
    //** emoji corresponding the emotions list

   // String [] observations = observData.split(" ");
   // int c = 0;

  //  int obs [] = new int [observations.length];

    //**split obserbdate by space separator and push them in observations array
   /* public void convert()
    {    		
	   
		for (String i : observations)
	    {
	        //System.out.println(i);
	
	        for (int j = 0; j < m; j++)
	        {
	            if (i.equals(emotions.get(j)) )
	            {
	                obs [c] = j;
	                c++;
	                break;
	            }
	        }
	    }
	    
    }
   
	public void calculate() {
		
            int[] result = Viterbi.compute(obs, status, start_p, trans_p, emit_p);
            for (int i : result)
            {
                  System.out.print(states.get(i) + " ");
            }
        }
	*/
//		System.out.println();
}

