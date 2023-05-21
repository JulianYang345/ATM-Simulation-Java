package edu.pradita.modelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.pradita.MainApplication;
import edu.pradita.model.ATM;
import edu.pradita.model.BankAccount;
import edu.pradita.view.ATMState;
import edu.pradita.view.MainScreen;
import edu.pradita.view.LoginState;

public class CancelButtonListener implements ActionListener {

	MainScreen mainScreen;
	public CancelButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)) {
			
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {
			mainScreen.getLblTop().setText("Enter your account number:");
			//ATM.setAccountNumber("");
			ATM.setPin("");
			mainScreen.getLblMiddle().setText(ATM.getAccountNumber());
			MainApplication.setAtmState(ATMState.ENTER_ACCOUNT_NUMBER);
		} 
		
		else if (MainApplication.getAtmState().equals(ATMState.MAIN_MENU)) {

		}
		
		else if(MainApplication.getAtmState().equals(ATMState.WITHDRAW) ||
				MainApplication.getAtmState().equals(ATMState.CHECK_BALANCE)||
				MainApplication.getAtmState().equals(ATMState.DEPOSIT)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER1)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER2) ||
				MainApplication.getAtmState().equals(ATMState.TRANSACTION_RECORD)) {
				ATM.setAmmount("");
				ATM.setTransferNumber("");
				MainApplication.setAtmState(ATMState.MAIN_MENU);
				mainScreen.getBtnLeft1().setText("<html><center>Check<br/>Balance</center></html>");
				mainScreen.getBtnLeft2().setText("<html><center>Withdraw</center></html>");
				mainScreen.getBtnRight1().setText("<html><center>Deposit</center></html>");
				mainScreen.getBtnRight2().setText("<html><center>Transfer</center></html>");
				mainScreen.getBtnLeft3().setText("<html><center>Exit</center></html>");
				mainScreen.getBtnRight3().setText("<html><center>Transaction<br/>Record</center></html>");
				mainScreen.getLblTop().setText("Main Menu");
				mainScreen.getLblMiddle().setText("");
				mainScreen.getLblBottom().setText("");
		}
	}
}
