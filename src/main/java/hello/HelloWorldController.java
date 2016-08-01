package hello;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Menu;
import entity.Order;
import entity.ResponseData;

@RestController
@RequestMapping("/webhook")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody ResponseData req){

    	Menu m1=new Menu("Strawberry Basil Soda",10,"http://atmedia.imgix.net/51908962be2e4dbae14b488de63831c7e57a86a9",false);
    	Menu m2=new Menu("Cucumber Gimlet",8,"http://assets.epicurious.com/photos/560dd770f3a00aeb2f1d27b2/master/pass/235327.jpg",false);
    	Menu m3=new Menu("The Bright & Bitter",6,"https://716f24d81edeb11608aa-99aa5ccfecf745e7cf976b37d172ce54.ssl.cf1.rackcdn.com/the-bright--bitter-1280924l1.jpg",false);
    	Menu m4=new Menu("Blueberry Hard Lemonade",9,"http://4.bp.blogspot.com/-JcwBEm9JNlU/T_ZMDfE6FGI/AAAAAAAABA8/N5IFoJCqWXc/s1600/blueberrylemonade4.jpg",false);
    	Menu m5=new Menu("Bubbly Lemonade",15,"http://www.bakespace.com/images/large/d4523ab8582819b31e6f2e7e0147b2ab.jpeg",true);
    	Menu m6=new Menu("Mojito",12,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTdVYlA2iLCpBGiucUN6KYQGuJWPH8EcDZShNx1-LqZIcs9ZqgONg",true);
    	
    	List<Menu> list = new ArrayList<Menu>();
    	list.add(m1);
    	list.add(m2);
    	list.add(m3);
    	list.add(m4);
    	list.add(m5);    	 
    	list.add(m6); 
    	
        String speech = "empty speech";
        String  slack_message = null;
        String data = "";
        if (req!=null) { 
        	ResponseData  requestBody = req;
            if (requestBody.getResult()!=null) {
                speech = "";

                if (requestBody.getResult().getFulfillment()!=null) {
                    speech += requestBody.getResult().getFulfillment().getSpeech();
                    speech += ' ';
                }
                if (requestBody.getResult().getAction()!=null) {
                    if(requestBody.getResult().getAction().equals("getTotalCost" ) || requestBody.getResult().getAction().equals("reorderTotalCost"))
                    {                                               
                          
                    	   Order order=new Order();
                    	      
                        	   order.setNumber(requestBody.getResult().getParameters().getNumber());
                        	   order.setIce(requestBody.getResult().getParameters().getIce());
                               order.setIngredients(requestBody.getResult().getParameters().getIngredients());
                               order.setName(requestBody.getResult().getParameters().getName());
                               order.setUser_name(requestBody.getResult().getParameters().getUser_name());
                            List<Order> orderList = new ArrayList<Order>();
                            orderList.add(order);
                         int[] cost=new int[30];
                        String[] image_url=new String[30];                     
                       
                        double grandTotal=0.00;
                       for (Menu obj : list) 						
					    {  
	                          if(order.getName().equals(obj.getDrinkName())){
	                              cost[0]= order.getNumber() * obj.getPrice();
	                              image_url[0] = obj.getImage_url();  
	                              grandTotal = grandTotal+cost[0] + (.1 * cost[0]);
	                           }                       
	                    }                       
                        
                        if(requestBody.getResult().getAction().equals("getTotalCost"))
                        {
                            speech = "So, your order is "+ orderList.get(0).getNumber()  +" "+ orderList.get(0).getName() +" with "+ orderList.get(0).getIngredients()  + " ingredient and "+ orderList.get(0).getIce() + " ice. This would be a total of "+"$" + grandTotal +" including taxes & 10% gratuity. Should I confirm?";
                           
                            slack_message = "{ 'text': 'You have ordered: ', 'attachments': [{'text': '*'" +  orderList.get(0).getName()  + "'* with _' "+ orderList.get(0).getIngredients() +" '_ ingredients and _' "+ orderList.get(0).getIce() + "'_ ice' + '\nQuantity: ' "+ orderList.get(0).getNumber() + "'\nCost: $' "+ cost[0]+",'thumb_url':"+ image_url[0]+", 'mrkdwn_in': ['text']},{'fallback': 'Your total order cost is $' "+ grandTotal + "' (including taxes & 10% gratuity). Should I confirm?','title': 'Your total order cost is $' "+ grandTotal + "' (including taxes & 10% gratuity). Should I confirm?','callback_id': 'comic_1234_xyz', 'color': '#3AA3E3', 'attachment_type': 'default',}]}";
                        }
                       else if(requestBody.getResult().getAction().equals("reorderTotalCost"))
                        {
                            speech = "Your last order was "+ orderList.get(0).getNumber() +" "+ orderList.get(0).getName()  +" with "+ orderList.get(0).getIngredients() + " ingredient and "+ orderList.get(0).getIce()  + " ice. This would be a total of "+"$" + grandTotal +" including taxes & 10% gratuity. Should I repeat same?";                            
                          
                            slack_message = "{'text': 'Your last order was: ','attachments': [ {'text': '*' "+ orderList.get(0).getName() +" '* with _' "+ orderList.get(0).getIngredients() +" '_ ingredients and _' "+ orderList.get(0).getIce() +" '_ ice' + '\nQuantity: ' "+ orderList.get(0).getNumber() +" '\nCost: $' "+ cost[0]+",'thumb_url':"+ image_url[0]+",'mrkdwn_in': ['text'] },{'fallback': 'Your total order cost is $' "+ grandTotal +" ' (including taxes & 10% gratuity). Should I repeat same?','title': 'Your total order cost is $' "+ grandTotal + "' (including taxes & 10% gratuity). Should I repeat same?','callback_id': 'comic_1234_xyz','color': '#3AA3E3','attachment_type': 'default'}]}";
                                       
                        } 
                       else if(requestBody.getResult().getAction().equals("getTotalCostMultiple"))
                       {
                    	               
                    	   Order order1=new Order();
                 	      
                    	   order1.setNumber(requestBody.getResult().getParameters().getNumber());
                    	   order1.setIce(requestBody.getResult().getParameters().getIce());
                           order1.setIngredients(requestBody.getResult().getParameters().getIngredients());
                           order1.setName(requestBody.getResult().getParameters().getName());
                           order1.setUser_name(requestBody.getResult().getParameters().getUser_name());
	                        List<Order> orderList1 = new ArrayList<Order>();
	                        double grandTotal1=0.00;
	                        orderList1.add(order);
	                        int[] cost1=new int[30];
	                        String[] image_url1=new String[30];                       
		                    
		                    Iterator<Menu> it1 = list.iterator();
		                    double grandTota1l=0.00;
		                    speech="So, your order is ";
		                    while(it1.hasNext() ){        
		                    
		                       for(int i=0;i<orderList1.size();i++)
		                       {
		                          if(orderList1.get(i).getName().equals(it1.next().getDrinkName())){
		                              cost1[i] = orderList1.get(i).getNumber() * it1.next().getPrice();
		                              image_url1[i] = it1.next().getImage_url();                        
		                           }
		                                                    
		                        }
		                    
		                      }  
		                    for(int i=0;i<orderList1.size();i++)
		                       {
			                       grandTotal1 = grandTotal1+cost1[i] + (.1 * cost1[i]);	
		                           speech = speech+ orderList.get(i).getNumber()  +" "+ orderList.get(i).getName() +" with "+ orderList.get(i).getIngredients() + " ingredient and "+ orderList.get(i).getIce() + " ice and ";
		                           slack_message = "{'text': 'You have ordered: ','attachments': [{'text': '*' + drinkname1 + '* with _' + ingredients1 + '_ ingredients and _' + ice1 + '_ ice' + '\nQuantity: ' + quantity1 + '\nCost: $' + cost1,'thumb_url': image_url1,'mrkdwn_in': ['text']},"
		                           		                                                       + "{'text': '*' + drinkname2 + '* with _' + ingredients2 + '_ ingredients and _' + ice2 + '_ ice' + '\nQuantity: ' + quantity2 + '\nCost: $' + cost2,'thumb_url': image_url2,'mrkdwn_in': ['text']},"
		                           		                                                       + "{'fallback': 'Your total order cost is $' + grandTotal1 + ' (including taxes & 10% gratuity). Should I confirm?','title': 'Your total order cost is $' + grandTotal1 + ' (including taxes & 10% gratuity). Should I confirm?','callback_id': 'comic_1234_xyz''color': '#3AA3E3','attachment_type': 'default',}]"
		                           		         + "}";
		                          
		                       }
		                    speech=speech+ "This would be a total of "+"$" + grandTotal1 +" including taxes & 10% gratuity. Should I confirm?";
                       }
                       else if(requestBody.getResult().getAction().equals("help"))
                       {
                           speech = "Hi, here are some example tasks that you can ask me to do: **See menu by saying: *I want to see menu *What is special today? *I want to order a drink **Or simply order a drink from menu by saying: *I want 2 mojito. *Get me 1 strawberry basil soda. **Confirm or update your drink order: *I wanna update my order. *I want to change drink to blueberry hard lemonade. *update ingredients *update ice quantity **Repeat order";
                           slack_message = "{'text': 'Hi, here are some example tasks that you can ask me to do:\n\nSee menu by saying:\nI want to see menu\nWhat is special today?\nI want to order a drink\n\nOr simply order a drink from menu by saying:\nI want 2 mojito.\nGet me 1 strawberry basil soda.\n\nConfirm or update your drink order:\nI wanna update my order.\nI want to change drink to blueberry hard lemonade.\nupdate ingredients\nupdate ice quantity\n\nRepeat order'}";                        
                       } 
                       else if(requestBody.getResult().getAction().equals("getDrinksMenu"))
                       {
                           speech = "Main menu: * Strawberry Basil Soda * Cucumber Gimlet * The Bright & Bitter * Blueberry Hard Lemonade Today's special menu: * Bubbly Lemonade * Mojito";
                           slack_message = "{'text': 'Main menu: \n* Strawberry Basil Soda \n* Cucumber Gimlet \n* The Bright & Bitter \n* Blueberry Hard Lemonade \nToday's special menu: \n* Bubbly Lemonade \n* Mojito'}";
                                                  
                       }                       
                       else if(requestBody.getResult().getAction().equals("getSpecialMenu"))
                       {
                           speech = "Today's special menu: * Bubbly Lemonade * Mojito";
                           slack_message = "{'text': 'Today's special menu: \n* Bubbly Lemonade \n* Mojito'}";
                             
                       }                  
                       data = "{'slack': slack_message}";
                   }                       

          
                        System.out.println(req);
                }
            }
        }
        return new WebhookResponse(speech,speech,data);
    }
   
}
