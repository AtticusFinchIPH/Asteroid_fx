package viewModel;

import game.Asteroid;
import game.Space;
import game.Spaceship;
import views.View;

import java.util.List;


/**
 * An object of this class is responsible for the communication between the
 * state of the game (Space, the model), and the view of the game (View).
 * Ideally, Space and View should ignore each other (but to avoid boilerplate
 * we may sometimes use the space from the view). The view should only contain
 * rendering methods and event handlers, while the model should contain
 * all the data and the logic of the application.
 */
public class ViewModel {


  private Space gameState; // the model
  private View view; // the view

  public ViewModel(Space space, View view) {
    this.gameState = space;
    this.view = view;
  }


  /**
   * Update the model and view after time delay dt.
   * @param dt the time delay in seconds.
   */
  public void tick(double dt) {
    gameState.update(dt);
    view.render();
  }


  /**
   * Command to start the main engine of the player's spaceship
   */
  public void startSpaceshipMainEngine() {
    gameState.getSpaceship().startMainEngine();
  }

  /**
   * Command to stop the main engine of the player's spaceship
   */
  public void stopSpaceshipMainEngine() {
    gameState.getSpaceship().stopMainEngine();
  }

  public void startSpaceshipLeftEngine() {
	gameState.getSpaceship().startLeftEngine();
  }
  
  public void stopSpaceshipLeftEngine() {
	gameState.getSpaceship().stopRightEngine();
  }
  
  public void startSpaceshipRightEngine() {
	gameState.getSpaceship().startLeftEngine();
  }
  
  public void stopSpaceshipRightEngine() {
	gameState.getSpaceship().stopRightEngine();
  }
  
  public void startSpaceshipReverseEngine() {
	gameState.getSpaceship().startReverseEngine();
  }
  
  public void stopSpaceshipReverseEngine() {
	gameState.getSpaceship().stopReverseEngine();
  }
  
  public double getSpaceshipFuelPercentage() {
	return gameState.getSpaceship().getFuelPercentage();
  }
  
  public boolean isSpaceshipMainEngineOn() {
	return gameState.getSpaceship().isMainEngineOn();
  }
  
  public boolean isSpaceshipLeftEngineOn() {
		return gameState.getSpaceship().isLeftEngineOn();
  }
  
  public boolean isSpaceshipRightEngineOn() {
		return gameState.getSpaceship().isRightEngineOn();
  }
  
  public boolean isSpaceshipReverseEngineOn() {
		return gameState.getSpaceship().isReverseEngineOn();
  }
  
  public boolean isSpaceshipInvulnerable() {
	return gameState.getSpaceship().getInvunerableTime() > 0 ? true : false;
  }
  
  public double getSpaceshipInvulnerabilityTime() {
	  return gameState.getSpaceship().getInvunerableTime();
  }
  
  public int getSpaceshipLife() {
	return gameState.getSpaceship().getLife();
  }

  /**
   * @return whether the game is over
   */
  public boolean isGameOver() {
    return gameState.isGameOver();
  }


  /**
   * @return the list of asteroids to display
   */
  public List<Asteroid> getAsteroids() {
    return gameState.getAsteroids();
  }


  /**
   * @return the state of the spaceship
   */
  public Spaceship getSpaceship() {
    return gameState.getSpaceship();
  }


  /**
   * @return the current score
   */
  public double getScore() {
    return gameState.getScore();
  }
}
