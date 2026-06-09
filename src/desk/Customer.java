package desk;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextArea;

public class Customer {

    
    Object[][] CusBar = new Object[50][2];
    
    int ser = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); 

    
    public void cusEnter() {
        

       
        CusBar[ser][0] = LocalDateTime.now();
        
        ser++;
    }

    
    public String getStayTime(int index) {


        LocalDateTime enterTime = (LocalDateTime) CusBar[index][0];
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(enterTime, now);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60; 

        
        return String.format("%02d小時 %02d分鐘 %02d秒", hours, minutes, seconds);
    }
    
    
    public String getEnterTime(int index) {

        
        return ((LocalDateTime) CusBar[index][0]).format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    
        
        
        
     public void refreshTable(JTextArea textArea) {
            
            
            String sb ="";
            
            for (int i=0; i<this.ser; i++) {
            	
            	if(CusBar[i][0] == null) {
            		sb += (" 顧客: " + (i + 1) + " ------- 已刪單 -------\n");
                    continue;
            	}
            	
            	
                String enterTime = this.getEnterTime(i);
                String stayTime = this.getStayTime(i); 
                sb+=(" 顧客: "+(i+1)+" 進場時間: "+enterTime+" 目前已待: "+stayTime+"\n");
            }
            
            textArea.setText(sb);
             
    
        }
        

        
        public int[] getHours() {
      	   	int hour1=0;
      	   	int hour2=0;
      	   	int hour3=0;
      	   	int hour4=0;
      	   	

      	   	
        	for(int i=0; i<this.ser; i++) 
        	{
        		
        		
        		if (CusBar[i][0] == null) {
                    continue; 
                }
        		
                LocalDateTime enterTime = (LocalDateTime) CusBar[i][0];
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(enterTime, now);
                long hours = duration.toHours();
                hours =hours+1;
      		  	
                if(hours <= 1) 
                {
                	hour1++;
                }
                if(1< hours && hours<= 2) 
                {
                	hour2++;
                }
                if(2< hours && hours<= 3) 
                {
                	hour3++;
                }
                if(hours>=4) 
                {
                	hour4++;
                }
              
      		 }
        	
        	return new int[] {hour1,hour2,hour3,hour4};
        	
        	
                

      		  
      		  
  				
  			}
        
        
       public void passOneHour() {
           
            for (int i = 0; i < this.ser; i++) {
                if (CusBar[i][0] != null) {
                    LocalDateTime currentEnterTime = (LocalDateTime) CusBar[i][0];
                    
                    
                    CusBar[i][0] = currentEnterTime.minusHours(1);
                }
            }
            
        }
        
        
        public void deleteCustomer(int index) {
            
            if (index >= 0 && index < ser) {
                CusBar[index][0] = null;
                
            }
        }
        
        
        
}

		
        
        
        
        
