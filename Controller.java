import java.util.ArrayList;

public interface Controller {
	
	private ArrayList<Observer> observers = new ArrayList<>();

    public void register(Observer obs){
        observers.add(obs);
    }

    public void unregister(Observer obs){
        observers.remove(obs);
    }

    public void notifyObservers(){
        for(Observer obs:observers)
        obs.update();
    }
    

}
