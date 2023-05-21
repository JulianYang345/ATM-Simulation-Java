package edu.pradita.modelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.pradita.MainApplication;
import edu.pradita.model.ATM;
import edu.pradita.view.ATMState;
import edu.pradita.view.LoginState;
import edu.pradita.view.MainScreen;

public class SideButtonListener implements ActionListener {

	MainScreen mainScreen;
	public SideButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource(); 
		double balance = ATM.getBankAccount(ATM.getAccountNumber()).getBalance();
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)){

		}
		else if(MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {

		}
		else if(MainApplication.getAtmState().equals(ATMState.MAIN_MENU)) {
			if(button == mainScreen.getBtnLeft1()) {
				MainApplication.setAtmState(ATMState.CHECK_BALANCE);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("Main Menu");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Your balance is:");
				mainScreen.getLblMiddle().setText(Double.toString(balance));
				mainScreen.getLblBottom().setText("");
			}
			else if(button == mainScreen.getBtnLeft2()) {
				MainApplication.setAtmState(ATMState.WITHDRAW);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("Main Menu");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Withdraw");
				mainScreen.getLblMiddle().setText("____");
				mainScreen.getLblBottom().setText("Enter the ammount to withdraw");
			}
			else if (button == mainScreen.getBtnLeft3()) {
				ATM.setAccountNumber("");
				ATM.setPin("");
				MainApplication.setLoginState(LoginState.LOGOUT);
				MainApplication.setAtmState(ATMState.ENTER_ACCOUNT_NUMBER);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Enter your account number:");
				mainScreen.getLblMiddle().setText("________");
				mainScreen.getLblBottom().setText("Press ENTER to proceed.");
				
			}
			else if(button == mainScreen.getBtnRight1()) {
				MainApplication.setAtmState(ATMState.DEPOSIT);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("Main Menu");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Deposit");
				mainScreen.getLblMiddle().setText("____");
				mainScreen.getLblBottom().setText("Enter the ammount to deposit");
			}
			else if(button == mainScreen.getBtnRight2()) {
				MainApplication.setAtmState(ATMState.TRANSFER1);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("Main Menu");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Transfer");
				mainScreen.getLblMiddle().setText("________");
				mainScreen.getLblBottom().setText("Enter recipients number");
			}
			else if (button == mainScreen.getBtnRight3()) {
				MainApplication.setAtmState(ATMState.TRANSACTION_RECORD);
				mainScreen.getBtnLeft1().setText("");
				mainScreen.getBtnLeft2().setText("");
				mainScreen.getBtnRight1().setText("");
				mainScreen.getBtnRight2().setText("");
				mainScreen.getBtnLeft3().setText("Main Menu");
				mainScreen.getBtnRight3().setText("");
				mainScreen.getLblTop().setText("Transaction Record");
				mainScreen.getLblMiddle().setText("");
				mainScreen.getLblBottom().setText("");
				if(ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1().equals("")&&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2().equals("")&&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction3().equals("")) {
					mainScreen.getLblMiddle().setText("No transaction History");
				}
				else if(ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1().equals("") == false &&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2().equals("")&&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction3().equals("")) {
					mainScreen.getLblMiddle().setText(ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1());
				}
				else if(ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1().equals("") == false &&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2().equals("") == false &&
					ATM.getBankAccount(ATM.getAccountNumber()).getTransaction3().equals("")) {
					mainScreen.getLblMiddle().setText("<html>" + ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1() +
					"<br/>" + ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2());
				}
				else if(ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1().equals("") == false &&
						ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2().equals("") == false &&
						ATM.getBankAccount(ATM.getAccountNumber()).getTransaction3().equals("") == false) {
						mainScreen.getLblMiddle().setText("<html>" + ATM.getBankAccount(ATM.getAccountNumber()).getTransaction1() +
						"<br/>" + ATM.getBankAccount(ATM.getAccountNumber()).getTransaction2() +
						"<br/>" + ATM.getBankAccount(ATM.getAccountNumber()).getTransaction3());
				}
			}
		}
		
		else if(MainApplication.getAtmState().equals(ATMState.WITHDRAW) ||
				MainApplication.getAtmState().equals(ATMState.CHECK_BALANCE)||
				MainApplication.getAtmState().equals(ATMState.DEPOSIT)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER1)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER2)||
				MainApplication.getAtmState().equals(ATMState.TRANSACTION_RECORD)) {
			if(button == mainScreen.getBtnLeft3()) {
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
}
