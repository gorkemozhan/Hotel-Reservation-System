import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;

import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class Main extends JPanel {
	
	private JTextArea textArea;
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Services> services = new ArrayList<>();
    ArrayList<Integer> samehotelID = new ArrayList<>();
	int reservationCount = 0;
	
	public Main() {
		JMenuBar menuBar = new JMenuBar();
        
        
        JMenu fileMenu = new JMenu("File");
        JMenu newMenu = new JMenu("New");
        JMenu helpMenu = new JMenu("Help");
        
        JMenuItem reservationItem = new JMenuItem("Reservation");
        JMenuItem servicesItem = new JMenuItem("Services");
        JMenuItem exItem = new JMenuItem("Exit");
        JMenuItem contentItem = new JMenuItem("Contents");
        JMenuItem aboutItem = new JMenuItem("About");
        
        newMenu.add(reservationItem);
        newMenu.add(servicesItem);
        
        menuBar.add(fileMenu);
        fileMenu.add(exItem);
        menuBar.add(newMenu);
        menuBar.add(helpMenu);
        helpMenu.add(contentItem);
        helpMenu.add(aboutItem);
        
        
        setLayout(null);
        setBounds(0,0,500,500);
        menuBar.setBounds(4,0,500,20);
        add(menuBar);
        
        
        JButton button = new JButton();
        button.setBounds(80,30,150,25);
        button.setText("Display Reservations");
        button.setFocusable(false);
        button.setBackground(Color.lightGray);
        
        JButton button2 = new JButton();
        button2.setBounds(250,30,150,25);
        button2.setText("Display Extra Services");
        button2.setFocusable(false);
        button2.setBackground(Color.lightGray);
        
        JButton button3 = new JButton();
        button3.setBounds(80,60,150,25);
        button3.setText("Disp. Res. For City");
        button3.setFocusable(false);
        button3.setBackground(Color.lightGray);
        
        JButton button4 = new JButton();
        button4.setBounds(250, 60, 150, 25);
        button4.setText("Multithread Search");
        button4.setFocusable(false);
        button4.setBackground(Color.lightGray);
        
        
        JButton button5 = new JButton();
        button5.setBounds(80, 425, 150, 25);
        button5.setText("Save Reservations");
        button5.setFocusable(false);
        button5.setBackground(Color.lightGray);
        

        JButton button6 = new JButton();
        button6.setBounds(250, 425, 150, 25);
        button6.setText("Load Reservations");
        button6.setFocusable(false);
        button6.setBackground(Color.lightGray);
        
        
      
       
        
        add(button);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        
        
        textArea = new JTextArea(5, 5);
        textArea.setBounds(20,95, 440, 320);
        
       
        add(textArea);
        
        
       
        reservationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String city=JOptionPane.showInputDialog("Enter City "," ");
				int ID = reservationCount;
				String hotelNameWithRoomType=JOptionPane.showInputDialog("Enter Hotel Name "," ");
                int reservationStartWithRoomType=Integer.parseInt(JOptionPane.showInputDialog("Enter reservation start"," "));
                int reservationEndWithRoomType=Integer.parseInt(JOptionPane.showInputDialog("Enter reservation end"," "));
                String reservationMonthWithRoomType=JOptionPane.showInputDialog("Reservation Month "," ");
                String roomType=JOptionPane.showInputDialog("Select Room Type "," ");
                JOptionPane.showMessageDialog(null, "Reservation created successfully!");
                
            
                    
                Reservation reservationWithRoomType = new Reservation(ID,city,hotelNameWithRoomType, reservationMonthWithRoomType, reservationStartWithRoomType, reservationEndWithRoomType, roomType);
                reservations.add(reservationWithRoomType); 
                reservationCount++;
                
                
        	    
				
			}
		});
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text1 = "";
				
				for (Reservation reservation : reservations) {
					text1 += reservation.displayInfo();
				}
				textArea.setText(text1);
			}
		});
        
        servicesItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selection =Integer.parseInt(JOptionPane.showInputDialog("Please select one of the extra services from below \n 1.Laundry Service \n 2.Spa Service"," "));
				int Id=Integer.parseInt(JOptionPane.showInputDialog("Type the reservation ID to credit this service:"," "));
				
				if(selection == 1) {
					int item = Integer.parseInt(JOptionPane.showInputDialog("How many items"," "));
					services.add(new Laundry(item,Id));
				}
				else if(selection == 2) {
					int day = Integer.parseInt(JOptionPane.showInputDialog("How many days?"," "));
					services.add(new Spa(day,Id));
				}
			}
		});
        
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text2 = "";
				
				for (Services services : services) {
					if(services instanceof Spa) {
						text2 += ((Spa)(services)).displayInfo();
					}else if(services instanceof Laundry) {
						text2 += ((Laundry)(services)).displayInfo();
					}
				}
				textArea.setText(text2);
			}
		});
        
        button3.addActionListener(new ActionListener() {
			String text3 = "";
			@Override
			public void actionPerformed(ActionEvent e) {
				 String city1 = JOptionPane.showInputDialog("Enter city name:");
				 
				 for (Reservation reservation: reservations) {
					if (reservation.getCity().equalsIgnoreCase(city1)) {
						text3 += "Reservations for " + city1 + ":\n";
						text3 += reservation.displayInfo();
					}
					 
				 }
				 
				 textArea.setText(text3);
			}
		});
        
        
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reservationCount >= 8) {
                    String hotelName = JOptionPane.showInputDialog("Enter Hotel name:");
                    multi(hotelName);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter at least 8 reservations - now it is only " + reservationCount);
                }
            }
        });
        
        
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFromFile();
            }
        });
       
        
        
        exItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
        
        aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bekir Görkem Özhan\n 20200702087");
			}
		});
        
        contentItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Create new reservation from new+Reservation");	
			}
		});
	}
	
	
	

	private void multi(String hotelName) {
		
		for (Reservation reservation : reservations) {
	        if (reservation.getHotelName().equalsIgnoreCase(hotelName)) {
	            samehotelID.add(reservation.getID());
	        }
	    }
	    

	    String text4 = "Reservation IDs for hotels with the name '" + hotelName + "':\n";
	    for (Reservation reservation : reservations) {
	        if (samehotelID.contains(reservation.getID())) {
	            text4 += reservation.getID() + " ";
	        }
	    }
	   

	    textArea.setText(text4);
	}
    
    
 
    
	private void writeToFile(String filePath, String content) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        writer.write(content);
	        JOptionPane.showMessageDialog(null, "Saved!");
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
	    }
	}

	private void saveToFile() {
	    StringBuilder content = new StringBuilder();
	    for (Reservation reservation : reservations) {
	        content.append(reservation.toString());
	    }
	    writeToFile("reservations.txt", content.toString());
	}

	private void readFromFile() {
	    try {
	        String content = new String(Files.readAllBytes(Paths.get("reservations.txt")));
	        textArea.setText(content);
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
	    }
	}

    
    
    
    
	public static void main(String[] args) {
	
       
        JFrame frame = new JFrame("LaunchPage");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setTitle("Hotel Reservation System");
    	
    	frame.getContentPane().add(new Main());
    	frame.setMaximumSize(new Dimension(1000,600));
    	frame.setMinimumSize(new Dimension(500,500));
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
		frame.setResizable(false);
       
	}
}