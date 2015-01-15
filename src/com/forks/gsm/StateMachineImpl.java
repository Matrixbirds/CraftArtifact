package com.forks.gsm;

import com.forks.gsm.inter.GameState;
import com.forks.gsm.inter.GameStateMachine;

public class StateMachineImpl implements GameStateMachine {

	
	protected GameState state;
	
	public StateMachineImpl(GameState state) {
		this.state = state;
	}
	
	public StateMachineImpl() {
		this.state = new MenuState(this);
	}
	
	@Override
	public void setGameState(GameState state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	
	@Override
	public GameState getGameState() {
		return state;
	}

}
