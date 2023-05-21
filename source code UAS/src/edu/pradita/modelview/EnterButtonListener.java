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
import edu.pradita.modelview.NumericButtonListener;

public class EnterButtonListener implements ActionListener {

	MainScreen mainScreen;
	public EnterButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	BankAccount bankAccount = null;
	
	public void actionPerformed(ActionEvent e) {
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)) {
			mainScreen.getLblTop().setText("<html><center>Type in 4 digits<br/>of your PIN Number:</center></html>");
			mainScreen.getLblMiddle().setText("____");
			mainScreen.getLblBottom().setText("Press ENTER to proceed.");
			MainApplication.setAtmState(ATMState.ENTER_PIN);
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {
			if ((bankAccount = ATM.login(ATM.getAccountNumber(), ATM.getPin())) == null) {
				mainScreen.getLblTop().setText("Wrong login credential, Try again.");
			}
			else {
				mainScreen.getBtnLeft1().setText("<html><center>Check<br/>Balance</center></html>");
				mainScreen.getBtnLeft2().setText("<html><center>Withdraw</center></html>");
				mainScreen.getBtnRight1().setText("<html><center>Deposit</center></html>");
				mainScreen.getBtnRight2().setText("<html><center>Transfer</center></html>");
				mainScreen.getBtnLeft3().setText("<html><center>Exit</center></html>");
				mainScreen.getBtnRight3().setText("<html><center>Transaction<br/>Record</center></html>");
				mainScreen.getLblTop().setText("Main Menu");
				mainScreen.getLblMiddle().setText("");
				mainScreen.getLblBottom().setText("");
				MainApplication.setAtmState(ATMState.MAIN_MENU);
				MainApplication.setLoginState(LoginState.LOGIN);
			}
		} 
		
		else if (MainApplication.getAtmState().equals(ATMState.MAIN_MENU)) {

		}  
		
		else if (MainApplication.getAtmState().equals(ATMState.WITHDRAW)) {
			if (bankAccount.getBalance() - Double.parseDouble(ATM.getAmmount()) <= 0) {
				mainScreen.getLblTop().setText("Balance not enough");
			}
			else {
				ATM.withdraw(ATM.getAccountNumber(), Double.parseDouble(ATM.getAmmount()));
				mainScreen.getLblTop().setText("You have successfully withdrawn");
				ATM.setTransactionRecord(ATM.getAccountNumber(), "Withdraw: " + ATM.getAmmount());
				ATM.setAmmount("");
				ATM.saveUsers(ATM.getBankAccountList());
			}
			
		}
		else if (MainApplication.getAtmState().equals(ATMState.DEPOSIT)) {
			ATM.deposit(ATM.getAccountNumber(), Double.parseDouble(ATM.getAmmount()));
			mainScreen.getLblTop().setText("You have successfully deposited");
			ATM.setTransactionRecord(ATM.getAccountNumber(), "Deposit: " + ATM.getAmmount());
			ATM.setAmmount("");
			ATM.saveUsers(ATM.getBankAccountList());
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.TRANSFER1)) {
			if(ATM.getBankAccount(ATM.getTransferNumber()) == null) {
				mainScreen.getLblTop().setText("Account doesn't exist");
			}
			else {
				mainScreen.getLblTop().setText("Transfer to: " + ATM.getBankAccount(ATM.getTransferNumber()).getName());
				mainScreen.getLblMiddle().setText("____");
				mainScreen.getLblBottom().setText("Enter the ammount to transfer");
				MainApplication.setAtmState(ATMState.TRANSFER2);
				ATM.setAmmount("");
			}
			
		}
		
		else if (MainApplication.getAtmState().equals(ATMState.TRANSFER2)) {
			if (bankAccount.getBalance() - Double.parseDouble(ATM.getAmmount()) <= 0) {
				mainScreen.getLblTop().setText("Balance not enough");
			}
			else {
				ATM.transfer(ATM.getAccountNumber(), ATM.getTransferNumber(), Double.parseDouble(ATM.getAmmount()));
				mainScreen.getLblTop().setText("You have successfully transfered");
				ATM.setTransactionRecord(ATM.getAccountNumber(), "Transfer: " + ATM.getAmmount() + 
						" | to: " + ATM.getBankAccount(ATM.getTransferNumber()).getName());
				ATM.setTransactionRecord(ATM.getTransferNumber(), "From: " + ATM.getBankAccount(ATM.getAccountNumber()).getName()
						+ " | transfered: " + ATM.getAmmount());
				ATM.setAmmount("");
				ATM.setTransferNumber("");
				ATM.saveUsers(ATM.getBankAccountList());
			}
		}
	}
}
