package edu.pradita.modelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.pradita.MainApplication;
import edu.pradita.model.ATM;
import edu.pradita.view.ATMState;
import edu.pradita.view.MainScreen;

public class DeleteButtonListener implements ActionListener {

	MainScreen mainScreen;
	public DeleteButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		String delNumber;
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)) {
			
			delNumber = ATM.getAccountNumber().substring(0,ATM.getAccountNumber().length()-1);
			ATM.setAccountNumber(delNumber);
			mainScreen.getLblMiddle().setText(ATM.getAccountNumber());
			if (ATM.getAccountNumber().length() <= 0) {
				mainScreen.getLblMiddle().setText("________");
			}
			if (ATM.getAccountNumber().length() < 10) {
				mainScreen.getLblTop().setText("Enter your account number:");
			}
			
		} 
		else if (MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {		
			delNumber = ATM.getPin().substring(0,ATM.getPin().length()-1);
			ATM.setPin(delNumber);
			
			String stars = "";
			for (int i = 0; i < ATM.getPin().length();i++) {
				stars += "*";
			}
			mainScreen.getLblMiddle().setText(stars);
			
			if (ATM.getPin().length() <= 0) {
				mainScreen.getLblMiddle().setText("____");
			}
			
			if (ATM.getPin().length() < 4) {
				mainScreen.getLblTop().setText("<html><center>Type in 4 digits<br/>of your PIN Number:</center></html>");
			}
			
		} 
		else if (MainApplication.getAtmState().equals(ATMState.MAIN_MENU)) {
			
		}  
		else if (MainApplication.getAtmState().equals(ATMState.WITHDRAW) ||
				MainApplication.getAtmState().equals(ATMState.DEPOSIT)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER2)) {
			delNumber = ATM.getAmmount().substring(0,ATM.getAmmount().length()-1);
			ATM.setAmmount(delNumber);
			mainScreen.getLblMiddle().setText(ATM.getAmmount());
			if (ATM.getAmmount().length() <= 0) {
				mainScreen.getLblMiddle().setText("____");
			}
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.TRANSFER1)) {
			
			delNumber = ATM.getTransferNumber().substring(0,ATM.getTransferNumber().length()-1);
			ATM.setTransferNumber(delNumber);
			mainScreen.getLblMiddle().setText(ATM.getTransferNumber());
			if (ATM.getTransferNumber().length() <= 0) {
				mainScreen.getLblMiddle().setText("________");
			}
			if (ATM.getTransferNumber().length() < 10) {
				mainScreen.getLblTop().setText("Transfer");
			}
			
		}  
	}
}
