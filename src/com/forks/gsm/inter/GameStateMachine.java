package com.forks.gsm.inter;

public interface GameStateMachine {
	
	void setGameState(GameState state);

	GameState getGameState();
}
