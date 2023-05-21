package edu.pradita.modelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.pradita.MainApplication;
import edu.pradita.model.ATM;
import edu.pradita.view.ATMState;
import edu.pradita.view.MainScreen;

public class NumericButtonListener implements ActionListener {

	MainScreen mainScreen;
	public NumericButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String number = button.getText();
		double ammount = 0;
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)) {
			mainScreen.getLblTop().setText("Enter your account number:");
			if (ATM.getAccountNumber().length() >= 10) {
				mainScreen.getLblTop().setText("Number cannot exceed 10 digits");
			}
			else {
				ATM.setAccountNumber(ATM.getAccountNumber() + number);
			}
			mainScreen.getLblMiddle().setText(ATM.getAccountNumber());
		} 
		
		else if (MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {
			mainScreen.getLblTop().setText("<html><center>Type in 4 digits<br/>of your PIN Number:</center></html>");
			if (ATM.getPin().length() >= 4) {
				mainScreen.getLblTop().setText("PIN Cannot Exceed 4 digits");
			}
			else {
				ATM.setPin(ATM.getPin() + number);
			}
			String stars = "";
			for (int i = 0; i < ATM.getPin().length();i++) {
				stars += "*";
			}
			mainScreen.getLblMiddle().setText(stars);
		} 
		
		else if(MainApplication.getAtmState().equals(ATMState.WITHDRAW)||
				MainApplication.getAtmState().equals(ATMState.DEPOSIT)) {
			ATM.setAmmount(ATM.getAmmount() + number) ;
			mainScreen.getLblMiddle().setText(ATM.getAmmount());
		}
		
		else if(MainApplication.getAtmState().equals(ATMState.TRANSFER2)) {
			mainScreen.getLblTop().setText("Transfer to: " + ATM.getBankAccount(ATM.getTransferNumber()).getName());
			ATM.setAmmount(ATM.getAmmount() + number);
			mainScreen.getLblMiddle().setText(ATM.getAmmount());
			
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.TRANSFER1)) {
			mainScreen.getLblTop().setText("Transfer");
			if (ATM.getTransferNumber().length() >= 10) {
				mainScreen.getLblTop().setText("Number cannot exceed 10 digits");
			}
			else {
				ATM.setTransferNumber(ATM.getTransferNumber() + number);
			}
			mainScreen.getLblMiddle().setText(ATM.getTransferNumber());
		}
	}

}
