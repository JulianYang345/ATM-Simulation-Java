package edu.pradita.modelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.pradita.MainApplication;
import edu.pradita.model.ATM;
import edu.pradita.view.ATMState;
import edu.pradita.view.MainScreen;

public class ClearButtonListener implements ActionListener {

	MainScreen mainScreen;
	public ClearButtonListener(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (MainApplication.getAtmState().equals(ATMState.ENTER_ACCOUNT_NUMBER)){
			ATM.setAccountNumber("");
			mainScreen.getLblMiddle().setText("________");
		}
		else if(MainApplication.getAtmState().equals(ATMState.ENTER_PIN)) {
			ATM.setPin("");
			mainScreen.getLblMiddle().setText("____");
		}
		
		else if(MainApplication.getAtmState().equals(ATMState.WITHDRAW) ||
				MainApplication.getAtmState().equals(ATMState.DEPOSIT)||
				MainApplication.getAtmState().equals(ATMState.TRANSFER2)) {
			ATM.setAmmount("");
			mainScreen.getLblMiddle().setText("____");
		}
		else if (MainApplication.getAtmState().equals(ATMState.TRANSFER1)){
			ATM.setTransferNumber("");
			mainScreen.getLblMiddle().setText("________");
		}
	}
}
